package net.wanho.client;

import java.util.*;

public class TimerTest {
    public static void main(String[] args) {
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println(new Date());
//            }
//        },1000,1000);



        Integer[] is = new Integer[]{6,4,5765,3546,32455,4323436,435};

        Arrays.sort(is, (a,b)->b-a);//lamda
        System.out.println(Arrays.toString(is));

    }
}
