# CS 2430 — Programming Project 2: Sorting Algorithms, Efficiency, and Performance

**Team:** Team 4
**Members:** Bryan Estrada, John McElpgrang , Zachary Tucker, Cameron Dickinson
**Course:** CS 2430,
**Semester:** Spring 2026

\---

## Overview

In this project we tested the four sorting algorithms, merge sort, quick sort, shaker sort and heap sort by running them on every type of small integer array. The arrays tested were 4,6,8 and we also kept track of how many comparisons each made. It was recorded the 10 best,worst, and average cases. 

\---

## Repository Structure

```
repo-root/
├── src/
│   ├── module-info.java
│   └── team4/
│       ├── SortingAlgorithm.java     interface defining sort() and getName()
│       ├── SortResult.java           bundles sorted array + comparison count
│       ├── PermutationGenerator.java generates all n! permutations of \[0..n-1]
│       ├── MergeSort.java            mergesort with comparison counting
│       ├── QuickSort.java            quicksort (Lomuto, last-element pivot)
│       ├── ShakerSort.java           bidirectional bubble sort
│       ├── HeapSort.java             heapsort using max-heap
│       ├── ProjectDriver.java        main driver — runs all experiments
│       └── TestSuite.java            correctness tests and edge cases
├── docs/
│   ├── ProjectPlan.md
│   ├── ScopeAndPseudocode.md         design artifact 1
│   └── StructureDiagram.md           design artifact 2
├── README.md
└── CONTRIBUTIONS.md
```

\---

## How to Build and Run

### Requirements

* Java JDK 8 or higher
* or open as an Eclipse project

### Run in Eclipse

Right click `ProjectDriver.java` then Run As then Java Application

### Expected Output

For each 4,6,8 and each algorithm, the program prints:

* Algorithm name
* Average comparisons across all n! permutations
* Best 10 cases (lowest comparison counts)
* Worst 10 cases (highest comparison counts)

\---

## Comparison Counting Definition

Only counted comparisons where there was two elements being compared. We did not count loop conditions checking if an index is still in bounds or Boolean checks. We made sure to count compaisons the same way across all algorithms. 

