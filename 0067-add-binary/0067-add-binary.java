class Solution {
    public String addBinary(String a, String b) {
        if(a.length()<b.length()){
            return addBinary(b,a);
        }
        char a1[]=a.toCharArray();
        char b1[]=b.toCharArray();
        int c=0;
        int j=b1.length-1;
        for(int i=a1.length-1;i>=0;i--){
            int sum = (a1[i] - '0') + (j >= 0 ? b1[j--] - '0' : 0) + c;
            a1[i] = (char) ((sum % 2) + '0');
            c = sum / 2;
        }
        String res = new String(a1);
        return c == 1 ? "1" + res : res;
    }
}