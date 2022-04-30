public class Table {
    private final Deck mainDeck;
    private final Deck playingPile;
    private final int playerNum;
    private final Deck[][] playerDeck;
    //For each player 0 would be playing deck,1 would be the showing deck and 2 would be the hidden one
    Table (int playerNum){
        if(playerNum<2||playerNum>5){
            throw new IllegalArgumentException("Player number must be between 2 and 4 ");
        }
        this.playerNum=playerNum;
        this.playerDeck = new Deck[playerNum][3];
        this.playingPile=new Deck();
        this.mainDeck = new Deck();
        for(int f = 0;f<playerNum;f++) {
            for (int z = 0; z < playerDeck[f].length; z++) playerDeck[f][z] = new Deck();
        }
        addNewDeckToMain();
        if(playerNum>2){
            addNewDeckToMain();
        }
        mainDeck.shuffle();
        for(int i = 0; i<playerNum;i++){
            for (int z = 0;z<3;z++){
                distribute(i,z);
                distribute(i,z);
                distribute(i,z);
            }
        }
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        for(int i  = 0;i < playerNum;i++){
            if(i==0){
                s.append("Drawing Deck(").append(mainDeck.length()).append(")");
                s.append("                     Playing Pile(").append(playingPile.length()).append("):\n");
                for(int z = 0;z<playingPile.length();z++){
                    s.append("   ").append(playingPile.getCard(z).toString());
                }
                s.append("\n");
            }
            for(int b = 0 ; b<playerDeck[i].length-1 ; b++){
                if(b==0){
                    s.append("Player ").append(i + 1).append(": On hand:");
                }
                else if(b==1){
                    s.append("\n          ").append("Showing:");
                }
                for(int k = 0; k<playerDeck[i][b].length();k++){
                    s.append("   ").append(playerDeck[i][b].getCard(k).toString());
                }
            }
            s.append("\n          ").append("Hidden(");
            s.append(playerDeck[i][2].length()).append(")");
            s.append("\n\n");
        }
        return s.toString();
    }
    private void addNewDeckToMain(){
        for(int z = 2;z<=14;z++){
            mainDeck.put(new Card(Card.suit.SPADE,z));
            mainDeck.put(new Card(Card.suit.HEART,z));
            mainDeck.put(new Card(Card.suit.CLUB,z));
            mainDeck.put(new Card(Card.suit.DIAMOND,z));
        }
    }

    private void distribute(int player,int deck){
        Card temp = mainDeck.getCard(0);
        mainDeck.pull(0);
        playerDeck[player][deck].put(temp);
    }
}
