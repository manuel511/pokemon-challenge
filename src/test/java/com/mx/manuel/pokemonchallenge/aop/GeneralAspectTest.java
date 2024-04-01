package com.mx.manuel.pokemonchallenge.aop;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mx.manuel.pokemonchallenge.repository.IBitacoraRepository;
import com.mx.manuel.pokemonchallenge.util.PopularityUtil;

import jakarta.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
class GeneralAspectTest {

    @InjectMocks
    GeneralAspect aspect;

    @Mock
    IBitacoraRepository bitacoraRep;

    @Mock
    PopularityUtil popularity;

    @Mock
    HttpServletRequest request;

    @Test
    void createTest() {
        JoinPoint joinPoint = mock(JoinPoint.class);
        when(joinPoint.getSignature()).thenReturn(mock());
        aspect.create(joinPoint);
        verify(request).getRemoteAddr();
        verify(bitacoraRep).save(any());
    }

    @Test
    void addPopularityTest() {
        JoinPoint joinPoint = mock(JoinPoint.class);
        when(joinPoint.getArgs()).thenReturn(new String[]{"test"});
        aspect.addPopularity(joinPoint);
        verify(popularity).addPopularity(anyString());
    }
}
