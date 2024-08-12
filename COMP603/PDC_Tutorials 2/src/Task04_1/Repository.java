/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task04_1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yushi
 */
interface IRepository {
    void load(IUser user);

    void save(IUser user);

}

public class Repository implements IRepository {
    // Configuration
    private final String fileName;

    public Repository(String fileName) {
        this.fileName = fileName;
    }

    // Load the user's score from the file
    @Override
    public void load(IUser user) {
        File file = initialFile(user);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while (true) {
                if ((line = reader.readLine()) == null)
                    break;
                line = line.trim();
                String[] pairs = line.split(" ");
                if (pairs[0].equals(user.getName())) {
                    user.setScore(Integer.parseInt(pairs[1]));
                    break;
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }

    // initialize the file, if it does not exist
    private File initialFile(IUser user) {
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(String.format("%s %d", user.getName(), user.getScore()));
                writer.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return file;
    }

    // Save the user's score to the file
    @Override
    public void save(IUser user) {
        Map<String, Integer> users = new HashMap<>();
        File file = initialFile(user);
        if (file.length() == 0) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write(String.format("%s %d", user.getName(), user.getScore()));
                writer.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
            while (true) {
                String line;
                if ((line = reader.readLine()) == null)
                    break;
                line = line.trim();
                String[] pairs = line.split(" ");
                users.put(pairs[0], Integer.parseInt(pairs[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        users.put(user.getName(), user.getScore());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, Integer> entry : users.entrySet()) {
                writer.write(String.format("%s %d", entry.getKey(), entry.getValue()));
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
