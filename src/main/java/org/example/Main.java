package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static ArrayList<Product> listSortProduct = new ArrayList<>();
    public static ArrayList<String> listSortManufacturer = new ArrayList<>();
    public static ArrayList<Order> listOrders = new ArrayList<>();
    private static Delivery delivery;

    public static Order order;

    public static String input = "";
    public static int num;
    public static int amount;

    //В данной програме мы используем принцип единственной ответственности, каждый класс отвечает за отдельный функционал

//    Product - реализует карточку товара со своими уникальными полям.

//    Order - реализует заказ клиента, тоесть хранит выбранный список карточек товара и позволяет его редактировать.

//    Shop - хранит карточки товара и позволяет сортировать их по разным параметрам.

//    Delivery - хранит кокретный заказ клиента  и позволяет проверить статус заказа.

//    Реализованно правильно DRY все повторяющиеся элементы кода вынесены в отдельные методы.


//    Во избежание появления "Магических числе " все необходимые параметры заведены полями.


    public static void main(String[] args) {

        Shop shop = new Shop("Оружейный магазин");
        Scanner sc = new Scanner(System.in);

        Product product = new Product("Винтовка 338", "Лобаев", "оружие", 10000);
        Product product1 = new Product("Винтовка 308", "Лобаев", "оружие", 5000);
        Product product2 = new Product("Винтовка 7.62", "Лобаев", "оружие", 45000);
        Product product3 = new Product("Винтовка 7.98", "GnG", "оружие", 48990);
        Product product4 = new Product("Винтовка 366тк", "AEG", "оружие", 2000);
        Product product5 = new Product("Патроны 7.62 ", "AEG", "боеприпасы", 1000);
        Product product6 = new Product("Патроны 366ткм ", "Туль-Маж", "боеприпасы", 500);
        Product product7 = new Product("Патронаж", "Туль-Маж", "Снаряжение", 6999);

        shop.addProduct(product);
        shop.addProduct(product1);
        shop.addProduct(product2);
        shop.addProduct(product3);
        shop.addProduct(product4);
        shop.addProduct(product5);
        shop.addProduct(product6);
        shop.addProduct(product7);


        System.out.println("Добро пожаловать в " + shop.getTitle());
        while (true) {
            System.out.println("Выбирите вариант \n" +
                    "1 Сделать  новый заказ \n" +
                    "2 Посмотреть свои заказы\n" +
                    "3 Доставка\n" +
                    "4 Выход");
            input = sc.nextLine();

            if (input.equals("1")) {

                order = new Order();

                while (!input.equals("6")) {
                    System.out.println("Выбирите вариант \n" +
                            "1 Посмотреть полный список товаров \n" +
                            "2 Найти товар по названию \n" +
                            "3 Найти товар по цене \n" +
                            "4 Найти товар по Производителю \n" +
                            "5 Посмотреть свою корзину \n" +
                            "6 Сохранить заказ \n" +
                            "7 Вернуться в пред меню");
                    input = sc.nextLine();
                    if (input.equals("1")) {
                        listSortProduct = shop.Show();
                        while (true) {
                            recurringMessage();
                            num = Integer.parseInt(sc.nextLine());
                            if (num != 0) {
                                System.out.println("Введите количество товара");
                                amount = Integer.parseInt(sc.nextLine());
                                order.addProduct(listSortProduct.get(num - 1), amount);
                            } else {
                                break;
                            }
                        }
                    } else if (input.equals("2")) {
                        while (true) {
                            System.out.println("Введи ключевое слово");
                            input = sc.nextLine();
                            listSortProduct = shop.sortName(input);
                            recurringMessage();
                            num = Integer.parseInt(sc.nextLine());
                            if (num != 0) {
                                System.out.println("Введите количество товара");
                                amount = Integer.parseInt(sc.nextLine());
                                order.addProduct(listSortProduct.get(num - 1), amount);
                            } else {
                                break;
                            }
                        }
                    } else if (input.equals("3")) {
                        while (true) {
                            try {
                                System.out.println("Введите диапазон цен");
                                System.out.println("Минимальный");
                                int min = Integer.parseInt(sc.nextLine());
                                System.out.println("Максимальный");
                                int max = Integer.parseInt(sc.nextLine());
                                listSortProduct = shop.sortPrise(min, max);
                                recurringMessage();
                                num = Integer.parseInt(sc.nextLine());
                                if (num != 0) {
                                    System.out.println("Введите количество товара");
                                    amount = Integer.parseInt(sc.nextLine());
                                    order.addProduct(listSortProduct.get(num - 1), amount);
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Не корректный ввод!");
                                break;
                            }

                        }
                    } else if (input.equals("4")) {
                        while (true) {
                            listSortManufacturer = shop.getAllManufacturer();
                            System.out.println("Выбирите производителя ");
                            int index = Integer.parseInt(sc.nextLine());
                            listSortProduct = shop.sortManufacturerName(listSortManufacturer.get(index - 1));
                            recurringMessage();
                            num = Integer.parseInt(sc.nextLine());
                            if (num != 0) {
                                System.out.println("Введите количество товара");
                                amount = Integer.parseInt(sc.nextLine());
                                order.addProduct(listSortProduct.get(num - 1), amount);
                            } else {
                                break;
                            }
                        }
                    } else if (input.equals("5")) {
                        while (true) {
                            System.out.println("Список ваших продкутов: ");
                            order.showBuys();
                            if (order.getListBuy().size() > 0) {
                                System.out.println("Выберите товар для удаления или введите 0 для выхода в пред меню");
                                input = sc.nextLine();
                                if (input.equals("0")) {
                                    break;
                                }
                                order.removeProduct(Integer.parseInt(input) - 1);
                            } else {
                                break;
                            }

                        }

                    } else if (input.equals("6")) {
                        order.setNumberOrder(listOrders.size() + 1);
                        listOrders.add(order);
                        System.out.println("Заказ сохранён");
                    } else if (input.equals("7")) {
                        break;
                    }

                }
            } else if (input.equals("2")) {

                if (listOrders.size() > 0) {
                    System.out.println("Список заказов: ");
                    sortListOrders(listOrders);
                    System.out.println("Выбирите вариант \n" +
                            "1 Посмотреть содежимое заказа \n" +
                            "2 Удалить заказ \n" +
                            "3 Оформить достаку\n" +
                            "4 Вернуть в пред меню");
                    while (true) {
                        input = sc.nextLine();
                        if (input.equals("1")) {
                            System.out.println("Укажите номер заказа ");
                            num = Integer.parseInt(sc.nextLine());
                            Order or = listOrders.get(num - 1);
                            or.showBuys();
                            break;
                        } else if (input.equals("2")) {
                            recurringMessage();
                            num = Integer.parseInt(sc.nextLine());
                            if (num == 0) {
                                break;
                            }
                            listOrders.remove(num - 1);
                            System.out.println("заказ удалён!");
                            break;
                        } else if (input.equals("3")) {
                            if (listOrders.size() > 0) {
                                System.out.println("Выберите заказ:");
                                sortListOrders(listOrders);
                                System.out.println();
                                num = Integer.parseInt(sc.nextLine());
                                Order orderDelivery = listOrders.get(num - 1);
                                System.out.println("Введите адрес Доставки");
                                input = sc.nextLine();
                                delivery = new Delivery(input, orderDelivery);
                                System.out.println("Ваш id заказа " + delivery.getId());
                                System.out.println("Доставка оформлена");
                                break;
                            }
                        } else if (input.equals("4")) {
                            break;
                        }
                    }
                } else {
                    System.out.println("Заказов не найдено!");
                }

            } else if (input.equals("3")) {
                System.out.println("Что бы узанть статус  введите id заказа");
                num = Integer.parseInt(sc.nextLine());
                if (num == delivery.getId()) {
                    System.out.println(delivery.status());
                } else {
                    System.out.println("Не найдено");
                }
            } else if (input.equals("4")) {
                System.out.println("До свидания!");
                break;
            }
        }
    }

    public static void recurringMessage() {
        System.out.println("Выберите товар или введите 0 для выхода в пред меню");
    }

    public static void sortListOrders(ArrayList<Order> listOrders) {
        int count = 1;
        for (Order orders : listOrders) {
            System.out.printf("%d %s \n", count, orders);
            count++;
        }
        System.out.println();
    }
}