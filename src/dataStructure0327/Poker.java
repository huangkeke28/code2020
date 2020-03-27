package dataStructure0327;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Card {
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
        List<Card> poker = buyPoker();
        System.out.println(poker);
       // Collections.shuffle(poker);
        myshuffle(poker);
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                players.get(j).add(i, poker.remove(0));
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("玩家" + i + ":" +players.get(i));
        }
        System.out.println(poker);
    }
    public static List<Card> buyPoker() {
        String[] suits = {"♠", "♥", "♦", "♣"};
        List<Card> pokers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 11; j++) {
                pokers.add(new Card(String.valueOf(j), suits[i]));
            }
            pokers.add(new Card("A", suits[i]));
            pokers.add(new Card("J", suits[i]));
            pokers.add(new Card("Q", suits[i]));
            pokers.add(new Card("K", suits[i]));
        }
        return pokers;
    }

    public static List<Card> myshuffle(List<Card> cards) {
        //创造随机数种子
        long t = System.currentTimeMillis();
        System.out.println(t);
        Random random = new Random(t);
        for (int i = 0; i < cards.size(); i++) {
            int x = random.nextInt(52);
            swap(cards, i, x);
        }
        return cards;
    }

    private static void swap(List<Card> cards, int i, int x) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(x));
        cards.set(x,temp);
    }
}
