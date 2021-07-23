package com.company.service;

import com.company.database.Storage;
import com.company.model.Configuration;
import com.company.model.Generative;
import com.company.model.Group;
import com.company.model.Stock;
import com.company.util.CreateGenerative;
import com.company.util.CreateGroup;
import com.company.util.CreateStock;

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

            CreateGroup.createGroup();
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
            System.out.println("If you want to continue add new Item \n" +
                    "1 - Continue \n" +
                    "2 - Exit");
            command = scint.nextInt();
            if (command == 1) {
                System.out.println("What type of Items you want to create , please choose  \n" +
                        "1 - Generative \n" +
                        "2 - Stock");
                command = scint.nextInt();
                if (command == 1) {

                    Generative generative = CreateGenerative.createGenerative();
                    System.out.println("Choose resolution for generative Item");
                    for (Configuration.Resolution element : Configuration.Resolution.values()) {
                        System.out.println(element);
                    }
                    String resolution = sc.nextLine();
                    generative.setResolution(generative.setItemResolution(resolution));
                    generative.setFinalPrice(generative.calculate(generative.getResolution()));
                    Storage.newItem(generative);
                } else if (command == 2) {
                    System.out.println(" Please input Stock Item name ");
                    Stock stock = CreateStock.createStock();
                    System.out.println("Choose resolution for Stock Item");
                    for (Configuration.Resolution element : Configuration.Resolution.values()) {
                        System.out.println(element);
                    }
                    String resolution = sc.nextLine();
                    stock.setResolution(stock.setItemResolution(resolution));
                    stock.setFinalPrice(stock.calculate(stock.getResolution()));
                } else {
                    bool = false;
                }
            }
        }
        print();
        System.out.println();
    }

    private static void print() {
        List<Group> list = Storage.getGroupList();
        for (Group group : list) {
            if (group.getParentGroup() == null) {
                group.printContent();
            }
        }
    }
}
