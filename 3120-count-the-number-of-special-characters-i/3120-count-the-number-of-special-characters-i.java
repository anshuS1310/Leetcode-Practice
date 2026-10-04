class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> s=new HashSet<>();
        Set<Character> l=new HashSet<>();
        for(char c: word.toCharArray()){
            if(c>='A' && c<='Z'){
                l.add(Character.toLowerCase(c));
            }else{
                s.add(c);
            }
        }
        Set<Character> intersection = new HashSet<>(l);
        intersection.retainAll(s);
        return intersection.size();
    }
}