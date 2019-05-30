package com.example.xmly.test5.linkedlist;

public class TestDeleteNList {


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

        ListNode newNode = deleteKInListNode(5, head);
        while (newNode != null) {
            System.out.println(newNode.number);
            newNode = newNode.next;
        }


    }

    public static ListNode deleteKInListNode(int k, ListNode head) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode guide = new ListNode(-1);
        guide.next = head;
        ListNode quick = guide;
        ListNode slow = guide;

        for (int i = 0; i < k; i++) {
            if (quick != null) {
                quick = quick.next;
            }
        }
        //TODO 重点
        while (quick != null && quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return guide.next;

    }


    public static class ListNode {
        public int number;
        public ListNode next = null;

        public ListNode(int number) {
            this.number = number;
        }
    }
}

