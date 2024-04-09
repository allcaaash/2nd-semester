package example19_02;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ConvertToBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int userNum = in.nextInt();
        System.out.println("Число " + userNum + " в двоичном представлении будет иметь вид: " + convertToBinary(userNum));

    }

    public static String convertToBinary(int decimal) {
        switch (decimal) {
            case 0:
                return "0";
            case 1:
                return "1";
            default:
                int remainder = decimal % 2;
                int quotient = decimal / 2;
                return convertToBinary(quotient) + remainder;
        }
    }
}