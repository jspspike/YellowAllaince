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

    String team;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        team = getIntent().getStringExtra("Team#");
        makeTable();
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
        if (id == R.id.action_settings) {
            TeamActivity.this.startActivity(new Intent(TeamActivity.this, MainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public void makeTable() {
        TableLayout table = (TableLayout) findViewById(R.id.mainTable);

        TableRow row;
        TextView view;

        DBManager manager = new DBManager(this);
        ArrayList<Team> teams = manager.getAllContacts();
        Team robo = new Team();

        for (int i = 0; i < teams.size(); i++) {
            if (("" + teams.get(i).getNumber()).equals(team)) {
                robo = teams.get(i);
                break;
            }
        }

        row = new TableRow(this);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        view = new TextView(this);
        view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        view.setTextAppearance(this, android.R.style.TextAppearance_Large);
        view.setText("Number: " + robo.getNumber());

        row.addView(view);
        table.addView(row);

        row = new TableRow(this);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        view = new TextView(this);
        view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        view.setTextAppearance(this, android.R.style.TextAppearance_Large);
        view.setText("Name: " + robo.getName());

        row.addView(view);
        table.addView(row);

        row = new TableRow(this);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        view = new TextView(this);
        view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        view.setTextAppearance(this, android.R.style.TextAppearance_Large);
        view.setText("Matches: " + robo.getMatches());

        row.addView(view);
        table.addView(row);

        row = new TableRow(this);
        row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));


        for (int i = 0; i < robo.getMatches().size(); i++) {
            int redScore = -1;
            int blueScore = -1;

            view = new TextView(this);
            view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            view.setTextAppearance(this, android.R.style.TextAppearance_Large);
            view.setText("" + robo.getMatches().get(i) + ":");
            view.setTypeface(null, Typeface.BOLD);

            row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            row.addView(view);

            for (int j = 0; j < teams.size(); j++) {
                for(int k = 0; k < teams.get(j).getMatches().size(); k++) {
                    if (robo.getMatches().get(i) == teams.get(j).getMatches().get(k) && teams.get(j).getNumber() != robo.getNumber()) {
                        view = new TextView(this);
                        view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                        view.setTextAppearance(this, android.R.style.TextAppearance_Large);
                        view.setText(" " + teams.get(j).getNumber());

                        if (teams.get(j).getAlliances().get(k).equals("Red1") || teams.get(j).getAlliances().get(k).equals("Red2")) {
                            view.setTextColor(Color.RED);
                        }

                        else {
                            view.setTextColor(Color.BLUE);
                        }

                        final String TeamNumber =  "" + teams.get(j).getNumber();

                        view.setOnClickListener(new TableRow.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(TeamActivity.this, TeamActivity.class);
                                intent.putExtra("Team#", TeamNumber);
                                TeamActivity.this.startActivity(intent);
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
            view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            view.setTextAppearance(this, android.R.style.TextAppearance_Large);
            view.setText("  Score:");
            view.setTypeface(null, Typeface.BOLD);
            row.addView(view);


            view = new TextView(this);
            view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            view.setTextAppearance(this, android.R.style.TextAppearance_Large);
            view.setText(redScore + "-");
            view.setTextColor(Color.RED);
            row.addView(view);


            view = new TextView(this);
            view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            view.setTextAppearance(this, android.R.style.TextAppearance_Large);
            view.setText("" + blueScore);
            view.setTextColor(Color.BLUE);
            row.addView(view);

            table.addView(row);
        }
    }
}
