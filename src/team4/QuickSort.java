package team4;
// =============================================================================
// File:             QuickSort.java
// Team Name:        Team 4
// Team Members:     Zachary, Bryan, Cameron, John
// Course/Section:   CS 2430
// Project:          Programming Project 2 – Sorting Algorithms, Efficiency, and Performance (Spring 2026)
// Primary Author:   Implementation Lead (John / Cameron)
// =============================================================================

import java.util.Arrays;

//Class for QuickSort Operations this class implements SortingAlgorithm

public class QuickSort implements SortingAlgorithm {

    private long comparisons;

    @Override
    public SortResult sort(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        comparisons = 0;
        quickSort(copy, 0, copy.length - 1);
        return new SortResult(copy, comparisons);
    }

    /**
     * This method recursively does a quick sort on parts of the array
     *
     * @param arr the array being sorted
     * @param low the starting index of the sub array
     * @param high the ending index of the sub array
     */
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Assigns last element to be the pivot it then sorts the array 
       so all elements greater are on the right and all elements smaller are on the left
     *
     * @param arr the input array
     * @param low the starting index of the sub array
     * @param high the ending index of the sub array
     * @return the final index position of the pivot
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }
}
