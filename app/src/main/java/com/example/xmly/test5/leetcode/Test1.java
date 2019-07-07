package com.example.xmly.test5.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test1 {

    int arr[] = new int[]{2,7,8,19};
    int target = 9;
    public static void main(String[] args){

    }

    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)) { //这个时间复杂度是O(1),最差是O(n),当key的hash值一样的时候
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");


    }

}
