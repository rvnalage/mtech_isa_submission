package org.example;

import org.example.service.TwoKnapsack;

import java.util.Arrays;

public class TwoKnapsackApplication {



    public static void main(String[] args) {
        TwoKnapsack twoKnapsack = new TwoKnapsack();
        int[] arr = {10, 15, 20, 25, 30};
        int W1 = 50;
        int W2 = 30;

        int result = twoKnapsack.maxWeight(arr, W1, W2);
        System.out.println("Maximum weight that can be fitted in both knapsacks: " + result);
    }
}

