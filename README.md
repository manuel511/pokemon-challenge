# Pokemon Challenge

Este proyecto es un WebService SOAP que consume el ApiRest https://pokeapi.co/ y en base a la información obtenida expone los siguientes métodos: 
- `getAbilities` -> Lista de habilidades que tiene un pokemon. Esta lista se compone por: id, nombre, si esta habilidad se originó o no en la serie principal, generación, efecto, lista de los pokemon que pueden tener esa habilidad.
- `getBaseExperience` -> La experiencia base obtenida por derrotar a este Pokémon.
- `getHeldItems` -> Una lista de los objetos que este Pokémon puede tener en sus manos cuando se encuentra. Esta lista se compone por: id, nombre, lista de las versiones en las que se mantiene el elemento.
- `getId` -> El Identificador de este recurso.
- `getLocationAreaEncounters` -> Lista de áreas donde se pueden encontrar el Pokémon, Esta lista se compone por: id, name, lista detallada de las versiones.
- `getName` -> Regresa si es un pokemon valido.

Ademas guarda un par de bitacoras, la primera registra la ip, fecha y método consumido. La segunda refleja la popularidad de los pokemon al contar cuantas veces se a buscado el mismo pokemon en los diferentes métodos.

## Tecnologías utilizadas

El proyecto esta desarrollado en Java 17, Spring boot 3, maven y se conecta a una base de datos SQL.

## Características de la aplicación

- `Funcionalidad 1:` Consumo de ApiRest(https://pokeapi.co/) por medio de RestClient.
- `Funcionalidad 2:` Conexión a base de datos SQL utilizando spring-boot-starter-data-jpa para la gestion del datasource y administrando el pool de conexión con hikari.
- `Funcionalidad 3:` Programación con Aspectos utilizando spring-boot-starter-aop para la ejecucion de la bitacora.
- `Funcionalidad 3:` Implementacion de control de errores.
- `Funcionalidad 4:` Pruebas unitarias.

## Instalación

***
Para compilar el proyecto se requiere java 17 o superior y maven.
Para levantar el proyecto se requiere de alguna base de datos, se puede ajustar la configuracion de conexión en el archivo `pokemon-challenge/src/main/resources/application.yml`, en automatico se realizara la generación del par de tablas necesarias en caso de no existir en la base.
```
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/local
    username: <user>
    password: <password>
    hikari:
      connection-timeout: 15000
      maximum-pool-size: 25
      pool-name: localConnPool
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
```
Los siguientes comandos son para uso en terminal windows:
```
$ git clone https://github.com/manuel511/pokemon-challenge.git
$ cd pokemon-challenge
$ mvn clean verify
```
En caso de tener docker se agrega `Dockerfile` para la generacion de imagen:
```
$ docker build . --tag=pokemon-challenge:latest
$ docker run -p8080:8080 -m 1024m pokemon-challenge
```
En caso de no contar con Docker se puede ejecutar el componente con el siguiente comando:
```
$ java -jar target\pokemon-challenge-1.0.0.jar
```
Por default se levantara en el puerto 8080, y se expondra un WSDL en la ruta: http://localhost:8080/api/v1/pokemon/pokeData.wsdl

## Pruebas

Como herramienta de pruebas se puede utilizar [SoapUI](https://www.soapui.org/downloads/soapui/) el cual nos permite importar el WSDL que expone el servicio. Los 6 metodos expuestos manejan la misma extructura de request, el cual recibe como parametro el nombre de pokemon de entrada y dependiendo del metodo consumido regresara alguno de los atributos, en caso de ingresar un nombre de pokemon incorrecto regresara un error de no encontrado.
```
- REQUEST:
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:pok="https://pokeapi.co/api/v1/pokemon">
   <soapenv:Header/>
   <soapenv:Body>
      <pok:getBaseExperienceRequest>
         <pok:pokemon>darkrai</pok:pokemon>
      </pok:getBaseExperienceRequest>
   </soapenv:Body>
</soapenv:Envelope>

- RESPONSE:
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
   <SOAP-ENV:Header/>
   <SOAP-ENV:Body>
      <ns2:getBaseExperienceResponse xmlns:ns2="https://pokeapi.co/api/v1/pokemon">
         <ns2:baseExperience>270</ns2:baseExperience>
      </ns2:getBaseExperienceResponse>
   </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```