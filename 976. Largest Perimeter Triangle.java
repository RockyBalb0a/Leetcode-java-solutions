/*Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

 

Example 1:

Input: nums = [2,1,2]
Output: 5

Example 2:

Input: nums = [1,2,1]
Output: 0
 

Constraints:

3 <= nums.length <= 104
1 <= nums[i] <= 106
 * 
 */

class Solution {
    public int largestPerimeter(int[] nums) {
      Arrays.sort(nums);
      
      for(int a = nums.length - 1, b = nums.length - 2, c = nums.length - 3; b != 0; a--, b--, c--)
        if(nums[a] < nums[b] + nums[c]) return nums[a] + nums[b] + nums[c];
      
      return 0;      
    }
  }
  