package com.bohutskyi.algorithms.leetcode;

public class RotatedArraySearch {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] array = {5, 6, 7, 8, 9, 1, 2, 3, 4};
        System.out.println("The minimum number is: " + findMin(array));

        array = new int[]{6, 7, 8, 9, 1, 2, 3, 4, 5};
        System.out.println("The minimum number is: " + findMin(array));

        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("The minimum number is: " + findMin(array));

        array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("The minimum number is: " + findMin(array));
    }
}
