/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task04_1;

import java.util.Map;
import java.util.Scanner;

/**
 * @author yushi
 */

interface ICUI {
    void start();
}

public class CUI implements ICUI {
    private final int round;
    private final String exitCommand;
    private final String fileName;
    Map.Entry<String, Double> quiz;
    private QuizPack quizPack;
    private Repository repository;
    private Scanner scan;
    private IUser user;
    private int counter;

    public CUI(int round, String exitCommand, String fileName) {
        this.exitCommand = exitCommand;
        this.round = round;
        this.fileName = fileName;
    }

    public void start() {
        // setup the quiz pack, repository, and scanner
        setup();
        // get the user's name
        getUser();
        // loop through the quiz pack
        processQuiz();
        // save the user's score
        save();

    }

    private void setup() {
        quizPack = new QuizPack(round);
        repository = new Repository(fileName);
        scan = new Scanner(System.in);
        counter = 0;

    }

    private void getUser() {
        System.out.println("Please enter your name:");
        String name = scan.nextLine();
        user = new User(name);
        // load the user's score
        repository.load(user);
    }

    private void processQuiz() {
        int inputFlag;
        while (counter < (round)) {
            quiz = quizPack.getNextQuiz();
            // loop until the user enters a valid input
            do {
                inputFlag = handleInput();
            } while (inputFlag != 0 && inputFlag != 1);
            if (inputFlag == 1) {
                break;
            }
            counter++;
        }
    }

    //flag = 1 means exit, flag = 0 means correct, flag = -1 means invalid input
    private int handleInput() {
        int flag = 0;
        try {
            System.out.printf("What is %s? (Round your answer to two decimal places)\n(Input x for exit)\n",
                    quiz.getKey());

            String input = scan.next();
            input = input.trim();
            if (exitCommand.equals(input)) {
                flag = 1;
                return flag;
            } else if (input.isEmpty()) {

                System.out.println("Invalid input.");
                flag = -1;
            }

            if (Double.parseDouble(input) == quiz.getValue()) {
                System.out.println("Correct!");
                user.setScore(user.getScore() + 1);
            } else {
                System.out.println("Incorrect!");
                user.setScore(user.getScore() - 1);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            flag = -1;
        }
        return flag;


    }


    private void save() {
        repository.save(user);
        System.out.println("Your score is: " + user.getScore());
        scan.close();
    }


}
