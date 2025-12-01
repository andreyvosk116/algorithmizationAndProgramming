public class SinglyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
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
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    public T removeFirst() {
        if (isEmpty()) {
            System.out.println("Список пуст");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    public T removeLast() {
        if (isEmpty()) {
            System.out.println("Список пуст");
        }
        
        if (head.next == null) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }
        
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }
    
    public boolean remove(T data) {
        if (isEmpty()) {
            return false;
        }
        
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void display() {
        Node<T> current = head;
        System.out.print("Начало списка: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("конец");
    }
    
    public void clear() {
        head = null;
        size = 0;
    }
}




