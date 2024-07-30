package com.javarush.siberia.menu;

import com.javarush.siberia.constants.Constants;

import java.util.Scanner;

public class ConsoleMenu {

    private final ConsoleApplication consoleApplication;

    public ConsoleMenu(ConsoleApplication consoleApplication) {
        this.consoleApplication = consoleApplication;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(Constants.MENU_TXT);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    toEncode(scanner);
                    break;
                case "2":
                    toDecode(scanner);
                    break;
                case "3":
                    toBruteForce(scanner);
                    return;
                case "4":
                    toAnalyse(scanner);
                    return;
                case "5":
                    System.out.println(Constants.EXIT_TXT);
                    return;
                default:
                    System.out.println(Constants.INVALID_CHOICE_TXT);
                    break;
            }
        }
    }

    private void toEncode(Scanner scanner) {
        System.out.print(Constants.ENCODE_TXT);
        String encodeInputPath = scanner.nextLine().trim();
        if (encodeInputPath.isEmpty()) {
            encodeInputPath = Constants.INPUT_FILE;
        }

        System.out.print(Constants.OUTPUT_TXT);
        String encodeOutputPath = scanner.nextLine().trim();
        if (encodeOutputPath.isEmpty()) {
            encodeOutputPath = Constants.ENCODED_FILE;
        }

        System.out.print(Constants.KEY_TXT);
        String encodeKeyInput = scanner.nextLine().trim();
        int encodeKey = encodeKeyInput.isEmpty()
                ? Constants.DEFAULT_SHIFT
                : Integer.parseInt(encodeKeyInput);

        String[] encodeArgs = {"encode", String.valueOf(encodeKey), encodeInputPath, encodeOutputPath};
        consoleApplication.run(encodeArgs);
        System.out.println("Шифрование завершено.");
    }

    private void toDecode(Scanner scanner) {
        System.out.print(Constants.DECODE_TXT);
        String decodeInputPath = scanner.nextLine().trim();
        if (decodeInputPath.isEmpty()) {
            decodeInputPath = Constants.ENCODED_FILE;
        }

        System.out.print(Constants.OUTPUT_TXT);
        String decodeOutputPath = scanner.nextLine().trim();
        if (decodeOutputPath.isEmpty()) {
            decodeOutputPath = Constants.DECODED_FILE;
        }

        System.out.print(Constants.KEY_TXT);
        String decodeKeyInput = scanner.nextLine().trim();
        int decodeKey = decodeKeyInput.isEmpty()
                ? Constants.DEFAULT_SHIFT
                : Integer.parseInt(decodeKeyInput);

        String[] decodeArgs = {"decode", String.valueOf(decodeKey), decodeInputPath, decodeOutputPath};
        consoleApplication.run(decodeArgs);
        System.out.println("Дешифрование завершено.");
    }

    private void toBruteForce(Scanner scanner) {
        System.out.println("В разработке... Ожидайте новых обновлений.");
    }

    private void toAnalyse(Scanner scanner) {
        System.out.println("В разработке... Ожидайте новых обновлений.");
    }
}