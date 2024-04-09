package node_examples;

import node.Node;

public class Example_03 {

    // добавление элемента в начало односвязного списка
    public static void main(String[] args) {
        Node head = null;
        for (int i = 9; i >= 0; i--) {
            head = new Node(i, head);
        }

        System.out.println("Исходный список:");
        Node ref = head;
        while(ref != null) {
            System.out.println(ref.value);
            ref = ref.next;
        }

        head = new Node(77, head);
        System.out.println("После добавления нового значения в начало списка:");
        ref = head;
        while (ref != null) {
            System.out.println(ref.value);
            ref = ref.next;
        }
    }
}
