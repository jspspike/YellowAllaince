package com.example.johnson_849323.YellowAllaince;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.johnson_849323.yellowallaince.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by johnson_849323 on 2/9/2016.
 */
public class DBManager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "teamsManager";

    // Contacts table name
    private static final String DB_TABLES = "teams";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NUMBER = "number";
    private static final String KEY_NAME = "name";
    private static final String KEY_ALLAINCE = "alliance";
    private static final String KEY_MATCH_NUMBERS = "numbers";
    private static final String KEY_SCORES = "scores";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DB_TABLES + "("
                + KEY_ID +  " INTEGER PRIMARY KEY," + KEY_NUMBER + "NUMBERS," + KEY_NAME + " TEXT,"
                + KEY_ALLAINCE + " TEXT," + KEY_MATCH_NUMBERS + "NUMBERS," + KEY_SCORES + "NUMBERS" + ")"; //Create SQL command to create table
        db.execSQL(CREATE_CONTACTS_TABLE); //Run the SQL command to create the table
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLES);

        // Create tables again
        onCreate(db);
    }

    //Adds contact
    public void addContact(Team team) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, team.getName()); //Name variable in new contact
        values.put(KEY_NUMBER, team.getNumber());
        values.put(KEY_ALLAINCE, team.getAlliance()); //Phone number variable in new contact
        values.put(KEY_MATCH_NUMBERS, team.getMatch());
        values.put(KEY_SCORES, team.getScore());

        db.insert(DB_TABLES, null, values); //Adds the new contact to the database
        db.close();
    }

    public List<Team> getAllContacts() { //Gets an arraylist of contacts from all of the contacts in the database
        List<Team> teamList = new ArrayList<>();

        String selectQuery = "SELECT  * FROM " + DB_TABLES; //Gets contact data as a string

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null); //Creates cursor go through the contacts

        if (cursor.moveToFirst()) {
            do {
                Team team = new Team(Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(2)), cursor.getString(1), cursor.getString(3), cursor.getString(4), cursor.getString(5));
                 //Gets contact phone number
                teamList.add(team); //Adds the contact to the array list
            } while (cursor.moveToNext());
        }

        System.out.println(teamList);
        return teamList;
    }

    public void deleteContact(Team team) { //Deletes the contact from the database
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_TABLES, KEY_ID + " = ?", new String[] {String.valueOf(team.getId())}); //Deletes the contact suing teh id from the contact object

        db.close();
    }

    public int updateContact(Team team) {
     //Modifies the contact
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, team.getName()); //Name variable in new contact
        values.put(KEY_NUMBER, team.getNumber());
        values.put(KEY_ALLAINCE, team.getAlliance()); //Phone number variable in new contact
        values.put(KEY_MATCH_NUMBERS, team.getMatch());
        values.put(KEY_SCORES, team.getScore());


        return db.update(DB_TABLES, values, KEY_ID + " = ?", new String[] { String.valueOf(team.getId()) }); //Updates the contact
    }
}
