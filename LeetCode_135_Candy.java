package Leetcode135_Candy;

/*思路:
	记忆化搜索：
	当一个小孩比左边或者右边rating高时， 则糖果多拿一个。
	if (i - 1 >= 0 && w[i - 1] < w[i]) {
		f[i] = Math.max(f[i], dp(i - 1) + 1);
	}

	if (i + 1 < n && w[i + 1] < w[i]) {
		f[i] = Math.max(f[i], dp(i + 1) + 1);
	}
*/

import java.util.Arrays;

public class Solution {

	int f[];
	int w[];
	int n;

	public int candy(int[] ratings) {
		int ret = 0;
		n = ratings.length;
		w = ratings;

		f = new int[n];
		Arrays.fill(f, -1);
		for (int i = 0; i < n; ++i) {
			ret += dp(i);
		}

		return ret;
	}

	public int dp(int i) {
		if (f[i] >= 0) {
			return f[i];
		}

		f[i] = 1;
		if (i - 1 >= 0 && w[i - 1] < w[i]) {
			f[i] = Math.max(f[i], dp(i - 1) + 1);
		}

		if (i + 1 < n && w[i + 1] < w[i]) {
			f[i] = Math.max(f[i], dp(i + 1) + 1);
		}

		return f[i];

	}

	public static void main(String[] args) {
		int[] ratings = new int[] { 1, 2, 2 };
		
		Solution solution = new Solution();

		System.out.println(solution.candy(ratings));
	}

}
