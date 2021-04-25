//This is the code for the second activity / the activity the user sees after one of the teams reach 5 points

package com.example.scorecounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {
    private TextView winnerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        winnerText = (TextView)findViewById(R.id.winnerScreenText);

        Intent getValue = getIntent(); //Gets the boolean information from MainActivity (Did team 1 win?)
        boolean team1Wins = getValue.getBooleanExtra(MainActivity.TEAM1WINS,false); //Keeps track of team 1 from MainActivity class
        String team1Name = getValue.getStringExtra(MainActivity.TEAM1NAME); //Retrieves the team 1 name entered by player
        String team2Name = getValue.getStringExtra(MainActivity.TEAM2NAME); //Retrieves the team 2 name entered by player
        int difference = getValue.getIntExtra(MainActivity.DIFFERENCE, 0);

        if (team1Wins == true){ //Checks if team 1 wins
            winnerText.setText("CONGRATULATIONS\n" + team1Name + " You won by " + difference + " points!");
        } else { //If not, that means team 2 wins!
            winnerText.setText("CONGRATULATIONS\n" + team2Name + " You won by " + difference + " points!");
        }
    }

    public void redoButtonCode(View view){ //This code is for the redo button which brings the user back to the MainActivity
        Intent mainActiv = new Intent(this, MainActivity.class);
        startActivity(mainActiv);
    }
}