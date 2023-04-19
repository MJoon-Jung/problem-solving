import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] sequence = {1,2,3,4,5};
        int[] sequence2 = {1,1,1,2,3,4,5};
        int[] sequence3 = {2,2,2,2,2};
        Solution s = new Solution();
        System.out.println(s.solution(sequence, 7));
        System.out.println(s.solution(sequence2, 5));
        System.out.println(s.solution(sequence3, 6));
    }
    public int[] solution(int[] sequence, int k) {
        Arrays.sort(sequence);
        recursive(null, 0, 0, sequence, k);
        for(List<Integer> a : result) {
            System.out.println(a);
        }
        // Collections.sort(result, (o1, o2) -> {
        //     if(o1.size() == o2.size()) {
        //         return o1.get(0).compareTo(o2.get(0));
        //     }
        //     return Integer.valueOf(o1.size()).compareTo(o2.size());
        // });
        List<Integer> tmp = result.get(0);
        return new int[] { tmp.get(0), tmp.get(tmp.size()-1) };
    }
    private void recursive(List<Integer> cur, int idx, int sum, int[] sequence, int k) {
        if(idx >= sequence.length) return;
        if(sum > k) return;
        if(sum == k) {
            result.add(cur);
            return;
        }
        
        List<Integer> tmp = new ArrayList<>();
        if(cur != null) {
            for(Integer val : cur) {
                tmp.add(val);
            }    
        }
        
        recursive(tmp, idx + 1, sum + sequence[idx], sequence, k);
        recursive(tmp, idx + 1, sum, sequence, k);
    }
}
