package com.gobrs.async.test.task.sence.casefour;

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
public class CaseFourTaskK extends AsyncTask {

    @Override
    public Object task(Object o, TaskSupport support) {
        System.out.println("K开始任务执行");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("K任务执行");
        return "KResult";
    }


    @Override
    public void prepare(Object o) {
        System.out.println("CaseFourTaskK " + Thread.currentThread().getName());
    }
}
