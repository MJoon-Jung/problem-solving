class Solution {
    public int solution(String str1, String str2) {
        for(int i = 0; i < str1.length() - str2.length() + 1; i++) {
            if(str1.charAt(i) != str2.charAt(0)) continue;
            boolean flag = true;
            for(int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i + j) != str2.charAt(j)) {
                    flag = false;
                    break;
				}
            }
            if(flag) return 1;
        }
        return 2;
    }
}
