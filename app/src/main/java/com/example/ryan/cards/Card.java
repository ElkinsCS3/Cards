package com.example.ryan.cards;

/**
 * Created by coop on 2/14/2015.
 */
public class Card implements Comparable<Card>
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

    public int getSuit()
    {
        return suit;
    }

    public int getRank()
    {
        return rank;
    }

    public String toString()
    {
        if(rank == 0 || suit == 0)
            return "Empty";
        String output = "";
        switch (rank)
        {
            case 1: output += "A"; break;
            case 2: output += "2"; break;
            case 3: output += "3"; break;
            case 4: output += "4"; break;
            case 5: output += "5"; break;
            case 6: output += "6"; break;
            case 7: output += "7"; break;
            case 8: output += "8"; break;
            case 9: output += "9"; break;
            case 10: output += "10"; break;
            case 11: output += "J"; break;
            case 12: output += "Q"; break;
            case 13: output += "K"; break;
        }
        output += " ";
        switch (suit)
        {
            case 1: output += "♠"; break;
            case 2: output += "♦"; break;
            case 3: output += "♣"; break;
            case 4: output += "♥"; break;
        }

        return output;
    }

    @Override
    public int compareTo(Card another) {
        if (another.getSuit()==0)
            return -1;
        else if(suit==0)
            return 1;
        else if(rank < another.getRank())
        {
            return -1;
        }
        else if(rank > another.getRank())
        {
            return 1;
        }
        else
        {
            if(suit < another.getSuit())
            {
                return 1;
            }
            else if(suit > another.getSuit())
            {
                return -1;
            }
        }
        return 0;
    }
}
