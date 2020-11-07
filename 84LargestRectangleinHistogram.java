/*
 单调栈
针对每一个元素，求出其左边小于其的第一个元素元素和右边小于其的第一个元素， 着组成的矩形面积是
(right-left-1)*h[i]

如果左边不存在小于其的元素，则left=-1
如果右边不纯在小于其的元素， 则right = n

举个例子: 5左边小于他的是1，右边小于他的是2， 下表left =1, right=4, 则面积（4-1-1）*5 = 10.

*/

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
