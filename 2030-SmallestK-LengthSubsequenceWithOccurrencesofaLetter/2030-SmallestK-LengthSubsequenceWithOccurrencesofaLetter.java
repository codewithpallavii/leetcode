class Solution:
    def smallestSubsequence(self, s: str, k: int, letter: str, repetition: int) -> str:
        available = s.count(letter)
        discardable = available-repetition
        stack = []
        
        for i, ch in enumerate(s):
            while stack and stack[-1] > ch and (len(stack)+len(s)-i > k) and (stack[-1] != letter or discardable > 0):
                if stack.pop() == letter:
                    discardable -= 1
                    repetition += 1
            if len(stack) < k:
                if ch == letter:
                    repetition -= 1
                    stack.append(ch)
                else:
                    if k-len(stack) > repetition:
                        stack.append(ch)
        return ''.join(stack)