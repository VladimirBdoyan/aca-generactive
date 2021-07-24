package com.company.model;

import com.company.configuration.Configuration;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 20.07.2021.
 * Time: 15:55.
 */

public class Generative extends Item {
    Random r = new Random();

    public Generative(String name, int price, Currency currency) {
        super(name, price, currency);
        setComplexity(addComplexity());
    }

    @Override
    public double calculate(Configuration configuration) {
        double finalPrice;
        finalPrice = getPrice() * configuration.getResolution().getCoefficient() * getComplexity();
        setFinalPrice(finalPrice);
        return finalPrice;
    }

    private double addComplexity() {
        double complexity;
        complexity = Math.round((r.nextDouble() + 1) * 10) / 10d;
        return complexity;
    }

}
