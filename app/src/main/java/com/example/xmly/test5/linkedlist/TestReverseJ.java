package com.example.xmly.test5.linkedlist;

import java.util.List;

public class TestReverseJ {

    public static void main(String[] args){

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five =   new ListNode(3);
        ListNode six = new ListNode(2);
        ListNode sevent = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = sevent;

//        ListNode listNode = reverse(one);
//        ListNode listNode = reverseOne(one);

//        printListNode(listNode);

        boolean flag = isPalindrome(one);
        System.out.println(flag);

    }

    public static boolean isPalindrome(ListNode listNode){

        if (listNode == null){
            return false;
        }
        if (listNode.next == null){
            System.out.println("只有一个元素");
            return true;
        }

        ListNode pre = null;
        ListNode qucik = listNode;
        ListNode slow = listNode;


        while (qucik != null && qucik.next != null){
            qucik = qucik.next.next;
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        //quick不等于null，说明是链表总长是奇数， level  说明在 v的节点上，需要后移一下。如果是noon（偶数） 那就在第二个o节点上，不需要后移了
        if (qucik != null){
            slow = slow.next;
        }
        while (slow != null){
            if (slow.number != pre.number){
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }
        return true;





    }




    public static ListNode reverse(ListNode head){

        ListNode pre = null;
        ListNode curr = head;
        ListNode next = null;
        if (curr == null && curr.next == null){
            return curr;
        }
        while (curr != null){
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;

    }

    public static ListNode reverseOne(ListNode head){

        ListNode pre = null;
        ListNode next = null;
        if (head == null && head.next == null){
            return head;
        }
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }









    public static void printListNode(ListNode node){

        while (node != null){
            System.out.println(node.number);
            node = node.next;
        }
    }





    public static class ListNode{

        public ListNode next = null;
        private int number;
        public ListNode(int number){
            this.number = number;
        }
    }
}
