class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++) answer += convert(s.charAt(i), n) + "";
        return answer;
    }
    char convert(char c, int n) {
        if(c == ' ') return c;
        char result = (char) (c + n);
        if(c >= 'a' && c <= 'z' && result > 'z') return (char) (result - ('z' - 'a' + 1));
        else if(c >= 'A' && c <= 'Z' && result > 'Z') return (char) (result - ('z' - 'a' + 1));
        return result;
    }
}
