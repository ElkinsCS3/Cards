package com.example.ryan.cards;

import java.util.ArrayList;

/**
 * Created by AnbuShogunate-laptop on 2/14/2015.
 */
public class Player
{
    Card[] currentCards;
    int amt;

    public Player(Card[] input)
    {
        currentCards = input;
        amt = input.length;
    }

    public Card[] getCurrentCards()
    {
        return currentCards;
    }

    public void addCard(Card in)
    {
        if(amt < 54) {
            currentCards[amt] = in;
            amt++;
        }

    }


}
