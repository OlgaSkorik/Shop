package com.sales.goods.electronic;

import com.sales.goods.Goods;

//TODO: finish
public class Smartphone extends Goods {
    private String model;
    private int battery;

    public Smartphone(long price, String description, String model, int battery) {
        super(price, description);
        this.model = model;
        this.battery = battery;
    }

    public String getModel() {
        return model;
    }

    public int getBattery() {
        return battery;
    }

    @Override
    public String toString() {
        return "battery=" + battery;
    }
}
