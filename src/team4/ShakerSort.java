package team4;
// =============================================================================
// File:             ShakerSort.java
// Team Name:        Team 4
// Team Members:     Zachary, Bryan, Cameron, John
// Course/Section:   CS 2430
// Project:          Programming Project 2 – Sorting Algorithms, Efficiency, and Performance (Spring 2026)
// Primary Author:   Implementation Lead (John / Cameron)
// =============================================================================

import java.util.Arrays;

//Class for ShakerSort Operations implements SortingAlgorithm

public class ShakerSort implements SortingAlgorithm {

    @Override
    public SortResult sort(int[] arr) {

        int[] copy = Arrays.copyOf(arr, arr.length);

        long comparisonCount = 0;

        boolean swapped = true;
        int start = 0;
        int end = copy.length - 1;

        while (swapped) {
            swapped = false;

            for (int i = start; i < end; i++) {

                comparisonCount++;
                if (copy[i] > copy[i + 1]) {
                    int temp = copy[i];
                    copy[i] = copy[i + 1];
                    copy[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;
            end--;

            for (int i = end; i > start; i--) {

                comparisonCount++;
                if (copy[i] < copy[i - 1]) {
                    int temp = copy[i];
                    copy[i] = copy[i - 1];
                    copy[i - 1] = temp;
                    swapped = true;
                }
            }

            start++;
        }

        return new SortResult(copy, comparisonCount);
    }

    @Override
    public String getName() {
        return "Shaker Sort";
    }
}