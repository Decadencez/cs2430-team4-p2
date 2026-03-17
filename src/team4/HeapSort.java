package team4;
// =============================================================================
// File:             HeapSort.java
// Team Name:        Team 4
// Team Members:     Zachary, Bryan, Cameron, John
// Course/Section:   CS 2430
// Project:          Programming Project 2 – Sorting Algorithms, Efficiency, and Performance (Spring 2026)
// Primary Author:   Implementation Lead (John / Cameron)
// ============================================================================

import java.util.Arrays;

//Class for HeapSort operations implements SortingAlgorithm

public class HeapSort implements SortingAlgorithm {

    private long comparisons;

    @Override
    public SortResult sort(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        comparisons = 0;

        int n = copy.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(copy, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = copy[0];
            copy[0] = copy[i];
            copy[i] = temp;
            heapify(copy, i, 0);
        }

        return new SortResult(copy, comparisons);
    }

    /**
     *
     * Method that creates heap compares it compares the current node with its children
     * Identifies which is the largest swaps them if needed
     * It then recursively heapifies the affected subtree
     * It also keeps track of the comparison count it only increments when comparing element to element 
     *
     */
    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            comparisons++;
            if (arr[left] > arr[largest])
                largest = left;
        }

        if (right < n) {
            comparisons++;
            if (arr[right] > arr[largest])
                largest = right;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    @Override
    public String getName() {
        return "Heap Sort";
    }
}
