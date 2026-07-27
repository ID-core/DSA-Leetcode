class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int ans = 0;
        if (fruits.length == 1)
            return 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            int ch = fruits[right];
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            //shrinking
            while (map.size() > 2) {
                int leftchar = fruits[left];
                map.put(leftchar, map.get(leftchar) - 1);
                if (map.get(leftchar) == 0) {
                    map.remove(leftchar);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}