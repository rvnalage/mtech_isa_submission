package org.example.service;

import java.util.Arrays;

public class TwoKnapsack {

    // Function to find the maximum weight that can be fitted in both knapsacks
    public int maxWeight(int[] arr, int W1, int W2) {
        Arrays.sort(arr); // Sort the array

        // Start backtracking from the end of the array
        return backtrack(arr, arr.length - 1, W1, W2);
    }

    private int backtrack(int[] arr, int index, int W1, int W2) {
        if (index < 0) {
            return 0; // Base case: No items left
        }

        // Option 1: Don't take the current item
        int maxWeight = backtrack(arr, index - 1, W1, W2);

        // Option 2: Take the current item in the first knapsack if it fits
        if (arr[index] <= W1) {
            maxWeight = Math.max(maxWeight, arr[index] + backtrack(arr, index - 1, W1 - arr[index], W2));
        }

        // Option 3: Take the current item in the second knapsack if it fits
        if (arr[index] <= W2) {
            maxWeight = Math.max(maxWeight, arr[index] + backtrack(arr, index - 1, W1, W2 - arr[index]));
        }

        return maxWeight;
    }

}
