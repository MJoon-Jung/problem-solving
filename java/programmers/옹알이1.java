class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] ar = { "aya", "ye", "woo", "ma" };
        
        for(String s: babbling) {
            boolean flag = true;
            while(flag) {
                flag = false;
                for(String word: ar) {
                    if(s.startsWith(word)) {
                        flag = true;
                        s = s.substring(word.length());
                        break;
                    }
                }
            }
            if(s.length() == 0) answer++;
            
        }
        return answer;
    }
}
