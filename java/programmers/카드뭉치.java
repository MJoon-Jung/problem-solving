import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public String solution(String[] exCards1, String[] exCards2, String[] goals) {
        Cards cards1 = new Cards(exCards1);
        Cards cards2 = new Cards(exCards2);

        for (String goal : goals) {
            if(cards1.isCardUsed(goal) || cards2.isCardUsed(goal)) {
                continue;
            }
            
            return "No";
        }
        return "Yes";
    }

}

class Cards {
    private final Queue<String> cards;

    public Cards(String[] cards) {
        this.cards = new LinkedList<>(List.of(cards));
    }

    public boolean isCardUsed(String goal) {
        if(this.cards.isEmpty() || !this.cards.peek().equals(goal)) {
            return false;
        }
        this.cards.poll();
        return true;
    }
}
