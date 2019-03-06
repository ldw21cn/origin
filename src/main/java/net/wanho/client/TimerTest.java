package net.wanho.client;

import org.junit.Test;

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

    /**
     * 冒泡排序
     * @param arr
     */
    public void bubble(Integer[] arr) {


        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    Integer temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    @Test
    public void testBubble() {

        Integer[] ints = {90, 100, 40, 110};
        bubble(ints);

        System.out.println(Arrays.toString(ints));


    }


    /**
     * 遍历map
     */
    @Test
    public void traverseMap() {

        HashMap<String, String> map = new HashMap<>();
        map.put("1001", "CCS");
        map.put("1002", "OSS");
        map.put("1003", "CSSSOFT");


        /**
         * 方式一: 获取 key
         */
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("key: " + key + ",value= " + map.get(key));
        }

        /**
         * 方式二: 获取 entry
         */
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key: " + entry.getKey() + ",value: " + entry.getValue());
        }


        /**
         * 方式三: 获取 entry 的 iterator
         */
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("key: " + key + ",value: " + map.get(key));
        }


        /**
         * 方式四: 获取entrySet 的 iterator
         */
        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, String> entry = iterator1.next();
            System.out.println("key: " + entry.getKey() + ",value: " + entry.getValue());
        }


        

    }









}
