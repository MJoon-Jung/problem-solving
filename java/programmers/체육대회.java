import java.util.stream.IntStream;

class Solution {
    int[] board = new int[11];
    int result;
    public int solution(int[][] ability) {
        for(int i = 0; i < ability.length; i++) board[i] = i;
        permutation(0, ability);
        return result;
    }
    private void permutation(int depth, int[][] ability) {
        int r = ability[0].length;
        if(depth == r) {
            result = Math.max(result, IntStream.range(0, r).map((i) -> ability[board[i]][i]).sum());
            return;
        }
        for(int i = depth; i < ability.length; i++) {
            swap(i, depth);
            permutation(depth + 1, ability);
            swap(depth, i);
        }
    }
    private void swap(int a, int b) {
        int tmp = board[b];
        board[b] = board[a];
        board[a] = tmp;
    }
}
