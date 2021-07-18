package com.company.model;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 17.07.2021.
 * Time: 12:19.
 */
public class Item {
    private static int idGeneration = 0;
    private Integer id;
    private String name;
    private int price;
    private Currency currency;
    private Group group;

    public Item(String name, int price, Currency currency) {
        this.id = ++idGeneration;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.group = null;
    }

    public static int getIdGeneration() {
        return idGeneration;
    }

    public static void setIdGeneration(int idGeneration) {
        Item.idGeneration = idGeneration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public enum Currency {
        AMD, DOLLAR, EURO

    }
}
