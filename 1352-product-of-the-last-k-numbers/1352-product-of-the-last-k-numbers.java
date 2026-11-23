class ProductOfNumbers {
    private List<Integer> res;

    public ProductOfNumbers() {
        this.res=new ArrayList<>();
        this.res.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            this.res=new ArrayList<>();
            this.res.add(1);
        }else{
            this.res.add(this.res.get(this.res.size()-1)*num);
        }
    }
    public int getProduct(int k) {
        int n=this.res.size();
        if (k>=n){
            return 0;
        }
        return this.res.get(n-1)/this.res.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */