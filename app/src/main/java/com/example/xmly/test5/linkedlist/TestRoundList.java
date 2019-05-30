package com.example.xmly.test5.linkedlist;

public class TestRoundList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(5);
        ListNode five = new ListNode(6);
        ListNode six = new ListNode(7);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        //six.next = three;

        boolean flag = isHasRoundList(head);
        System.out.println(flag);

    }

    public static boolean isHasRoundList(ListNode head){
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if (quick.number == slow.number){
                return true;
            }
        }
        return false;
    }



    public static class ListNode {
        public int number;
        public ListNode next = null;

        public ListNode(int number) {
            this.number = number;
        }
    }
}
