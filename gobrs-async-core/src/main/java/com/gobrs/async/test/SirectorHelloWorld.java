package com.gobrs.async.test;

import com.gobrs.async.domain.AsyncParam;
import com.gobrs.async.task.AsyncTask;
import com.gobrs.async.Callback;
import com.gobrs.async.GobrsAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: gobrs-async-starter
 * @ClassName SirectorHelloWorld
 * @description:
 * @author: sizegang
 * @create: 2022-03-16
 **/


@SuppressWarnings("unchecked")
public class SirectorHelloWorld {

    public static void main(String[] args) {

        GobrsAsync gobrsAsync = new GobrsAsync();

        //准备事件处理器实例和回调实例
        AService aService = new AService();
        BService bService = new BService();
        CService cService = new CService();
        DService dService = new DService();
        EService eService = new EService();
        FService fService = new FService();
        GService gService = new GService();


        //编排事件处理器
        gobrsAsync.begin(aService, bService);
        gobrsAsync.after(aService).then(cService);
        gobrsAsync.after(bService).then(dService).then(eService);
        gobrsAsync.after(bService).then(fService).then(gService);
        gobrsAsync.readyTo();

        //同步发布事件
        gobrsAsync.go(() -> new Object(), 100);
        //异步发布事件
//        gobrsAsync.start(() -> new Object(), alertCallback);
    }

}
