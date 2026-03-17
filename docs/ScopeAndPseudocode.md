# Design Artifact 1 — Project Scope \& Pseudocode

**CS 2430 — Programming Project 2
Team:** Team 4
**Semester:** Spring 2026

\---

## Project Scope

### Goal

Point of the project was to run a real experiment on four sorting algorithms instead of looking up how complex they are. We generated every permutation of small arrays, ran them all and counted the comparisons to see which was the best and worst in performance 

### In Scope

PermutationGenerator was built, this creates every ordering of the array. 

Four sorting classes that count their own comparisons and a sortresult class to hold results and also 

a ProjectDriver that will be the main and run everything + print output. 

### Out of Scope

Only sorted the integer arrays and tested the sizes 4,6,and 8 ONLY. No memory was measured and we did not write output to any files everything was printed to the console. 

### Language \& Platform

Java, `package team4`

Developed in EclipsePseudocode

### PermutationGenerator

```
generate(n):
    arr = \[0, 1, 2, ..., n-1]
    result = \[copy of arr]
    while nextPermutation(arr) is true:
        result.add(copy of arr)
    return result

nextPermutation(arr):
    i = length - 2
    while i >= 0 and arr\[i] >= arr\[i+1]: i--
    if i < 0: return false          // already last permutation
    j = length - 1
    while arr\[j] <= arr\[i]: j--
    swap(arr\[i], arr\[j])
    reverse arr\[i+1 .. end]
    return true
```

### MergeSort

```
sort(arr):
    copy = clone of arr
    comparisons = 0
    mergeSort(copy, 0, length-1)
    return SortResult(copy, comparisons)

merge(arr, left, mid, right):
    build temp array from arr\[left..right]
    while both halves have elements:
        comparisons++               // ← element-to-element comparison
        if left\[i] <= right\[j]: place left\[i]
        else: place right\[j]
    copy remaining elements (no comparisons)
```

### QuickSort  (Lomuto, last-element pivot)

```
sort(arr):
    copy = clone of arr
    comparisons = 0
    quickSort(copy, 0, length-1)
    return SortResult(copy, comparisons)

partition(arr, low, high):
    pivot = arr\[high]
    i = low - 1
    for j = low to high-1:
        comparisons++               // ← element-to-element comparison
        if arr\[j] < pivot:
            i++; swap(arr\[i], arr\[j])
    swap(arr\[i+1], arr\[high])
    return i+1
```

### ShakerSort  (bidirectional bubble)

```
sort(arr):
    copy = clone of arr; comparisons = 0
    start = 0; end = length-1; swapped = true
    while swapped:
        swapped = false
        for i = start to end-1:    // forward pass
            comparisons++           // ← element-to-element comparison
            if copy\[i] > copy\[i+1]: swap; swapped = true
        if not swapped: break
        swapped = false; end--
        for i = end down to start+1:  // backward pass
            comparisons++           // ← element-to-element comparison
            if copy\[i] < copy\[i-1]: swap; swapped = true
        start++
    return SortResult(copy, comparisons)
```

### HeapSort

```
sort(arr):
    copy = clone of arr; comparisons = 0
    build max-heap: heapify from n/2-1 down to 0
    for i = n-1 down to 1:
        swap(copy\[0], copy\[i])
        heapify(copy, i, 0)
    return SortResult(copy, comparisons)

heapify(arr, n, i):
    largest = i
    left = 2i+1; right = 2i+2
    if left < n:
        comparisons++               // ← element-to-element comparison
        if arr\[left] > arr\[largest]: largest = left
    if right < n:
        comparisons++               // ← element-to-element comparison
        if arr\[right] > arr\[largest]: largest = right
    if largest != i:
        swap(arr\[i], arr\[largest])
        heapify(arr, n, largest)    // recurse on affected subtree
```

### ProjectDriver

```
for each n in \[4, 6, 8]:
    permutations = PermutationGenerator.generate(n)
    for each algorithm in \[ShakerSort, MergeSort, QuickSort, HeapSort]:
        results = \[]
        map = {}                    // comparisons → list of input arrays
        for each perm in permutations:
            result = algorithm.sort(perm)
            results.add(result.getComparisonCount())
            map\[comparisons].add(perm)
        sort results ascending
        print average, best 10, worst 10
```

\---

## Comparison Counting Definition

Only comparisons where counted where two elements are compared with each other to decide the order of them. Loop conditions and Boolean checks were not checked. Made sure it was counted across all four algorithms. 

