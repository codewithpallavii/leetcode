import java.util.Arrays;

class Solution {
    
    // Helper method to find the length of the common prefix between two strings
    private int commonPrefixLength(String a, String b) {
        int len = 0;
        int minLength = Math.min(a.length(), b.length());
        
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                len++;
            } else {
                break;
            }
        }
        return len;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // Convert both arrays into String arrays for prefix comparison
        String[] strArr1 = new String[arr1.length];
        String[] strArr2 = new String[arr2.length];
        
        for (int i = 0; i < arr1.length; i++) {
            strArr1[i] = Integer.toString(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            strArr2[i] = Integer.toString(arr2[i]);
        }
        
        // Sort both string arrays
        Arrays.sort(strArr1);
        Arrays.sort(strArr2);
        
        int maxLength = 0;
        
        // Compare each element from sorted arrays (early stop when prefix mismatch)
        int i = 0, j = 0;
        while (i < strArr1.length && j < strArr2.length) {
            String x = strArr1[i];
            String y = strArr2[j];
            
            // Find the common prefix length between x and y
            int currentLength = commonPrefixLength(x, y);
            maxLength = Math.max(maxLength, currentLength);
            
            // Increment the pointer for the smaller string lexicographically
            if (x.compareTo(y) < 0) {
                i++;
            } else {
                j++;
            }
        }
        
        return maxLength;
    }
}
