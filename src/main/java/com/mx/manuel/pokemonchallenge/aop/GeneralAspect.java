package com.mx.manuel.pokemonchallenge.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mx.manuel.pokemonchallenge.model.entity.Bitacora;
import com.mx.manuel.pokemonchallenge.repository.IBitacoraRepository;
import com.mx.manuel.pokemonchallenge.util.PopularityUtil;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class GeneralAspect {

    @Autowired
    private IBitacoraRepository bitacoraRep;

    @Autowired
    private PopularityUtil popularity;

    @Autowired
    private HttpServletRequest request;

    @Pointcut("target(com.mx.manuel.pokemonchallenge.service.PokemonService)")
    public void inPokemonService() {}

    @Before("inPokemonService()")
    public void create(JoinPoint joinPoint) {
        log.debug("Aspect create Bitacora");
        final Bitacora bitacora = new Bitacora();
        bitacora.setIp(request.getRemoteAddr());
        bitacora.setMethod(joinPoint.getSignature().getName());
        bitacora.setCreationDate(LocalDateTime.now());
        bitacoraRep.save(bitacora);
    }

    @AfterReturning("inPokemonService()")
    public void addPopularity(JoinPoint joinPoint) {
        log.debug("Aspect Popularity");
        popularity.addPopularity(joinPoint.getArgs()[0].toString());
    }
}
