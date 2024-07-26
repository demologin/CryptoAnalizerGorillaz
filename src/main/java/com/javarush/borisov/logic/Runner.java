package com.javarush.borisov.logic;


import java.io.FileNotFoundException;

import java.nio.file.AccessDeniedException;

public class Runner {


    public void run(MainMenu menu){
        int choice=0;
        while(choice != 9) {
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
                    case 9 -> {break;}

                    default -> System.out.println(Messages.WRONG_NUMBER);
                }
            }catch (AccessDeniedException e){

                System.out.println(Messages.ACCESS_DENIED);

            }catch (FileNotFoundException e){

                System.out.println(Messages.FILE_NOT_FOUND);
            }catch (Exception e){

                System.out.println(Messages.UNKNOWN_ERROR +
                        e.getLocalizedMessage().substring(e.getLocalizedMessage().indexOf(':')+1));
            }

        }
    }
}
