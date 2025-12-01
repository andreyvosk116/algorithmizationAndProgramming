public class testsList {
    public static void main(String[] args) {

        SinglyLinkedList<Integer> singlList = new SinglyLinkedList<>();
        DoublyLinkedList<Integer> doubleList = new DoublyLinkedList<>();
        CircularLinkedList<Integer> circularList = new CircularLinkedList<>();

        //Заполняем списки 

        singlList.addFirst(52); 
        singlList.addLast(40);
        singlList.addFirst(31);

        singlList.display();
        //Удаляем элементы
        singlList.removeFirst();
        singlList.removeLast();

        singlList.display();
        //иные функции

        System.out.println(singlList.isEmpty());
        System.out.println(singlList.contains(52));
        System.out.println(singlList.contains(31));
        System.out.println(singlList.size());

        // Заполняем список
        doubleList.addFirst(52);
        doubleList.addLast(40);
        doubleList.addFirst(31);
        doubleList.display();
        
        // Удаляем элементы
        doubleList.removeFirst();
        doubleList.removeLast();
        doubleList.display();
        
        // Иные функции
        System.out.println("Пуст ли список: " + doubleList.isEmpty());
        System.out.println("Содержит 52: " + doubleList.contains(52));
        System.out.println("Содержит 31: " + doubleList.contains(31));
        System.out.println("Размер: " + doubleList.size());
        
        // Дополнительные тесты для двусвязного списка
        System.out.println("\nДополнительные тесты DoublyLinkedList:");
        doubleList.addLast(100);
        doubleList.addFirst(200);
        doubleList.display();
        doubleList.displayReverse(); // Вывод в обратном порядке
        System.out.println("Первый элемент: " + doubleList.getFirst());
        System.out.println("Последний элемент: " + doubleList.getLast());

    }
}
