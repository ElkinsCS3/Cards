package com.example.ryan.cards;

import java.util.ArrayList;
import java.util.Arrays;
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
        currentCards[amt] = in;
        sort();
    }

    public void remove(int in)
    {
        currentCards[in] = null;
        sort();
    }

    public void sort()
    {
        Arrays.sort(currentCards);
    }

}
