/*Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?
 * 
 */

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        int count = map.size(), ansLength = Integer.MAX_VALUE;
        String ans = "";
        
        int i = 0, j = 0;
        while(j < s.length()) {
            
            char cur = s.charAt(j);
            if(map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if(map.get(cur) == 0) count--;
            }
            
            if(count > 0)
                j++;
            
            else if(count == 0) {  
                  
                while(count == 0) {
                    
                    if(j-i+1 < ansLength) {
                        ansLength = j-i+1;
                        ans = s.substring(i, j+1);
                    }
                    
                    char rm = s.charAt(i);
                    if(map.containsKey(rm)) {
                        map.put(rm, map.get(rm) + 1);
                        if(map.get(rm) == 1) count++;
                    }  
                    
                    i++;    
                }  
                
                j++;  
            }
        }
        
        return ans;
         
    }
}