class Solution {
    public int solution(int[][] sizes) {
        int small = 0, large = 0;
        for(int i = 0; i < sizes.length; i++) {
            large = Math.max(large, Math.max(sizes[i][0], sizes[i][1]));
            small = Math.max(small, Math.min(sizes[i][0], sizes[i][1]));
        }
        return large * small;
    }
}
