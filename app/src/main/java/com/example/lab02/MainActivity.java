package com.example.lab02;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int playerCounter;
    private int comCounter;

    public Weapon playerWeapon;
    public Weapon comWeapon;

    private static final String TAG = "MainActivity";

    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");
        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

        /*
        public static Weapon determineWinner( Weapon p1, Weapon p2){

            boolean p1_Winner = false;
            boolean p2_Winner = false;

            switch(p1){
                case ROCK: if(p2 == Weapon.SCISSORS)
                                p1_Winner = true;
                                break;
                case PAPER: if(p2 == Weapon.ROCK)
                    p1_Winner = true;
                    break;
                case SCISSORS: if(p2 == Weapon.PAPER)
                    p1_Winner = true;
                    break;
            }
        }*/

        public  Weapon getRandomWeapon(){
            Weapon[] values = Weapon.values();
            Random random = new Random();
            return (values[random.nextInt(values.length)]);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        playerCounter = 0;
        comCounter = 0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void rockButtonClicked(View v){
        Log.i(TAG, "Rock Button Clicked");
        playerWeapon = Weapon.ROCK;
        TextView t = (TextView)findViewById(R.id.playerWeaponView);
        t.setText("Player's Weapon: Rock");
        comWeapon.getRandomWeapon();
        TextView s = (TextView)findViewById(R.id.comWeaponView);
        s.setText("Computer's Weapon: "+ String.valueOf(comWeapon));

        if (comWeapon == Weapon.ROCK) {
            if(playerWeapon == Weapon.ROCK){
                TextView u = (TextView)findViewById(R.id.winnerView);
                u.setText("It's a draw!");
            }
        }
        else if(comWeapon == Weapon.PAPER){
            if(playerWeapon == Weapon.ROCK){
                TextView u = (TextView)findViewById(R.id.winnerView);
                u.setText("Computer Wins...Paper covers Rock!");
                ++comCounter;
            }
        }
        else if(comWeapon == Weapon.SCISSORS){
            if(playerWeapon == Weapon.ROCK){
                TextView u = (TextView)findViewById(R.id.winnerView);
                u.setText("Player win.. Rock crushes Scissors!");
                ++playerCounter;
            }
        }
    }

    public void paperButtonClicked(View v){
        Log.i(TAG, "Paper Button Clicked");
        playerWeapon = Weapon.PAPER;
        TextView t = (TextView)findViewById(R.id.playerWeaponView);
        t.setText("Player's Weapon: Paper");
        comWeapon.getRandomWeapon();
        TextView s = (TextView)findViewById(R.id.comWeaponView);
        s.setText("Computer's Weapon: " + String.valueOf(comWeapon));
        if (comWeapon == Weapon.ROCK) {
            if(playerWeapon == Weapon.PAPER){
                TextView u = (TextView)findViewById(R.id.winnerView);
                u.setText("Player win... Paper covers Rock");
                ++playerCounter;
            }
        }
        else if(comWeapon == Weapon.PAPER){
            if(playerWeapon == Weapon.PAPER){
                TextView u = (TextView)findViewById(R.id.winnerView);
                u.setText("It's a draw!");
            }
        }
        else if(comWeapon == Weapon.SCISSORS){
            if(playerWeapon == Weapon.PAPER){
                TextView u = (TextView)findViewById(R.id.winnerView);
                u.setText("Computer win.. Scissors cut Paper!");
                ++comCounter;
            }
        }
    }

    public void scissorsButtonClicked(View V){
        Log.i(TAG, "Scissor Button Clicked");
        playerWeapon = Weapon.SCISSORS;
        TextView t = (TextView)findViewById(R.id.playerWeaponView);
        t.setText("Player's Weapon: Scissors");
        comWeapon.getRandomWeapon();
        TextView s = (TextView)findViewById(R.id.comWeaponView);
        s.setText("Computer's Weapon: " + String.valueOf(comWeapon));
        if (comWeapon == Weapon.ROCK) {
            if(playerWeapon == Weapon.SCISSORS){
                TextView u = (TextView)findViewById(R.id.winnerView);
                u.setText("Computer win... Rock crushes Scissors");
                ++comCounter;
            }
        }
        else if(comWeapon == Weapon.PAPER){
            if(playerWeapon == Weapon.SCISSORS){
                TextView u = (TextView)findViewById(R.id.winnerView);
                u.setText("Player win... Scissors cut Paper");
                ++playerCounter;
            }
        }
        else if(comWeapon == Weapon.SCISSORS){
            if(playerWeapon == Weapon.SCISSORS){
                TextView u = (TextView)findViewById(R.id.winnerView);
                u.setText("It's a draw!");
            }
        }
    }



}
