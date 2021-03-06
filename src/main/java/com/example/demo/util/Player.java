package com.example.demo.util;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Player {

    private int score;
    @Id
    private String id;
    public String name; //Player's name
    public int numCards; //Number of cards player has
    private ArrayList<Card> hand = new ArrayList<Card>(); //The player's hand
    public Card iofb;

    public Player(String newName){
        this.name = newName;
        score = 0;
        iofb = new Card(Card.INDEXOUTOFBOUNDS, 0);
    }

    public Player(String newName, int score){
        this.name = newName;
        this.score = score;
    }

    public Player(){

    }


    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void addCard(Card c) {
        hand.add(c);
    }

    public void removeCard(Card c) {
        hand.remove(c);
    }

    public Card getCard(int cardInd) {
        try {
            return hand.get(cardInd);
        } catch (IndexOutOfBoundsException e) {
            iofb.setCardNum(cardInd);
            return iofb;
        }
    }

    public int getSize() {
        return hand.size();
    }

    public boolean isBot() {
        return false;
    }

    //required to make sure bot selectedCard method can run for all players
    public Card chosenCard(Player p1, Player p2, Card card) {
        return null;
    }

    public void addScore(int points) {
        score = score + points;
    }

    public int getScore() {
        return score;
    }
}
