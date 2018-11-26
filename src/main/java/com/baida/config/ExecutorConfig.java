package com.baida.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ShiQing_Chen
 * @date 2018/11/13 18:17
 */

@Configuration
@EnableAsync
public class ExecutorConfig {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

    @Bean("taskExecutor")
    public Executor taskExecutor() {

        logger.info("start taskExecutor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        //线程池维护线程的最少数量
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        //配置最大线程数
        //线程池维护线程的最大数量
        executor.setMaxPoolSize(200);
        //配置队列大小
        //线程池所使用的缓冲队列
        executor.setQueueCapacity(200);
        //线程池维护线程所允许的空闲时间
        executor.setKeepAliveSeconds(30000);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("task-executor-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}


