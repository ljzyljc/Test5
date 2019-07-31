package com.example.xmly.test5.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumAdd {

    static int[] array = new int[]{1,2,6,8,35,100};

    public static void main(String[] args){

//        int[] arr = theSumOfTwoNum(array,43);
//        System.out.println(Arrays.toString(arr));

        ListNode first = new ListNode(1);
        ListNode first1 = new ListNode(7);
        ListNode first2 = new ListNode(2);
        first.next = first1;
        first1.next = first2;


        ListNode sec = new ListNode(2);
        ListNode sec1 = new ListNode(1);
        ListNode sec2 = new ListNode(6);
        sec.next = sec1;
        sec1.next = sec2;

        ListNode listNode = twoSum(first,sec);
        while (listNode != null){
            System.out.println(listNode.num);
            listNode = listNode.next;
        }


    }


    //两数之和
    private static int[] theSumOfTwoNum(int[] nums,int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);

        }
        return null;
    }

    //    给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    //
    //    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    //
    //    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    //



    private static ListNode twoSum(ListNode l1,ListNode l2){

            ListNode first = l1;
            ListNode sec = l2;

            ListNode newNode = new ListNode(0);
            ListNode curr = newNode;
            int carry = 0;
            while (first != null || sec != null){

                int x = (first != null) ? first.num : 0;
                int y = (sec != null) ? sec.num : 0;
                int sum = x + y + carry;

                carry = sum / 10;
                curr.next = new ListNode(sum%10);
                curr = curr.next;


                if (first != null) first = first.next;
                if (sec != null) sec = sec.next;

            }
            //注意最后一位要判断
            if(carry > 0){
                curr.next = new ListNode(1);
            }

            return newNode.next;
        }




























    private static class ListNode{

        int num;
        ListNode next;
        ListNode(int num){
            this.num = num;
        }

    }



}
