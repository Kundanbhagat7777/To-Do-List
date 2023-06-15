import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList {
    private final List<String> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid index!");
        }
    }

    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("\n=== Todo List ===");
            System.out.println("1. Add a task");
            System.out.println("2. Remove a task");
            System.out.println("3. Display tasks");
            System.out.println("4. Quit");
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the task: ");
                    String task = scanner.nextLine();
                    todoList.addTask(task);
                }
                case 2 -> {
                    System.out.print("Enter the index of the task to remove: ");
                    int index = scanner.nextInt();
                    todoList.removeTask(index);
                }
                case 3 -> todoList.displayTasks();
                case 4 -> {
                    quit = true;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }
}
