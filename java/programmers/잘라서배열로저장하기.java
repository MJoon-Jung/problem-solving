class Solution {
    public String[] solution(String my_str, int n) {
        String answer = "";
        for(int i = 0; i < my_str.length(); i += n) {
            answer += i + n > my_str.length() ? my_str.substring(i) : my_str.substring(i, i + n) + ",";
        }
        return answer.split(",");
    }
}
