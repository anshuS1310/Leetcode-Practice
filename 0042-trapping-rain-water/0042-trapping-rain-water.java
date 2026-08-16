import java.util.*;
class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int lf = 0, rg = n - 1;
        int lx = 0, rx = 0;
        int w = 0;

        while (lf < rg) {
            if (h[lf] < h[rg]) {
                lx = Math.max(lx, h[lf]);
                w += lx - h[lf];
                lf++;
            } else {
                rx = Math.max(rx, h[rg]);
                w += rx - h[rg];
                rg--;
            }
        }
        return w;
    }
}