/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task04_1;

/**
 * @author yushi
 */
interface IUser {
    String getName();

    void setName(String name);

    int getScore();

    void setScore(int score);
}

public class User implements IUser {
    private String name;
    private int score;

    public User(String name) {
        this.score = 0;
        this.name = name;
    }

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}


