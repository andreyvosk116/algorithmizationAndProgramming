public class DoublyLinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }
    
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public T removeFirst() {
        if (isEmpty()) {
           System.out.println("Список пуст");
        }
        T data = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }
    
    public T removeLast() {
        if (isEmpty()) {
            System.out.println("Список пуст");
        }
        T data = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }
    
    public boolean remove(T data) {
        if (isEmpty()) {
            return false;
        }
        
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                if (current == head) {
                    removeFirst();
                } else if (current == tail) {
                    removeLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                }
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
        System.out.print("Список с начала: начало <- ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            } else {
                System.out.print(" -> конец");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    public void clear() {
        head = tail = null;
        size = 0;
    }
    
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            System.out.println("Индекст выходит за рамки списка");
        }
        
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node<T> newNode = new Node<>(data);
            Node<T> current = getNode(index);
            
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }
    
    public T remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Индекст выходит за рамки списка");
        }
        
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<T> current = getNode(index);
            T data = current.data;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
            return data;
        }
    }
    
    public T get(int index) {
        return getNode(index).data;
    }
    
    public void displayReverse() {
        Node<T> current = tail;
        System.out.print("Список с конца: конец <- ");
        while (current != null) {
            System.out.print(current.data);
            if (current.prev != null) {
                System.out.print(" <-> ");
            } else {
                System.out.print(" -> начало");
            }
            current = current.prev;
        }
        System.out.println();
    }
    
    public T getFirst() {
        if (isEmpty()) {
            System.out.println("Список пуст");
        }
        return head.data;
    }
    
    public T getLast() {
        if (isEmpty()) {
            System.out.println("Список пуст");
        }
        return tail.data;
    }
    
    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Индекст выходит за рамки списка");
        }
        
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}