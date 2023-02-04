/*
 * LESSON 3: Time Complexity (FrogJmp)
 * -----------------------------------
 * A small frog wants to get to the other side of the road.
 * The frog is currently located at position X and wants to get to a position greater than or equal to Y.
 * The small frog always jumps a fixed distance, D.
 *
 * Count the minimal number of jumps that the small frog must perform to reach its target.
 *
 * Write a function:
 *
 * class Solution { public int solution(int X, int Y, int D); }
 *
 * that, given three integers X, Y and D,
 * returns the minimal number of jumps from position X to a position equal to or greater than Y.
 *
 * For example, given:
 *   X = 10
 *   Y = 85
 *   D = 30
 * the function should return 3, because the frog will be positioned as follows:
 *
 * after the first jump, at position 10 + 30 = 40
 * after the second jump, at position 10 + 30 + 30 = 70
 * after the third jump, at position 10 + 30 + 30 + 30 = 100
 *
 * Write an efficient algorithm for the following assumptions:
 * - X, Y and D are integers within the range [1..1,000,000,000]
 * - X ≤ Y
 */

package lessons;

import java.util.List;

public class FrogJmp {

	public static void main(String[] args) {
		Solution s = new Solution();
		List<TestCase> testCases = List.of(new TestCase(10, 85, 30, 3));

		testCases.forEach(t -> System.out.println(String.format(
				"Inputs [%d, %d, %d] -> Expected result: %d -> Actual result: %d",
				t.x, t.y, t.d, t.expectedResult, s.solution(t.x, t.y, t.d))));
	}

	private static class Solution {
		public int solution(int x, int y, int d) {
			int jumps = (y - x) / d;
			return (jumps * d == y - x) ? jumps : jumps + 1;
		}
	}

	record TestCase(int x, int y, int d, int expectedResult) {
	}
}
