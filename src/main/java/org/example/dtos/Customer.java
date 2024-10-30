package org.example.dtos;

public class Customer {

    private final int id;
    private final double milk;
    private final double grocery;

    public Customer(int id, double milk, double grocery) {
        this.id = id;
        this.milk = milk;
        this.grocery = grocery;
    }

    public int getId() {
        return id;
    }

    public double getMilk() {
        return milk;
    }

    public double getGrocery() {
        return grocery;
    }

    @Override
    public String toString() {
        return "CustomerID: " + id + ", Milk: " + milk + ", Grocery: " + grocery;
    }
}
