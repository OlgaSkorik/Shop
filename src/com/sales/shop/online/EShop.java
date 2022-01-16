package com.sales.shop.online;

import com.sales.goods.Goods;
import com.sales.goods.electronic.Laptop;
import com.sales.goods.electronic.Smartphone;
import com.sales.shop.Logics;
import com.sales.shop.Selling;

//TODO finish electronics
public class EShop implements Selling {
    private static final int ARRAY_SIZE = 3;

    private final Laptop[] laptopStorage;
    private final Smartphone[] smartphoneStorage;

    private int currentIndexLaptop;
    private int currentIndexSmartphone;

    private long commonSumma;

    public EShop() {
        laptopStorage = new Laptop[ARRAY_SIZE];
        smartphoneStorage = new Smartphone[ARRAY_SIZE];
        currentIndexLaptop = 0;
        currentIndexSmartphone = 0;
    }

    @Override
    public boolean addNewGoods(Goods goods) {
        boolean wasAdded = false;
        if (goods instanceof Laptop && currentIndexLaptop < ARRAY_SIZE) {
            laptopStorage[currentIndexLaptop++] = (Laptop) goods;
            wasAdded = true;
        }
        if (goods instanceof Smartphone && currentIndexSmartphone < ARRAY_SIZE) {
            smartphoneStorage[currentIndexSmartphone++] = (Smartphone) goods;
            wasAdded = true;
        }
        if (wasAdded) {
            commonSumma += goods.getPrice();
        }
        return wasAdded;
    }

    @Override
    public long commonPrice() {
        if (commonSumma != 0) {
            return commonSumma;
        }
        for (int i = 0; i < currentIndexLaptop; i++) {
            commonSumma += laptopStorage[i].getPrice();
        }
        for (int i = 0; i < currentIndexSmartphone; i++) {
            commonSumma += smartphoneStorage[i].getPrice();
        }
        return commonSumma;
    }

    @Override
    public void printGoodsDescription() {
        for (int i = 0; i < currentIndexLaptop; i++) {
            System.out.println(laptopStorage[i].getDescription());
        }
        for (int i = 0; i < currentIndexSmartphone; i++) {
            System.out.println(smartphoneStorage[i].getDescription());
        }
    }

    @Override
    public boolean buy(Goods goods) {
        boolean wasRemoved = false;
        if (goods instanceof Laptop) {
            int index = Logics.find(laptopStorage, currentIndexLaptop, goods);
            if (index < 0) {
                return false;
            }
            Logics.remove(laptopStorage, currentIndexLaptop, index);
            currentIndexLaptop--;
            wasRemoved = true;
        }
        if (goods instanceof Smartphone) {
            int index = Logics.find(smartphoneStorage, currentIndexSmartphone, goods);
            if (index < 0) {
                return false;
            }
            Logics.remove(smartphoneStorage, currentIndexSmartphone, index);
            currentIndexSmartphone--;
            wasRemoved = true;
        }

        if (wasRemoved) {
            commonSumma -= goods.getPrice();
        }
        return wasRemoved;
    }
}