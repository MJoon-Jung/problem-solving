class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++) {
            String[] ar = quiz[i].split(" ");
            int result = toInt(ar[0]) + toInt(ar[2]) * (ar[1].equals("-") ? -1 : 1);
            int expected = toInt(ar[4]);
            answer[i] = result == expected ? "O" : "X";
        }

        return answer;
    }
    int toInt(String val) {
        return Integer.parseInt(val);
    }
}
