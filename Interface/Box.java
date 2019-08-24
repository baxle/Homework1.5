package CandyGift.Interface;


import CandyGift.Comparator.MaxPriceComparator;
import CandyGift.Comparator.MaxWeightComparator;
import CandyGift.Sweets.Sweet;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;


/** Класс Box
 *  @author Бакулин Андрей
 */
public class Box implements CanDo {

    private static Sweet[] sweets = new Sweet[0];

    /**
     * Функция добавления объекта класса Sweet в массив sweets.
     */
    public void add(Sweet sweet) {
        if (sweet == null) {
            System.out.println("Вы ввели null");
        } else {
            sweets = Arrays.copyOf(sweets, sweets.length + 1);
            sweets[sweets.length-1] = sweet;
        }
    }





    /**
     * Функция удаления последнего объекта из массива sweets.
     */

    public void remove() {
        if (sweets.length > 0) {
            sweets = Arrays.copyOf(sweets, sweets.length - 1);
        } else {

            System.out.println("В массиве нет элементов для удаления");

        }
    }


    /**
     * Функция удаления объекта из массива sweets по индексу.
     * @param index - индекс удаляемого элемента
     */
    public void remove(int index) {
        if (index > sweets.length - 1) {
            System.out.println("Индекс массива слишком большой");
        } else if (index < 0) {
            System.out.println("Индекс массива отрицателен");
        } else {
            Sweet[] anotherSweets = new Sweet[sweets.length - 1];

            for (int i = 0, k = 0; i < sweets.length; i++) {

                if (i == index) {
                    continue;
                }

                anotherSweets[k++] = sweets[i];
            }
            sweets = anotherSweets;
        }


    }

    /**
     * Функция получения значения поля totalWeight
     * @return возвращает суммарный вес всех объектов массива
     */
    public BigDecimal getTotalWeight() {
        BigDecimal totalWeight = BigDecimal.valueOf(0.00);
        for (int i = 0; i < sweets.length; i++) {
            totalWeight = totalWeight.add(BigDecimal.valueOf(sweets[i].price));
        }
        return totalWeight;
    }

    /**
     * Функция получения значения поля totalPrice
     * @return возвращает суммарную стоимость всех объектов массива
     */
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.valueOf(0.00);
        for (int i = 0; i < sweets.length; i++) {
            totalPrice = totalPrice.add(BigDecimal.valueOf(sweets[i].price));
        }
        return totalPrice;
    }

    /**
     * Функция выводит на экран каждый элемент массива sweets.
     */
    public void getAllInfo() {
        System.out.println("\nИнформация о всех сладостях в подарке:");
        for (Sweet sweet : sweets) {
            System.out.println(sweet.toString());
        }
        System.out.println(" ");
    }

    /**
     * Функция, удаляющая из массива sweets элементы до тех пор, пока {@link Box#getTotalWeight()} >  @param weight
     */
    public void reduceWeight(double weight) {
        if (weight < 0) {
            System.out.println("Вы ввели отрицательный вес");
        } else {
            BigDecimal x = getTotalPrice();
            Comparator weightComparator = new MaxWeightComparator();
            Arrays.sort(sweets, weightComparator);
            for (Sweet sweet : sweets) {
                System.out.println(sweet.toString());
            }


            while (x.doubleValue() > weight) {
                if (sweets.length == 0) {
                    System.out.println("Коробочка пуста");
                    break;
                }
                System.out.println("\n Вес коробочки " + x + " больше входного параметра " + weight);
                System.out.println("Удаляем сладость с наименьшим весом " + sweets[sweets.length - 1].weight);
                x = x.subtract(BigDecimal.valueOf(sweets[sweets.length - 1].weight));
                sweets = Arrays.copyOf(sweets, sweets.length - 1);


            }
            System.out.println("Вес коробочки " + x + " меньше входного параметра (<" + weight + ")");

        }
    }

    /**
     * Функция, удаляющая из массива sweets элементы до тех пор, пока {@link Box#getTotalPrice()} >  @param price
     */
    public void reducePrice(double price) {
        if (price < 0) {
            System.out.println("Вы ввели отрицательную цену");
        } else {
            BigDecimal x = getTotalPrice();
            Comparator priceComparator = new MaxPriceComparator();
            Arrays.sort(sweets, priceComparator);
            for (Sweet sweet : sweets) {
                System.out.println(sweet.toString());
            }


            while (x.doubleValue() > price) {
                if (sweets.length == 0) {
                    System.out.println("Коробочка пуста");
                    break;
                }
                System.out.println("\n Цена коробочки " + x + " больше входного параметра " + price);
                System.out.println("Удаляем сладость с наименьшей ценой " + sweets[sweets.length - 1].price);
                x = x.subtract(BigDecimal.valueOf(sweets[sweets.length - 1].price));
                sweets = Arrays.copyOf(sweets, sweets.length - 1);


            }
            System.out.println("Цена коробочки " + x + " меньше входного параметра (<" + price + ")");

        }

    }
}