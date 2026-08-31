class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        a=""
        ans=0
        c=0
        for i in s:
            if i in a:
                c+=1
            a+=i
            if len(a)==3:
                if c==0:
                    ans+=1
                elif a[2]!=a[1]:
                    c=0
                a=a[1:]
        return ans

                