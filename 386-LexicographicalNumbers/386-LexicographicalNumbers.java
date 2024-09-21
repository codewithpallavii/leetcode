class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int current = 1;

        for (int i = 0; i < n; i++) {
            result.add(current);

            if (current * 10 <= n) {
                current *= 10; // Move to the next lexicographically smallest number
            } else {
                while (current % 10 == 9 || current + 1 > n) {
                    current /= 10; // Move to the parent level when there is no more room for further digits
                }
                current++; // Move to the next number at the current level
            }
        }
        
        return result;
    }
}
