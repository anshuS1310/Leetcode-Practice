class Solution:
    def findTheWinner(self, n: int, k: int) -> int:
        r=list(range(1,n+1))
        c=0
        while len(r)!=1:
            c=(c+k-1)%len(r)
            r.pop(c)
        return r[0]
        