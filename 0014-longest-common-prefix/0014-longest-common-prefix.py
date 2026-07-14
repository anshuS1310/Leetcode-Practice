class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        strs.sort()
        s=""
        l=len(strs)
        for i in range(len(strs[0])):
            if(strs[0][i])==(strs[l-1][i]):
                s+=strs[0][i]
            else:
                break
        return s