/*You are given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

 

Example 1:

Input: num = 9669
Output: 9969
Explanation: 
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.

Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.

Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.
 

Constraints:

1 <= num <= 104
num consists of only 6 and 9 digits.
 * 
 */

class Solution {
    public int maximum69Number (int num) 
    {
         //first encountered '6' from left = last encountered '6' from right
        
        int rightDigCount = -1; //number of digits to right of last encountered '6'
        int digCount = 0; //number of digits to right of any dig at some instance
        int temp = num; 
        //====================================================================
        while(temp > 0) //digits are being recorded from right to left of num
        {
            int dig = temp % 10;
            if (dig == 6) rightDigCount = digCount; //record the rightDigCount when a '6' is encountered
            
            digCount++;
            temp = temp / 10;
        }
        //======================================================================
        if (rightDigCount == -1) return num;
        int ans = num + (3 * (int)Math.pow(10, rightDigCount));
        return ans;
        
    }
}