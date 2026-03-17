package team4;
// =============================================================================
// File:             ProjectDriver.java
// Team Name:        Team 4
// Team Members:     Zachary, Bryan, Cameron, John
// Course/Section:   CS 2430
// Project:          Programming Project 2 – Sorting Algorithms, Efficiency, and Performance (Spring 2026)
// Primary Author:   Implementation Lead (John / Cameron)
// =============================================================================

import java.util.*;

//Calls permutation generator
//Runs every sorting algorithm
//Collects the comparison counts

public class ProjectDriver {
	public static void main(String[] args) {

        int[] nValues = {4, 6, 8};

        List<SortingAlgorithm> algorithms = List.of(
                new ShakerSort(),
                new MergeSort(),
                new QuickSort(),
                new HeapSort()
        );

        for (int n : nValues) {
            runExperiment(n, algorithms);
        }
    }

	 /**
     * This class runs the sorting algorithms for different input sizes
     *
     * For every value of N it generates all permutations of {0 ... n-1}.
     * then runs all sorting algorithms on the permutations
     * it tracks comparison count and summarizes the stats
     *
     * @param n the number of elements in each permutation
     * @param algorithms the list of sorting algorithms
     */
    private static void runExperiment(int n, List<SortingAlgorithm> algorithms) {

        System.out.println("\n===== n = " + n + " =====");

        List<int[]> permutations = PermutationGenerator.generate(n);

        for (SortingAlgorithm algorithm : algorithms) {

            List<Long> results = new ArrayList<>();
            Map<Long, List<int[]>> map = new HashMap<>();

            for (int[] perm : permutations) {

                SortResult result = algorithm.sort(perm);
                long comparisons = result.getComparisonCount();

                results.add(comparisons);

                map.computeIfAbsent(comparisons, k -> new ArrayList<>())
                        .add(Arrays.copyOf(perm, perm.length));
            }

            Collections.sort(results);

            double average = results.stream()
                    .mapToLong(Long::longValue)
                    .average()
                    .orElse(0);
            System.out.println("-----------------------------------------");
            System.out.println(algorithm.getName());
            System.out.println("Average Comparisons: " + average);
            System.out.println("Best 10: " + results.subList(0, Math.min(10, results.size())));
            System.out.println("Worst 10: " +
                    results.subList(Math.max(results.size() - 10, 0), results.size()));
        }
    }
}
