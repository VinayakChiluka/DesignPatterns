package com.learn.designpatterns.patterns.behaviour.strategypattern.example2;

import java.util.Arrays;

// Strategy interface
interface SortingStrategy {
    void sort(int[] array);
}

// Concrete strategy classes
class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Bubble Sort");
        // Actual sorting logic using bubble sort
    }
}

class QuickSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Quick Sort");
        // Actual sorting logic using quick sort
    }
}

class MergeSort implements SortingStrategy {
    @Override
    public void sort(int[] array) {
        System.out.println("Sorting using Merge Sort");
        // Actual sorting logic using merge sort
    }
}

// Context class
class ArraySorter {
    private SortingStrategy sortingStrategy;

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sortArray(int[] array) {
        sortingStrategy.sort(array);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arrayToSort = { 7, 2, 10, 1, 5 };
        ArraySorter arraySorter = new ArraySorter();

        SortingStrategy bubbleSort = new BubbleSort();
        SortingStrategy quickSort = new QuickSort();
        SortingStrategy mergeSort = new MergeSort();

        arraySorter.setSortingStrategy(bubbleSort);
        arraySorter.sortArray(arrayToSort.clone());

        arraySorter.setSortingStrategy(quickSort);
        arraySorter.sortArray(arrayToSort.clone());

        arraySorter.setSortingStrategy(mergeSort);
        arraySorter.sortArray(arrayToSort.clone());
    }
}
