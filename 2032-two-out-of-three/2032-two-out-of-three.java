import java.util.*;
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> s1=new HashSet<>();
        for (int n:nums1){
            s1.add(n);
        }
        Set<Integer> s2=new HashSet<>();
        for (int n:nums2){
            s2.add(n);
        }
        Set<Integer> s3=new HashSet<>();
        for (int n:nums3){
            s3.add(n);
        }
        Set<Integer> r=new HashSet<>();
        Set<Integer> i1=new HashSet<>(s1);
        i1.retainAll(s2);
        Set<Integer> i2=new HashSet<>(s2);
        i2.retainAll(s3);
        Set<Integer> i3=new HashSet<>(s1);
        i3.retainAll(s3);
        r.addAll(i1);
        r.addAll(i2);
        r.addAll(i3);
        return new ArrayList<>(r);
    }
}