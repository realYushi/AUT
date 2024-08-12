/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task04_1;

/**
 * @author yushi
 */
public class MathQuizLauncher {

    // Configuration
    private static final int ROUND = 10;
    private static final String EXIT_COMMAND = "x";
    private static final String FILE_NAME = "resources/T04_users.txt";

    public static void main(String[] args) {
        // Start the CUI
        ICUI cui = new CUI(ROUND, EXIT_COMMAND, FILE_NAME);
        cui.start();
    }


}
