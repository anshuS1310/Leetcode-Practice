class Solution {
    public int maxDepth(String s) {
        int mns=0,mxf=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                mns++;
                mxf=Math.max(mxf,mns);
            }else if(s.charAt(i)==')'){
                mns--;
            }
        }
        return mxf;
    }
}