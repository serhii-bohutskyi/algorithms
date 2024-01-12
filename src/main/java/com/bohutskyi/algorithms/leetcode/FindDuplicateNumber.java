package com.bohutskyi.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {

    public static void findDuplicates(int[] numbers) {
        Set<Integer> seen = new HashSet<>();
        boolean foundDuplicate = false;

        for (int number : numbers) {
            if (!seen.add(number)) { // add returns false if the element was already in the set
                System.out.println("Duplicate found: " + number);
                foundDuplicate = true;
            }
        }

        if (!foundDuplicate) {
            System.out.println("No duplicates found.");
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 5, 6, 7, 8, 9, 9};
        findDuplicates(numbers);
    }
}
