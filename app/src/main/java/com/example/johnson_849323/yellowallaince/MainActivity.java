package com.example.johnson_849323.yellowallaince;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;



public class MainActivity extends Activity {

    public DBManager manager = new DBManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        manager.clearAll();
//        manager.addContact(new Team(1, 3708, "Iron Eagles Optimus", "Red1|Red2|Red2|Blue1|Blue2", "1|7|15|18|25", "55|33|16|53|47"));
//        manager.addContact(new Team(1, 3781, "Pi-Roh Maniacs", "Blue1|Blue1|Blue1|Red2|Red2", "3|8|11|20|25", "213|120|286|239|47"));
//        manager.addContact(new Team(1, 4027, "Sigma", "Blue1|Red1|Red2|Blue2|Blue2", "5|8|12|19|23", "213|120|286|239|47"));
//        manager.addContact(new Team(1, 4290, "High PHidelity", "Blue2|Blue2|Red1|Blue1|Red2", "4|8|15|17|24", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 4723, "Robo Raiders", "Red1|Blue1|Red1|Blue2|Red2", "3|7|14|16|23", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 5810, "Those Guys", "Red2|Red1|Blue2|Blue2|Red1", "4|10|13|18|23", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 6210, "Stryke", "Red1|Blue1|Blue1|Red1|Blue1", "5|9|13|16|25", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 6272, "Iron Eagles Prime", "Red2|Blue2|Red2|Blue2|Blue1", "1|6|13|20|24", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 6299, "QuadX", "Red1|Red2|Blue2|Blue1|Blue1", "2|9|11|20|23", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 6937, "Ctrl F8", "Red2|Blue2|Red1|Red2|Blue2", "2|7|13|19|22", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 7064, "Techno Inferno", "Blue1|Blue1|Blue2|Red1|Red1", "2|6|12|17|25", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 7079, "Faltech", "Blue1|Red1|Red2|Blue1|Red2", "4|6|11|16|22", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 7717, "Eagles 2", "Blue1|Blue2|Red2|Red2|Blue1", "1|9|14|17|22", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 7797, "Victorian Voltage", "Blue2|Red1|Red1|Blue2|Red2", "5|7|11|17|21", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 8048, "404 Not Found", "Blue2|Red2|Red1|Red2|Blue2", "1|10|12|16|21", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 8683, "Game Changers", "Red2|Blue2|Blue2|Red1|Red1", "5|10|15|20|22", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 8886, "Saber Robotics", "Blue2|Red1|Blue1|Red2|Blue2", "3|9|12|18|24", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 9048, "Philobots", "Red2|Red2|Blue1|Red1|Blue1", "3|6|15|19|21", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 9874, "Back to the PHuture", "Blue2|Red2|Blue2|Red1|Red1", "2|8|14|18|21", "-1|-1|-1|-1|-1"));
//        manager.addContact(new Team(1, 10282, "CruBots", "Red1|Blue1|Blue1|Blue1|Red1", "4|10|14|19|24", "-1|-1|-1|-1|-1"));



//        manager.addContact(new Team(1, 6299, "QuadX", "Red|Blue|Red", "11|55|66", "34|54|234"));
//        manager.addContact(new Team(1, 4211, "Bombers", "Red|Blue|Red", "11|55|66", "34|54|234"));
//        manager.addContact(new Team(2, 4997, "Masquerade", "Blue|Red|Blue", "11|55|66", "34|54|234"));
//        manager.addContact(new Team(4, 3781, "Pi-Roh Maniacs", "Blue|Red|Blue", "11|55|66", "34|54|234"));
//        manager.addContact(new Team(5, 7477, "Super-7", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addContact(new Team(6, 3846, "Maelstrom", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addContact(new Team(7, 3486, "Techno Warriors", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addContact(new Team(8, 5096, "Monkey Madness", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addContact(new Team(9, 92, "Jr Bomb Squad", "Red|Blue|Red", "10|23|44", "34|54|234"));
        makeTable();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main , menu);
        return true;
    }

    public void display(View v) {
        System.out.println("Teams: " +  manager.getAllContacts());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.addTeam) {
            MainActivity.this.startActivity(new Intent(MainActivity.this, AddActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void makeTable() {

        ArrayList<Team> teams = manager.getAllContacts();

        TableLayout table = (TableLayout) findViewById(R.id.mainTable);
        TableRow row;
        TextView view;
        TextView number;

        Collections.sort(teams);

        for (int i = 0; i < teams.size(); i++) {
            row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            number = new TextView(this);
            number.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            number.setTextAppearance(this, android.R.style.TextAppearance_Large);
            number.setText(teams.get(i).getNumber() + "  ");

            view = new TextView(this);
            view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            view.setTextAppearance(this, android.R.style.TextAppearance_Large);
            view.setText(teams.get(i).getName());
            row.addView(number);
            row.addView(view);
            final String TeamNumber =  "" + teams.get(i).getNumber();

            row.setOnClickListener(new TableRow.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, TeamActivity.class);
                    intent.putExtra("Team#", TeamNumber);
                    MainActivity.this.startActivity(intent);
                }
            });

            System.out.println(teams.get(i));
            table.addView(row);
        }
    }
}
