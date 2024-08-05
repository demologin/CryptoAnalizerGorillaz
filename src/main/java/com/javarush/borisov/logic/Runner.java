package com.javarush.borisov.logic;


import com.javarush.borisov.logic.exception.MyException;

import java.util.Arrays;


public class Runner {


    public void run(MainMenu menu, String[] param) {
        int choice = 0;

        while (choice != 9) {
            if (param.length ==0) {
                choice = menu.getCommand();
            }else {
                Messages mes = Messages.valueOf(param[0].toUpperCase());

                choice = mes.ordinal();
            }
            try {
                switch (choice) {
                    case 1 -> {
                        Encrypt encrypt = new Encrypt(menu.getPathToGetFile(param[1]), menu.getKey(param[2]), menu.getPathToSaveFile(param[3]));
                        encrypt.runEncrypt();
                    }
                    case 2 -> {
                        Decrypt decrypt = new Decrypt(menu.getPathToGetFile(1), menu.getKey(param[2]), menu.getPathToSaveFile(1,param[3]), Const.ALPHABET);
                        decrypt.runDecrypt();
                    }
                    case 3 -> {
                        ButForce butForce = new ButForce(menu.getPathToGetFile(1), menu.getPathToSaveFile(1,param[3]));
                        butForce.runBF();
                    }


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
