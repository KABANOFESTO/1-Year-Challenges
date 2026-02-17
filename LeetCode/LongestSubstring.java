package LeetCode;

class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[128]; 
        java.util.Arrays.fill(charIndex, -1);

        int maxLen = 0;
        int left = 0; 

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (charIndex[c] >= left) {
                left = charIndex[c] + 1;
            }

            charIndex[c] = right; 
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); 
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));   
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));  
        System.out.println(solution.lengthOfLongestSubstring(""));        
        System.out.println(solution.lengthOfLongestSubstring(" "));       
    }
}