package com.cg.Server.Model;

import java.util.LinkedHashMap;
import java.util.Random;

public class SpinFeature {

	private static int value;

	private static int rand() {
		int min = 0;
		int max = 17;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	private static LinkedHashMap<Integer, String> stringrandom(String[] a, String[] b, String[] c,
			LinkedHashMap<Integer, String> map) {
		map.put(1, a[rand()]);
		map.put(2, b[rand()]);
		map.put(3, c[rand()]);

		return map;
	}

	private static int valueChecker(int aceCount, int kingCount, int queenCount, int jackCount) {
		if (aceCount == 3) {
			value += 15;
		} else if (aceCount == 2) {
			value += 11;
		} else if (kingCount == 3) {
			value += 14;
		} else if (queenCount == 3) {
			value += 13;
		} else if (jackCount == 3) {
			value += 12;
		}

		return value;
	}

	public String[][] createSpin(String[] a, String[] b, String[] c) {

		int aceCount = 0, jackCount = 0, kingCount = 0, queenCount = 0;
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

		String[] reel1 = a;
		String[] reel2 = b;
		String[] reel3 = c;

		map = stringrandom(reel1, reel2, reel3, map);

		String[][] matrix = new String[3][3];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = map.get(j + 1);
				System.out.print(matrix[i][j] + " ");
				if (i == 1) {
					String s = map.get(j + 1);
					if (s.equalsIgnoreCase("ACE")) {
						aceCount++;
					} else if (s.equalsIgnoreCase("KING")) {
						kingCount++;
					} else if (s.equalsIgnoreCase("QUEEN")) {
						queenCount++;
					} else if (s.equalsIgnoreCase("JACK")) {
						jackCount++;
					}
					setValue(valueChecker(aceCount, jackCount, kingCount, queenCount));
				}
			}
			map = stringrandom(reel1, reel2, reel3, map);

			System.out.println("  ");
		}
		return matrix;
	}

	/**
	 * This method is used to get details of value.
	 *
	 * @return value : Returns the value.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * This method is used to set the value of value.
	 *
	 * @param value : The value to set.
	 */
	public void setValue(int value) {
		SpinFeature.value = value;
	}

}
