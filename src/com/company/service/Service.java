package com.company.service;

import com.company.database.Storage;
import com.company.model.Group;
import com.company.model.Item;

import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 17.07.2021.
 * Time: 13:14.
 */
public class Service {
    private static final Scanner sc = new Scanner(System.in);
    private static final Scanner scint = new Scanner(System.in);


    public static void work() {
        boolean bool = true;
        int command;
        while (bool) {
            addGroup();
            System.out.println("If you want to continue add new Group \n" +
                    "1 - Continue \n" +
                    "2 - Exit");
            command = scint.nextInt();
            if (command == 1) {
                bool = true;
            } else {
                bool = false;
            }
        }
        bool = true;
        while (bool) {
            addItem();
            System.out.println("If you want to continue add new Item \n" +
                    "1 - Continue \n" +
                    "2 - Exit");
            command = scint.nextInt();
            if (command == 1) {
                bool = true;
            } else {
                bool = false;
            }
        }
        print();
    }

    private static void print() {
        List<Group> list = Storage.getGroupList();
        for (Group group : list) {
            if (group.getParentGroup() == null) {
                group.printContent();
            }
        }
    }

    public static void addGroup() {
        String name;
        String parentId;
        int pId;
        System.out.println(" Please input Group name ");
        name = sc.nextLine();
        System.out.println(" Please input parent Group id ");
        parentId = sc.nextLine();
        Group group = new Group(name);
        System.out.println("Created group with Id - " + group.getId());

        if (!parentId.isEmpty()) {
            pId = Integer.parseInt(parentId);
            Storage.getGroup(pId).addSubGroup(group);
        }
        Storage.addGroup(group);
    }

    public static void addItem() {
        String name;
        int price;
        Item.Currency currency;
        int groupId;
        System.out.println(" Please input Item name ");
        name = sc.nextLine();
        System.out.println(" Please input Item price ");
        price = scint.nextInt();
        System.out.println(" Please input Item Currency ");
        currency = Item.Currency.valueOf(sc.nextLine());
        System.out.println(" Please input Group Id for Item ");
        groupId = scint.nextInt();
        Item item = new Item(name, price, currency);
        System.out.println("Created Item with Id - " + item.getId());

        Storage.getGroup(groupId).addItem(item);
        Storage.addItem(item);
    }
}
