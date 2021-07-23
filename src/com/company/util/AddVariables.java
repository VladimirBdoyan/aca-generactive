package com.company.util;

import com.company.database.Storage;
import com.company.model.Configuration;
import com.company.model.Generative;
import com.company.model.Item;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 23.07.2021.
 * Time: 11:52.
 */
public  class AddVariables {
    private static final java.util.Scanner sc = new java.util.Scanner(System.in);
    private static final java.util.Scanner scInt = new java.util.Scanner(System.in);

    private AddVariables() {
    }

    protected static String addItemName() {
        String name;
        System.out.println(" Please input Item name ");
        name = sc.nextLine();
        return name;
    }
    protected static int addItemPrice() {
        int price;
        System.out.println(" Please input Item price ");
        price = scInt.nextInt();
        return price;
    }
    protected static Generative.Currency addItemCurrency() {
        Generative.Currency currency;
        System.out.println(" Please input Item Currency ");
        currency = Generative.Currency.valueOf(sc.nextLine());
        return currency;
    }
    protected static int addItemGroupId() {
        int groupId;
        System.out.println(" Please input Group Id for Item ");
        groupId = scInt.nextInt();
        return groupId;
    }
    protected static String setGroupName() {
        String name;
        System.out.println(" Please input Group name ");
        name = sc.nextLine();
        return name;
    }
    protected static String addGroupParentId() {
        String parentId;
        System.out.println(" Please input parent Group id ");
        parentId = sc.nextLine();
        int pId;
        if (!parentId.isEmpty()) {
            pId = Integer.parseInt(parentId);
            if (Storage.getGroup(pId) == null) {
                System.out.println(" Try again , because we haven't - " + pId + " Parent Group Id");
                parentId = "";
                addGroupParentId();
            }
        }
        return parentId;
    }
}
