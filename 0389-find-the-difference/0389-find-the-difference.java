class Solution {
    public char findTheDifference(String s, String t) {
        long sm = 0, d = 0;
        for (char c : t.toCharArray()) {
            sm += c - 'a';
        }
        for (char c : s.toCharArray()) {
            d += c - 'a';
        }
        return (char) (sm - d + 'a');
    }
}