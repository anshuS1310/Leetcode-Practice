class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        a = 0
        c = ""
        res = []
        for i in range(len(s)):
            c += s[i]
            if s[i] == "(":
                a += 1
            elif s[i] == ")":
                a -= 1
            
            if a == 0:
                res.append(c[1:-1])
                c = ""         
        return "".join(res)