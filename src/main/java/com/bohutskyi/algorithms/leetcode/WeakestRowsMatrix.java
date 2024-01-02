package com.bohutskyi.algorithms.leetcode;

import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/
 */
public class WeakestRowsMatrix {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] mat1 = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int k1 = 3;
        int[] result1 = solution.kWeakestRows(mat1, k1);
        System.out.println(Arrays.toString(result1));

        int[][] mat2 = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}
        };
        int k2 = 2;
        int[] result2 = solution.kWeakestRows(mat2, k2);
        System.out.println(Arrays.toString(result2));

        int[][] mat3 = {
                {1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 1, 0, 0}
        };
        int k3 = 3;
        int[] result3 = solution.kWeakestRows(mat3, k3);
        System.out.println(Arrays.toString(result3));
    }


    static class Solution {
        public int[] kWeakestRows(int[][] mat, int k) {

                int m = mat.length;
                int n = mat[0].length;

                PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                    if (a[1] == b[1]) {
                        return Integer.compare(a[0], b[0]);
                    }
                    return Integer.compare(a[1], b[1]);
                });

                for (int i = 0; i < m; i++) {
                    int soldierCount = 0;
                    for (int j = 0; j < n; j++) {
                        if (mat[i][j] == 1) {
                            soldierCount++;
                        } else {
                            break;
                        }
                    }
                    pq.offer(new int[]{i, soldierCount});
                }

                int[] result = new int[k];
                for (int i = 0; i < k; i++) {
                    result[i] = Objects.requireNonNull(pq.poll())[0];
                }

                return result;
            }
    }
}
