package net.wanho.task;

import com.alibaba.dubbo.common.store.support.SimpleDataStore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloTask {
    public void execute() {

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

    }
}
