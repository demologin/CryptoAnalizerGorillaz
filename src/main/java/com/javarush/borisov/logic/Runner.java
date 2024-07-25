package com.javarush.borisov.logic;



public class Runner {


    public void run(MainMenu menu){
        while(true) {
            int choice = menu.getCommand();
            switch (choice) {
                case 1 -> {

                    Encrypt encrypt = new Encrypt(menu.getPathToGetFile(), menu.getKey(), menu.getPathToSaveFile());

                    encrypt.runEncrypt();


                }
                case 2 -> {
                    Decrypt decrypt = new Decrypt(menu.getPathToGetFile(), menu.getKey(), menu.getPathToSaveFile() );
                    decrypt.runDecrypt();
                }
            }
            break;
        }
    }
}
