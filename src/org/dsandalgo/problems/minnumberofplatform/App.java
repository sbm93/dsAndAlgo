package org.dsandalgo.problems.minnumberofplatform;

import java.util.Arrays;

public class App {
	/*
	 * Given arrival and departure times of all trains that reach a railway station,
	 * the task is to find the minimum number of platforms required for the railway
	 * station so that no train waits.We are given two arrays which represent
	 * arrival and departure times of trains that stop
	 */
	public static void main(String[] args) {
		int[] arrival = { 900, 940, 950, 1100, 1500, 1800 };
		int[] departure = { 910, 1200, 1120, 1130, 1900, 2000 };
		findMinimum(arrival, departure);
	}

	static void findMinimum(int[] arrival, int[] departure) {
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int i = 1, j = 0;
		int max = 1, count = 1;
		while (i < arrival.length && j < arrival.length) {
			if (arrival[i] <= departure[j]) {
				count++;
				i++;
				if (count > max) {
					max = count;
				}
			} else {
				count--;
				j++;
			}
		}

		System.out.println(max);
	}
}
