package com.bohutskyi.algorithms.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals problem.
 * The task is to merge all overlapping intervals from a given list of intervals.
 * Overlapping intervals are those where one interval's start time is less than or equal to another's end time.
 * <p>
 * Example:
 * Input: [[1,3], [2,6], [8,10], [15,18]]
 * Output: [[1,6], [8,10], [15,18]]
 */
public class MergeIntervals {

    public static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        // Sort intervals by their start time
        intervals.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> result = new ArrayList<>();
        Interval current = intervals.get(0);
        result.add(current);

        for (Interval interval : intervals) {
            int currentEnd = current.end;
            if (interval.start <= currentEnd) { // Overlapping intervals, move the end if needed
                current.end = Math.max(currentEnd, interval.end);
            } else { // Non-overlapping interval, add to the result and move to next
                current = interval;
                result.add(current);
            }
        }
        return result;
    }

    private static List<Interval> convertArrayToList(int[][] intervalsArray) {
        List<Interval> intervals = new ArrayList<>();
        for (int[] interval : intervalsArray) {
            intervals.add(new Interval(interval[0], interval[1]));
        }
        return intervals;
    }

    /**
     * The main method to test the merge function with various test cases.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test case 1: Standard case
        int[][] intervalsArray1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        testMerge(intervalsArray1);

        // Test case 2: Overlapping intervals
        int[][] intervalsArray2 = {{1, 4}, {4, 5}};
        testMerge(intervalsArray2);

        // Test case 3: Non-overlapping intervals
        int[][] intervalsArray3 = {{1, 2}, {3, 4}, {5, 6}};
        testMerge(intervalsArray3);

        // Test case 4: No intervals
        int[][] intervalsArray4 = {};
        testMerge(intervalsArray4);

        // Test case 5: One interval
        int[][] intervalsArray5 = {{1, 3}};
        testMerge(intervalsArray5);

        // Additional test cases can be added here
    }

    /**
     * Helper method to test merge functionality and print results.
     *
     * @param intervalsArray the array of array representation of intervals
     */
    private static void testMerge(int[][] intervalsArray) {
        List<Interval> intervals = convertArrayToList(intervalsArray);
        List<Interval> mergedIntervals = merge(intervals);

        System.out.print("Input: ");
        printIntervals(intervals);
        System.out.print("Merged: ");
        printIntervals(mergedIntervals);
        System.out.println();
    }

    /**
     * Helper method to print a list of intervals.
     *
     * @param intervals the list of intervals to print
     */
    private static void printIntervals(List<Interval> intervals) {
        for (Interval interval : intervals) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
        System.out.println();
    }
}
