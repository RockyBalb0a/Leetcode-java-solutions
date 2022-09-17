/*Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

 

Example 1:

Input: words = ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

Example 2:

Input: words = ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]

Example 3:

Input: words = ["a",""]
Output: [[0,1],[1,0]]
 

Constraints:

1 <= words.length <= 5000
0 <= words[i].length <= 300
words[i] consists of lower-case English letters.
 * 
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        Map<String, Integer> dictionary = new HashMap<>();
        int[] hasLength = new int[5000];

        for (int i = 0; i < words.length; i++) {
            dictionary.put(words[i], i);
            hasLength[words[i].length()]++;
        }   
        if (dictionary.containsKey("")) {
            int emptyStrIndex = dictionary.get("");
            for (int i = 0; i < words.length; i++) {
                if (isPalindrome(words[i], 0, words[i].length() - 1)) {
                    if (i == emptyStrIndex) {
                        continue;
                    }
                    result.add(Arrays.asList(emptyStrIndex, i));
                    result.add(Arrays.asList(i, emptyStrIndex));
                }
            }  
        }
        for (int i = 0; i < words.length; i++) {
            String reversedStr = reverseStr(words[i]);
            if (dictionary.containsKey(reversedStr)) {
                int reversedStrIndex = dictionary.get(reversedStr);
                if (i == reversedStrIndex) {
                    continue;
                }
                result.add(Arrays.asList(i, reversedStrIndex));
            }
        }
        for (int i = 0; i < words.length; i++) {
            String currentStr = words[i];
            for (int sliceIndex = 1; sliceIndex < currentStr.length(); sliceIndex++) {
                if (hasLength[sliceIndex] > 0 && isPalindrome(currentStr, sliceIndex, currentStr.length() - 1)) {
                    String reversedSubStr = reverseStr(currentStr.substring(0,sliceIndex));
                    if (dictionary.containsKey(reversedSubStr)) {
                        int reversedStrIndex = dictionary.get(reversedSubStr);               
                        if (reversedStrIndex == i) {
                            continue;
                        }                   
                        result.add(Arrays.asList(i, reversedStrIndex));
                    }
                }           
                if (hasLength[currentStr.length() - sliceIndex] > 0&& isPalindrome(currentStr, 0, sliceIndex - 1)) {
                String reversedSubStr = reverseStr(currentStr.substring(sliceIndex, currentStr.length()));
                if (dictionary.containsKey(reversedSubStr)) {
                    int reversedStrIndex = dictionary.get(reversedSubStr);
                    
                    if (reversedStrIndex == i) {
                        continue;
                    }
                   
                    result.add(Arrays.asList(reversedStrIndex, i));
                }
            }
        }
    }
    return result;
}


private boolean isPalindrome(String str, int front, int back) {
    while (front < back) {
        if (str.charAt(front) != str.charAt(back)) {
            return false;
        }
        front++;
        back--;
    }
    return true;
}


private String reverseStr(String str) {
    StringBuilder stringBuilder = new StringBuilder(str);
    return stringBuilder.reverse().toString();
}
}