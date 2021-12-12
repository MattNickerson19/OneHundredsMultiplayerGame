import java.util.*;

public class OneHundreds {
    ArrayList<Player> playerList = new ArrayList();
    HashMap<String, Integer> score = new HashMap<String, Integer>();
    //Generate Deck
    ArrayList deck = createDeck();

    //Deal cards to players
    LinkedList<Card> hand;
    public void dealCards(){
        int counter = deck.size() / playerList.size();
        for (int i = 0; i < counter; i++){
            for (Player player : playerList){
                Card removedCard = (Card) deck.get(0);
                hand = player.getHand();
                hand.add(removedCard);
                deck.remove(removedCard);
                player.setHand(hand);
            }

        }
    }
    //takes clients and creates player objects and adds them to player list
    public void addPlayer(String name){
        Player player = new Player();
        player.setName(name);
        playerList.add(player);
    }
    //generates and shuffles deck
    public ArrayList createDeck(){
        CardDeck carddeck = new CardDeck();
        ArrayList deck = carddeck.GenerateDeck();
        carddeck.ShuffleDeck(deck, 2);
        return deck;
    }
    //shows players hand to client
    public String showHand(String name){
        for (Player player : playerList){
            if (player.getName().equals(name)){
                return player.PrintHand(player.getHand());
            }
        }
        return null;
    }

    //determines winner of each round and calculates overall winner
    public ArrayList<String> playGame() {
        ArrayList<String> output = new ArrayList<>();
        Player player1 = playerList.get(0);
        Player player2 = playerList.get(1);
        Player player3 = playerList.get(2);
        Player player4 = playerList.get(3);

        int player1Wins = 0;
        int player2Wins = 0;
        int player3Wins = 0;
        int player4Wins = 0;

        while (true) {
            int winningValue = 0;
            try {
                hand = player1.getHand();
                Card playedCard1 = hand.getFirst();
                output.add(player1.getName() + " lays (" + playedCard1.getValue() + " " + playedCard1.getStatus() + ")");
                hand.remove(playedCard1);
                player1.setHand(hand);
                if (playedCard1.getStatus().equals("W")) {
                    int wildcardValue = playedCard1.getValue() + 100;
                    playedCard1.setValue(wildcardValue);
                }
                if (playedCard1.getValue() > winningValue) {
                    winningValue = playedCard1.getValue();
                }

                hand = player2.getHand();
                Card playedCard2 = hand.getFirst();
                output.add(player2.getName() + " lays (" + playedCard2.getValue() + " " + playedCard2.getStatus() + ")");
                hand.remove(playedCard2);
                player2.setHand(hand);
                if (playedCard2.getStatus().equals("W")) {
                    int wildcardValue = playedCard2.getValue() + 100;
                    playedCard2.setValue(wildcardValue);
                }
                if (playedCard2.getValue() > winningValue) {
                    winningValue = playedCard2.getValue();
                }

                hand = player3.getHand();
                Card playedCard3 = hand.getFirst();
                output.add(player3.getName() + " lays (" + playedCard3.getValue() + " " + playedCard3.getStatus() + ")");
                hand.remove(playedCard3);
                player3.setHand(hand);
                if (playedCard3.getStatus().equals("W")) {
                    int wildcardValue = playedCard3.getValue() + 100;
                    playedCard3.setValue(wildcardValue);
                }
                if (playedCard3.getValue() > winningValue) {
                    winningValue = playedCard3.getValue();
                }

                hand = player4.getHand();
                Card playedCard4 = hand.getFirst();
                output.add(player4.getName() + " lays (" + playedCard4.getValue() + " " + playedCard4.getStatus() + ")");
                hand.remove(playedCard4);
                player4.setHand(hand);
                if (playedCard4.getStatus().equals("W")) {
                    int wildcardValue = playedCard4.getValue() + 100;
                    playedCard4.setValue(wildcardValue);
                }
                if (playedCard4.getValue() > winningValue) {
                    winningValue = playedCard4.getValue();
                }

                //Determine hand winner
                if (winningValue == playedCard1.getValue()) {
                    output.add(player1.getName() + " Wins the round\n");
                    player1Wins += 1;
                    score.put(player1.getName(), player1Wins);
                } else if (winningValue == playedCard2.getValue()) {
                    output.add(player2.getName() + " Wins the round\n");
                    player2Wins += 1;
                    score.put(player2.getName(), player2Wins);
                } else if (winningValue == playedCard3.getValue()) {
                    player3Wins += 1;
                    output.add(player3.getName() + " Wins the round\n");
                    score.put(player3.getName(), player3Wins);
                } else if (winningValue == playedCard4.getValue()) {
                    output.add(player4.getName() + " Wins the round\n");
                    player4Wins += 1;
                    score.put(player4.getName(), player4Wins);
                }
            } catch (Exception e) {
                break;
            }
        }
        output.add("FINAL SCORES");
        output.add(player1.getName() +"-> Wins: " +score.get(player1.getName()));
        output.add(player2.getName() +"-> Wins: " +score.get(player2.getName()));
        output.add(player3.getName() +"-> Wins: " +score.get(player3.getName()));
        output.add(player4.getName() +"-> Wins: " +score.get(player4.getName()));
        int max = Collections.max(score.values());
        output.add(max + " Wins is the winner");
        return output;
    }
}
