class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> us = new HashSet<>();
        for(int i=0;i<digits.length;i++){
            if(digits[i]%2!=0){
                continue;
            }
            for(int j=0;j<digits.length;j++){
                if(j==i){
                    continue;
                }
                for(int k=0;k<digits.length;k++){
                    if(k==i || k==j || digits[k]==0){
                        continue;
                    }
                    int a=digits[k]*100 + digits[j]*10 + digits[i];
                    us.add(a);
                }
            }
        }

        return us.size();
    }
}