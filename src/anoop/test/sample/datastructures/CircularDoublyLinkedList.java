package anoop.test.sample.datastructures;

public class CircularDoublyLinkedList {

    public Node head;
    public Node tail;
    public int size;

    public static void main(String[] args) {
        CircularDoublyLinkedList dll = new CircularDoublyLinkedList();
        dll.create(5);
        dll.insert(2, 0);
        dll.insert(7, dll.size);
        dll.insert(3, 1);
        dll.insert(8, dll.size);
        dll.insert(4, 2);
        dll.traverse();
    }

    public Node create(int value){
        head = new Node();
        Node node = new Node();
        node.value = value;
        node.next = node;
        node.prev = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insert(int value, int location){
        Node node = new Node();
        node.value = value;
        if(head == null){
            create(value);
            return ;
        }
        if(location == 0) {
            node.next = head;
            node.prev = tail;
            head.prev = node;
            head = node;
            tail.next = head;
        } else if(location >= size) {
            node.prev = tail;
            node.next = head;
            tail.next = node;
            tail = node;
            head.prev = tail;
        } else {
            Node currentNode = head;
            for(int count=0; count<location-1; count++){
                currentNode = currentNode.next;
            }
            node.next = currentNode.next;
            node.prev = currentNode;
            currentNode.next.prev = node;
            currentNode.next = node;
        }
        size++;
    }

    public void traverse(){
        if(head == null){
            System.out.println("Linked List not exist !!");
            return ;
        }
        Node currentNode = head;

        for(int count=0; count<size; count++){
            if(currentNode.prev == null ){
                System.out.print("-,");
            } else {
                System.out.print(currentNode.prev.value+",");
            }
            System.out.print(currentNode.value);
            if(currentNode.next == null ){
                System.out.print(",-");
            } else {
                System.out.print(","+currentNode.next.value);
            }
            if(count != size-1){
                System.out.print(" >> ");
            }
            currentNode = currentNode.next;
        }
        System.out.println();
        System.out.println();
    }

    class Node {
        public int value;
        public Node next;
        public Node prev;
    }
}

