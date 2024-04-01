package com.mx.manuel.pokemonchallenge.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.task.TaskExecutor;

@ExtendWith(MockitoExtension.class)
class ThreadPoolExecutorConfigTest {

    @InjectMocks
    ThreadPoolExecutorConfig threadPool;

    @Test
    void taskExecutorPopularityTest() {
        TaskExecutor taskExecutor = threadPool.taskExecutorPopularity();
        assertNotNull(taskExecutor);
    }
}
