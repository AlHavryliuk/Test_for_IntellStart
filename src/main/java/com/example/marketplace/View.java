package com.example.marketplace;

import java.util.Scanner;

import static com.example.marketplace.MainMenu.*;
import static com.example.marketplace.SupportClass.*;

public class View {

    private static Scanner view = new Scanner(System.in);

    public static void addNewConsumer () {
        System.out.println(" Consumer name : ");
        String name = inputString();
        System.out.println(" Consumer surname : ");
        String surname = inputString();
        System.out.println(" Count of wallet :  ");
        double money = inputDouble();
        Consumer consumer = new Consumer(name, surname, money);
        consumerList.add(consumer);
        System.out.println(" Successful create new consumer :  " + name + " " + surname + " Id: " + consumer.getId() + "\n");
        MainSwitch();
    }
    public static void addNewProduct () {
        System.out.println(" Product name : ");
        String name = inputString();
        System.out.println(" Cost :  ");
        double price = inputDouble();
        Product product = new Product(name, price);
        productList.add(product);
        System.out.println(" Create is successful : " + name  + "\n");
        MainSwitch();
    }
    public static void removeConsumer () {
        consumerList.getAll();
        System.out.println(" What is remove ? ");
        int num = inputNum();
        if (num > consumerList.size()) {
            System.out.println(" Number is bigger than size List. ");
            removeSwitch();
        } else {
            consumerList.remove(consumerList.getIndex(num));
            consumerList.optimization();
            System.out.println(" Select consumer is removed. \n");
        }
    }
    public static void removeProduct () {
        productList.getAll();
        System.out.println(" What is remove ? ");
        int num = inputNum();
        Product remove = productList.getIndex(num);
        if (num > productList.size()) {
            System.out.println(" Number is bigger than size List. ");
            removeSwitch();
        } else {
            productList.remove(productList.getIndex(num));
            productList.optimization();
            System.out.println(" Product is removed. \n");
            removeProductFromUser(remove);
            backToMain();
        }
    }
    public static void removeProductFromUser (Product product) {
        for (int i = 0; i < consumerList.size(); i++) {
            for (int j = 0; j < consumerList.getIndex(i).getConsumerBag().size(); j++) {
                if (consumerList.getIndex(i).getConsumerBag().getIndex(j).getId() == product.getId()) {
                    double wallet = consumerList.getIndex(i).getCountOfMoney();
                    consumerList.getIndex(i).getConsumerBag().remove(consumerList.getIndex(i).getConsumerBag().getIndex(j));
                    consumerList.getIndex(i).setCountOfMoney(wallet + product.getPrice());
                    j--;
                }
            }
        }
        for (int i = 0; i < consumerList.size(); i++) {
            consumerList.getIndex(i).getConsumerBag().optimization();
        }
        System.out.println("""
                 This product was removed from costumers bag.\s
                 The cost was returned to the account\s
                """);
    }
    public static void buyProduct (int consumer) {
        productList.getAll();
        System.out.println(" What would you like to buy ? Or enter any number for back to Main Menu. ");
        int choice = inputNum();
        double wallet = consumerList.getIndex(consumer).getCountOfMoney();
        if (choice >= 0 & choice < productList.size()) {
            if (productList.getIndex(choice).getPrice() <= consumerList.getIndex(consumer).getCountOfMoney()) {
                consumerList.getIndex(consumer).setCountOfMoney(wallet - productList.getIndex(choice).getPrice());
                ConsumerBag bag = consumerList.getIndex(consumer).getConsumerBag();
                bag.add(productList.getIndex(choice));
                System.out.println(" The purchase was successful ! \n");
                MainSwitch();
            } else {
                System.out.println(" Not enough money to pay. Come back later. \n");
                MainSwitch();
            }
        } MainSwitch();
    }

    public static void getConsumer () {
        consumerList.getAll();
        System.out.println(" For back to Main Menu enter any number.");
        int num = inputNum();
        backToMain();
    }
    public static void getProduct () {
        productList.getAll();
        backToMain();
    }
    public static void showProducts () {
        consumerList.getAll();
        System.out.println(" Select user ");
        int number = inputNum();
        if (number >= consumerList.size()) {
            System.out.println(" Number is bigger than size List. ");
            smartSwitch();
        } else {
            consumerList.getIndex(number).getConsumerBag().getAll();
            backToMain();
        }
    }
    public static void showConsumer () {
        productList.getAll();
        System.out.println(" Select product ");
        int number = inputNum();
        if (number >= productList.size()) {
            System.out.println(" Number is bigger than size List. ");
            smartSwitch();
        } else {
            int countRepeat = 0;
            for (int i = 0; i < consumerList.size(); i++) {
                for (int j = 0; j < consumerList.getIndex(i).getConsumerBag().size(); j++) {
                    if (consumerList.getIndex(i).getConsumerBag().getIndex(j).equals(productList.getIndex(number))) {
                        System.out.println(consumerList.getIndex(i));
                        countRepeat++;
                        break;
                    }
                }
            }
            if (countRepeat == 0) {
                System.out.println(" This product is unique. ");
            }
            backToMain();
        }
    }


}
