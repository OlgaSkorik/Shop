package com.sales.shop;

import com.sales.goods.Goods;

public class Logics {
    public static int find(Goods[] storage, int currentIndex, Goods goods) {
        for (int i = 0; i < currentIndex; i++) {
            if (storage[i].equals(goods)) {
                return i;
            }
        }
        return -1;
    }

    public static void remove(Goods[] storage, int currentIndex, int index) {
        storage[index] = storage[currentIndex - 1];
        storage[currentIndex - 1] = null;
    }
}
