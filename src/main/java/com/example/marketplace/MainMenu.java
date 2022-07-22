package com.example.marketplace;


import static com.example.marketplace.SupportClass.inputNum;
import static com.example.marketplace.View.*;

public class MainMenu {

    public static ConsumerList consumerList = new ConsumerList();
    public static ProductList productList = new ProductList();


    public static void MainSwitch () {
        String StartBlock = (""" 
                1. Add consumer or product.\s
                2. Remove consumer or product. \s
                3. Buy product. \s
                4. Get list of consumer or product. \s
                5. Smart list.
                6. Exit.""".indent(1));
        System.out.println(StartBlock);

        int number = inputNum();

        switch (number){
            case (1) :
                addSwitch();
            case (2) :
                removeSwitch();
            case (3) :
                buySwitch();
            case (4) :
                getListSwitch();
            case (5) :
                smartSwitch();
            case (6) :
                System.exit(0);
            default:
                System.out.println(" Check your number! \n");
                MainSwitch();
        }
    }

    public static void addSwitch () {
        System.out.println("""
                1. Add consumer.
                2. Add product.
                3 or more. Back to Main Menu.""");
        int number = inputNum();
        if (number == 1) {
            addNewConsumer();
        } else if (number == 2) {
            addNewProduct();
        } else {
            MainSwitch();
        }
    }
    public static void removeSwitch () {
        System.out.println("""
                1. Remove consumer.
                2. Remove product.
                3 or more. Back to Main Menu.""");
        int number = inputNum();
        if (number == 1) {
            removeConsumer();
        } else if (number == 2) {
            removeProduct();
        } else {
            MainSwitch();
        }
    }
    public static void buySwitch () {
        consumerList.getAll();
        System.out.println(" Who will be the buyer ? \n" +" Any number greater than " +
                consumerList.size() + "for back to Main Menu.");
        int num = inputNum();
        if (num >= 0 & num < consumerList.size()) {
            buyProduct(num);
        } else {
            MainSwitch();
        }
    }

    public static void getListSwitch () {
        System.out.println("""
                1. Get list of consumer.
                2. Get list of product.
                3 or more. Back to Main Menu.""");
        int number = inputNum();
        if (number == 1) {
            getConsumer();
        } else if (number == 2) {
            getProduct();
        } else {
            MainSwitch();
        }
    }
    public static void smartSwitch () {
        System.out.println("""
                1. Show list of custom products by user id.
                2. Show a list of users who bought a product by product id.
                3 or more. Back to Main Menu.""");
        int number = inputNum();
        if (number == 1) {
            showProducts();
        } else if (number == 2) {
            showConsumer();
        } else {
            MainSwitch();
        }
    }
}
