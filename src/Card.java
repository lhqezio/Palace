import java.lang.StringBuilder;
public class Card {
    private final suit suit;
    private final int value;
    public enum suit { CLUB, HEART, SPADE, DIAMOND }
    Card(suit suit, int value){
        this.suit=suit;
        if(value<2||value>14){
            throw new IllegalArgumentException("Invalid value for card");
        } 
        else {
            this.value=value;
        }
    }
    public int getValue(){
        return this.value;
    }
    public suit getSuit(){
        return this.suit;
    }
    public String toString(){
        StringBuilder cardString=new StringBuilder();
        switch (value) {
            case 2, 3, 4, 5, 6, 7, 8, 9, 10 -> cardString.append(this.value);
            case 11 -> cardString.append("J");
            case 12 -> cardString.append("Q");
            case 13 -> cardString.append("K");
            case 14 -> cardString.append("A");
            default -> {
            } //Exception handling done by Card class constructor
        }
        switch (this.suit) {
            case CLUB -> cardString.append("oC");
            case HEART -> cardString.append("oH");
            case SPADE -> cardString.append("oS");
            case DIAMOND -> cardString.append("oD");
            default -> {
            } //Exception handling done by Enumeration class
        }
        return cardString.toString();
    }
}