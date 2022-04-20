package com.bohutskyi.algorithms.leetcode;

/**
 * https://leetcode.com/problems/first-bad-version/
 */
public class FirstBadVersion extends VersionControl {

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int middle = right / 2;

        while (left != right) {
            if (isBadVersion(middle)) {
                right = middle;
                middle = right / 2;
            } else {
                left = middle + 1;
                middle = left + (right - left) / 2;
            }
            System.out.println("isBadVersion=true, right=" + right + ", middle=" + middle + " left=" + left);
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
//        System.out.println(firstBadVersion(10));
//        System.out.println(firstBadVersion(11));
    }
}

class VersionControl {
    static boolean isBadVersion(int version) {
        System.out.println("isBadVersion " + version);
        return version >= 4;
    }
}
