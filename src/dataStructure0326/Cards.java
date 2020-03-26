package dataStructure0326;

public class Cards {
    //想弄一个纸牌游戏 那先必须要有牌
    private String rank;
    private String suit;
    //初始化，创造一副牌

    public Cards(String rank, String suit) {
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
        return "[" + rank + ": " + suit + "]";
    }
}
