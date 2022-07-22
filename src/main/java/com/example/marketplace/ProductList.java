package com.example.marketplace;

import java.util.Arrays;

public class ProductList {
    private Product[] ProductList;
    private int size;


    public ProductList() { ProductList = new Product [0]; }

    public void add(Product product) throws NullPointerException {
        if (product == null) { throw new NullPointerException();}
        if (size == ProductList.length) {
            ProductList = Arrays.copyOf(ProductList, size + 1);
        }
        ProductList[size] = product;
        size++;
    }



    public boolean remove (Product product) {
        if (product != null) {
            for (int i = 0; i < size; i++) {
                if (ProductList[i].getId() == product.getId()) {
                    System.arraycopy(ProductList, (i + 1), ProductList, i, size() - (i + 1));
                    ProductList[size - 1] = null;
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

    public Product getIndex (int index) {
        if (index > size) {
            try {
                throw new ArrayIndexOutOfBoundsException();
            } catch (IndexOutOfBoundsException e) {
                System.out.println(" List is smaller than your index. Please, try again. ");
            }
        }
        return ProductList[index];
    }

    public void getAll () {

        for (int i = 0; i < ProductList.length; i++) {
            System.out.println(" Product: " + i + ". " + ProductList[i]);
        }
    }
    public void optimization () {
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (!(ProductList[i].equals(null))) {
                count++;
            }
        }
        Product[] temp = new Product[count];
        int indexTemp = 0;
        for (int i = 0; i < size; i++) {
            if (ProductList[i].equals(null)) {
                continue;
            }
            temp[indexTemp] = ProductList[i];
            indexTemp++;
        }
        ProductList = Arrays.copyOf(temp, count);
        size = count;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "ProductList=" + Arrays.toString(ProductList) +
                '}';
    }
}
