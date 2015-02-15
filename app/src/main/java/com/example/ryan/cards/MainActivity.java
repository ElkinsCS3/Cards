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


public class MainActivity extends ActionBarActivity
{
    Button card01,card02,card03,card04,card05,card06,card07,card08,card09,card10,card11,card12,card13,card14,card15,card16,card17,card18,card19,card20,card21,card22,card23,card24,card25,card26;
    Button scard01,scard02,scard03,scard04,scard05;
    Button rcard01,rcard02,rcard03,rcard04,rcard05;
    Card[] handCards = new Card[26];
    Card[] selected = new Card[5];
    Player player1;
    Player player2;
    int currentPlayer,selectedC;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentPlayer = 1;
        reset();
        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        card01 = (Button)findViewById(R.id.Card01);
        card01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPlayer == 1)
                {
                    handCards=player1.getCurrentCards();
                    selected[selectedC]=handCards[0];
                    player1.remove(0);
                }
                else if(currentPlayer == 2)
                {
                    handCards=player2.getCurrentCards();
                    selected[selectedC]=handCards[0];
                    player2.remove(0);
                }
            }
        });
    }
    public void initialize()
    {
        /*handCards[0]=new Card(card01.getText().toString());
        handCards[1]=new Card(card02.getText().toString());
        handCards[2]=new Card(card03.getText().toString());
        handCards[3]=new Card(card04.getText().toString());
        handCards[4]=new Card(card05.getText().toString());
        handCards[5]=new Card(card06.getText().toString());
        handCards[6]=new Card(card07.getText().toString());
        handCards[7]=new Card(card08.getText().toString());
        handCards[8]=new Card(card09.getText().toString());
        handCards[9]=new Card(card10.getText().toString());
        handCards[10]=new Card(card11.getText().toString());
        handCards[11]=new Card(card12.getText().toString());
        handCards[12]=new Card(card13.getText().toString());
        handCards[13]=new Card(card14.getText().toString());
        handCards[14]=new Card(card15.getText().toString());
        handCards[15]=new Card(card16.getText().toString());
        handCards[16]=new Card(card17.getText().toString());
        handCards[17]=new Card(card18.getText().toString());
        handCards[18]=new Card(card19.getText().toString());
        handCards[19]=new Card(card20.getText().toString());
        handCards[20]=new Card(card21.getText().toString());
        handCards[21]=new Card(card22.getText().toString());
        handCards[22]=new Card(card23.getText().toString());
        handCards[23]=new Card(card24.getText().toString());
        handCards[24]=new Card(card25.getText().toString());
        handCards[25]=new Card(card26.getText().toString());*/
        for(int i=0;i<26;i++)
        {
            handCards[i]=new Card(0, 0);
        }
        for(int i=0;i<5;i++)
        {
            selected[i]=new Card(0, 0);
        }
    }
    public void reset()
    {
        initialize();
        player1 = new Player(handCards);
        player2 = new Player(handCards);
    }
    public void sync()
    {
        if(currentPlayer==1)
        {
            handCards=player1.getCurrentCards();
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
            handCards=player2.getCurrentCards();
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