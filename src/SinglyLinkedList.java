

public class SinglyLinkedList<T> {

    private static class Node<T> {
        public T data;
        public Node<T> next;

    

        public Node(T data) {
            this.data = data;
            this.next = null;

        }

    }

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        
        if(head == null) {
            head = newNode;
        }
        else {
            Node<T> current = head;

            while(current.next != null) {
                current = current.next;
            }

            current.next = newNode;

        }

        size++;

    }

    public void display() {
        Node<T> current = head;
        int count = 1;

        while(current != null) {
            System.out.print("элемент №" + count + " = " + current.data + " ");
            current = current.next;
            count++;

        }
    }

    public static void main(String[] args) {
        
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.addFirst(12);
        linkedList.addLast(13);
        linkedList.addFirst(0);

        linkedList.display();





    }




}