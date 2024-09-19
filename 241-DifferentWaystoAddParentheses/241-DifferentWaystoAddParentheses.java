class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        // Memoization map to store results of subproblems
        Map<String, List<Integer>> memo = new HashMap<>();
        return computeWays(expression, memo);
    }
    
    private List<Integer> computeWays(String expression, Map<String, List<Integer>> memo) {
        // If we've already computed the result for this expression, return it
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();
        
        // Loop through the expression and split at each operator
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // If we find an operator, split the expression around it
            if (c == '+' || c == '-' || c == '*') {
                // Compute all possible results from the left and right sub-expressions
                List<Integer> left = computeWays(expression.substring(0, i), memo);
                List<Integer> right = computeWays(expression.substring(i + 1), memo);
                
                // Combine the results from left and right sub-expressions using the operator
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        
        // If no operators were found, it means the expression is just a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        // Store the result in the memo map
        memo.put(expression, result);
        return result;
    }
}