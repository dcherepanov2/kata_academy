import service.UserNumberExecutor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите два числа, и что нужно с ними сделать...");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(UserNumberExecutor.calc(input));
    }
}

