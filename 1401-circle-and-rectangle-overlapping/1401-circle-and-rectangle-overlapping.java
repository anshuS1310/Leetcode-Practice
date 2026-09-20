class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xc=Math.max(x1,Math.min(xCenter,x2));
        int yc=Math.max(y1,Math.min(yCenter,y2));
        return (((xc-xCenter)*(xc-xCenter))+((yc-yCenter)*(yc-yCenter)))<=(radius*radius);  
    }
}