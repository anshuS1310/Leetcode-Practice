class Solution {
    public int findPermutationDifference(String s, String t) {
        int a=0;
        for(int i=0;i<t.length();i++){
            a+=Math.abs(i-(s.indexOf(t.charAt(i))));
        }
        return a; 
    }
}