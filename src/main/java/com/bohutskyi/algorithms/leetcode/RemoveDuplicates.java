package com.bohutskyi.algorithms.leetcode;

import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        System.out.println(removeDuplicates(nums1) == 2);
        assert Arrays.equals(Arrays.copyOfRange(nums1, 0, 2), new int[]{1, 2});

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assert removeDuplicates(nums2) == 5;
        assert Arrays.equals(Arrays.copyOfRange(nums2, 0, 5), new int[]{0, 1, 2, 3, 4});

        System.out.println("All tests passed.");
    }
}
