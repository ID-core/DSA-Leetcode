class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int req[] = new int[26];
        int window[] = new int[26];

        for (int i = 0; i < p.length(); i++) {
            req[p.charAt(i) - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            window[s.charAt(right) - 'a']++;
            while (right - left + 1 > p.length()) {
                window[s.charAt(left) - 'a']--;
                left++;
            }
            if (Arrays.equals(window, req)) {
                ans.add(left);
            }
        }
        return ans;
    }
}