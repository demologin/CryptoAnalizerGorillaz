package com.javarush.borisov.logic;


import java.io.IOException;
import java.nio.file.AccessDeniedException;

public class Runner {


    public void run(MainMenu menu){
        int choice=0;
        while(choice != 3) {
            choice = menu.getCommand();
            try {
                switch (choice) {
                    case 1 -> {

                        Encrypt encrypt = new Encrypt(menu.getPathToGetFile(), menu.getKey(), menu.getPathToSaveFile());

                        encrypt.runEncrypt();


                    }
                    case 2 -> {
                        Decrypt decrypt = new Decrypt(menu.getPathToGetFile(), menu.getKey(), menu.getPathToSaveFile());
                        decrypt.runDecrypt();
                    }
                    case 3 -> {

                    }
                }
            }catch (AccessDeniedException e){
                System.out.println("\nне могу создать файл (отказано в доступе, давай по новой)\n");
            }catch (IOException e){
                System.out.println("\nфайл по указанному пути отсутсвует, давай по новой\n");
            }

        }
    }
}
