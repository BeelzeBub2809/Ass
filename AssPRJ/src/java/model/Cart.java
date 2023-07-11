/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguye
 */
public class Cart {

    private List<Items> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Items> getItems() {
        return items;
    }

    private Items getItemById(int id) {
        for (Items i : items) {
            if (i.getP().getId() == id) {
                return i;
            }
        }
        return null;
    }

    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    public void addItem(Items t) {
        if (getItemById(t.getP().getId()) != null) {
            Items m = getItemById(t.getP().getId());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }

    public void removeItems(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for (Items i : items) {
            t += (i.getQuantity() * i.getPrice());
        }
        return t;
    }

    private Product getProductById(int id, List<Product> list) {
        for (Product p : list) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public Cart(String txt, List<Product> list) {
        items = new ArrayList<>();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("\\.");
                for(String i : s){
                    String[] n = i.split(":");
                    int id= Integer.parseInt(n[0]);
                    int quantity =  Integer.parseInt(n[1]);
                    Product p = getProductById(id, list);
                    Items t = new Items(p, quantity, p.getPrice());
                    addItem(t);
                }
            }
        } catch (NumberFormatException e) {

        }
    }
}
