import java.util.HashSet;
import java.util.Set;

class Solution {
    public double minAreaFreeRect(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        for (int[] p : points) {
            pointSet.add(p[0] + "," + p[1]);
        }

        int n = points.length;
        double minArea = Double.MAX_VALUE;

        // p1 is the corner vertex (scans all N points)
        for (int i = 0; i < n; i++) {
            int[] p1 = points[i];

            // p2 and p3 are the two arm points (scanned as combinations j < k)
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int[] p2 = points[j];

                for (int k = j + 1; k < n; k++) {
                    if (i == k) continue;
                    int[] p3 = points[k];

                    // Vector 1: p1 -> p2
                    int uX = p2[0] - p1[0];
                    int uY = p2[1] - p1[1];

                    // Vector 2: p1 -> p3
                    int vX = p3[0] - p1[0];
                    int vY = p3[1] - p1[1];

                    // 1. Perpendicular Check: Dot product == 0
                    if (uX * vX + uY * vY != 0) continue;

                    // 2. Expected 4th point: p4 = p2 + v
                    String p4Key = (p2[0] + vX) + "," + (p2[1] + vY);

                    // 3. Check presence of p4
                    if (pointSet.contains(p4Key)) {
                        double len1 = Math.sqrt(uX * uX + uY * uY);
                        double len2 = Math.sqrt(vX * vX + vY * vY);
                        double area = len1 * len2;

                        minArea = Math.min(minArea, area);
                    }
                }
            }
        }

        return minArea == Double.MAX_VALUE ? 0.0 : minArea;
    }
}