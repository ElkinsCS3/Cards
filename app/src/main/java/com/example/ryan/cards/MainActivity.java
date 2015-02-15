package com.example.ryan.cards;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.*;

import static android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity
{
    Button card01,card02,card03,card04,card05,card06,card07,card08,card09,card10,card11,card12,card13,card14,card15,card16,card17,card18,card19,card20,card21,card22,card23,card24,card25,card26;
    Button scard01,scard02,scard03,scard04,scard05;
    Button rcard01,rcard02,rcard03,rcard04,rcard05;
    Button getCard,reset,done;
    Card[] handCards = new Card[26];
    Card[] selected = new Card[5];
    Card[] recent = new Card[5];
    ArrayList<Card> available;
    Player player1;
    Player player2;
    Player player3;
    TextView cp;
    int currentPlayer,selectedC;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        currentPlayer = 1;selectedC=0;
        available = new ArrayList<Card>();
        cp = (TextView)findViewById(R.id.cp);

        /*if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
        getCard = (Button)findViewById(R.id.get);
        reset = (Button)findViewById(R.id.reset);
        done = (Button)findViewById(R.id.done);
        card01 = (Button)findViewById(R.id.Card01);
        card02 = (Button)findViewById(R.id.Card02);
        card03 = (Button)findViewById(R.id.Card03);
        card04 = (Button)findViewById(R.id.Card04);
        card05 = (Button)findViewById(R.id.Card05);
        card06 = (Button)findViewById(R.id.Card06);
        card07 = (Button)findViewById(R.id.Card07);
        card08 = (Button)findViewById(R.id.Card08);
        card09 = (Button)findViewById(R.id.Card09);
        card10 = (Button)findViewById(R.id.Card10);
        card11 = (Button)findViewById(R.id.Card11);
        card12 = (Button)findViewById(R.id.Card12);
        card13 = (Button)findViewById(R.id.Card13);
        card14 = (Button)findViewById(R.id.Card14);
        card15 = (Button)findViewById(R.id.Card15);
        card16 = (Button)findViewById(R.id.Card16);
        card17 = (Button)findViewById(R.id.Card17);
        card18 = (Button)findViewById(R.id.Card18);
        card19 = (Button)findViewById(R.id.Card19);
        card20 = (Button)findViewById(R.id.Card20);
        card21 = (Button)findViewById(R.id.Card21);
        card22 = (Button)findViewById(R.id.Card22);
        card23 = (Button)findViewById(R.id.Card23);
        card24 = (Button)findViewById(R.id.Card24);
        card25 = (Button)findViewById(R.id.Card25);
        card26 = (Button)findViewById(R.id.Card26);
        scard01 = (Button)findViewById(R.id.sCard01);
        scard02 = (Button)findViewById(R.id.sCard02);
        scard03 = (Button)findViewById(R.id.sCard03);
        scard04 = (Button)findViewById(R.id.sCard04);
        scard05 = (Button)findViewById(R.id.sCard05);
        rcard01 = (Button)findViewById(R.id.rCard01);
        rcard02 = (Button)findViewById(R.id.rCard02);
        rcard03 = (Button)findViewById(R.id.rCard03);
        rcard04 = (Button)findViewById(R.id.rCard04);
        rcard05 = (Button)findViewById(R.id.rCard05);
        reset();
        sync();

        getCard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int ran = (int)(Math.random()*available.size());
                if(currentPlayer ==1)
                {
                    player1.addCard(available.get(ran));
                    sync();
                    int index = available.indexOf(available.get(ran));
                    if(available.size()>0)
                        available.remove(index);
                    else
                        cp.setText("No Cards Left");
                }
                else if(currentPlayer ==2)
                {
                    player2.addCard(available.get(ran));
                    sync();
                    int index = available.indexOf(available.get(ran));
                    if(available.size()>0)
                        available.remove(index);
                    else
                        cp.setText("No Cards Left");
                }
            }
        });

        reset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
                sync();
            }
        });

        done.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedC=0;
                if(currentPlayer==1)
                {
                    currentPlayer=3;
                    cp.setText("Press Done");
                    for(int i=0;i<5;i++)
                    {
                        recent[i]=selected[i];
                        selected[i]=new Card(0,0);
                    }
                    sync();
                }
                else if(currentPlayer==2)
                {
                    currentPlayer=4;
                    cp.setText("Press Done");
                    for(int i=0;i<5;i++)
                    {
                        recent[i]=selected[i];
                        selected[i]=new Card(0,0);
                    }
                    sync();
                }
                else if(currentPlayer == 3)
                {
                    currentPlayer=2;
                    cp.setText("Player 2");
                    sync();
                }
                else if(currentPlayer == 4)
                {
                    currentPlayer=1;
                    cp.setText("Player 2");
                    sync();
                }
            }
        });

        card01.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(1);
            }
        });
        card02.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(2);
            }
        });
        card03.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(3);
            }
        });
        card04.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(4);
            }
        });
        card02.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(2);
            }
        });
        card05.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(5);
            }
        });
        card06.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(6);
            }
        });
        card07.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(7);
            }
        });
        card08.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(8);
            }
        });
        card09.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(9);
            }
        });
        card10.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(10);
            }
        });
        card11.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(11);
            }
        });
        card12.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(12);
            }
        });
        card13.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(13);
            }
        });
        card14.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(14);
            }
        });
        card15.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(15);
            }
        });
        card16.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(16);
            }
        });
        card17.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(17);
            }
        });
        card18.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(18);
            }
        });
        card19.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(19);
            }
        });
        card20.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(20);
            }
        });
        card21.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(21);
            }
        });
        card22.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(22);
            }
        });
        card23.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(23);
            }
        });
        card24.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(24);
            }
        });
        card25.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(25);
            }
        });
        card26.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                select(26);
            }
        });
    }
    public void select(int cardNum)
    {
        try{
            if(currentPlayer == 1 && selectedC<5)
            {
                clone(player1.getCurrentCards());
                if(!handCards[cardNum-1].toString().equals("Empty"))
                {
                    selected[selectedC]=handCards[cardNum-1];
                    selectedC++;
                    player1.remove(cardNum-1);
                    sync();
                }

            }
            else if(currentPlayer == 2 && selectedC<5)
            {
                clone(player2.getCurrentCards());
                if(!handCards[cardNum-1].toString().equals("Empty"))
                {
                    selected[selectedC] = handCards[cardNum - 1];
                    selectedC++;
                    player2.remove(cardNum - 1);
                    sync();
                }
            }
        }catch (Exception e)
        {

        }

    }
    public void initialize()
    {
        for(int i=0;i<26;i++)
        {
            handCards[i]=new Card(0,0);
        }
        for(int i=0;i<5;i++)
        {
            selected[i]=new Card(0,0);
            recent[i]=new Card(0,0);
        }
        available = new ArrayList<Card>();
        for(int i=1;i<=13;i++)
        {
            for(int j=1;j<=4;j++)
            {
                available.add(new Card(i,j));
            }
        }
        for(int i=0;i<5;i++)
        {
            selected[i]=new Card(0, 0);

        }
    }
    public void reset()
    {
        initialize();
        selectedC=0;
        currentPlayer=1;
        cp.setText("Player 1");
        player1 = new Player(newClone());
        player2 = new Player(newClone());
        player3 = new Player(newClone());
    }
    public void sync()
    {
        if(currentPlayer==1)
        {
            clone(player1.getCurrentCards());
            card01.setText(handCards[0].toString());
            card02.setText(handCards[1].toString());
            card03.setText(handCards[2].toString());
            card04.setText(handCards[3].toString());
            card05.setText(handCards[4].toString());
            card06.setText(handCards[5].toString());
            card07.setText(handCards[6].toString());
            card08.setText(handCards[7].toString());
            card09.setText(handCards[8].toString());
            card10.setText(handCards[9].toString());
            card11.setText(handCards[10].toString());
            card12.setText(handCards[11].toString());
            card13.setText(handCards[12].toString());
            card14.setText(handCards[13].toString());
            card15.setText(handCards[14].toString());
            card16.setText(handCards[15].toString());
            card17.setText(handCards[16].toString());
            card18.setText(handCards[17].toString());
            card19.setText(handCards[18].toString());
            card20.setText(handCards[19].toString());
            card21.setText(handCards[20].toString());
            card22.setText(handCards[21].toString());
            card23.setText(handCards[22].toString());
            card24.setText(handCards[23].toString());
            card25.setText(handCards[24].toString());
            card26.setText(handCards[25].toString());
        }
        else if(currentPlayer == 2)
        {
            clone(player2.getCurrentCards());
            card01.setText(handCards[0].toString());
            card02.setText(handCards[1].toString());
            card03.setText(handCards[2].toString());
            card04.setText(handCards[3].toString());
            card05.setText(handCards[4].toString());
            card06.setText(handCards[5].toString());
            card07.setText(handCards[6].toString());
            card08.setText(handCards[7].toString());
            card09.setText(handCards[8].toString());
            card10.setText(handCards[9].toString());
            card11.setText(handCards[10].toString());
            card12.setText(handCards[11].toString());
            card13.setText(handCards[12].toString());
            card14.setText(handCards[13].toString());
            card15.setText(handCards[14].toString());
            card16.setText(handCards[15].toString());
            card17.setText(handCards[16].toString());
            card18.setText(handCards[17].toString());
            card19.setText(handCards[18].toString());
            card20.setText(handCards[19].toString());
            card21.setText(handCards[20].toString());
            card22.setText(handCards[21].toString());
            card23.setText(handCards[22].toString());
            card24.setText(handCards[23].toString());
            card25.setText(handCards[24].toString());
            card26.setText(handCards[25].toString());
        }
        else if(currentPlayer == 3 || currentPlayer == 4 )
        {
            //handCards=player3.getCurrentCards();
            card01.setText("Empty");//handCards[0].toString());
            card02.setText("Empty");//handCards[1].toString());
            card03.setText("Empty");//handCards[2].toString());
            card04.setText("Empty");//handCards[3].toString());
            card05.setText("Empty");//handCards[4].toString());
            card06.setText("Empty");//handCards[5].toString());
            card07.setText("Empty");//handCards[6].toString());
            card08.setText("Empty");//handCards[7].toString());
            card09.setText("Empty");//handCards[8].toString());
            card10.setText("Empty");//handCards[9].toString());
            card11.setText("Empty");//handCards[10].toString());
            card12.setText("Empty");//handCards[11].toString());
            card13.setText("Empty");//handCards[12].toString());
            card14.setText("Empty");//handCards[13].toString());
            card15.setText("Empty");//handCards[14].toString());
            card16.setText("Empty");//handCards[15].toString());
            card17.setText("Empty");//handCards[16].toString());
            card18.setText("Empty");//handCards[17].toString());
            card19.setText("Empty");//handCards[18].toString());
            card20.setText("Empty");//handCards[19].toString());
            card21.setText("Empty");//handCards[20].toString());
            card22.setText("Empty");//handCards[21].toString());
            card23.setText("Empty");//handCards[22].toString());
            card24.setText("Empty");//handCards[23].toString());
            card25.setText("Empty");//handCards[24].toString());
            card26.setText("Empty");//handCards[25].toString());
        }
        scard01.setText(selected[0].toString());
        scard02.setText(selected[1].toString());
        scard03.setText(selected[2].toString());
        scard04.setText(selected[3].toString());
        scard05.setText(selected[4].toString());
        rcard01.setText(recent[0].toString());
        rcard02.setText(recent[1].toString());
        rcard03.setText(recent[2].toString());
        rcard04.setText(recent[3].toString());
        rcard05.setText(recent[4].toString());
    }
    public void clone(Card[] in)
    {
        for(int i=0;i<26;i++)
        {
            handCards[i]=in[i];
        }
    }
    public Card[] newClone()
    {
        Card[] temp = new Card[26];
        for(int i=0;i<26;i++)
        {
            temp[i]=new Card(handCards[i].getRank(),handCards[i].getSuit());
        }
        return temp;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment
    {

        public PlaceholderFragment()
        {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}