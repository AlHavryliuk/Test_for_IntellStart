package com.example.marketplace;

import java.util.Arrays;

public class ConsumerList {

    private Consumer[] ConsumerList;
    private int size;


    public ConsumerList() { ConsumerList = new Consumer[0]; }

    public void add(Consumer consumer) throws NullPointerException {
        if (consumer == null) { throw new NullPointerException();}
        if (size == ConsumerList.length) {
            ConsumerList = Arrays.copyOf(ConsumerList, size + 1);
        }
        ConsumerList[size] = consumer;
        size++;
    }



    public boolean remove(Consumer consumer) {
        if (consumer != null) {
            for (int i = 0; i < size; i++) {
                if (ConsumerList[i].getId() == consumer.getId()) {
                    System.arraycopy(ConsumerList, (i + 1), ConsumerList, i, size() - (i + 1));
                    ConsumerList[size - 1] = null;
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

    public Consumer getIndex(int index) {
        if (index > size) {
            try {
                throw new ArrayIndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("List is smaller than your index. Please, try again.");
            }
        }
        return ConsumerList[index];
    }

    public void getAll() {

        for (int i = 0; i < ConsumerList.length; i++) {
            System.out.println(" Consumer: " + i + ". " + ConsumerList[i]);
        }
    }
    public void optimization () {
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (!(ConsumerList[i].equals(null))) {
                count++;
            }
        }
        Consumer[] temp = new Consumer[count];
        int indexTemp = 0;
        for (int i = 0; i < size; i++) {
            if (ConsumerList[i].equals(null)) {
                continue;
            }
            temp[indexTemp] = ConsumerList[i];
            indexTemp++;
        }
        ConsumerList = Arrays.copyOf(temp, count);
        size = count;
    }

    @Override
    public String toString() {
        return "ConsumerList{" +
                "ConsumerList=" + Arrays.toString(ConsumerList) +
                '}';
    }
}

