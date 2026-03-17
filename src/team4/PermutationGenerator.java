package team4;
// =============================================================================
// File:             PermutationGenerator.java
// Team Name:        Team 4
// Team Members:     Zachary, Bryan, Cameron, John
// Course/Section:   CS 2430
// Project:          Programming Project 2 – Sorting Algorithms, Efficiency, and Performance (Spring 2026)
// Primary Author:   Implementation Lead (John / Cameron)
// =============================================================================

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//GenerateS all permutations of {0 … n-1}
//Returns a list of integer arrays

public class PermutationGenerator {

	 /**
     * Method to Generate all permutations of the integers from 0 to n - 1.
     *
     * @param n the number of elements to permute
     * @return a List containing all permutations as integer arrays
     */
    public static List<int[]> generate(int n) {

        List<int[]> permutations = new ArrayList<>();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;

        permutations.add(Arrays.copyOf(arr, n));

        while (nextPermutation(arr)) {
            permutations.add(Arrays.copyOf(arr, n));
        }

        return permutations;
    }

    /**
     * Class that rearranges the array into the next lexicographically
     * greater permutation.
     *
     * @param arr the current permutation
     * @return true if the next permutation exists,
     *         false if the array is already in its highest permutation
     */
    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) j--;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        for (int left = i + 1, right = arr.length - 1; left < right; left++, right--) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        return true;
    }
}
