package team4;
// =============================================================================
// File:             SortResult.java
// Team Name:        Team 4
// Team Members:     Zachary, Bryan, Cameron, John
// Course/Section:   CS 2430
// Project:          Programming Project 2 – Sorting Algorithms, Efficiency, and Performance (Spring 2026)
// Primary Author:   Implementation Lead (John / Cameron)
// =============================================================================

//Stores sorted array and comparison count returned by sorting algorithms

public class SortResult {
	
    private int[] sortedArray;
    private long comparisonCount;

    /**
     * This method creates a SortResult that has the sorted array and comparison count
     * 
     * @param sortedArray
     * @param comparisonCount
     */
    public SortResult(int[] sortedArray, long comparisonCount) {
        this.sortedArray = sortedArray;
        this.comparisonCount = comparisonCount;
    }

    /**
     * This method is a getter for sorted array.
     * 
     * @return		sortedArray
     */
    public int[] getSortedArray() {
        return sortedArray;
    }

    /**
     * This method is a getter for comparison count.
     * 
     * @return		comparisonCount
     */
    public long getComparisonCount() {
        return comparisonCount;
    }
}
