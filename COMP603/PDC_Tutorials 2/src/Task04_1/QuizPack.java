/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task04_1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * @author yushi
 */
interface IQuizPack {
    void generator();

    int generateNumber(int range);

    Map.Entry<String, Double> getNextQuiz();


}

public class QuizPack implements IQuizPack {
    // Configuration
    private static final int NUMBER_RANGE = 100;
    private static final int NUMBER_OF_OPERATION = 4;
    // Setup
    private final Random random = new Random();
    private final Map<String, Double> quizMap;
    private final int size;
    private Iterator<Map.Entry<String, Double>> iterator;

    public QuizPack(int size) {
        this.size = size;
        quizMap = new HashMap<>(size);
        this.generator();
    }

    //generate a map of quiz questions and answers.
    @Override
    public void generator() {
        for (int i = 0; i < size; i++) {
            double num1 = this.generateNumber(NUMBER_RANGE);
            double num2 = this.generateNumber(NUMBER_RANGE);
            String operation = "";
            double result = 0d;

            switch (this.generateNumber(NUMBER_OF_OPERATION)) {
                case 0:
                    operation = "+";
                    result = num1 + num2;
                    break;
                case 1:
                    operation = "-";
                    result = num1 - num2;
                    break;
                case 2:
                    operation = "*";
                    result = num1 * num2;
                    break;
                case 3:
                    operation = "/";
                    while (num2 == 0) {
                        num2 = this.generateNumber(100);
                    }
                    result = Math.round((num1 / num2) * 100.0) / 100.0;
                    break;
                default:
                    break;
            }
            quizMap.put(String.format("%.0f %s %.0f", num1, operation, num2), result);
        }
        //Generate two numbers between 0 and 100 randomly.
        this.iterator = quizMap.entrySet().iterator();


    }

    //generate a random number.
    @Override
    public int generateNumber(int range) {
        return random.nextInt(range);
    }

    //get the next quiz question and answer.
    @Override
    public Map.Entry<String, Double> getNextQuiz() {
        if (iterator.hasNext()) {
            return iterator.next();
        }

        return null;
    }
}
