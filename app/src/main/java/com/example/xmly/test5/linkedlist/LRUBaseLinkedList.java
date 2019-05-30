package com.example.xmly.test5.linkedlist;

public class LRUBaseLinkedList<T> {

    //默认链表容量
    private final static int DEFAULT_CAPACITY = 10;
    //头结点
    private ListNode<T> headNode;
    //链表容量
    private int capacity;
    //链表长度
    private int length;

    public LRUBaseLinkedList(){
        this.headNode = new ListNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(int capacity){
        this.headNode = new ListNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T data){

        //加入时先遍历，看看是否已经加入到链表之中
        //1.如果已经在链表中，找到这个节点并删除，然后把它再插入到头结点中
        //2.如果不在这个链表中：
        //    缓存未满，直接插入到链表头部
        //    缓存已满，删除末尾节点，然后新的数据点插入到链表头部
        //

    }







    public static class ListNode<T>{
        private ListNode next;
        private T element;

        public ListNode(){
            this.next = null;
        }

        public ListNode(T element){
            this.element = element;
        }

        public ListNode(T element,ListNode next){
            this.element = element;
            this.next = next;
        }

        public ListNode getNext() {
            return next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }




    public static void main(String[] args){

    }
}
