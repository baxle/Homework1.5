package CandyGift.Interface;


import CandyGift.Sweets.Sweet;

import java.math.BigDecimal;

public interface CanDo {
    void add(Sweet sweet);
    void remove();
    void remove(int index);
    BigDecimal getTotalWeight();
    BigDecimal getTotalPrice();
    void getAllInfo();
    void reduceWeight(double weight);
    void reducePrice(double price);



}