package com.example.lab02;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int playerCounter;
    private int comCounter;

    Weapon playerWeapon;
    Weapon comWeapon;

    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");
        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

        public  Weapon getRandomWeapon(){
            Weapon[] values = Weapon.values();
            Random random = new Random();
            return (values[random.nextInt(values.length)]);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        playerCounter = 0;
        comCounter = 0;
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
        playerWeapon = Weapon.ROCK;
        TextView t = (TextView) findViewById(R.id.playerWeaponView);
        t.setText("Player's Weapon: Rock");
        comWeapon.getRandomWeapon();
        TextView s = (TextView) findViewById(R.id.comWeaponView);
        s.setText("Computer's Weapon: " + comWeapon);
        if (comWeapon == Weapon.ROCK) {
            if(playerWeapon == Weapon.ROCK){
                TextView u = (TextView) findViewById(R.id.winnerView);
                u.setText("It's a draw!");
            }
        }
        else if(comWeapon == Weapon.PAPER){
            if(playerWeapon == Weapon.ROCK){
                TextView u = (TextView) findViewById(R.id.winnerView);
                u.setText("Computer Wins...Paper covers Rock!");
                comCounter++;
            }
        }
        else if(comWeapon == Weapon.SCISSORS){
            if(playerWeapon == Weapon.ROCK){
                TextView u = (TextView) findViewById(R.id.winnerView);
                u.setText("Player win.. Rock crushes Scissors!");
                playerCounter++;
            }
        }
    }

    public void paperButtonClicked(View v){
        playerWeapon = Weapon.PAPER;
        TextView t = (TextView) findViewById(R.id.playerWeaponView);
        t.setText("Player's Weapon: Paper");
        comWeapon.getRandomWeapon();
        TextView s = (TextView) findViewById(R.id.comWeaponView);
        s.setText("Computer's Weapon: " + comWeapon);
        if (comWeapon == Weapon.ROCK) {
            if(playerWeapon == Weapon.PAPER){
                TextView u = (TextView) findViewById(R.id.winnerView);
                u.setText("Player win... Paper covers Rock");
                playerCounter++;
            }
        }
        else if(comWeapon == Weapon.PAPER){
            if(playerWeapon == Weapon.PAPER){
                TextView u = (TextView) findViewById(R.id.winnerView);
                u.setText("It's a draw!");
            }
        }
        else if(comWeapon == Weapon.SCISSORS){
            if(playerWeapon == Weapon.PAPER){
                TextView u = (TextView) findViewById(R.id.winnerView);
                u.setText("Computer win.. Scissors cut Paper!");
                comCounter++;
            }
        }
    }

    public void scissorsButtonClicked(View V){
        playerWeapon = Weapon.SCISSORS;
        TextView t = (TextView) findViewById(R.id.playerWeaponView);
        t.setText("Player's Weapon: Scissors");
        comWeapon.getRandomWeapon();
        TextView s = (TextView) findViewById(R.id.comWeaponView);
        s.setText("Computer's Weapon: " + comWeapon);
        if (comWeapon == Weapon.ROCK) {
            if(playerWeapon == Weapon.SCISSORS){
                TextView u = (TextView) findViewById(R.id.winnerView);
                u.setText("Computer win... Rock crushes Scissors");
                comCounter++;
            }
        }
        else if(comWeapon == Weapon.PAPER){
            if(playerWeapon == Weapon.SCISSORS){
                TextView u = (TextView) findViewById(R.id.winnerView);
                u.setText("Player win... Scissors cut Paper");
                playerCounter++;
            }
        }
        else if(comWeapon == Weapon.SCISSORS){
            if(playerWeapon == Weapon.SCISSORS){
                TextView u = (TextView) findViewById(R.id.winnerView);
                u.setText("It's a draw!");
            }
        }
    }



}
