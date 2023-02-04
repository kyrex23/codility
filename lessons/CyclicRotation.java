/*
 * LESSON 2: Arrays (CyclicRotation)
 * ---------------------------------
 * An array A consisting of N integers is given.
 * Rotation of the array means that each element is shifted right by one index,
 * and the last element of the array is moved to the first place.
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]
 * (elements are shifted right by one index and 6 is moved to the first place).
 *
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 *
 * Write a function:
 *
 * class Solution { public int[] solution(int[] A, int K); }
 *
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 */

package lessons;

import java.util.Arrays;
import java.util.List;

public class CyclicRotation {

	public static void main(String[] args) {
		Solution s = new Solution();

		List<TestCase> testCases = List.of(
				new TestCase(new int[] { 3, 8, 9, 7, 6 }, 3, new int[] { 9, 7, 6, 3, 8 }),
				new TestCase(new int[] { 0, 0, 0 }, 1, new int[] { 0, 0, 0 }),
				new TestCase(new int[] { 1, 2, 3, 4 }, 4, new int[] { 1, 2, 3, 4 }),
				new TestCase(new int[] {}, 1, new int[] {}));

		testCases.forEach(t -> System.out.println(String.format(
				"Original array: %15s (rotations: %d) -> Expected result: %15s -> Actual result: %15s",
				Arrays.toString(t.originalArray), t.rotations, Arrays.toString(t.expectedArray),
				Arrays.toString(s.solution(t.originalArray, t.rotations)))));
	}

	record TestCase(int[] originalArray, Integer rotations, int[] expectedArray) {
	}

	private static class Solution {
		public int[] solution(int[] array, int rotations) {
			for (int i = 0; i < rotations; ++i)
				array = rotateRight(array);
			return array;
		}

		private static int[] rotateRight(int[] array) {
			if (array == null || array.length == 0)
				return array;

			int[] rotated = new int[array.length];
			for (int i = 0; i < array.length - 1; ++i)
				rotated[i + 1] = array[i];
			rotated[0] = array[array.length - 1];
			return rotated;
		}
	}
}
