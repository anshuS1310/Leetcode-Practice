class Solution:
    def findMinimumOperations(self, s1: str, s2: str, s3: str) -> int:
        if len(s1)<len(s2) and len(s1)<len(s3):
            n=len(s1)
        elif len(s2)<len(s3):
            n=len(s2)
        else:
            n=len(s3)
        l=0
        for i in range(n):
            if s1[i]==s2[i] and s2[i]==s3[i] and i==l:
                l+=1
        if l>0:
            return (len(s1)-l)+(len(s2)-l)+(len(s3)-l)
        return -1
