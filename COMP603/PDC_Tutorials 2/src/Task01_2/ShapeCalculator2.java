/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task01_2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author yushi
 */
public class ShapeCalculator2 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please select:");
        System.out.println("(1) Rectangle");
        System.out.println("(2) Circle");
        System.out.println("(3) Square");
        try {
            int input = scan.nextInt();

            switch (input) {
                case 1:
                    System.out.println("Please input Width");
                    double width = scan.nextFloat();
                    System.out.println("Please input Length");
                    double length = scan.nextFloat();
                    Rectangle rec = new Rectangle(width, length);
                    rec.calculateArea();
                    rec.printInfo();
                    break;
                case 2:
                    System.out.println("Please input Radius");
                    double r = scan.nextFloat();
                    Circle cir = new Circle(r);
                    cir.calculateArea();
                    cir.printInfo();
                    break;
                case 3:
                    System.out.println("Please input Side Length");
                    double side = scan.nextFloat();
                    Square squ = new Square(side);
                    squ.calculateArea();
                    squ.printInfo();
                    break;
                default:
                    System.out.println("Wrong input");
                    break;

            }

        } catch (InputMismatchException e) {
            System.out.println("System.out.println(\"Invalid input. Not an integer\");");
        } finally {
            scan.close();
        }

    }
}
