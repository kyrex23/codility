/*
 * This is a demo task.
 *
 * Write a function:
 *
 * class Solution { public int solution(int[] A); }
 *
 * that, given an array A of N integers,
 * returns the smallest positive integer (greater than 0) that does not occur in A.
 *
 * For example:
 * - Given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * - Given A = [1, 2, 3], the function should return 4.
 * - Given A = [−1, −3], the function should return 1.
 *
 * Write an efficient algorithm for the following assumptions:
 * - N is an integer within the range [1..100,000];
 * - each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

package lessons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DemoTest {

	public static void main(String[] args) {
		Solution s = new Solution();
		List<TestCase> testCases = List.of(new TestCase(new int[] { 1, 3, 6, 4, 1, 2 }, 5));

		testCases.forEach(t -> System.out.println(String.format(
				"Array: %s -> Expected result: %d -> Actual result: %d",
				Arrays.toString(t.input), t.expectedResult, s.solution(t.input))));
	}

	private static class Solution {
		public int solution(int[] array) {
			List<Integer> positives = Arrays.stream(array).filter(n -> n > 0).boxed()
					.collect(Collectors.toSet())
					.stream().sorted().collect(Collectors.toList());

			for (int i = 1; i < positives.size() + 1; ++i)
				if (i < positives.get(i - 1))
					return i;
			return positives.size() + 1;
		}
	}

	record TestCase(int[] input, Integer expectedResult) {
	}
}
