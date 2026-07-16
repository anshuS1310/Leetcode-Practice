class Solution:
    def isValid(self, s: str) -> bool:
        a=[]
        for i in s:
            if i == "{" or i == "["or i == "(":
                a.append(i)
            elif i == "}" or i == "]" or i == ")":
                if(len(a)==0):
                    return False
                if(a[-1]=="{" and i =="}"):
                    a.pop(-1)
                elif(a[-1]=="(" and i == ")") :
                    a.pop(-1)
                elif(a[-1]=="[" and i == "]"):
                    a.pop(-1)
                else:
                    return False
        if len(a)==0:
            return True
        else:
            return False

        



        