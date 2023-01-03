package com.gobrs.async.core.property;


import java.io.Serializable;


/**
 * The type Rule.
 *
 * @author sizegang1
 * @program: gobrs -async
 * @ClassName Rule
 * @description:
 * @author: sizegang
 * @create: 2022 -01-26 01:39
 * @Version 1.0
 * @date 2022 -01-27
 */
public class RuleConfig {

    private String name;

    private String content;

    private LogConfig logConfig;

    private boolean catchable;

    private GobrsAsyncProperties.ThreadPool threadPool;

    /**
     * Whether the execution com.gobrs.async.exception interrupts the workflow
     * 任务流程 某任务中断是否终止整个任务流程
     */
    private boolean taskInterrupt = false;

    private boolean interruptionImmediate = true;

    /**
     * 流程事务
     */
    boolean transaction = false;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Is com.gobrs.async.com.gobrs.async.test.task interrupt boolean.
     *
     * @return the boolean
     */
    public boolean isTaskInterrupt() {
        return taskInterrupt;
    }

    /**
     * Sets com.gobrs.async.com.gobrs.async.test.task interrupt.
     *
     * @param taskInterrupt the com.gobrs.async.com.gobrs.async.test.task interrupt
     */
    public void setTaskInterrupt(boolean taskInterrupt) {
        this.taskInterrupt = taskInterrupt;
    }


    /**
     * Gets log config.
     *
     * @return the log config
     */
    public LogConfig getLogConfig() {
        return logConfig;
    }

    /**
     * Sets log config.
     *
     * @param logConfig the log config
     */
    public void setLogConfig(LogConfig logConfig) {
        this.logConfig = logConfig;
    }

    /**
     * Is transaction boolean.
     *
     * @return the boolean
     */
    public boolean isTransaction() {
        return transaction;
    }

    /**
     * Sets transaction.
     *
     * @param transaction the transaction
     */
    public void setTransaction(boolean transaction) {
        this.transaction = transaction;
    }

    /**
     * Is catchable boolean.
     *
     * @return the boolean
     */
    public boolean isCatchable() {
        return catchable;
    }

    /**
     * Sets catchable.
     *
     * @param catchable the catchable
     */
    public void setCatchable(boolean catchable) {
        this.catchable = catchable;
    }

    /**
     * Is interruption immediate boolean.
     *
     * @return the boolean
     */
    public boolean isInterruptionImmediate() {
        return interruptionImmediate;
    }

    /**
     * Sets interruption immediate.
     *
     * @param interruptionImmediate the interruption immediate
     */
    public void setInterruptionImmediate(boolean interruptionImmediate) {
        this.interruptionImmediate = interruptionImmediate;
    }

    /**
     * Gets thread pool.
     *
     * @return the thread pool
     */
    public GobrsAsyncProperties.ThreadPool getThreadPool() {
        return threadPool;
    }

    /**
     * Sets thread pool.
     *
     * @param threadPool the thread pool
     */
    public void setThreadPool(GobrsAsyncProperties.ThreadPool threadPool) {
        this.threadPool = threadPool;
    }
}
