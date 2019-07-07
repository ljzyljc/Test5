package com.example.xmly.test5.linkedlist;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestReverse {


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

        ListNode newNode = reverse(head);
        while (newNode != null) {
            System.out.println(newNode.number);
            newNode = newNode.next;
        }

    }
//    prev连接下一次需要反转的节点
//    反转节点pCur
//    纠正头结点dummy的指向
//    pCur指向下一次要反转的节点
    // dumpsy  1 2 3 4 5    prev.next = curr.next; curr.next = dumpsy.next; dumpsy.next = curr; curr = prev.next

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dumpsy = new ListNode(-1);
        dumpsy.next = head;
        ListNode prev = dumpsy.next;
        ListNode curr = prev.next;

        while (curr != null) {
            prev.next = curr.next;
            curr.next = dumpsy.next;
            dumpsy.next = curr;
            curr = prev.next;
        }
        return dumpsy.next;

    }

    //判断一个字符串是不是回文字符串,前提是这个字符串已经用链表装填了
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.number != prev.number) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }


    public static class ListNode {
        public int number;
        public ListNode next = null;

        public ListNode(int number) {
            this.number = number;
        }
    }
}
//  图    dumpsy  1   2   3   4   5
//   上一个结尾，下一个开始
//    prev.next = curr.next;
//    curr.next = dumpsy.next;
//    dumpsy.next = curr;
//    curr = prev.next;
//四个阶段
//1.prev连接下一个需要反转的节点
//2.反转curr节点
//3.纠正dumpsy的指向
//4.curr指向下一次需要反转的节点
