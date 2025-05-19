//Design Linked List
//link:https://leetcode.com/problems/design-linked-list/description/


class MyLinkedList {
    private class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    Node head,tail;
    int size;

    public MyLinkedList() { 
        head=null;
        tail=null;
        size=0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return (temp!=null)? temp.data : -1;
    }
    
    public void addAtHead(int val) {
        Node newNode=new Node(val);
        if(head==null){
            head=tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        Node newNode=new Node(val);
        if(tail==null){
            head=tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size) return;
        if(index==0){
            addAtHead(val);
            return;
        }
        if(index==size){
            addAtTail(val);
            return;
        }
        Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        if(temp==null) return;
        Node newNode=new Node(val);
        newNode.next=temp.next;
        temp.next=newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if(index==0){
            head=head.next;
            if(size==1) tail=null;
            size--;
            return;
        }
        Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        if(temp==null || temp.next==null)
            return;
        temp.next=temp.next.next;
        if(index==size-1)tail=temp;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */