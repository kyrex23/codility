/*
 * LESSON 3: Time Complexity (PermMissingElem)
 * -------------------------------------------
 * An array A consisting of N different integers is given.
 * The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 *
 * Your goal is to find that missing element.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A, returns the value of the missing element.
 *
 * For example, given array A such that:
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [0..100,000];
 * - the elements of A are all distinct;
 * - each element of array A is an integer within the range [1..(N + 1)].
 */

package lessons;

import java.util.Arrays;
import java.util.List;

public class PermMissingElem {

	public static void main(String[] args) {
		Solution s = new Solution();
		List<TestCase> testCases = List.of(
				new TestCase(new int[] { 2, 3, 1, 5 }, 4),
				new TestCase(new int[] {}, 1));

		testCases.forEach(t -> System.out.println(String.format(
				"Input: %-12s -> Expected result: %d -> Actual result: %d",
				Arrays.toString(t.input), t.expectedResult, s.solution(t.input))));
	}

	private static class Solution {
		public int solution(int[] a) {
			// calculate the expected sum of (N+1) consecutive elements starting from 1
			int n = a.length + 1;
			long expectedSum = (long) n * (n + 1) / 2;
			// the actual sum will contain the same value except for the missing element
			long actualSum = Arrays.stream(a).sum();
			return (int) (expectedSum - actualSum);
		}
	}

	record TestCase(int[] input, int expectedResult) {
	}
}
