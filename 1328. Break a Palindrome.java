/*Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.

Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.

A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.

 

Example 1:

Input: palindrome = "abccba"
Output: "aaccba"
Explanation: There are many ways to make "abccba" not a palindrome, such as "zbccba", "aaccba", and "abacba".
Of all the ways, "aaccba" is the lexicographically smallest.

Example 2:

Input: palindrome = "a"
Output: ""
Explanation: There is no way to replace a single character to make "a" not a palindrome, so return an empty string.
 

Constraints:

1 <= palindrome.length <= 1000
palindrome consists of only lowercase English letters.
 * 
 */
class Solution {
    public String breakPalindrome(String palindrome) {
         // If the string contains only one char then we will simply return blank string 
         if(palindrome.length()==1) return "";
         StringBuilder answer = new StringBuilder(palindrome);
         // If the string contains all the 'a's or only one char other than 'a' which is in the middle, then we can simply change the last char to 'b'. This will make the string non-palindromic and will be lexiographically smallest.
         if(isThisStringAnEdgeCase(palindrome)) {
             answer.setCharAt(palindrome.length()-1 , 'b');
         } 
         // Here we will simply find the first char which is not 'a', convert it to 'a' and the string will become non-palindromic.
         else {
             for(int i=0;i<answer.length();i++) {
                 if(answer.charAt(i)!='a') {
                     answer.replace(i,i+1,"a");
                     break;
                 }
             }   
         }
         return  answer.toString();
     }
 
     /**
     * This method will return true if every chacter is 'a' or if the string contains only one character that is other than 'a' and it's placed in the middle.
     * You can choose a better name for the method ;)
     */
     private boolean isThisStringAnEdgeCase(String palindrome) {
         int start = 0;
         int end = palindrome.length()-1;
         while(start<end) {
             if(palindrome.charAt(start)!='a' || palindrome.charAt(end)!='a') {
                 return false;
             }
             start++;
             end--;
         }
         return true;
     }
 }