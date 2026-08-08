class Solution {
    public long matrixSumQueries(int n, int[][] q) {
        boolean[] rowUsed = new boolean[n];
        boolean[] colUsed = new boolean[n];
        int rowsLeft = n;
        int colsLeft = n;

        long a = 0;
        for (int i = q.length - 1; i >= 0; i--) {
            int type = q[i][0];
            int idx = q[i][1];
            int val = q[i][2];

            if (type == 0) {
                if (!rowUsed[idx]) {
                    rowUsed[idx] = true;
                    rowsLeft--;
                    a += (long) val * colsLeft;
                }
            } else {
                if (!colUsed[idx]) {
                    colUsed[idx] = true;
                    colsLeft--;
                    a += (long) val * rowsLeft; 
                }
            }
        }

        return a;
    }
}