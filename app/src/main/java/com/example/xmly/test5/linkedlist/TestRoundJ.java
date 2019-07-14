package com.example.xmly.test5.linkedlist;

public class TestRoundJ {

    public static void main(String[] args){

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = three;

        ListNode fast = one;
        ListNode slow = one;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast.number == slow.number){
                System.out.println("链表有环");
                return;
            }
        }
        System.out.println("链表无环");

    }

    public static class ListNode{

        private int number;
        public ListNode next = null;
        public ListNode(int number){
            this.number = number;
        }

    }
}
