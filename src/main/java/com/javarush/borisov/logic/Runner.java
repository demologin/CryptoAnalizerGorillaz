package com.javarush.borisov.logic;

import java.nio.file.Path;

public class Runner {


    public void run(MainMenu menu){

       int choice= menu.getCommand();
        switch (choice) {
            case 1 -> {

                Encrypt encrypt = new Encrypt(menu.getPathOfFile(),menu.getKey(),menu.getPathToEncryptedFile());
                encrypt.runEncrypt();

            }
        }
    }
}
