package node;

public class Node { // КЛАСС - СТРУКТУРА ЭЛЕМЕНТА СПИСКА
    public int value; // значение
    public String line; // значение
    public Node next; // поле-ссылка (указатель) на следующий узел

    public Node(int value, Node next) { // конструктор класса
        this.value = value;
        this.next = next;
    }

    public Node(String line, Node next) {
          this.line = line;
          this.next = next;
      }
}