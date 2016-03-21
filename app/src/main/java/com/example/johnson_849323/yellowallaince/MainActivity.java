package com.example.johnson_849323.yellowallaince;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;



public class MainActivity extends Activity {

    public DBManager manager = new DBManager(this); //Create global manager object in order to be able access the database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        manager.addTeam(new Team(1, 6299, "QuadX", "Red|Blue|Red", "11|55|66", "34|54|234"));
//        manager.addTeam(new Team(1, 4211, "Bombers", "Red|Blue|Red", "11|55|66", "34|54|234"));
//        manager.addTeam(new Team(2, 4997, "Masquerade", "Blue|Red|Blue", "11|55|66", "34|54|234"));
//        manager.addTeam(new Team(4, 3781, "Pi-Roh Maniacs", "Blue|Red|Blue", "11|55|66", "34|54|234"));
//        manager.addTeam(new Team(5, 7477, "Super-7", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addTeam(new Team(6, 3846, "Maelstrom", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addTeam(new Team(7, 3486, "Techno Warriors", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addTeam(new Team(8, 5096, "Monkey Madness", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addTeam(new Team(9, 92, "Jr Bomb Squad", "Red|Blue|Red", "10|23|44", "34|54|234"));
        makeTable(); //Writes the list of teams based on the information in the database
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
        if (id == R.id.addTeam) {
            MainActivity.this.startActivity(new Intent(MainActivity.this, AddActivity.class)); //Start the activity in order to manually add a team
            return true;
        }

        if (id == R.id.clear) {
            TableLayout table = (TableLayout) findViewById(R.id.mainTable); //Create table object that is the main table

            manager.clearAll(); //Remove all the information in the database that currently is already there
            table.removeAllViews(); //Clear the table so it appears blank

            makeTable(); //Remake table in case there is still information left in the database
        }

        if (id == R.id.load) { //Load data from excel file (Not done so just manually adding things)
            manager.addTeam(new Team(1, 3708, "Iron Eagles Optimus", "Red1|Red2|Red2|Blue1|Blue2", "1|7|15|18|25", "55|33|-1|-1|-1"));
            manager.addTeam(new Team(1, 3781, "Pi-Roh Maniacs", "Blue1|Blue1|Blue1|Red2|Red2", "3|8|11|20|25", "213|120|286|-1|-1"));
            manager.addTeam(new Team(1, 4027, "Sigma", "Blue1|Red1|Red2|Blue2|Blue2", "5|8|12|19|23", "31|51|70|-1|-1"));
            manager.addTeam(new Team(1, 4290, "High PHidelity", "Blue2|Blue2|Red1|Blue1|Red2", "4|8|15|17|24", "124|120|-1|-1|-1"));
            manager.addTeam(new Team(1, 4723, "Robo Raiders", "Red1|Blue1|Red1|Blue2|Red2", "3|7|14|16|23", "11|8|-1|-1|-1"));
            manager.addTeam(new Team(1, 5810, "Those Guys", "Red2|Red1|Blue2|Blue2|Red1", "4|10|13|18|23", "93|26|-1|-1|-1"));
            manager.addTeam(new Team(1, 6210, "Stryke", "Red1|Blue1|Blue1|Red1|Blue1", "5|9|13|16|25", "48|34|-1|-1|-1"));
            manager.addTeam(new Team(1, 6272, "Iron Eagles Prime", "Red2|Blue2|Red2|Blue2|Blue1", "1|6|13|20|24", "55|143|-1|-1|-1"));
            manager.addTeam(new Team(1, 6299, "QuadX", "Red1|Red2|Blue2|Blue1|Blue1", "2|9|11|20|23", "79|210|286|-1|-1"));
            manager.addTeam(new Team(1, 6937, "Ctrl F8", "Red2|Blue2|Red1|Red2|Blue2", "2|7|13|19|22", "79|8|-1|-1|-1"));
            manager.addTeam(new Team(1, 7064, "Techno Inferno", "Blue1|Blue1|Blue2|Red1|Red1", "2|6|12|17|25", "33|143|123|-1|-1"));
            manager.addTeam(new Team(1, 7079, "Faltech", "Blue1|Red1|Red2|Blue1|Red2", "4|6|11|16|22", "124|25|25|-1|-1"));
            manager.addTeam(new Team(1, 7717, "Eagles 2", "Blue1|Blue2|Red2|Red2|Blue1", "1|9|14|17|22", "23|34|-1|-1|-1"));
            manager.addTeam(new Team(1, 7797, "Victorian Voltage", "Blue2|Red1|Red1|Blue2|Red2", "5|7|11|17|21", "31|33|25|-1|-1"));
            manager.addTeam(new Team(1, 8048, "404 Not Found", "Blue2|Red2|Red1|Red2|Blue2", "1|10|12|16|21", "23|26|70|-1|-1"));
            manager.addTeam(new Team(1, 8683, "Game Changers", "Red2|Blue2|Blue2|Red1|Red1", "5|10|15|20|22", "48|32|-1|-1|-1"));
            manager.addTeam(new Team(1, 8886, "Saber Robotics", "Blue2|Red1|Blue1|Red2|Blue2", "3|9|12|18|24", "213|210|123|-1|-1"));
            manager.addTeam(new Team(1, 9048, "Philobots", "Red2|Red2|Blue1|Red1|Blue1", "3|6|15|19|21", "11|25|-1|-1|-1"));
            manager.addTeam(new Team(1, 9874, "Back to the PHuture", "Blue2|Red2|Blue2|Red1|Red1", "2|8|14|18|21", "33|51|-1|-1|-1"));
            manager.addTeam(new Team(1, 10282, "CruBots", "Red1|Blue1|Blue1|Blue1|Red1", "4|10|14|19|24", "93|32|-1|-1|-1"));

            makeTable(); //Make table based on information in the database
        }

        return super.onOptionsItemSelected(item);
    }

    public void makeTable() { //Creates the table based on information in the database

        ArrayList<Team> teams = manager.getAllTeams(); //Gets an arraylist of all teams from the database

        TableLayout table = (TableLayout) findViewById(R.id.mainTable); //Create table object that is the main table
        TableRow row; //Create row object that will be modified and then added to the table object
        TextView view; //Create textview object that will be modified with the teams' name and then be added to the row object
        TextView number; //Create textview object that will be modified with the teams' number and then be added to the row object

        Collections.sort(teams); //Sort the arraylist of teams by team number

        for (int i = 0; i < teams.size(); i++) { //Go through each team in the teams arraylist
            row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set row object sizing

            number = new TextView(this);
            number.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set textview object sizing
            number.setTextAppearance(this, android.R.style.TextAppearance_Large); //Make the text size large
            number.setText(teams.get(i).getNumber() + "  "); //Set the textview to display the teams' number

            view = new TextView(this);
            view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT)); //Set textview object sizing
            view.setTextAppearance(this, android.R.style.TextAppearance_Large); //Make the text size large
            view.setText(teams.get(i).getName());  //Set the textview to display the teams' name
            row.addView(number); //Add the textview to the row
            row.addView(view); //Add the textview to the row
            final String TeamNumber =  "" + teams.get(i).getNumber(); //Get the teams' number in String form

            row.setOnClickListener(new TableRow.OnClickListener() {
                @Override
                public void onClick(View v) { //Make an onClick for the each row
                    Intent intent = new Intent(MainActivity.this, TeamActivity.class); //If the row is clicked create a new team activity
                    intent.putExtra("Team#", TeamNumber); //Send the team number into the new activity in order to know which team the new activity should be about
                    MainActivity.this.startActivity(intent); //Start the new activity
                }
            });

            Log.i("Teams", "" + teams.get(i));
            table.addView(row); //Add row of team name and number with onClick to table
        }
    }
}
