package com.example.xmly.test5.stack;

public class LinkedStack {
    //a stack based linked

    private ListNode top;
    public int size;

    public static void main(String[] args) {

//        LinkedStack linkedStack = new LinkedStack();
//        linkedStack.push("lin");
//        linkedStack.push("jun");
//        linkedStack.push("cheng");

    }


    public String pop() {
        if (top == null) {
            size = 0;
            return "stack is null";
        }
        String value = top.val;
        top = top.next;
        size--;
        return value;

    }

    public void push(String value){
        ListNode newNode = new ListNode(value,null);
        if (top == null){
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        size++;

    }

    public static class ListNode {
        String val;

        public ListNode(String val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode next;

    }

    public void clear(){
        top = null;
        this.size = 0;
    }

}






