package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Delivery {

    private int id;

    private String address;

    private Order order;

    private Random random = new Random();

    public Delivery(String address, Order order) {
        this.id = random.nextInt(99999999);
        this.address = address;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void getOrder() {
        order.showBuys();
    }

    public String status() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Собирается.");
        list.add("В пути");
        list.add("Доставлен");
        list.add("Передан курьеру");
        return "Заказ \n" +
                "Номер " + id + "\n" +
                "По адресу " + address + "\n" +
                "статус " + list.get(random.nextInt(list.size())) + "\n";
    }

}
