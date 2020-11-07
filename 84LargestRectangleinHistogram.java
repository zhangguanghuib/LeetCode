package P84LargestRectangleInHistogram;

import java.util.Stack;

public class Solution {

	public int largestRectangleArea(int[] heights) {

		int result = 0;
		int n = heights.length;

		int left[] = new int[n];
		int right[] = new int[n];

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; ++i) {
			while (stack.empty() == false && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}

			if (!stack.empty()) {
				left[i] = stack.peek();
			} else {
				left[i] = -1;
			}
			stack.push(i);
		}

		stack.clear();

		for (int i = n - 1; i >= 0; --i) {
			while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
				stack.pop();
			}

			if (!stack.empty()) {
				right[i] = stack.peek();
			} else {
				right[i] = n;
			}
			stack.push(i);
		}

		for (int i = 0; i < n; ++i) {
			result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
		}

		return result;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int heights[] = new int[] { 2, 1, 5, 6, 2, 3 };
		System.out.println(solution.largestRectangleArea(heights));

	}

}
