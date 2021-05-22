package com.gokibe.facejs;

import java.util.*;

public class A {
    public static ArrayList<Integer> sortMethod(ArrayList<Integer> list){
        // map的左边存放值，右边存放出项的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer integer : list) {
            if(map.get(integer) == null){
                map.put(integer,1);
            }else {
                map.put(integer,map.get(integer) + 1);
            }
        }
        list.clear();
        for (Integer key : map.keySet()) {
            if (map.get(key) % 2 != 0){
                list.add(key);
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr,4,3,7,1,1,9,11,11,2,5);
        ArrayList<Integer> newArr = sortMethod(arr);
        System.out.println("输入：" + arr);
        System.out.println("输出：" + newArr);
    }

}


