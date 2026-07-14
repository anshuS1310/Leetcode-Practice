class Solution:
    def isPalindrome(self, x: int) -> bool:
        m=str(x)
        l=len(m)
        res=False
        for i in range(l):
            if(m[i]==m[l-i-1]):
                res=True
            else:
                res=False
                break
        return res


        