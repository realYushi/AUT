/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task02_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yushi
 */
public class T02_3 {

    private static void fileToMap(String filePath, HashMap<String, Integer> map) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] newLine = line.split(" ");
                map.put(newLine[0], Integer.parseInt(newLine[1]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(T02_3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(T02_3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void mapToFile(String filePath, HashMap<String, Integer> map) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            String line;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                line = entry.getKey() + " " + entry.getValue();
                bw.write(line);
                bw.newLine();
            }

        } catch (IOException ex) {
            Logger.getLogger(T02_3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String filePath = "./resources/T02_scores.txt";
        HashMap<String, Integer> map = new HashMap<>();
        int score;
        String line;
        while (true) {
            map.clear();
            fileToMap(filePath, map);
            System.out.println("First name? input x for quit");
            line = scan.nextLine();
            if ("x".equals(line)) {
                break;
            } else if (map.containsKey(line)) {
                System.out.println("student found, now input mark.");
                score = Integer.parseInt(scan.nextLine());
                if (map.containsValue(score)) {
                    System.out.println("record found, do you want to overwrite the score? (y/n)");
                    if ("y".equals(scan.nextLine())) {
                        System.out.println("what is the new score?");
                        score = Integer.parseInt(scan.nextLine());
                        map.replace(line, score);
                        mapToFile(filePath, map);
                        System.out.println("update done");
                    }

                }else{
                    System.out.println("can't find the score, please check again.");
                }

            } else {
                    System.out.println("can't find the student, please check again.");
            }

        }
        scan.close();
    }

}
