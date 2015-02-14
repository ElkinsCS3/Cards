package com.example.ryan.cards;

import java.util.ArrayList;

/**
 * Created by AnbuShogunate-laptop on 2/14/2015.
 */
public class Player
{
    ArrayList<String> currentCards;
    public Player(ArrayList<String> input)
    {
        currentCards = input;
    }
    public static Player getInstance() {
        return 0;
    }
}
