package com.example.johnson_849323.yellowallaince;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }


    public void add(View v) {
        DBManager manager = new DBManager(this);

        EditText nameText = (EditText)findViewById(R.id.nameText);
        EditText numberText = (EditText)findViewById(R.id.numberText);
        EditText allianceText = (EditText)findViewById(R.id.allaincesText);
        EditText matchesText = (EditText)findViewById(R.id.matchesText);
        EditText scoresText = (EditText)findViewById(R.id.scoresText);

        try {
            manager.addContact(new Team(1, Integer.parseInt("" + numberText.getText()), "" + nameText.getText(), "" + allianceText.getText(), "" + matchesText.getText(), "" + scoresText.getText()));
        }

        catch(Exception e) {}

        AddActivity.this.startActivity(new Intent(AddActivity.this, MainActivity.class));

    }
}
