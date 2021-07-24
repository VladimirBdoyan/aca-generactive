package com.company.model;

import com.company.configuration.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 17.07.2021.
 * Time: 12:19.
 */
public abstract class Item {
    private static int idGeneration = 0;
    private Integer id;
    private String name;
    private int price;
    private Currency currency;
    private Group group;
    private double finalPrice;
    Configuration resolution;
    private double complexity;

    public void setComplexity(double complexity) {
        this.complexity = complexity;
    }

    public double getComplexity() {
        return complexity;
    }


    public Item(String name, int price, Currency currency) {
        this.id = ++idGeneration;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.group = null;
        this.finalPrice = 0;
        this.resolution = null;
        this.complexity = 0.0;
    }

    public abstract double calculate(Configuration configuration);

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Configuration getResolution() {
        return resolution;
    }

    public void setResolution(Configuration resolution) {
        this.resolution = resolution;
    }

    public    Configuration setItemResolution(String resolution) {
        Configuration itemResolution = null;
        // Check if choose trust resolution
        Boolean bool = false;
        do {

            switch (resolution) {
                case "HD":
                    itemResolution = new Configuration(Configuration.Resolution.HD);
                    break;
                case "FHD":
//                    itemResolution = Configuration.Resolution.FHD;
                    itemResolution = new Configuration(Configuration.Resolution.FHD);
                    break;
                case "FOUR_4K":
//                    itemResolution = Configuration.Resolution.FOUR_4K;
                    itemResolution = new Configuration(Configuration.Resolution.FOUR_4K);
                    break;
                default:
                    System.out.println("Invalid choose");
                    bool = true;
                    break;
            }
        } while (bool);
        return itemResolution;
    }



    public enum Currency {
        AMD, DOLLAR, EURO

    }
}
