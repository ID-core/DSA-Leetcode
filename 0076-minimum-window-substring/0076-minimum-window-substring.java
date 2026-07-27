class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();
        int start = 0;
        int left = 0;
        int min_len = Integer.MAX_VALUE;
        int formed_len = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            t_map.put(ch, t_map.getOrDefault(ch, 0) + 1);
        }
        int req_len = t_map.size();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            s_map.put(ch, s_map.getOrDefault(ch, 0) + 1);

            if (t_map.containsKey(ch) && t_map.get(ch).equals(s_map.get(ch))) {
                formed_len++;
            }
            while (req_len == formed_len) {
                //updating ans
                if (right - left + 1 < min_len) {
                    min_len = right - left + 1;
                    start = left;
                }
                char leftchar = s.charAt(left);
                s_map.put(leftchar, s_map.get(leftchar) - 1); //removing left char - shrinking

                // if windows satisfying/not satisfying condition after removing left
                if (t_map.containsKey(leftchar) && s_map.get(leftchar) < t_map.get(leftchar)) {
                    formed_len--;
                }
                left++;
            }
        }
        return min_len == Integer.MAX_VALUE ? "" : s.substring(start, start + min_len);
    }
}