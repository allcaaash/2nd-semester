package example19_04;

import node.Node;

public class nodeExample {
    public static void main(String[] args) {
        // создание несвязных узлов с помощью конструктора
        Node node0 = new Node(0, null);     // 0-й узел - голова списка
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);     // последний узел - хвост списка

        // связывание узлов в список с помощью ссылки
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        // вывод списка с использованием вспомогательной переменной ref,
        // соответствующей текущему значению ссылки при прохождении по списку
        Node ref = node0; // для перемещения по списку достаточно помнить ссылку
        while (ref != null) {
            System.out.println(" " + ref.value);
            ref = ref.next;
        }
    }
}
