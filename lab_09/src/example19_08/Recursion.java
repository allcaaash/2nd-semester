package example19_08;

import node.Node;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Recursion {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int input = -1;
        int nodeCount;
        Node head = null;
        System.out.print("Введите количество узлов для заполнения линейного одновязного списка: ");
        try {
            nodeCount = in.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Вы ввели не корректное число. Повторите попытку");
            return;
        }
        if (nodeCount <= 0) {
            System.out.println("Количество узлов не может быть меньше или равно 0");
            return;
        }
        do {
            System.out.println("Что вы хотите сделать со списком(введите номер пункта):");
            System.out.println(
                    """
                            1. Ввод с головы
                            2. Ввод с хвоста
                            3. Вывод списка
                            0. Завершение программы""");
            try {
                input = in.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Вы ввели не корректное число. Повторите попытку");
                in.next();
                continue;
            }
            if (head == null && input != 0 && input != 1 && input != 2) {
                System.out.println("Список пуст. Для начала его следует заполнить\n");
                continue;
            }
            switch (input) {
                case 1:
                    head = createHeadRec(nodeCount, null);
                    break;
                case 2:
                    head = createTailRec(nodeCount, null);
                    break;
                case 3:
                    System.out.println(toStringRec(head));
                    break;
            }
        } while (input != 0);
        System.out.println("Конец выполнения программы");
    }

    public static Node createHeadRec(int nodeCount, Node head) {
        if (nodeCount == 0)
            return null;
        String line = in.next();
        head = new Node(line, createHeadRec(--nodeCount, head));
        return head;
    }

    public static Node createTailRec(int nodeCount, Node head) {
        if (nodeCount == 0)
            return head;

        String line = in.next();
        if (head == null) {
            head = new Node(line, null);
        } else {
            Node ref = head;
            while (ref.next != null)
                ref = ref.next;
            ref.next = new Node(line, null);
        }

        return createTailRec(--nodeCount, head);
    }

    public static String toStringRec(Node head) {
        if (head == null)
            return "";
        return head.line + toStringRec(head.next);
    }
}
