class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        a=-1
        for i in range(len(haystack)):
            for j in range(i,len(haystack)):
                if haystack[i:j+1]==needle:
                    a=i
                    if(a!=-1):
                        return a       
        if(a==-1):
            return a