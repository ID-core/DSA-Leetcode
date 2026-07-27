class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int req[] = new int[26];
        int window[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            req[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        int right;
        for (right = 0; right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;

            // if our window becomes> s1.length
            while (right - left + 1 > s1.length()) {
                window[s2.charAt(left) - 'a']--;
                left++;
            }

            //if length matches, then frequencies matched check
            if (right - left + 1 == s1.length()) {
                if (Arrays.equals(req, window)) {
                    return true;
                }
            }

        }
        return false;
    }
}