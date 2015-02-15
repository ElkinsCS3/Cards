package com.example.ryan.cards;

/**
 * Created by coop on 2/14/2015.
 */
public class Card
{
    private int rank;
    /*
        1 (Ace), 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 (Jack), 12 (Queen), 13 (King)
     */
    private int suit;
    /*
        1 (Spades), 2 (Diamonds), 3 (Clubs), 4 (Hearts)
     */

    public Card(int r, int s)
    {
        rank = r;
        suit = s;
    }
}
