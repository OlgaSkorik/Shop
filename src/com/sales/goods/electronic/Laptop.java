package com.sales.goods.electronic;


import com.sales.goods.Goods;

//TODO: finish
public class Laptop extends Goods {
    private String model;
    private int ram;

    public Laptop(long price, String description, String model, int ram) {
        super(price, description);
        this.model = model;
        this.ram = ram;
    }

    public int getRam() {
        return ram;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "ram=" + ram;
    }
}
