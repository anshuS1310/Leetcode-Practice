class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
       int qLen = queries.length;
        
        // 1. Store original indices of queries to populate the result array correctly
        int[][] sortedQueries = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i][0] = queries[i]; // Query time
            sortedQueries[i][1] = i;          // Original index
        }
        
        // 2. Sort logs by timestamp and queries by target time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. Frequency array for server request counts (1-indexed servers)
        int[] serverCount = new int[n + 1];
        int activeServers = 0;
        
        int left = 0;  // Left pointer of sliding window in logs
        int right = 0; // Right pointer of sliding window in logs
        int lLen = logs.length;
        
        int[] ans = new int[qLen];

        // 4. Process each query using the sliding window
        for (int i = 0; i < qLen; i++) {
            int qTime = sortedQueries[i][0];
            int qIdx = sortedQueries[i][1];
            int intervalStart = qTime - x;
            int intervalEnd = qTime;

            // Expand right boundary: add logs whose timestamp <= intervalEnd
            while (right < lLen && logs[right][1] <= intervalEnd) {
                int serverId = logs[right][0];
                if (serverCount[serverId] == 0) {
                    activeServers++;
                }
                serverCount[serverId]++;
                right++;
            }

            // Shrink left boundary: remove logs whose timestamp < intervalStart
            while (left < lLen && logs[left][1] < intervalStart) {
                int serverId = logs[left][0];
                serverCount[serverId]--;
                if (serverCount[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }

            // Number of zero-request servers = Total servers - Active servers
            ans[qIdx] = n - activeServers;
        }

        return ans;     
    }
}