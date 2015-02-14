package com.example.ryan.cards;

import java.util.ArrayList;

/**
 * Created by AnbuShogunate-laptop on 2/14/2015.
 */
public class Player
{
    static String[] currentCards;
    public Player(String[] input)
    {
        currentCards = input;
    }
    public static String[] getCurrentCards() {
        return currentCards;
    }
}
