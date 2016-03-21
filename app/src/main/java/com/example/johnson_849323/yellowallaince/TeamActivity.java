package com.example.johnson_849323.yellowallaince;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;


public class TeamActivity extends Activity {

    String team; //The number of the team that was selected so everything in the this activity knows what team is being referenced

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        team = getIntent().getStringExtra("Team#"); //Sets the global team number string to the extra given in the intent
        makeTable(); //Create the table that gives information about the team selected
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_team, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) { //If the home button is selected go back to the Main acitivity
            TeamActivity.this.startActivity(new Intent(TeamActivity.this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public void makeTable() {  //Create the table that gives information about the team selected
        TableLayout table = (TableLayout) findViewById(R.id.mainTable); //Create table object that is the main table

        TableRow row; //Create row object that will be modified and then added to the table object
        TextView view; //Create textview object that will hold information for that line

        DBManager manager = new DBManager(this); //Create manager object in order to be able access the database
        ArrayList<Team> teams = manager.getAllTeams(); //Gets an arraylist of all teams from the database
        Team robo = new Team(); //Creates team object that will be the team of this acitvity

        for (int i = 0; i < teams.size(); i++) { //Find the team of this activity
            if (("" + teams.get(i).getNumber()).equals(team)) {
                robo = teams.get(i); //Set the team object of the team for this activity
                break;
            }
        }

        row = new TableRow(this);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set row object sizing

        view = new TextView(this);
        view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set textview object sizing
        view.setTextAppearance(this, android.R.style.TextAppearance_Large); //Make the text size large
        view.setText("Number: " + robo.getNumber()); //Display the number of the team

        row.addView(view);
        table.addView(row);

        row = new TableRow(this);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set row object sizing
        view = new TextView(this);
        view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set textview object sizing
        view.setTextAppearance(this, android.R.style.TextAppearance_Large); //Make the text size large
        view.setText("Name: " + robo.getName()); //Display the name of the team

        row.addView(view);
        table.addView(row);

        row = new TableRow(this);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set row object sizing
        view = new TextView(this);
        view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set textview object sizing
        view.setTextAppearance(this, android.R.style.TextAppearance_Large); //Make the text size large
        view.setText("Matches: " + robo.getMatches()); //Display the matches of the team

        row.addView(view);
        table.addView(row);

        row = new TableRow(this);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set row object sizing


        for (int i = 0; i < robo.getMatches().size(); i++) { //Go through each match the team will play
            int redScore = -1;
            int blueScore = -1;

            //Display the match number
            view = new TextView(this);
            view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set textview object sizing
            view.setTextAppearance(this, android.R.style.TextAppearance_Large); //Make the text size large
            view.setText("" + robo.getMatches().get(i) + ":");
            view.setTypeface(null, Typeface.BOLD);

            row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set row object sizing

            row.addView(view);

            for (int j = 0; j < teams.size(); j++) { //Go through all of the teams
                for(int k = 0; k < teams.get(j).getMatches().size(); k++) { //Go through each match for the teams
                    if (robo.getMatches().get(i) == teams.get(j).getMatches().get(k) && teams.get(j).getNumber() != robo.getNumber()) { //If the match from the teams list equals a match from the matches from the team we are looking at

                        //Display the number of the team from the team's same match
                        view = new TextView(this);
                        view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set textview object sizing
                        view.setTextAppearance(this, android.R.style.TextAppearance_Large); //Make the text size large
                        view.setText(" " + teams.get(j).getNumber());

                        //Set the color of the teams' number based on what allaince they were on
                        if (teams.get(j).getAlliances().get(k).equals("Red1") || teams.get(j).getAlliances().get(k).equals("Red2")) {
                            view.setTextColor(Color.RED);
                        }

                        else {
                            view.setTextColor(Color.BLUE);
                        }

                        final String TeamNumber =  "" + teams.get(j).getNumber();

                        view.setOnClickListener(new TableRow.OnClickListener() {
                            @Override
                            public void onClick(View v) { //Make an onClick for the each row
                                Intent intent = new Intent(TeamActivity.this, TeamActivity.class); //If the team number is pressed start a new TeamActivity with information about the selected team
                                intent.putExtra("Team#", TeamNumber); //Send the team number into the new activity in order to know which team the new activity should be about
                                TeamActivity.this.startActivity(intent); //Start the new activity
                            }
                        });

                        row.addView(view);


                        if (redScore == -1 && (teams.get(j).getAlliances().get(k).equals("Red1") || teams.get(j).getAlliances().get(k).equals("Red2")))
                            redScore = teams.get(j).getScores().get(k);
                        if (blueScore == -1 && (teams.get(j).getAlliances().get(k).equals("Blue1") || teams.get(j).getAlliances().get(k).equals("Blue2")))
                            blueScore = teams.get(j).getScores().get(k);
                    }
                }
            }

            view = new TextView(this);
            view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set textview object sizing
            view.setTextAppearance(this, android.R.style.TextAppearance_Large); //Make the text size large
            view.setText("  Score:");
            view.setTypeface(null, Typeface.BOLD);
            row.addView(view);


            view = new TextView(this);
            view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set textview object sizing
            view.setTextAppearance(this, android.R.style.TextAppearance_Large); //Make the text size large
            view.setText(redScore + "-");
            view.setTextColor(Color.RED);
            row.addView(view);


            view = new TextView(this);
            view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set textview object sizing
            view.setTextAppearance(this, android.R.style.TextAppearance_Large); //Make the text size large
            view.setText("" + blueScore);
            view.setTextColor(Color.BLUE);
            row.addView(view);

            table.addView(row);
        }
    }
}
