package node_examples;

import node.Node;

public class Example_08 {

    // удаление элемента из середины односвязного списка
    public static void main(String[] args) {
        Node head = null;
        for (int i = 10; i >= 0; i--)
            head = new Node(i, head);

        System.out.println("Изначальный список: ");
        Node ref = head;
        while (ref != null) {
            System.out.println(ref.value);
            ref = ref.next;
        }

        int count = 1;
        int index = 5;  // удаляемый индекс
        ref = head;
        while (ref != null && count < index) {
            ref = ref.next;
            count++;
        }
        ref.next = ref.next.next;

        System.out.println("Измененый список: ");
        ref = head;
        while (ref != null) {
            System.out.println(ref.value);
            ref = ref.next;
        }
    }
}
