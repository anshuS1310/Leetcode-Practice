class Solution {
    public int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Set<String> communicatingServers = new HashSet<>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    List<int[]> component = new ArrayList<>();
                    dfs(r, c, grid, rows, cols, component);

                    // MINIMAL CHANGE: Only add to set if component size > 1
                    if (component.size() > 1) {
                        for (int[] pos : component) {
                            communicatingServers.add(pos[0] + "," + pos[1]);
                        }
                    }
                }
            }
        }

        return communicatingServers.size();
    }

    private void dfs(int r, int c, int[][] grid, int rows, int cols, List<int[]> component) {
        grid[r][c] = 2; // Mark as visited
        component.add(new int[]{r, c});

        // Search entire row
        for (int colIdx = 0; colIdx < cols; colIdx++) {
            if (grid[r][colIdx] == 1) {
                dfs(r, colIdx, grid, rows, cols, component);
            }
        }

        // Search entire column
        for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
            if (grid[rowIdx][c] == 1) {
                dfs(rowIdx, c, grid, rows, cols, component);
            }
        }
    }
}