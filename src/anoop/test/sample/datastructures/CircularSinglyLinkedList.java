package anoop.test.sample.datastructures;

public class CircularSinglyLinkedList {

    public Node head;
    public Node tail;
    public int size;

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.create(5);

        csll.insert(1, 0);// Inserting into first element O(1) complexity
        csll.insert(8, 10);// Inserting into last element O(1) complexity
        csll.insert(6, 2);
        // Inserting into last element O(1) complexity
        csll.insert(10, csll.size);
        csll.insert(11, csll.size);

        System.out.println();
        System.out.println("Given Linked list");
        csll.traverse();

        System.out.println("Deleting first node");
        csll.delete(0);
        csll.traverse();

        System.out.println("Deleting third node");
        csll.delete(2);
        csll.traverse();

        System.out.println("Deleting last node");
        csll.delete(csll.size);
        csll.traverse();
    }

    public Node create(int value){
        head = new Node();
        Node node = new Node();
        node.value = value;
        node.next = node;
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
            head = node;
            tail.next = head;
        } else if(location >= size) {
            tail.next = node;
            tail = node;
            tail.next = head;
        } else {
            Node currentNode = head;
            for(int count=0; count<location-1; count++){
                currentNode = currentNode.next;
            }
            node.next = currentNode.next;
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
            System.out.print(currentNode.value);
            if(count != size-1){
                System.out.print(" >> ");
            }
            currentNode = currentNode.next;
        }
        System.out.println();
        System.out.println();
    }
    public void delete(int location){
        if(head == null){
            System.out.println("Linked List not exist !!");
            return ;
        }

        if(location == 0) {
            head = head.next;
            tail.next = head;
        } else if(location >= size) {
            Node currentNode = head;
            for(int count=0; count<size-1; count++){
                currentNode = currentNode.next;
            }
            tail = currentNode;
            currentNode.next = head;
        } else {
            Node currentNode = head;
            for(int count=0; count<location-1; count++){
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
        size--;
        if (size==0){
            head = null;
            tail = null;
            head.next = null;
        }
    }
    class Node {
        public int value;
        public Node next;
    }
}



