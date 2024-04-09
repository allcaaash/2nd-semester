package example19_08;

import node.Node;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cycle {
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
                            4. Добавить элемент в начало списка
                            5. Добавить элемент в конец списка
                            6. Добавить элемент в список с указанием номера
                            7. Удалить элемент из списка с головы списка
                            8. Удалить элемент из списка с хвоста списка
                            9. Удалить элемент из списка с указанием номера
                            10. Очмстить список
                            11. Завершение программы""");
            try {
                input = in.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Вы ввели не корректное число. Повторите попытку");
                in.next();
                continue;
            }
            if (head == null && input != 1 && input != 2 && input != 11) {
                System.out.println("Список пуст. Для начала его следует заполнить\n");
                continue;
            }
            switch (input) {
                case 1:
                    in.nextLine();
                    head = createHead(nodeCount);
                    break;
                case 2:
                    in.nextLine();
                    head = createTail(nodeCount);
                    break;
                case 3:
                    System.out.println(onScreen(head));
                    break;
                case 4:
                    String newFirstLine = in.next();
                    head = addFirst(newFirstLine, head);
                    break;
                case 5:
                    String newLastLine = in.next();
                    addLast(newLastLine, head);
                    break;
                case 6:
                    int addIndex = in.nextInt();
                    int listLength = 1;
                    Node addRef = head;
                    while (addRef.next != null) {
                        addRef = addRef.next;
                        listLength++;
                    }
                    if (addIndex > 0 && addIndex < listLength) {
                        String newLine = in.next();
                        insert(addIndex, newLine, head);
                    } else
                        System.out.println("Не корректный индекс");
                    break;
                case 7:
                    head = removeFirst(head);
                    break;
                case 8:
                    removeLast(head);
                    break;
                case 9:
                    int removeIndex = in.nextInt();
                    int count = 1;
                    Node ref = head;
                    while (ref.next != null) {
                        ref = ref.next;
                        count++;
                    }
                    if (removeIndex > 0 && removeIndex < count)
                        removeByIndex(removeIndex, head);
                    else
                        System.out.println("Не корректный индекс");
                    break;
                case 10:
                    head = remove();
                    break;

            }
        } while (input != 11);
        System.out.println("Конец выполнения программы");
    }

    public static Node createHead(int nodeCount) {
        Node head = null;
        for (int i = 0; i < nodeCount; i++) {
            String line = in.nextLine();
            head = new Node(line, head);
        }

        return head;
    }

    public static Node createTail(int nodeCount) {
        String line = in.nextLine();
        Node head = new Node(line, null);
        for (int i = nodeCount - 2; i >= 0; i--) {
            Node ref = head;
            while (ref.next != null)
                ref = ref.next;
            line = in.nextLine();
            ref.next = new Node(line, null);
        }

        return head;
    }

    public static String onScreen(Node head) {
        StringBuilder concat = new StringBuilder();
        Node ref = head;
        while (ref != null) {
            concat.append(ref.line);
            ref = ref.next;
        }

        return concat.toString();
    }

    public static Node addFirst(String newLine, Node head) {
        return new Node(newLine, head);
    }

    public static void addLast(String newLine, Node head) {
        Node ref = head;
        while (ref.next != null)
            ref = ref.next;
        ref.next = new Node(newLine, null);
    }

    public static void insert(int index, String line, Node head) {
        Node newNode = new Node(line, null);
        int count = 1;
        Node ref = head;
        while (count < index - 1) {
            ref = ref.next;
            count++;
        }
        newNode.next = ref.next;
        ref.next = newNode;
    }

    public static Node removeFirst(Node head) {
        return head.next;
    }

    public static void removeLast(Node head) {
        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
    }

    public static void removeByIndex(int index, Node head) {
        int count = 1;
        Node ref = head;
        while (ref != null && count < index) {
            ref = ref.next;
            count++;
        }
        ref.next = ref.next.next;
    }

    public static Node remove() {
        return null;
    }
}

