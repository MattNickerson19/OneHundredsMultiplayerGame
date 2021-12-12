import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Random;

public class CardDeck {

    public ArrayList GenerateDeck(){
        Random rand = new Random();
        ArrayList deck = new ArrayList();
        for (int i = 1; i <=100; i++){
            Card card = new Card();
            card.setValue(i);
            deck.add(card);
        }
        for (int i=0; i<4;i++){
            int n = rand.nextInt(101);
            Card wildcard1 = (Card) deck.get(n);
            wildcard1.setStatus("W");
        }

        return deck;
    }
    public ArrayList ShuffleDeck(ArrayList deck, int shuffleCount){
        for (int i=0; i <= shuffleCount; i++){
            Collections.shuffle(deck);
        }
        return deck;
    }

    public void PrintDeck(ArrayList deck){
        ListIterator<Card> itr = null;
        itr = deck.listIterator();
        while (itr.hasNext()){
            System.out.println(itr.next().getValue());
        }
    }

    public int CardsRemaining(ArrayList deck){
        return deck.size();
    }
}
