package node_examples;

import node.Node;

public class Example_04 {

    // добавление элемента в конец односвязного списка
    public static void main(String[] args) {
        Node head = null;
        for (int i = 9; i >= 0; i--) {
            head = new Node(i, head);
        }

        System.out.println("Исходный список: ");
        Node ref = head;
        while(ref != null) {
            System.out.println(ref.value);
            ref = ref.next;
        }

        // добавление нового хначения в конец списка
        Node newTail = new Node(78, null);
        ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = newTail;

        // отображение нового списка
        System.out.println("Изененный список: ");
        ref = head;
        while(ref != null) {
            System.out.println(ref.value);
            ref = ref.next;
        }
    }
}
