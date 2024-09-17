
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Step 1: Split both sentences into words
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        // Step 2: Use a HashMap to store the frequency of each word
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Count words in the first sentence
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Count words in the second sentence
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Step 3: Collect uncommon words (words that appear exactly once)
        List<String> result = new ArrayList<>();
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                result.add(word);
            }
        }
        
        // Convert the result list to an array and return it
        return result.toArray(new String[0]);
    }
}
