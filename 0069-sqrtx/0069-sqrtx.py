class Solution:
    def mySqrt(self, x: int) -> int:
        i=1
        while(True):
            j=i*i
            if j==x:
                return i
            elif j>x:
                return i-1
            i+=1
