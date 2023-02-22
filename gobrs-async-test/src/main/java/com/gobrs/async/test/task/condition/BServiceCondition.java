package com.gobrs.async.test.task.condition;

import com.gobrs.async.core.TaskSupport;
import com.gobrs.async.core.anno.Task;
import com.gobrs.async.core.common.domain.AnyConditionResult;
import com.gobrs.async.core.task.AsyncTask;
import org.springframework.stereotype.Component;

/**
 * The type B service.
 *
 * @program: gobrs -async-starter
 * @ClassName BService
 * @description: 任务依赖类型
 * AServiceCondition,BServiceCondition,CServiceCondition->DServiceCondition:anyCondition
 * <p>
 * 简化配置
 * <p>
 * A,B,C->D:anyCondition
 * <p>
 * D根据 A,B,C 返回的任务结果中的 AnyCondition 的state状态 进行判断是否继续执行 子任务
 * @author: sizegang
 * @create: 2022 -03-20
 */
@Task
public class BServiceCondition extends AsyncTask {

    int i = 10000;
    @Override
    public AnyConditionResult<String> task(Object o, TaskSupport support) {
        AnyConditionResult.AnyConditionResultBuilder<String> builder = AnyConditionResult.builder();

        System.out.println("BServiceCondition Begin");
        for (int i1 = 0; i1 < i; i1++) {
            i1 += i1;
        }
//        System.out.println(1 / 0);
        System.out.println("BServiceCondition Finish");
        builder.state(false);
        return builder.build();
    }
}
