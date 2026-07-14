class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s=s.split()
        l=len(s[-1])
        return l