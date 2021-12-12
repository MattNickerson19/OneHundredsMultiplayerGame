import java.util.LinkedList;

public class Player {

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private LinkedList<Card> hand = new LinkedList<Card>();
    public LinkedList getHand() {
        return hand;
    }
    public void setHand(LinkedList<Card> hand) {
        this.hand = hand;
    }


    public String PrintHand(LinkedList<Card> hand){
        String handSTR = "";
        for (int i=0;i < hand.size(); i ++){
            handSTR += hand.get(i).getValue() + hand.get(i).getStatus() + ", ";
        }
        return handSTR;

    }


}
