package com.gobrs.async.core.autoconfig;

import com.gobrs.async.core.config.GobrsConfig.ThreadPool;

import java.util.Objects;

import com.gobrs.async.core.config.GobrsAsyncRule;
import com.gobrs.async.core.property.GobrsAsyncProperties;
import com.gobrs.async.core.property.LogConfig;
import com.gobrs.async.core.property.RuleConfig;
import com.gobrs.async.core.config.GobrsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Gobrs property auto configuration.
 *
 * @program: gobrs -async
 * @description:
 * @author: sizegang
 * @create: 2022 -12-10
 */
@Configuration
public class GobrsPropertyAutoConfiguration {


    /**
     * Gobrs config gobrs config.
     *
     * @param properties the properties
     * @return the gobrs config
     */
    @Bean
    public GobrsConfig gobrsConfig(GobrsAsyncProperties properties) {

        GobrsConfig gobrsConfig = new GobrsConfig();

        gobrsConfig.setEnable(properties.isEnable());
        gobrsConfig.setSplit(properties.getSplit());
        gobrsConfig.setPoint(properties.getPoint());
        gobrsConfig.setParamContext(gobrsConfig.isParamContext());
        gobrsConfig.setTimeout(properties.getTimeout());
        gobrsConfig.setRelyDepend(properties.isRelyDepend());
        gobrsConfig.setTimeoutCoreSize(properties.getTimeoutCoreSize());
        threadPool(properties, gobrsConfig);
        List<RuleConfig> rules = properties.getRules();
        List<GobrsAsyncRule> rList = rules.stream().map(x -> {
            GobrsAsyncRule r = new GobrsAsyncRule();
            LogConfig logConfig = x.getLogConfig();

            if (Objects.nonNull(logConfig)) {
                r.setErrLogabled(logConfig.getErrLogabled());
                r.setCostLogabled(logConfig.getCostLogabled());
            }
            r.setCatchable(x.isCatchable());
            r.setName(x.getName());
            r.setContent(x.getContent());
            r.setTaskInterrupt(x.isTaskInterrupt());
            r.setTransaction(x.isTransaction());
            r.setInterruptionImmediate(x.isInterruptionImmediate());
            return r;
        }).collect(Collectors.toList());
        gobrsConfig.setRules(rList);
        return gobrsConfig;
    }

    /**
     * @param properties
     * @param gobrsConfig
     */
    private void threadPool(GobrsAsyncProperties properties, GobrsConfig gobrsConfig) {
        GobrsAsyncProperties.ThreadPool threadPool = properties.getThreadPool();
        if (Objects.nonNull(threadPool)) {
            ThreadPool tp = new ThreadPool();
            tp.setCorePoolSize(threadPool.getCorePoolSize());
            tp.setMaxPoolSize(threadPool.getMaxPoolSize());
            tp.setKeepAliveTime(threadPool.getKeepAliveTime());
            tp.setTimeUnit(threadPool.getTimeUnit());
            tp.setExecuteTimeOut(threadPool.getExecuteTimeOut());
            tp.setCapacity(threadPool.getCapacity());
            tp.setWorkQueue(threadPool.getWorkQueue());
            tp.setThreadNamePrefix(threadPool.getThreadNamePrefix());
            tp.setAllowCoreThreadTimeOut(threadPool.getAllowCoreThreadTimeOut());
            tp.setRejectedExecutionHandler(threadPool.getRejectedExecutionHandler());
            gobrsConfig.setThreadPool(tp);
        }
    }
}
