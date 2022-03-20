package com.gobrs.async.test;

import com.gobrs.async.TaskSupport;
import com.gobrs.async.task.AsyncTask;

/**
 * @program: gobrs-async-starter
 * @ClassName DService
 * @description:
 * @author: sizegang
 * @create: 2022-03-20
 **/
public class DService implements AsyncTask<Object, Object> {

    int i = 0;

    @Override
    public void prepare(Object o) {

    }

    @Override
    public Object task(Object o) {

        System.out.println("DService");
        while (i < 100000 && !Thread.currentThread().isInterrupted()) {
            System.out.println("i++:" + i);
            i++;
        }
        return "DService";
    }

    @Override
    public boolean nessary(Object o) {
        return true;
    }

    @Override
    public void onSuccess(TaskSupport support) {

    }

    @Override
    public void onFail(TaskSupport support) {

    }
}
