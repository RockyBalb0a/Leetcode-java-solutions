/*Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

 

Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].

Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100
 * 
 */

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int maxLength=0;
        int dp[][]=new int[len1+1][len2+1];
        for(int i=0;i<len1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<len2;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(nums1[i]==nums2[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                }
                if(maxLength<dp[i+1][j+1])
                    maxLength=dp[i+1][j+1];
            }
        }
        return maxLength;
    }
}

