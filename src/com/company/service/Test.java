package com.company.service;

import com.company.model.Generative;
import com.company.model.Group;
import com.company.model.Item;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 23.07.2021.
 * Time: 15:13.
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scint = new Scanner(System.in);
        Group group1 = new Group("Group1");
        Group group2 = new Group("Group2");
        Group group3 = new Group("Group3");
        Group group4 = new Group("Group4");
        Group group5 = new Group("Group5");
        Group group6 = new Group("Group6");
        Generative gen1 = new Generative("gen1",1000, Item.Currency.AMD);
        Generative gen2 = new Generative("gen2",1500, Item.Currency.AMD);
        Generative gen3 = new Generative("gen3",2000, Item.Currency.AMD);
        Generative stock1 = new Generative("stock1",3000, Item.Currency.AMD);
        Generative stock2 = new Generative("stock2",4000, Item.Currency.AMD);

        group2.setParentGroup(group1);
        group3.setParentGroup(group2);
        group4.setParentGroup(group2);
        group6.setParentGroup(group5);

        group1.addSubGroup(group2);
        group2.addSubGroup(group3);
        group2.addSubGroup(group4);
        group5.addSubGroup(group6);

        gen1.setGroup(group3);
        gen2.setGroup(group4);
        gen3.setGroup(group5);
        stock1.setGroup(group6);
        stock2.setGroup(group1);

        group3.addItem(gen1);
        group4.addItem(gen2);
        group5.addItem(gen3);
        group6.addItem(stock1);
        group1.addItem(stock2);

        group1.printContent();
        group5.printContent();


    }
}
