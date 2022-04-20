package com.bohutskyi.algorithms.leetcode;

/**
 * https://leetcode.com/problems/binary-search
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0;
        int pivot;
        int right = nums.length - 1;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return target;
            } else if (nums[pivot] < target) {
                left = pivot;
            }else {
                right = pivot;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(search(array, -1));
    }
}
