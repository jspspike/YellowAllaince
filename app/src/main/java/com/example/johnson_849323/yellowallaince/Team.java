package com.example.johnson_849323.yellowallaince;

import java.util.ArrayList;

/**
 * Created by johnson_849323 on 2/25/2016.
 */
public class Team {

    private int id;

    private int number;
    private String name;

    private String alliance;
    private ArrayList<String> alliances = new ArrayList<>();

    private String match;
    private ArrayList<Integer> matches = new ArrayList<>();

    private String score;
    private ArrayList<Integer> scores = new ArrayList<>();

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


    public void setMatch(String match) {
        this.match = match;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAlliance(String alliance) {
        this.alliance = alliance;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public ArrayList<Integer> getScores() {
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

    public ArrayList<Integer> getMatches() {
        return matches;
    }

    public String getScore() {
        return score;
    }

    public int getNumber() {
        return number;
    }
}
