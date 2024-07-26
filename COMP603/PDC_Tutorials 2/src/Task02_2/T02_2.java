/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task02_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yushi
 */
public class T02_2 {

    public static void main(String[] args) {
        String inputFile = "./resources/T02_input.txt";
        String outputFile = "./resources/T02_output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String cleanup = line.replaceAll("[^a-zA-Z]+", "").toUpperCase();
                String result = new StringBuilder(cleanup).reverse().toString();
                bw.write(result);
                bw.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(T02_2.class.getName()).log(Level.SEVERE, "An error occurred", ex);
        }
    }
}

