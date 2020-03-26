package dataStructure0326;

import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.*;

class Card{
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "[" + rank + suit + "]";
    }
}
public class Poker {
    public static void main(String[] args) {
        List<Card> poker = buyCard();
        //Collections.shuffle(poker);
        myshuffle(poker);
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                List<Card> player = players.get(j);
                player.add(poker.remove(0));
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("玩家" + i + ":" + players.get(i));
        }

    }

    public static List<Card> buyCard() {
        List<Card> poker = new ArrayList<>();
       String[] suits = {"♥", "♣", "♠", "♦"};
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 11; j++) {
                //String.valueOf(j)
                Card card = new Card("" + j, suits[i]);
                poker.add(card);
            }
            poker.add(new Card("A", suits[i]));
            poker.add(new Card("J", suits[i]));
            poker.add(new Card("Q", suits[i]));
            poker.add(new Card("K", suits[i]));
        }
        return poker;
    }

    private static void myshuffle(List<Card> cards) {
        long t = System.currentTimeMillis();//获取当前时间的毫秒数
        Random random = new Random(t);
        for (int i = 0; i < cards.size(); i++) {
            int x = random.nextInt(52);
            swap(cards, i, x);
        }
    }

    private static void swap(List<Card> cards, int i, int j){
        Card t = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, t);
    }
}
