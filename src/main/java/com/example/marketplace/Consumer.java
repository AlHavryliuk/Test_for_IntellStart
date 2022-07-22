package com.example.marketplace;

import java.util.ArrayList;

public class Consumer {
    private String name;
    private String surname;
    private final int id;
    private double countOfMoney;
    private ConsumerBag consumerBag;


    public Consumer(String name, String surname, double countOfMoney) {

        this.name = name;
        this.surname = surname;
        this.countOfMoney = countOfMoney;
        this.consumerBag = new ConsumerBag();
        id = hashCode();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getCountOfMoney() {
        return countOfMoney;
    }

    public void setCountOfMoney(double countOfMoney) {
        this.countOfMoney = countOfMoney;
    }

    public int getId() {
        return id;
    }

    public ConsumerBag getConsumerBag() {
        return consumerBag;
    }

    public void setConsumerBag(ConsumerBag consumerBag) {
        this.consumerBag = consumerBag;
    }

    @Override
    public String toString() {
        return "name = " + name + " , surname = " + surname +
                ", id = " + id;
    }
}
