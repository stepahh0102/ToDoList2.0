package org.example;

import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        label:
        while (true) {
            System.out.println("\n МОИ ЗАДАЧИ :)");
            System.out.println("1. Показать задачи");
            System.out.println("2. Добавить задачу");
            System.out.println("3. Удалить задачу");
            System.out.println("4. Изменить задачу");
            System.out.println("5. Выйти");
            System.out.print("Выберите: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showTasks(manager);
                    break;
                case "2":
                    addTask(manager, scanner);
                    break;
                case "3":
                    removeTask(manager, scanner);
                    break;
                case "4":
                    editTask(manager, scanner);
                    break;
                case "5":
                    System.out.println("Выход");
                    break label;
                default:
                    System.out.println("Неверный выбор!");
                    break;
            }
        }

        scanner.close();
    }

    static void showTasks(TaskManager manager) {
        System.out.println("\n Ваши задачи");
        if (manager.tasks.isEmpty()) {
            System.out.println("Нет задач");
        } else {
            for (Task task : manager.tasks) {
                System.out.println(task);
            }
        }
    }

    static void addTask(TaskManager manager, Scanner scanner) {
        System.out.print("Введите задачу: ");
        String text = scanner.nextLine();
        if (text.isEmpty()) {
            System.out.println("Задача пустая!");
        } else {
            manager.addTask(text);
            System.out.println("Задача добавлена!");
        }
    }

    static void removeTask(TaskManager manager, Scanner scanner) {
        showTasks(manager);
        if (!manager.tasks.isEmpty()) {
            System.out.print("Введите номер задачи для удаления: ");
            try {
                int id = Integer.parseInt(scanner.nextLine());
                if (manager.removeTask(id)) {
                    System.out.println("Задача удалена!");
                } else {
                    System.out.println("Задача не найдена!");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода!");
            }
        }
    }

    static void editTask(TaskManager manager, Scanner scanner) {
        showTasks(manager);
        if (!manager.tasks.isEmpty()) {
            System.out.print("Введите номер задачи для изменения: ");
            try {
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите новый текст: ");
                String newText = scanner.nextLine();
                if (manager.editTask(id, newText)) {
                    System.out.println("Задача изменена!");
                } else {
                    System.out.println("Задача не найдена!");
                }
            } catch (Exception e) {
                System.out.println("Ошибка ввода!");
            }
        }
    }
}