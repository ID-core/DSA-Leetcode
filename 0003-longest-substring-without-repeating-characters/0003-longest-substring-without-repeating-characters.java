class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int max_len = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            boolean visited[] = new boolean[256];
            for (int j = i; j < n; j++) {
                if (visited[s.charAt(j)] == true) {
                    break;
                } else {
                    visited[s.charAt(j)] = true;
                    max_len = Math.max(max_len, j - i + 1);
                }
            }
        }
        return max_len;
    }
}