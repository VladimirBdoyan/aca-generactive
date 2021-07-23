package com.company.util;

import com.company.database.Storage;
import com.company.model.Stock;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 22.07.2021.
 * Time: 15:37.
 */
public class CreateStock {
    private CreateStock() {
    }

    public static Stock createStock(){
        Stock stock = new Stock(AddVariables.addItemName(), AddVariables.addItemPrice(), AddVariables.addItemCurrency());
        System.out.println("Created stock Item with Id - " + stock.getId());
        stock.setGroup(Storage.getGroup(AddVariables.addItemGroupId()));
        return stock;
    }
}
