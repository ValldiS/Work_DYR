package org.example;

import java.util.ArrayList;
import java.util.HashMap;


// Класс Order схож по фкуционалу с классом Shop, мы могли наследоваться от класс Shop и реализовать необходимый функционал,
// но в таком случае мы нарушаем принцип замены Барбары Лисков , так - как класс Order не сможет выполнять функции
// класса Shop. Поэоту клаксс Order  реализован отдельным классм с своим интерфейсом.
public class Order implements Show {

    private int numberOrder;

    public ArrayList<Product> listBuy = new ArrayList<>();


    private ArrayList<Integer> listAmount = new ArrayList<>();
    private Integer amount = 0;



    public ArrayList<Product> addProduct(Product product, Integer amount) {
        listBuy.add(product);
        listAmount.add(amount);
        return listBuy;
    }


    @Override
    public void showBuys() {
        amount = 0;
        if (listBuy.size() > 0) {
            int count = 1;
            System.out.println("Ваш заказ:");
            for (Product product : listBuy) {
                amount += product.getPrice() * listAmount.get(count - 1);
                System.out.printf("%d %s на сумму %d рублей\n", count, product, product.getPrice()
                        * listAmount.get(count - 1));
                count++;
            }
            System.out.println("Общая сумма заказа : " + amount + " рублей");
            System.out.println();
        } else {
            System.out.println("Ваша корзина пуста!!");
        }
    }

    public ArrayList<Product> removeProduct(int num) {
        listBuy.remove(num);
        listAmount.remove(num);
        return listBuy;
    }
    public ArrayList<Product> getListBuy() {
        return listBuy;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    @Override
    public String toString() {
        return "Заказ{" +
                "Номер заказа" + numberOrder +

                '}';
    }
}
