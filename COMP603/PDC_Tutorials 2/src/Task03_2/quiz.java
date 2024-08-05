/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task03_2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yushi
 */
public class quiz {

    enum Operator {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
    }

    public static double quizMaker() {
        Random ran = new Random();
        double result = 0;
        String symbol = "";
        Operator operator = Operator.values()[ran.nextInt(Operator.values().length)];
        int number1 = ran.nextInt(101);
        int number2 = ran.nextInt(101);
        switch (operator) {
            case ADD:
                symbol = "+";
                result = number1 + number2;
                break;
            case SUBTRACT:
                result = number1 - number2;
                symbol = "-";
                break;
            case MULTIPLY:
                result = number1 * number2;
                symbol = "*";
                break;
            case DIVIDE:
                if (number2 == 0) {
                    number2 = 1;
                } else {
                    result = (double) number1 / (double) number2;
                    result = Math.round(result * 100.0) / 100.0;
                    symbol = "/";
                }
                break;
        }
        System.out.printf("What is %d %s %d? (Round your answer to two decimal places)\n", number1, symbol, number2);
        return result;

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int score = 0;
        double result = 0;
        while (true) {
            System.out.println("Enter your answer (type 'x' to exit): ");

            result = quizMaker();
            String input = scan.next();
            try {
                if ("x".equals(input)) {
                    break;
                } else if (result == Double.parseDouble(input)) {
                    score++;
                    System.out.println("Correct!");
                } else {
                    score--;
                    System.out.println("Wrong!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'x' to exit.");
                continue;

            }

        }
        System.out.println("Score:" + score);

        scan.close();
    }
}
