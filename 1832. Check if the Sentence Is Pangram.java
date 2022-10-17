/*A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

 

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.

Example 2:

Input: sentence = "leetcode"
Output: false
 

Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters.
 * 
 */

class Solution {
    public boolean checkIfPangram(String sentence) {
        Map<Character, Integer> map = new HashMap<>();
        for (char i='a';i<='z';i++){
            map.put(i, 0);
        }
        
        for (int i=0;i<sentence.length();i++){
            char temp = sentence.charAt(i);
            map.put(temp, map.get(temp) + 1);
        }
        
        for (char i='a';i<='z';i++){
            if (map.get(i) == 0) return false;
        }
        
        return true;
    }
}