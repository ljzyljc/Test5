package com.example.xmly.test5;

import java.util.HashMap;
import java.util.Map;

public class digui {

    static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args){

        System.out.println(totalCount(7));

    }

    //解决递归的重复计算问题
    public static int totalCount(int num){
        if (num == 1)
            return 1;
        if (num == 2)
            return 2;
        if (map.containsKey(num)){
            return map.get(num);
        }
        int value =  totalCount(num -1) + totalCount(num - 2);
        map.put(num,value);
        return value;

    }

}
