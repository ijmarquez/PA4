package model;

import java.util.HashMap;

/**
 * Created by Calvin on 5/26/2017.
 */
public class Cart {

//    HashMap<String,Integer> cart = new HashMap<String, Integer>();
    private String name;
    private int qty, totalCost;
    private String size;
    public Cart() { }

    public Cart(String name, Integer quantity, String size) {
//        cart.put(name, quantity);
        this.name = name;
        this.qty = quantity;
        this.size = size;
    }
    public Cart(String name, Integer quantity, String size, int cost) {
//        cart.put(name, quantity);
        this.name = name;
        this.qty = quantity;
        this.size = size;
        setTotalCost(cost*quantity);
    }

//    public HashMap getCart() { return cart; }

//    public void addToCart(String name, Integer qty) {
//        cart.put(name, qty);
//    }

    public String getName() { return name; }
    public String getSize() { return size; }
    public int getQty() { return qty; }
    public int getTotalCost() {return totalCost; }
    public void setTotalCost (int totalCost) { this.totalCost = totalCost; }
}
