# Design Artifact 2 — System Structure Diagram

**CS 2430 — Programming Project 2
Team:** Team 4
**Semester:** Spring 2026

\---

## Class Structure

```
┌─────────────────────────────────────────────────────────────────────┐
│                     «interface»  SortingAlgorithm                   │
│                        team4/SortingAlgorithm.java                  │
│                                                                     │
│  + sort(int\[] arr) : SortResult                                     │
│  + getName() : String                                               │
└──────────────────────────┬──────────────────────────────────────────┘
                           │ implements
          ┌────────────────┼────────────────┬───────────────┐
          ▼                ▼                ▼               ▼
   ┌────────────┐  ┌─────────────┐  ┌───────────┐  ┌───────────┐
   │ MergeSort  │  │  QuickSort  │  │ShakerSort │  │ HeapSort  │
   │            │  │             │  │           │  │           │
   │-comparisons│  │-comparisons │  │(inline    │  │-comparisons│
   │            │  │             │  │ counter)  │  │           │
   │+sort()     │  │+sort()      │  │+sort()    │  │+sort()    │
   │+getName()  │  │+getName()   │  │+getName() │  │+getName() │
   │-mergeSort()│  │-quickSort() │  │           │  │-heapify() │
   │-merge() ←C │  │-partition()←C │           │  │         ←C│
   └────────────┘  └─────────────┘  └───────────┘  └───────────┘
   ←C = comparison counted here
```

\---

## Module Overview

```
┌──────────────────────────────────────────────────────────────────────┐
│                         ProjectDriver.java                           │
│                         (main entry point)                           │
│                                                                      │
│  main()                                                              │
│    └── runExperiment(n, algorithms)   for n in \[4, 6, 8]            │
│          ├── PermutationGenerator.generate(n)  → List<int\[]>        │
│          ├── algorithm.sort(perm)              → SortResult          │
│          │     (called for each of 4 algorithms × all permutations) │
│          └── prints: average, best 10, worst 10 comparisons         │
└──────────────┬───────────────────────────┬───────────────────────────┘
               │                           │
               ▼                           ▼
┌──────────────────────────┐   ┌─────────────────────────────────────┐
│  PermutationGenerator    │   │            SortResult               │
│                          │   │                                     │
│  +generate(n): List<int\[]│   │  -sortedArray: int\[]                │
│  -nextPermutation(arr)   │   │  -comparisonCount: long             │
│                          │   │  +getSortedArray(): int\[]           │
│  Lexicographic algorithm │   │  +getComparisonCount(): long        │
│  produces all n!         │   │                                     │
│  permutations of \[0..n-1]│   │  Returned by every sort() call      │
└──────────────────────────┘   └─────────────────────────────────────┘
```

\---

## Data Flow

```
  n ∈ {4, 6, 8}
       │
       ▼
  PermutationGenerator.generate(n)
       │  returns List<int\[]>  — 24, 720, or 40320 permutations
       ▼
  for each perm in permutations:
    for each algorithm in \[ShakerSort, MergeSort, QuickSort, HeapSort]:
       │
       ▼
      algorithm.sort(perm)
       │  internally clones perm, sorts clone, counts comparisons
       │  returns SortResult
       ▼
      record comparisons → results list
      map comparisons → list of input arrays
       │
       ▼
  sort results list ascending
  compute average
  print best 10 / worst 10 / average → console
```

\---

## File \& Folder Structure

```
repo-root/
├── src/
│   ├── module-info.java
│   └── team4/
│       ├── SortingAlgorithm.java     interface — contract for all sorts
│       ├── SortResult.java           data class — sorted array + count
│       ├── PermutationGenerator.java Part 1 — generates all n! permutations
│       ├── MergeSort.java            Part 2 — mergesort implementation
│       ├── QuickSort.java            Part 2 — quicksort implementation
│       ├── ShakerSort.java           Part 2 — shaker sort implementation
│       ├── HeapSort.java             Part 2 — heapsort implementation
│       ├── ProjectDriver.java        Parts 3 \& 4 — driver + metrics
│       └── TestSuite.java            verification + edge cases
├── docs/
│   ├── ProjectPlan.md
│   ├── ScopeAndPseudocode.md         design artifact 1
│   └── StructureDiagram.md           design artifact 2 (this file)
├── README.md
└── CONTRIBUTIONS.md
```

\---

## Key Design Decisions

|Decision|Choice|Reason|
|-|-|-|
|Common interface|`SortingAlgorithm`|Easy to loop algorithms in driver|
|Result bundling|`SortResult` class|Needed to return both the array that was sorted and count from one method|
|Input protection|`Arrays.copyOf()` in every sort|So same permutations passed to all 4 algorithms |
|Comparison type|`long`|Long instead of int just in case the numbers were too big|
|Pivot strategy|Last element (Lomuto)|Picked the last elemet as pivot, simplest version to use|
|Permutation order|Lexicographic|Generates with no duplicates |



