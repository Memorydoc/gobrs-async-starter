package com.gobrs.async.test.task.sence.casetwo;

import com.gobrs.async.core.TaskSupport;
import com.gobrs.async.core.anno.Task;
import com.gobrs.async.core.task.AsyncTask;

/**
 * @program: gobrs-async
 * @ClassName GobrsTaskB
 * @description:
 * @author: sizegang
 * @create: 2022-10-31
 **/
@Task
public class CaseTwoTaskB extends AsyncTask {

    @Override
    public Object task(Object o, TaskSupport support) {
        System.out.println("B开始任务执行");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B任务执行");
        return "BResult";
    }
}
