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
        amt=0;
    }

    public Card[] getCurrentCards()
    {
        return currentCards;
    }

    public void addCard(Card in)
    {
        currentCards[amt] = in;
        amt++;
        sort();
    }

    public void remove(int in)
    {
        currentCards[in] = new Card(0,0);
        if(amt>0)
        {
            amt--;
        }
        sort();
    }

    public void sort()
    {
        int n = 26;
        Card temp = null;

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){

                if(currentCards[j-1]!=null && currentCards[j-1].compareTo(currentCards[j]) > 0){
                    //swap the elements!
                    temp = currentCards[j-1];
                    currentCards[j-1] = currentCards[j];
                    currentCards[j] = temp;
                }

            }
        }
    }

}
