// Циклический односвязный список 

public class CircularLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node<T> tail; 
    private int size;
    
    public CircularLinkedList() {
        tail = null;
        size = 0;
    }
    
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            tail = newNode;
            tail.next = tail; 
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        size++;
    }
    
    public void addLast(T data) {
        addFirst(data); 
        tail = tail.next; 
    }
    
    public T removeFirst() {
        if (isEmpty()) {
            System.out.println("Список пуст");
        }
        
        Node<T> head = tail.next;
        T data = head.data;
        
        if (tail == tail.next) { 
            tail = null;
        } else {
            tail.next = head.next;
        }
        size--;
        return data;
    }
    
    public T removeLast() {
        if (isEmpty()) {
            System.out.println("Список пуст");
        }
        
        if (tail.next == tail) { 
            T data = tail.data;
            tail = null;
            size--;
            return data;
        }
        
        Node<T> current = tail.next;
        while (current.next != tail) {
            current = current.next;
        }
        
        T data = tail.data;
        current.next = tail.next;
        tail = current;
        size--;
        return data;
    }
    
    public boolean remove(T data) {
        if (isEmpty()) {
            return false;
        }
        
        Node<T> current = tail.next;
        Node<T> prev = tail;
        
        do {
            if (current.data.equals(data)) {
                if (current == tail && size == 1) { 
                    tail = null;
                } else {
                    prev.next = current.next;
                    if (current == tail) { 
                        tail = prev;
                    }
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);
        
        return false;
    }
    
    public boolean contains(T data) {
        return find(data) != null;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return tail == null;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Список пуст");
            return;
        }
        
        Node<T> current = tail.next;
        System.out.print("Начало циклического списка");
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != tail.next);
        System.out.println("Конец циклического списка");
    }
    
    public void clear() {
        tail = null;
        size = 0;
    }
    
    public void rotate() {
        if (!isEmpty()) {
            tail = tail.next; 
        }
    }
    

    public boolean findCycle() {
        return !isEmpty(); 
    }
    
    public Node<T> find(T data) {
        if (isEmpty()) {
            return null;
        }
        
        Node<T> current = tail.next;
        do {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.next;
        } while (current != tail.next);
        
        return null;
    }
    
    public CircularLinkedList<T>[] splitIntoTwo() {
        if (size < 2) {
            System.out.println("Недостаточно элементов для разделения");
        }
        
        CircularLinkedList<T>[] result = new CircularLinkedList[2];
        result[0] = new CircularLinkedList<>();
        result[1] = new CircularLinkedList<>();
        
        int splitIndex = size / 2;
        Node<T> current = tail.next;
        
        for (int i = 0; i < splitIndex; i++) {
            result[0].addLast(current.data);
            current = current.next;
        }
        
        for (int i = splitIndex; i < size; i++) {
            result[1].addLast(current.data);
            current = current.next;
        }
        
        return result;
    }
    
    public T getFirst() {
        if (isEmpty()) {
            System.out.println("Список пуст");
        }
        return tail.next.data;
    }
    
    public T getLast() {
        if (isEmpty()) {
            System.out.println("Список пуст");
        }
        return tail.data;
    }
}