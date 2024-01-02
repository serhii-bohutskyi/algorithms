package com.bohutskyi.algorithms.leetcode;

/**
 * https://leetcode.com/problems/search-insert-position
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        searchInsert(new int[]{1, 3, 5, 6}, 2);
    }
}
