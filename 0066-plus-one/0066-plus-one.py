class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        a=""
        for i in digits:
            a+=str(i)
        b=int(a)
        b+=1
        b=str(b)
        c=[]
        for i in b:
            c.append(int(i))
        return c



        