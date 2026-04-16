package org.example;

public class TaskManagerTest {

    public static void main(String[] args) {
        System.out.println("запуск тестаф поихали\n");

        TaskManager manager = new TaskManager();
        manager.addTask("Тестовая задача");

        if (manager.tasks.size() == 1) {
            System.out.println("ура пополнение задач");
        } else {
            System.out.println("увы, задачи не добавились");
        }

        manager.addTask("Задача для удаления");
        boolean deleted = manager.removeTask(2);

        if (deleted && manager.tasks.size() == 1) {
            System.out.println("ура, удалилось");
        } else {
            System.out.println("блин( не удалилось(");
        }

        // Тест 3: Изменение задачи
        boolean edited = manager.editTask(1, "Измененный текст");

        if (edited && manager.tasks.getFirst().text.equals("Измененный текст")) {
            System.out.println("оооо есть изменения");
        } else {
            System.out.println("ничё не поменялось");
        }

        System.out.println("\nпака");
    }
}