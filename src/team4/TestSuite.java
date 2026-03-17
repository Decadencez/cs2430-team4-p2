package team4;

// =============================================================================
// File:             TestSuite.java
// Team Name:        Team 4
// Team Members:     Zachary, Bryan, Cameron, John
// Course/Section:   CS 2430
// Project:          Programming Project 2 – Sorting Algorithms, Efficiency,
//                   and Performance (Spring 2026)
// Primary Author:   Verification Lead (Zach Tucker)
// =============================================================================

// This file tests all the sorting operations to make sure they're correct.
// Run it with: java TestSuite
// If everything works you should see ALL TESTS PASSED at the bottom.

public class TestSuite {

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();
        HeapSort heapSort = new HeapSort();
        QuickSort quickSort = new QuickSort();
        ShakerSort shakerSort = new ShakerSort();

        boolean m1 = testMergeSorted(mergeSort);
        boolean m2 = testMergeReverse(mergeSort);
        boolean m3 = testMergeRandom(mergeSort);

        boolean h1 = testHeapSorted(heapSort);
        boolean h2 = testHeapReverse(heapSort);
        boolean h3 = testHeapRandom(heapSort);

        boolean q1 = testQuickSorted(quickSort);
        boolean q2 = testQuickReverse(quickSort);
        boolean q3 = testQuickRandom(quickSort);

        boolean s1 = testShakerSorted(shakerSort);
        boolean s2 = testShakerReverse(shakerSort);
        boolean s3 = testShakerRandom(shakerSort);

        if (m1 && m2 && m3 &&
            h1 && h2 && h3 &&
            q1 && q2 && q3 &&
            s1 && s2 && s3) {

            System.out.println("\nALL TESTS PASSED");

        } else {
            System.out.println("\nSOME TESTS FAILED");
        }
    }

    // ============================================================
    // MERGE SORT TESTS
    // ============================================================

    private static boolean testMergeSorted(MergeSort sorter) {
        int[] arr = {1, 2, 3, 4, 5};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("MergeSort Test 1 - Already Sorted: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    private static boolean testMergeReverse(MergeSort sorter) {
        int[] arr = {9, 7, 5, 3, 1};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("MergeSort Test 2 - Reverse Sorted: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    private static boolean testMergeRandom(MergeSort sorter) {
        int[] arr = {42, 5, 17, 9, 100, 3};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("MergeSort Test 3 - Random Array: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    // ============================================================
    // HEAP SORT TESTS
    // ============================================================

    private static boolean testHeapSorted(HeapSort sorter) {
        int[] arr = {1, 2, 3, 4, 5};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("HeapSort Test 1 - Already Sorted: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    private static boolean testHeapReverse(HeapSort sorter) {
        int[] arr = {9, 7, 5, 3, 1};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("HeapSort Test 2 - Reverse Sorted: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    private static boolean testHeapRandom(HeapSort sorter) {
        int[] arr = {50, 2, 88, 14, 7, 99, 1};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("HeapSort Test 3 - Random Array: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    // ============================================================
    // QUICK SORT TESTS
    // ============================================================

    private static boolean testQuickSorted(QuickSort sorter) {
        int[] arr = {1, 2, 3, 4, 5};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("QuickSort Test 1 - Already Sorted: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    private static boolean testQuickReverse(QuickSort sorter) {
        int[] arr = {9, 7, 5, 3, 1};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("QuickSort Test 2 - Reverse Sorted: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    private static boolean testQuickRandom(QuickSort sorter) {
        int[] arr = {33, 2, 77, 19, 8, 101, 4};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("QuickSort Test 3 - Random Array: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    // ============================================================
    // SHAKER SORT TESTS
    // ============================================================

    private static boolean testShakerSorted(ShakerSort sorter) {
        int[] arr = {1, 2, 3, 4, 5};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("ShakerSort Test 1 - Already Sorted: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    private static boolean testShakerReverse(ShakerSort sorter) {
        int[] arr = {9, 7, 5, 3, 1};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("ShakerSort Test 2 - Reverse Sorted: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    private static boolean testShakerRandom(ShakerSort sorter) {
        int[] arr = {12, 99, 3, 44, 7, 18};
        SortResult result = sorter.sort(arr);
        boolean sorted = isSorted(result.getSortedArray());
        System.out.println("ShakerSort Test 3 - Random Array: " + (sorted ? "PASS" : "FAIL"));
        return sorted;
    }

    // ============================================================
    // HELPER: Check if array is sorted
    // ============================================================

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }
}
