package team4;
// =============================================================================
// File:             SortingAlgorithm.java
// Team Name:        Team 4
// Team Members:     Zachary, Bryan, Cameron, John
// Course/Section:   CS 2430
// Project:          Programming Project 2 – Sorting Algorithms, Efficiency, and Performance (Spring 2026)
// Primary Author:   Implementation Lead (John / Cameron)
// =============================================================================

//Defines the structure for all sorting algorithms
//Defines sorting for consistency across classes

public interface SortingAlgorithm {

    /**
     * This method sorts the input array and then counts the comparisons
     *
     * @param arr the unsorted array
     * @return a SortResult with sorted array and comparison count.
     */
    SortResult sort(int[] arr);

    /**
     * This method is a getter for the name of the sorting method
     *
     * @return algorithm name as a String
     */
    String getName();
}
