/*You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.

You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:

Choose one integer x from either the start or the end of the array nums.
Add multipliers[i] * x to your score.
Remove x from the array nums.
Return the maximum score after performing m operations.

 

Example 1:

Input: nums = [1,2,3], multipliers = [3,2,1]
Output: 14
Explanation: An optimal solution is as follows:
- Choose from the end, [1,2,3], adding 3 * 3 = 9 to the score.
- Choose from the end, [1,2], adding 2 * 2 = 4 to the score.
- Choose from the end, [1], adding 1 * 1 = 1 to the score.
The total score is 9 + 4 + 1 = 14.

Example 2:

Input: nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
Output: 102
Explanation: An optimal solution is as follows:
- Choose from the start, [-5,-3,-3,-2,7,1], adding -5 * -10 = 50 to the score.
- Choose from the start, [-3,-3,-2,7,1], adding -3 * -5 = 15 to the score.
- Choose from the start, [-3,-2,7,1], adding -3 * 3 = -9 to the score.
- Choose from the end, [-2,7,1], adding 1 * 4 = 4 to the score.
- Choose from the end, [-2,7], adding 7 * 6 = 42 to the score. 
The total score is 50 + 15 - 9 + 4 + 42 = 102.
 

Constraints:

n == nums.length
m == multipliers.length
1 <= m <= 103
m <= n <= 105
-1000 <= nums[i], multipliers[i] <= 1000
 * 
 */
import java.util.*;
class Solution {
    private int helper(int[] nums, int N, int[] multipliers, int M, int numsLeftIndex, int index, int[][] dp) {
	    int numsRightIndex = N - 1 - (index - numsLeftIndex);
	    if (index == M){ 
            return 0;
        }

	    if (dp[numsLeftIndex][index] != Integer.MIN_VALUE) {
            return dp[numsLeftIndex][index];
        }

        int leftScore = nums[numsLeftIndex] * multipliers[index]vs + helper(nums, N,  multipliers, M, numsLeftIndex + 1, index + 1, dp);
        int rightScore = nums[numsRightIndex] * multipliers[index] + helper(nums, N, multipliers, M, numsLeftIndex, index + 1, dp);
	    return dp[numsLeftIndex][index] = Math.max(leftScore, rightScore);
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp = new int[multipliers.length][multipliers.length];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
	    return helper(nums, nums.length, multipliers, multipliers.length, 0, 0, dp);
    }
}