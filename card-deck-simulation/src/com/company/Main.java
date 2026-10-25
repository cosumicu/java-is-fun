package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Card {

    //Private Fields
    private ArrayList<String> deck = new ArrayList<>();
    private final String[] suit = {"Club", "Spade", "Heart", "Diamond"};
    private final String[] values = {"1(A)", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11(J)", "12(Q)", "13(K)"};
    private ArrayList<String> drawnCards = new ArrayList<>();

    //Default Constructor
    //Creates a deck of 52 cards
    public Card() {
        for (int i=0; i < 1; ++i) {
            for (int j=0; j < suit.length; ++j) {
                for (int k=0; k < values.length; ++k) {
                    deck.add("[" + values[k] + " of " + suit[j] + "]");
                }
            }
        }
    }

    public void draw() {
        drawnCards.add(deck.get(0));
        deck.remove(0);
    }

    public void draw(int qty) {

        if(qty > deck.size()) {
            qty = deck.size();
        }
        qty -= 1;

        for(int x = 0; x <= qty; x++) {
            drawnCards.add(deck.get(x));
        }
        for(int x = 0; x <= qty; x++){
            deck.remove(0);
        }
    }
    //Implementation of Random and Collection classes
    public void shuffle() {
        Random r1 = new Random();
        for (int i = deck.size() - 1; i >= 1; i--) {
            Collections.swap(deck, i, r1.nextInt(i + 1));
        }
    }

    public void restore() {
        deck.add(drawnCards.get(drawnCards.size()-1));
        drawnCards.remove(drawnCards.size()-1);
    }

    public void restore(int qty) {
        if(qty > drawnCards.size()) {
            qty = drawnCards.size();
        }
        qty -= 1;

        for(int x = 0; x <= qty; x++) {
            deck.add(drawnCards.get(drawnCards.size()-1));
            drawnCards.remove(drawnCards.size()-1);
        }
    }

    //Prints all cards from deck for checking
    public String printDeck(){
        String s = "";
        for(String card : deck) {
            s += card + "\n";
        }
        return s;
    }

    //Prints all cards from hand/drawn cards for checking
    public String printDrawnCards(){
        String s = "";
        for(String card : drawnCards) {
            s += card + "\n";
        }
        return s;
    }
}

public class Main {

    public static void main(String[] args) {

        //draw - retrieves the top most card on the deck. When called with number of desired cards, it will try to draw the N cards, if not enough, draw all cards.
        //shuffle - randomizes the location of all cards, excluding the drawn cards
        //restore - returns the last N cards drawn on the bottom of the deck, if no number is provided, return all drawn cards.

        Card cardObj = new Card(); //Creates a deck of 52 cards

        //Checking
        System.out.println("All cards: ");
        System.out.println(cardObj.printDeck());

        System.out.println("Start: ");

        cardObj.draw(10);
        System.out.println("Drawn cards: ");
        System.out.println(cardObj.printDrawnCards());
        System.out.println("update: ");
        System.out.println(cardObj.printDeck());

        cardObj.draw();
        System.out.println("Drawn cards: ");
        System.out.println(cardObj.printDrawnCards());
        System.out.println("update: ");
        System.out.println(cardObj.printDeck());

        cardObj.draw(100);
        System.out.println("Drawn cards: ");
        System.out.println(cardObj.printDrawnCards());
        System.out.println("update: ");
        System.out.println(cardObj.printDeck());


        cardObj.restore(10);
        System.out.println("Drawn cards: ");
        System.out.println(cardObj.printDrawnCards());
        System.out.println("update: ");
        System.out.println(cardObj.printDeck());

        cardObj.restore();
        System.out.println("Drawn cards: ");
        System.out.println(cardObj.printDrawnCards());
        System.out.println("update: ");
        System.out.println(cardObj.printDeck());

        cardObj.restore(50);
        System.out.println("Drawn cards: ");
        System.out.println(cardObj.printDrawnCards());
        System.out.println("update: ");
        System.out.println(cardObj.printDeck());

        cardObj.shuffle();
        System.out.println("Drawn cards: ");
        System.out.println(cardObj.printDrawnCards());
        System.out.println("update: ");
        System.out.println(cardObj.printDeck());
    }
}
