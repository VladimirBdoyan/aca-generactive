package com.company.util;

import com.company.database.Storage;
import com.company.model.Generative;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 21.07.2021.
 * Time: 12:11.
 */
public  class CreateGenerative {
    private CreateGenerative() {
    }

    public static Generative createGenerative() {

        Generative generative = new Generative(AddVariables.addItemName(), AddVariables.addItemPrice(), AddVariables.addItemCurrency());

        System.out.println("Created generative Item with Id - " + generative.getId());

        generative.setGroup(Storage.getGroup(AddVariables.addItemGroupId()));
        return generative;
    }
}
