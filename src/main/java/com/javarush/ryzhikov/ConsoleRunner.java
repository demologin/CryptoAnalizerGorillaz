package com.javarush.ryzhikov;

import com.javarush.ryzhikov.entity.Result;
import com.javarush.ryzhikov.utils.PathValidator;

import java.util.Scanner;

public class ConsoleRunner {
    public static final String TEXT_DIRECTORY = "./src/main/java/com/javarush/ryzhikov/text/";

    public static void main(String[] args) {
        String sourceFile;
        String targetFile;
        String key;

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Введите действие
                0. exit
                1. encode
                2. decode
                """);


        switch (scanner.nextLine()) {
            case "0", "exit" -> {
            }
            case "1", "encode" -> {
                System.out.println("Введите путь к файлу для кодирования:");
                System.out.println("[" + TEXT_DIRECTORY + "decrypted.txt" + "]");
                sourceFile = scanner.nextLine();
                if (!PathValidator.validate(sourceFile)) {
                    sourceFile = TEXT_DIRECTORY + "decrypted.txt";
                }
                System.out.println("sourceFile: " + sourceFile);
                System.out.println("Введите путь к файлу с результатом:");
                System.out.println("[" + TEXT_DIRECTORY + "encrypted.txt" + "]");
                targetFile = scanner.nextLine();
                if (!PathValidator.validate(targetFile)) {
                    targetFile = TEXT_DIRECTORY + "encrypted.txt";
                }
                System.out.println("targetFile: " + targetFile);
                System.out.println("Введите ключ шифрования:");
                key = scanner.nextLine();
                System.out.println("key: " + key);
                runApplication(new String[]{"encode", sourceFile, targetFile, key});
                break;
            }
            case "2", "decode" -> {
                System.out.println("Введите путь к файлу для декодирования:");
                System.out.println("[" + TEXT_DIRECTORY + "encrypted.txt" + "]");
                sourceFile = scanner.nextLine();
                if (!PathValidator.validate(sourceFile)) {
                    sourceFile = TEXT_DIRECTORY + "encrypted.txt";
                }
                System.out.println("sourceFile: " + sourceFile);
                System.out.println("Введите путь к файлу с результатом:");
                System.out.println("[" + TEXT_DIRECTORY + "decrypted.txt" + "]");
                targetFile = scanner.nextLine();
                if (!PathValidator.validate(targetFile)) {
                    targetFile = TEXT_DIRECTORY + "decrypted.txt";
                }
                System.out.println("targetFile: " + targetFile);
                System.out.println("Введите ключ шифрования:");
                key = scanner.nextLine();
                System.out.println("key: " + key);
                runApplication(new String[]{"decode", sourceFile, targetFile, key});
                break;
            }
            default -> {
                System.out.println("Команда не найдена");
                break;
            }
        }

    }

    static void runApplication(String[] args) {
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);

    }

}
