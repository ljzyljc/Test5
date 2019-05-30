package com.example.xmly.test5.linkedlist;

public class TestMergeList {

    public static void main(String[] args) {

        ListNode first = createNode();
        ListNode sec = createNode1();
        ListNode newNode = mergeNode(first,sec);
        while (newNode != null){
            System.out.println(newNode.number);
            newNode = newNode.next;
        }

    }


    public static ListNode createNode(){
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(6);
        ListNode three = new ListNode(41);
        ListNode four = new ListNode(51);
        ListNode five = new ListNode(62);
        ListNode six = new ListNode(74);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        return head;
    }

    public static ListNode createNode1(){
        ListNode head = new ListNode(14);
        ListNode one = new ListNode(24);
        ListNode two = new ListNode(67);
        ListNode three = new ListNode(68);
        ListNode four = new ListNode(69);
        ListNode five = new ListNode(72);
        ListNode six = new ListNode(78);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        return head;
    }



    public static ListNode mergeNode(ListNode first, ListNode sec) {
        ListNode newNode = new ListNode(-1);
        ListNode curr = newNode;
        if (first == null) {
            return sec;
        }
        if (sec == null) {
            return first;
        }
        while (first != null && sec != null) {
            if (first.number >= sec.number) {
                curr.next = sec;
                curr = curr.next;
                sec = sec.next;
            } else {
                curr.next = first;
                curr = curr.next;
                first = first.next;
            }
        }
        if (first != null){
            curr.next = first;
        }
        if (sec != null){
            curr.next = sec;
        }
        return newNode.next;

    }


    public static class ListNode {
        public int number;
        public ListNode next = null;

        public ListNode(int number) {
            this.number = number;
        }
    }
}















