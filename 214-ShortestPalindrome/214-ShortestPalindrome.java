class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;

        String reverse = new StringBuilder(s).reverse().toString(); // reverse the input string
        String combined = s + "#" + reverse; // combine original and reversed with a separator

        // Create the KMP array (Longest Prefix Suffix array)
        int[] lps = computeLPSArray(combined);

        // Find the characters that need to be added (length of reverse string - value of last position in lps array)
        String toAdd = reverse.substring(0, reverse.length() - lps[lps.length - 1]);

        // Add the necessary characters to the original string to make it a palindrome
        return toAdd + s;
    }

    // Helper method to compute the LPS array (Knuth-Morris-Pratt algorithm's preprocessing)
    private int[] computeLPSArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
