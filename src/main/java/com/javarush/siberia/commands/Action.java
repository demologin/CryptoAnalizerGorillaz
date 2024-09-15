package com.javarush.siberia.commands;

import com.javarush.siberia.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}