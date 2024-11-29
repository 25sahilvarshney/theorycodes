import java.util.*;
public class Tournament_Rankings {
    private List<String> rankings;

    public Tournament_Rankings() {
        rankings = new LinkedList<>();
    }

    public void addPlayer(String player) {
        rankings.add(player);
    }

    public void removePlayer(String player) {
        rankings.remove(player);
    }

    public String getTopPlayer() {
        return rankings.get(0);
    }

    public void displayRankings() {
        for (String player : rankings) {
            System.out.println(player);
        }
    }

    public static void main(String[] args) {
        Tournament_Rankings rankings = new Tournament_Rankings();
        rankings.addPlayer("Player A");
        rankings.addPlayer("Player B");
        rankings.addPlayer("Player C");
        System.out.println("Top player: " + rankings.getTopPlayer());
        rankings.removePlayer("Player B");
        rankings.displayRankings();
    }
}

