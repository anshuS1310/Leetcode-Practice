class ProductOfNumbers {
    private int l[];
    private int s;
    public ProductOfNumbers() {
        l=new int[16];
        s=1;
        l[0]=1;
    }
    
    public void add(int num) {
        if(num==0){
            l[0]=1;
            s=1;
        }else{
            if(s==l.length){
                l=Arrays.copyOf(l,s*2);
            }
            l[s]=l[s-1]*num;
            s++;
        }
    }
    
    public int getProduct(int k) {
        if(k>=s){
            return 0;
        }
        return l[s-1]/l[s-1-k];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */