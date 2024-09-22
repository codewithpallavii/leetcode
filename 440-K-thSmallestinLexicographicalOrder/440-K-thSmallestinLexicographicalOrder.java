class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--; // Since we already consider the first number

        while (k > 0) {
            int steps = calculateSteps(n, current, current + 1);
            if (steps <= k) {
                // Move to the next sibling
                current++;
                k -= steps;
            } else {
                // Move to the next child
                current *= 10;
                k--;
            }
        }
        return current;
    }

    // Helper method to calculate the number of steps between two prefixes
    private int calculateSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
