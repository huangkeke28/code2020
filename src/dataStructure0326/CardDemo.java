package dataStructure0326;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDemo {
    public static final String[] suits = {"♥", "♣", "♠", "♦"};
    //买一副牌
    private static List<Cards> buyDuck() {
        List<Cards> Duck = new ArrayList<>(52);
        for (int i = 0; i < 4; i++) {
            String strings = suits[i];
            for (int j = 2; j < 11; j++) {
                Cards card = new Cards("" + j, strings);
                Duck.add(card);
            }
            Cards card1 = new Cards("A", suits[i]);
            Duck.add(card1);
            Cards card2 = new Cards("J", suits[i]);
            Duck.add(card2);
            Cards card3 = new Cards("Q", suits[i]);
            Duck.add(card3);
            Cards card4 = new Cards("K", suits[i]);
            Duck.add(card4);
        }
        return Duck;
    }

    public static void shuffle(List<Cards> deck) {
        Random random = new Random();
        for (int i = 0; i < deck.size(); i++) {
            int r = random.nextInt(52);
            swap(deck,i,r);
        }
    }
    public static void swap(List<Cards> deck, int i, int j) {
        Cards t = deck.get(i);
        deck.set(i, deck.get(j));
        deck.set(j, t);
    }
    public static void main(String[] args) {
        List<Cards> deck = buyDuck();
        System.out.println("刚买回来的牌");
        System.out.println(deck);
        shuffle(deck);
        System.out.println("洗过的牌:");
        System.out.println(deck);
        List<List<Cards>> hands = new ArrayList<>();
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                hands.get(j).add(deck.remove(0));
            }
        }
        System.out.println("剩余的牌");
        System.out.println(deck);
        System.out.println("A手中的牌：");
        System.out.println(hands.get(0));
        System.out.println("B手中的牌：");
        System.out.println(hands.get(1));
        System.out.println("C手中的牌：");
        System.out.println(hands.get(2));
    }

}
