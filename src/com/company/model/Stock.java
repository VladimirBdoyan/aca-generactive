package com.company.model;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 20.07.2021.
 * Time: 15:55.
 */
public class Stock extends  Item{
    public Stock(String name, int price, Currency currency) {
        super(name, price, currency);
    }

    @Override
    public double calculate(Configuration configuration) {
        double finalPrice;
        finalPrice = getPrice() * configuration.getResolution().getCoefficient();
        setFinalPrice(finalPrice);
        return finalPrice;
    }
}
