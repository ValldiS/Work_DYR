package org.example;

import java.text.DecimalFormat;
import java.util.Random;

public class Product {

    private String name;
    private String manufacturerName;
    private String type;

    private int price;
    private double rating;

    private Random random = new Random();

    private double maxRating = 5.0;


    private DecimalFormat df = new DecimalFormat("#.##");


    public Product(String name, String manufacturerName, String type, int price) {
        this.name = name;
        this.manufacturerName = manufacturerName;
        this.type = type;
        this.price = price;
        this.rating = random.nextDouble(0, maxRating);
    }

    public String getName() {
        return name;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getType() {
        return type;
    }

    public String getRating() {
        return df.format(rating);
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Наименование='" + name + '\'' +
                ", Производитель='" + manufacturerName + '\'' +
                ", Цена =" + price +
                ", Рейтинг=" + df.format(rating) +
                '}';
    }
}
