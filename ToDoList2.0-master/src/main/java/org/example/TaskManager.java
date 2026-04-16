package org.example;

import java.io.*;
import java.util.*;

public class TaskManager {
    public ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String text) {
        int newId = tasks.size() + 1;
        Task task = new Task(newId, text);
        tasks.add(task);
        saveToFile();
    }

    public boolean removeTask(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).id == id) {
                tasks.remove(i);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public boolean editTask(int id, String newText) {
        for (Task task : tasks) {
            if (task.id == id) {
                task.text = newText;
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public void saveToFile() {
        try {
            PrintWriter writer = new PrintWriter("tasks.txt");
            for (Task task : tasks) {
                writer.println(task.id + "," + task.text + "," + task.done);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении");
        }
    }

    public void loadFromFile() {
        try {
            File file = new File("tasks.txt");
            if (!file.exists()) return;

            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    int id = Integer.parseInt(parts[0]);
                    String text = parts[1];
                    boolean done = Boolean.parseBoolean(parts[2]);
                    Task task = new Task(id, text);
                    task.done = done;
                    tasks.add(task);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Ошибка при загрузке");
        }
    }

    public TaskManager() {
        loadFromFile();
    }
}