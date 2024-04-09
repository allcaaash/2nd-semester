package node_examples;

import node.Node;

public class Example_05 {

    // добавление нового элмента в середину односвязного списка
    public static void main(String[] args) {
        Node head = null;
        for (int i = 9; i >= 0; i--) {
            head = new Node(i, head);
        }
        System.out.println("Исхоный список: ");
        Node ref = head;
        while(ref != null) {
            System.out.println(ref.value);
            ref = ref.next;
        }

        // вставка элемента в середину списка
        Node newNode = new Node(79, null);
        ref = head;
        int count = 1; // счетчик элементов
        while (ref.next != null && count < 5) {
            ref = ref.next;
            count++;
        }
        // переброска ссылок при вставке элементов
        newNode.next = ref.next;
        // если нужно произвести не добавление, а замену, то тогда
        //newNode.next = ref.next.next;
        // но нужно делать в блоке try, т.к. есть риск генерации исключения NullPointerException
        ref.next = newNode;

        // вывод измененного списка
        System.out.println("Итоговый список: ");
        ref = head;
        while (ref != null) {
            System.out.println(ref.value);
            ref = ref.next;
        }
    }
}
