package org.example;

import java.util.ArrayList;


//  В классе Shop реализованны следующие принципы:

//  принцип открытости/закрытости - каждый метод сортировки имплементируется через конкретный интерфейс, тоесть
//  если нам нужно будет добавить новый метод сортировки или удалить текущий, мы не будем изменять текущий класс.

// принцип сегрегации (разделения) интерфейса - каждый метод сортировки , это отдельный интерфейс.


//Реализованно правильно DRY все повторяющиеся элементы кода вынесены в отдельные методы.
// В данном классе это методы сортировки карточек товара.

public class Shop implements SortName, SortPrise, GetAllManufacturer, SortManufacturerName {

    private String title;

    private static ArrayList<Product> list = new ArrayList<>();


    public Shop(String title) {
        this.title = title;
    }


    public ArrayList<Product> Show() {
        ArrayList<Product> listBay = new ArrayList<>();
        int count = 1;
        for (Product product : list) {
            System.out.printf("\n" +
                    "%d %s", count, product);
            listBay.add(product);
            count++;
        }
        System.out.println();
        return listBay;
    }

    @Override
    public ArrayList<Product> sortName(String name) {
        ArrayList<Product> listBay = new ArrayList<>();
        int count = 1;
        for (Product product : list) {
            if (product.getName().contains(name)) {
                System.out.printf("%d %s\n", count, product);
                listBay.add(product);
                count++;
            }
        }
        if (listBay.size() == 0) {
            System.out.println("Соответсвий не найдено!");
        }
        System.out.println();
        return listBay;
    }

    @Override
    public ArrayList<Product> sortPrise(int min, int max) {
        ArrayList<Product> listBay = new ArrayList<>();
        int count = 1;
        for (Product product : list) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                System.out.printf("%d %s\n", count, product);
                listBay.add(product);
                count++;
            }
        }
        System.out.println();
        return listBay;
    }

    @Override
    public ArrayList<String> getAllManufacturer() {
        ArrayList<String> manufactures = new ArrayList<>();
        int count = 1;
        System.out.println("Список доступных производителей: ");
        for (Product product : list) {
            if (!manufactures.contains(product.getManufacturerName())) {
                System.out.printf("%d %s\n", count, product.getManufacturerName());
                manufactures.add(product.getManufacturerName());
                count++;
            }
        }
        return manufactures;
    }

    @Override
    public ArrayList<Product> sortManufacturerName(String name) {
        ArrayList<Product> listBay = new ArrayList<>();
        int count = 1;
        for (Product product : list) {
            if (product.getManufacturerName().equals(name)) {
                System.out.printf("%d %s\n", count, product);
                listBay.add(product);
                count++;
            }
        }
        System.out.println();
        return listBay;
    }

    public void addProduct(Product product) {
        list.add(product);
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public String getTitle() {
        return title;
    }
}
