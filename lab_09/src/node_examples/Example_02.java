package node_examples;

import node.Node;

public class Example_02 {
    public static void main(String[] args) {
        // второй вариант первого примера
        // добавление элементов с перемещением головы (наращивание головы)
        Node head = null;   // начальное значение ссылки на голову
        for (int i = 9; i >= 0; i --) {
            head = new Node(i, head);
        }
        // вывод элементов на экран
        Node ref2 = head;
        while(ref2 != null) {
            System.out.println(" " + ref2.value);
            ref2 = ref2.next;
        }
    }
}
