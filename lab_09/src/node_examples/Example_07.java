package node_examples;

import node.Node;

public class Example_07 {

    // удаление элемента из конца односвязного списка (с хвоста)
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

        ref = head;
        // перемещаемся на предпоследний элемент списка
        while(ref.next.next != null)
            ref = ref.next;
        // полю next предпоследнего элемента присваиваем null, что делает его последним элементом
        ref.next = null;

        System.out.println("Новый список: ");
        ref = head;
        while(ref != null) {
            System.out.println(ref.value);
            ref = ref.next;
        }
    }
}
