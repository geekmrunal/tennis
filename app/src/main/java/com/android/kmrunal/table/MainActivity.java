package com.android.kmrunal.table;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int teamA_Points = 0;
    int teamB_Points = 0;

    int teamA_games_won = 0;
    int teamB_games_won = 0;

    int teamA_sets_won = 0;
    int teamB_sets_won = 0;
    int sets_played = 1;

    boolean teamA_MATCH_WON = false;
    boolean teamB_MATCH_WON = false;

    int teamA_point_val = R.id.teamA_points_val;
    int teamB_point_val = R.id.teamB_points_val;

    int MAX_GAMES = 4;
    int MAX_SETS = 4;

    String match_status = "";
    String point_status = "";
    int score_status = R.id.points_status;
    //int score_status = R.id.lable2;
    int game_status = R.id.match_status;
    int set_status = R.id.match_status;

    // set status for each set and game
    int teamASet1Game = R.id.teamA_Set1_Game;
    int teamASet2Game = R.id.teamA_Set2_Game;
    int teamASet3Game = R.id.teamA_Set3_Game;

    int teamBSet1Game = R.id.teamB_Set1_Game;
    int teamBSet2Game = R.id.teamB_Set2_Game;
    int teamBSet3Game = R.id.teamB_Set3_Game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * function when Player1 button is clicked
     * updates point and status of the game
     * @param v
     */
    public void getTeamA_point(View v){
        teamA_Points = teamA_Points + 15 ;
        update_points();
}
    /**
     * function when player 2 button is pressed
     * @param v
     */
    public void getTeamB_point(View v){

        teamB_Points = teamB_Points + 15;
        update_points();
    }


    /**
     * displays score on respective ids
     * @param val
     */
    public void displayScore(int id, int val){
        TextView dispView = (TextView) findViewById(id);
        dispView.setText(String.valueOf(val));

}

    /**
     * displays status in respective status window
     * @param id
     * @    param status
     */
    public void displayStatus(int id, String status ){
            TextView dispView = (TextView) findViewById(id);
            dispView.setText(status);

}

    /**
     * displays message on toast
     * @param msg
     */
    public void display_toast(int msgid) {

    Context context = getApplicationContext();
    CharSequence text = getString(msgid);
    int duration = Toast.LENGTH_SHORT;

    Toast toast = Toast.makeText(context, text, duration);
    View view1 = toast.getView();

    toast.setGravity(Gravity.CENTER,0,0);
    toast.show();
}
    /**
     * function: update points.
     * functions updates points
     */
    public void update_points() {
        if (teamA_Points == 0) {
            if (teamB_Points == 0) {
                //set points status to love all
                displayStatus(score_status, "Love_All");
                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 15) {
                // set points status to 0 - 15
                displayStatus(score_status, "0 - 15");
                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 30) {
                //set the points sttaus to 0 -30
                displayStatus(score_status, "0 - 30");
                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 45) {
                //set the points sttaus to 0-40
                displayStatus(score_status, "0 - 40");
                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, 40);

            }
            /* add logic for games score update and sets won update */
            if (teamB_Points == 60) {
                //set the game won by team B to plus one and
                // add set the teamB points to 0
                // set the match status to last game won by team b
                teamB_games_won = teamB_games_won + 1;
                displayStatus(game_status,"GAME TeamB");
                display_toast(R.string.game_teamb);
                update_match_status(2,teamB_games_won,sets_played);
                if(teamB_games_won == MAX_GAMES ){
                    teamB_sets_won = teamB_sets_won + 1;
                    sets_played = sets_played + 1;
                    teamA_games_won = 0;
                    teamB_games_won = 0;
                    displayStatus(game_status,"SET TeamB");
                    display_toast(R.string.set_teamb);

                }
                if(sets_played == MAX_SETS ) {
                    if(teamB_sets_won > teamA_sets_won) {
                        teamB_MATCH_WON = true;
                        displayStatus(game_status, "MATCH TeamB");
                        display_toast(R.string.match_teamb);
                    }else{
                        teamA_MATCH_WON = true;
                        displayStatus(game_status, "MATCH TeamA");
                        display_toast(R.string.match_teama);
                    }
                }

                teamB_Points = 0;
                teamA_Points = 0;
                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
                displayStatus(score_status, "Love All");

            }

        }

        // if team a gets 15 points
        if (teamA_Points == 15) {
            if (teamB_Points == 0) {
                //set points status to love all
                displayStatus(score_status, "15 - 0");

                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 15) {
                // set points status to 0 - 15
                displayStatus(score_status, " 15 ALL");
                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 30) {
                //set the points sttaus to 0 -30
                displayStatus(score_status, "15 - 30");
                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 45) {
                //set the points sttaus to 0-40
                displayStatus(score_status, "15 - 40");
                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, 40);

            }
            /* add logic for games score update and sets won update */
            if (teamB_Points == 60) {
                //set the game won by team B to plus one and
                // add set the teamB points to 0
                // set the match status to last game won by team b

                teamB_games_won = teamB_games_won + 1;
                displayStatus(game_status,"GAME TeamB");
                display_toast(R.string.game_teamb);
                update_match_status(2,teamB_games_won,sets_played);
                if(teamB_games_won == MAX_GAMES ){
                    teamB_sets_won = teamB_sets_won + 1;
                    sets_played = sets_played + 1;
                    teamA_games_won = 0;
                    teamB_games_won = 0;
                    displayStatus(game_status,"SET TeamB");
                    display_toast(R.string.set_teamb);
                }
                if(sets_played == MAX_SETS ) {
                    if( teamB_sets_won > teamA_sets_won) {
                        teamB_MATCH_WON = true;
                        displayStatus(game_status, "MATCH TeamB");
                        display_toast(R.string.match_teamb);
                        //reset_match();
                    }else {
                        teamA_MATCH_WON = true;
                        displayStatus(game_status, "MATCH TeamA");
                        display_toast(R.string.match_teama);
                        //reset_match();
                    }
                }

                //Reset points for next game
                teamA_Points = 0;
                teamB_Points = 0;
                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
                displayStatus(score_status, "Love All");
            }

        }
// if teamA points are 30
        if (teamA_Points == 30) {

            if (teamB_Points == 0) {
                //set points status to love all
                displayStatus(score_status, "30 - 0");

                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 15) {
                // set points status to 0 - 15
                displayStatus(score_status, "30 - 15");

                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 30) {
                //set the points sttaus to 0 -30
                displayStatus(score_status, "30 ALL");

                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 45) {
                //set the points sttaus to 0-40
                displayStatus(score_status, "30 - 40");

                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, 40);

            }
            /* add logic for games score update and sets won update */
            if (teamB_Points == 60) {
                //set the game won by team B to plus one and
                // add set the teamB points to 0
                // set the match status to last game won by team b

                teamB_games_won = teamB_games_won + 1;
                displayStatus(game_status,"GAME TeamB");
                display_toast(R.string.game_teamb);
                update_match_status(2,teamB_games_won,sets_played);
                if(teamB_games_won == MAX_GAMES ){
                    teamB_sets_won = teamB_sets_won + 1;
                    sets_played = sets_played + 1;
                    teamA_games_won = 0;
                    teamB_games_won = 0;
                    displayStatus(game_status,"SET TeamB");
                    display_toast(R.string.set_teamb);
                }
                if(sets_played == MAX_SETS ) {
                    if(teamB_sets_won > teamA_sets_won) {
                        teamB_MATCH_WON = true;
                        displayStatus(game_status, "MATCH TeamB");
                        display_toast(R.string.match_teamb);
                       // reset_match();
                    }
                    else {
                        teamA_MATCH_WON = true;
                        displayStatus(game_status, "MATCH TeamA");
                        display_toast(R.string.match_teama);
                        //reset_match();
                    }
                }

                teamB_Points = 0;
                teamA_Points = 0;
                displayStatus(score_status, "Love All");
                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);

            }
        }
        //if teamA points are 45
        if (teamA_Points == 45) {

            if (teamB_Points == 0) {
                //set points status to love all
                displayStatus(score_status, "40 - 0");

                displayScore(teamA_point_val, 40);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 15) {
                // set points status to 0 - 15
                displayStatus(score_status, "40 - 15");

                displayScore(teamA_point_val, 40);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 30) {
                //set the points sttaus to 0 -30
                displayStatus(score_status, "40 - 30");

                displayScore(teamA_point_val, 40);
                displayScore(teamB_point_val, teamB_Points);
            }

            if (teamB_Points == 45) {
                //set the points sttaus to 0-40
                displayStatus(score_status, "DEUCE");
                displayScore(teamA_point_val, 40);
                displayScore(teamB_point_val, 40);

            }
            /* add logic for games score update and sets won update */
            if (teamB_Points == 60) {
                //set the game won by team B to plus one and
                // add set the teamB points to 0
                // set the match status to last game won by team b
                displayStatus(score_status, "Love All");
                teamB_games_won = teamB_games_won + 1;

                displayStatus(game_status,"GAME TeamB");
                display_toast(R.string.game_teamb);
                update_match_status(2,teamB_games_won,sets_played);

                if(teamB_games_won == MAX_GAMES ){
                    teamB_sets_won = teamB_sets_won + 1;
                    sets_played = sets_played + 1;
                    teamA_games_won = 0;
                    teamB_games_won = 0;
                    displayStatus(game_status,"SET TeamB");
                    display_toast(R.string.set_teamb);
                }
                if(sets_played == MAX_SETS ) {
                    if(teamB_sets_won > teamA_sets_won) {
                        teamB_MATCH_WON = true;
                        displayStatus(game_status, "MATCH TeamB");
                        display_toast(R.string.match_teamb);
                    }
                    else {

                        teamA_MATCH_WON = true;
                        displayStatus(game_status, "MATCH TeamA");
                        display_toast(R.string.match_teama);
                        //reset_match();
                    }
                }

                // need to add logic here to add games and set won
                displayScore( teamBSet1Game ,teamB_games_won);

                teamA_Points = 0;
                teamB_Points = 0;

                displayScore(teamA_point_val, teamA_Points);
                displayScore(teamB_point_val, teamB_Points);
        }
        }

        // if teamA points are 60
        if(teamA_Points == 60)
        {
            displayStatus( score_status,"Love All" );
            teamA_games_won = teamA_games_won + 1;
            displayStatus(game_status,"GAME TeamA");
            display_toast(R.string.game_teama);
            update_match_status( 1,teamA_games_won,sets_played);

             if(teamA_games_won == MAX_GAMES ){
                teamA_sets_won = teamA_sets_won + 1;
                sets_played = sets_played + 1;

                teamA_games_won = 0;
                teamB_games_won = 0;
                 displayStatus(game_status,"SET TeamA");
                 display_toast(R.string.set_teama);
            }
            if(sets_played == MAX_SETS ) {
                 if(teamA_sets_won > teamB_sets_won) {
                     teamA_MATCH_WON = true;
                     displayStatus(game_status, "MATCH TeamA");
                     display_toast(R.string.match_teama);
                    // reset_match();
                 }else {
                     teamB_MATCH_WON = true;
                     displayStatus(game_status, "MATCH TeamB");
                     display_toast(R.string.match_teamb);
                     // reset_match();
                 }
            }

            teamA_Points = 0;
            teamB_Points = 0;

            displayScore(teamA_point_val,teamA_Points);
            displayScore(teamB_point_val,teamB_Points);

        }
    }

    /**
     * resets score board
     */
    public void reset_match_status(){
        TextView dispView = (TextView) findViewById(R.id.teamA_Set1_Game);
        dispView.setText("0");

        dispView = (TextView) findViewById(R.id.teamA_Set1_Game);
        dispView.setText("0");

        dispView = (TextView) findViewById(R.id.teamA_Set2_Game);
        dispView.setText("0");

        dispView = (TextView) findViewById(R.id.teamA_Set3_Game);
        dispView.setText("0");

        dispView = (TextView) findViewById(R.id.teamB_Set1_Game);
        dispView.setText("0");

        dispView = (TextView) findViewById(R.id.teamB_Set2_Game);
        dispView.setText("0");

        dispView = (TextView) findViewById(R.id.teamB_Set3_Game);
        dispView.setText("0");
    }
    /**
     * function to update the games and sets
     * won status and match status
     */

    public void update_match_status(int team, int game_won, int set_won) {

        if(team == 1){

            if(set_won == 1) {
            // team A has won the game update row for team A
                TextView dispView = (TextView) findViewById(R.id.teamA_Set1_Game);
                dispView.setText(String.valueOf(game_won));
            }

            if(set_won == 2) {
                // team A has won the game update row for team A
                TextView dispView = (TextView) findViewById(R.id.teamA_Set2_Game);
                dispView.setText(String.valueOf(game_won));
            }

            if(set_won == 3) {
                // team A has won the game update row for team A
                TextView dispView = (TextView) findViewById(R.id.teamA_Set3_Game);
                dispView.setText(String.valueOf(game_won));
            }
        }
        /* */
        if(team == 2){
            if(set_won == 1) {
                // team A has won the game update row for team A
                TextView dispView = (TextView) findViewById(R.id.teamB_Set1_Game);
                dispView.setText(String.valueOf(game_won));
            }

            if(set_won == 2) {
                // team A has won the game update row for team A
                TextView dispView = (TextView) findViewById(R.id.teamB_Set2_Game);
                dispView.setText(String.valueOf(game_won));
            }

            if(set_won == 3) {
                // team A has won the game update row for team A
                TextView dispView = (TextView) findViewById(R.id.teamB_Set3_Game);
                dispView.setText(String.valueOf(game_won));
            }
        }

    }
    /**
     * function Reset match will reset all
     * points.
     */
    public void reset_match(View view){

        teamA_Points = 0;
        teamB_Points = 0;

        teamA_games_won = 0;
        teamB_games_won = 0;

        teamA_sets_won = 0;
        teamB_sets_won = 0;
        sets_played = 1;

        teamA_MATCH_WON = false;
        teamB_MATCH_WON = false;

        teamA_point_val = R.id.teamA_points_val;
        teamB_point_val = R.id.teamB_points_val;

        displayStatus(game_status,"TeamA vs TeamB");
        displayStatus(score_status, "Love All");

        displayScore(teamA_point_val,teamA_Points);
        displayScore(teamB_point_val,teamB_Points);
        reset_match_status();
    }
}
