package team4;
// =============================================================================
// File:             MergeSort.java
// Team Name:        Team 4
// Team Members:     Zachary, Bryan, Cameron, John
// Course/Section:   CS 2430
// Project:          Programming Project 2 – Sorting Algorithms, Efficiency, and Performance (Spring 2026)
// Primary Author:   Implementation Lead (John / Cameron)
// =============================================================================

import java.util.Arrays;

//Class for MergeSort operations this class implements SortingAlgorithm

public class MergeSort implements SortingAlgorithm {

    private long comparisons;

    @Override
    public SortResult sort(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        comparisons = 0;
        mergeSort(copy, 0, copy.length - 1);
        return new SortResult(copy, comparisons);
    }

    /**
     * Method that performs a merge sort by dividing the array in half
     * Sorting each half and then merging them back together.
     *
     * @param arr   the input array
     * @param left  the starting index of the current section
     * @param right the ending index of the current section
     */
    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * This class merges too sorted sub arrays that come from our input array
     *
     * It uses a temporary array to store the merged array values before copying 
       them back into the original array
     * 
     * It has an increment counter that only counts when comparing elements from two sub arrays.
     *
     * @param arr   the array containing the sub arrays
     * @param left  the starting index of the first sub array
     * @param mid   the ending index of the first sub array
     * @param right the ending index of the second sub array
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            comparisons++;
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }
}
