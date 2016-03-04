package com.example.johnson_849323.yellowallaince;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends Activity {

    public DBManager manager = new DBManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //manager.addContact(new Team(1, 6299, "QuadX", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addContact(new Team(1, 4211, "Bombers", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addContact(new Team(2, 4997, "Masquerade", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addContact(new Team(3, 4211, "Bombers", "Red|Blue|Red", "10|23|44", "34|54|234"));
//        manager.addContact(new Team(4, 3781, "Pi-Roh Maniacs", "Red|Blue|Red", "10|23|44", "34|54|234"));
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
        if (id == R.id.action_settings) {
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
            row.setOnClickListener(new TableRow.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("SWAG");
                }
            });

            System.out.println(teams.get(i));
            table.addView(row);
        }
    }
}
