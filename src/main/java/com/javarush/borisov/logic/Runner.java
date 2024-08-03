package com.javarush.borisov.logic;


import com.javarush.borisov.logic.exception.MyException;



public class Runner {


    public void run(MainMenu menu) {
        int choice = 0;
        while (choice != 9) {
            choice = menu.getCommand();
            try {
                switch (choice) {
                    case 1 -> {
                        Encrypt encrypt = new Encrypt(menu.getPathToGetFile(), menu.getKey(), menu.getPathToSaveFile());
                        encrypt.runEncrypt();
                    }
                    case 2 -> {
                        Decrypt decrypt = new Decrypt(menu.getPathToGetFile(1), menu.getKey(), menu.getPathToSaveFile(1), Const.ALPHABET);
                        decrypt.runDecrypt();
                    }
                    case 3 -> {
                        ButForce butForce = new ButForce(menu.getPathToGetFile(1), menu.getPathToSaveFile(1));
                        butForce.runBF();
                    }
                    case 9 -> {}

                    default -> System.out.println(Messages.WRONG_NUMBER);
                }
            } catch (MyException e) {

                System.out.println(e.getLocalizedMessage());

            } catch (Exception e) {

                System.out.println(Messages.UNKNOWN_ERROR +
                        e.getLocalizedMessage().substring(e.getLocalizedMessage().indexOf(':') + 1));
            }

        }
    }
}
