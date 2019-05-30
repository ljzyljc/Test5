package com.example.xmly.test5.linkedlist;

public class TestMiddleList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(5);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;

        ListNode newNode = middleListNode(head);
        while (newNode != null) {
            System.out.println(newNode.number);
            break;
        }


    }

    public static ListNode middleListNode(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;

    }


    public static class ListNode {
        public int number;
        public ListNode next = null;

        public ListNode(int number) {
            this.number = number;
        }
    }
}

