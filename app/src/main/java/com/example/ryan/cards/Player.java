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
        for(int i = 0; i < amt; i++)
        {
            if(in.getSuit() < currentCards[i].getSuit())
                continue;
        }
    }


}
