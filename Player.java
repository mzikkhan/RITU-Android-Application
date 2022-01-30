package com.example.ritu_app.first;

public class Player {

    //Simpleton class
    private static Player obj;
    private Player() {

    }
    public static Player getObject() {
        if(obj == null) {
            obj = new Player();
        }
        return obj;
    }

    //Player Data

    private String PlayerName;
    private String PlayerEmail;
    private String PlayerPassword;
    private String Task1;
    private String Task2;
    private String Task3;
    private String Task4;
    private String Task5;
    private int Points;

    //Setters

    public void setPlayerName(String name) {
        PlayerName = name;
    }
    public void setPlayerEmail(String email) {
        PlayerEmail = email;
    }
    public void setPlayerPassword(String playerPassword) {
        PlayerPassword = playerPassword;
    }
    public void setTask1(String task) {
        Task1 = task;
    }
    public void setTask2(String task) {
        Task2 = task;
    }
    public void setTask3(String task) {
        Task3 = task;
    }
    public void setTask4(String task) {
        Task4 = task;
    }
    public void setTask5(String task) {
        Task5 = task;
    }
    public void setPoints(int points) {
        Points = points;
    }

    //Getters

    public String getPlayerName() {
        return PlayerName;
    }
    public String getPlayerEmail() {
        return PlayerEmail;
    }
    public String getPlayerPassword() {
        return PlayerPassword;
    }
    public String getTask1() {
        return Task1;
    }
    public String getTask2() {
        return Task2;
    }
    public String getTask3() {
        return Task3;
    }
    public String getTask4() {
        return Task4;
    }
    public String getTask5() {
        return Task5;
    }
    public int getPoints() {
        return Points;
    }

}