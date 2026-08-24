class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        sub=[fruits[0]]
        l=0
        for i in range(1,len(fruits)):
            if fruits[i] not in sub:
                sub.append(fruits[i])
                l=i
                break
            l=i
            sub.append(fruits[i])
        ans=len(sub)
        for i in range(l+1,len(fruits)):
            if fruits[i] in sub:
                sub.append(fruits[i])
            else: 
                n=len(sub)-1
                t=[]
                while sub[-1]==sub[n]:
                    t.append(sub[n])
                    n-=1
                sub=t
                sub.append(fruits[i])
            mx=len(sub)
            if ans<mx:
                ans=mx
        return ans

