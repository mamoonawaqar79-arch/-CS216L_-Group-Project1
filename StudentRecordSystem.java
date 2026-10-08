import java.util.Scanner;

public class StudentRecordSystem {

    static Scanner sc = new Scanner(System.in);

    static LinkedList list = new LinkedList();
    static Stack stack = new Stack();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== STUDENT RECORD SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Sort by GPA");
            System.out.println("6. Undo Last Delete");
            System.out.println("7. Display Undo Stack");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    list.display();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    list.sort();
                    System.out.println("Students sorted by GPA.");
                    break;

                case 6:
                    undoDelete();
                    break;

                case 7:
                    stack.display();
                    break;

                case 8:
                    System.out.println("Program ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Add Student
    static void addStudent() {

        System.out.print("Enter ID: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID.");
            sc.nextLine();
            return;
        }

        int id = sc.nextInt();

        if (list.idExists(id)) {
            System.out.println("This ID already exists.");
            return;
        }

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Enter GPA (0.0 - 4.0): ");

        if (!sc.hasNextDouble()) {
            System.out.println("Invalid GPA.");
            sc.nextLine();
            return;
        }

        double gpa = sc.nextDouble();

        if (gpa < 0 || gpa > 4) {
            System.out.println("GPA must be between 0 and 4.");
            return;
        }

        list.add(new Student(id, name, gpa));

        System.out.println("Student added successfully.");
    }

    // Search Student
    static void searchStudent() {

        System.out.print("Enter ID to search: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID.");
            sc.nextLine();
            return;
        }

        Student student = list.search(sc.nextInt());

        if (student == null)
            System.out.println("Student not found.");
        else
            System.out.println("Student Found: " + student);
    }

    // Delete Student
    static void deleteStudent() {

        System.out.print("Enter ID to delete: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID.");
            sc.nextLine();
            return;
        }

        Student deleted = list.delete(sc.nextInt());

        if (deleted == null) {
            System.out.println("Student not found.");
        } else {
            stack.push(deleted);
            System.out.println("Student deleted.");
        }
    }

    // Undo Delete
    static void undoDelete() {

        Student student = stack.pop();

        if (student == null) {
            System.out.println("Nothing to undo.");
        } else {
            list.add(student);
            System.out.println("Last delete undone.");
        }
    }
}
