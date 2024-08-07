package com.javarush.kartsev.commands;

import com.javarush.kartsev.entity.Result;

public interface Action {

    Result execute(String[] parameters);

}
