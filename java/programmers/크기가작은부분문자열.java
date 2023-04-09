// [문제 링크]: https://school.programmers.co.kr/learn/courses/30/lessons/147355

import java.math.BigInteger;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
          if (t.charAt(i) > p.charAt(0) || i > t.length()) {
                continue;
            }
            String substring = t.substring(i, i + p.length());
            BigInteger tbi = new BigInteger(substring);
            BigInteger pbi = new BigInteger(p);

            if (tbi.compareTo(pbi) <= 0) {
                answer++;
            }
        }

        return answer;
    }
}
