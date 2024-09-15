package com.javarush.ryzhikov.command;


import com.javarush.ryzhikov.entity.Result;

public interface Action {
     Result execute(String[] parameters);
 //    void validateParameters(String[] parameters);
}
