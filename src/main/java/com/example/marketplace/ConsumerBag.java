package com.example.marketplace;

import java.util.Arrays;

public class ConsumerBag {
    private Product [] ConsumerBag;
    private int size;


    public ConsumerBag() { ConsumerBag = new Product [0]; }

    public void add(Product product) {
        if (size == ConsumerBag.length) {
            ConsumerBag = Arrays.copyOf(ConsumerBag, size + 1);
        }
        ConsumerBag[size] = product;
        size++;
    }



    public boolean remove(Product product) {
        if (product != null) {
            for (int i = 0; i < size; i++) {
                if (ConsumerBag[i].getId() == product.getId()) {
                    System.arraycopy(ConsumerBag, (i + 1), ConsumerBag, i, size() - (i + 1));
                    ConsumerBag[size - 1] = null;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }


    public int size() {
        return size;
    }

    public Product getIndex(int index) {
        if (index > size) {
            try {
                throw new ArrayIndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("List is smaller than your index. Please, try again.");
            }
        }
        return ConsumerBag[index];
    }

    public void getAll() {

        for (int i = 0; i < ConsumerBag.length; i++) {
            System.out.println(" Item " + i + ". " + ConsumerBag[i]);
        }
    }
    public void optimization () {
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (!(ConsumerBag[i].equals(null))) {
                count++;
            }
        }
        Product [] temp = new Product[count];
        int indexTemp = 0;
        for (int i = 0; i < size; i++) {
            if (ConsumerBag [i].equals(null)) {
                continue;
            }
            temp[indexTemp] = ConsumerBag[i];
            indexTemp++;
        }
        ConsumerBag = Arrays.copyOf(temp, count);
        size = count;
    }

    @Override
    public String toString() {
        return " Bag = " + Arrays.toString(ConsumerBag);
    }
}
