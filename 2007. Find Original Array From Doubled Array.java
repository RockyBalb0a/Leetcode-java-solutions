/*An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.

Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.

 
Example 1:

Input: changed = [1,3,4,2,6,8]
Output: [1,3,4]
Explanation: One possible original array could be [1,3,4]:
- Twice the value of 1 is 1 * 2 = 2.
- Twice the value of 3 is 3 * 2 = 6.
- Twice the value of 4 is 4 * 2 = 8.
Other original arrays could be [4,3,1] or [3,1,4].

Example 2:

Input: changed = [6,3,0,1]
Output: []
Explanation: changed is not a doubled array.

Example 3:

Input: changed = [1]
Output: []
Explanation: changed is not a doubled array.
 

Constraints:

1 <= changed.length <= 105
0 <= changed[i] <= 105
 * 
 */

import java.util.*;
class Solution {
    public int[] findOriginalArray(int[] changed) {
        //if length of array is odd it can't be doubled array

        if(changed.length%2==1)
            return new int[0];
        int n = changed.length/2;
        int[] result = new int[n];
        // sort the array because we want to check if double of element exists from smaller to greater
        Arrays.sort(changed);
        // HashMap because we want to keep track of considered element 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int c : changed){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int index = 0;
        for(int i : changed){
            int doubled = i*2;
            // i=0 have the same doubled value so handled explicitly
            if(i==0 && map.getOrDefault(i,0)>1){
                result[index++] = i;
                map.put(i,map.get(doubled)-2);
            }
            // check if element and doubled both exists in remaining element
            else if(i!=0 && map.get(i)>0 && map.getOrDefault(doubled,0)>0){
                result[index++] = i;
                map.put(doubled,map.get(doubled)-1);
                map.put(i,map.get(i)-1);
            }
        }
        // n is half the length of input array and if index is same then it is doubled array
        if(index==n)
            return result;
        return new int[0];
    }
}