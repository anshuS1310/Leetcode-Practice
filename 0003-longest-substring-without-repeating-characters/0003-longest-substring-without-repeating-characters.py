class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        a=[]
        b=0
        for i in range(len(s)):
            if s[i] in a:
                a=a[(a.index(s[i]))+1:len(a)]
                a.append(s[i])
            else:
                a.append(s[i])
                b=max(len(a),b)
        return b        