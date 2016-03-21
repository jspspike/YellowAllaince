package com.example.johnson_849323.yellowallaince;

import android.util.Log;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by johnson_849323 on 2/25/2016.
 */
public class Team implements Comparable{

    private int id;

    private int number;
    private String name;

    private String alliance;


    private String match;

    private String score;

    public Team(){}

    public Team(int id, int number, String name, String alliance, String match, String score) {
        this.id = id;
        this.score = score;
        this.match = match;
        this.alliance = alliance;
        this.number = number;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getScores() {
        ArrayList<Integer> scores = new ArrayList<>();

        Scanner scan = new Scanner(score);
        scan.useDelimiter("\\|");

        while(scan.hasNextInt()) {
            scores.add(scan.nextInt());
        }
        Log.i("Scores", "" + scores);
        return scores;
    }

    public String getName() {
        return name;
    }

    public String getAlliance() {
        return alliance;
    }

    public String getMatch() {
        return match;
    }

    public ArrayList<String> getAlliances() {
        ArrayList<String> allainces = new ArrayList<>();

        Scanner scan = new Scanner(alliance);
        scan.useDelimiter("\\|");

        while(scan.hasNext()) {
            allainces.add(scan.next());
        }

        return allainces;
    }

    public ArrayList<Integer> getMatches() {
        ArrayList<Integer> matches = new ArrayList<>();

        Scanner scan = new Scanner(match);
        scan.useDelimiter("\\|");

        while(scan.hasNextInt()) {
            matches.add(scan.nextInt());
        }

        Log.i("Matches", "" + matches);
        return matches;
    }

    public String getScore() {
        return score;
    }

    public int getNumber() {
        return number;
    }




    @Override
    public String toString() {
        return "ID: " + id + " Number: " + number + " Name " + name;
    }

    @Override
    public int compareTo(Object another) {
        Team other = (Team) another;

        return this.getNumber() - other.getNumber();
    }
}
