public class LinkedList {

    class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
        }
    }

    Node head;

    // Add student
    void add(Student student) {
        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null)
                temp = temp.next;

            temp.next = newNode;
        }
    }

    // Linear Search
    Student search(int id) {
        Node temp = head;

        while (temp != null) {
            if (temp.student.id == id)
                return temp.student;

            temp = temp.next;
        }

        return null;
    }

    // Delete student
    Student delete(int id) {

        if (head == null)
            return null;

        if (head.student.id == id) {
            Student deleted = head.student;
            head = head.next;
            return deleted;
        }

        Node temp = head;

        while (temp.next != null) {

            if (temp.next.student.id == id) {
                Student deleted = temp.next.student;
                temp.next = temp.next.next;
                return deleted;
            }

            temp = temp.next;
        }

        return null;
    }

    // Bubble Sort by GPA
    void sort() {

        if (head == null || head.next == null)
            return;

        boolean changed;

        do {
            changed = false;
            Node temp = head;

            while (temp.next != null) {

                if (temp.student.gpa > temp.next.student.gpa) {

                    Student swap = temp.student;
                    temp.student = temp.next.student;
                    temp.next.student = swap;

                    changed = true;
                }

                temp = temp.next;
            }

        } while (changed);
    }

    // Display students
    void display() {

        if (head == null) {
            System.out.println("No records found.");
            return;
        }

        System.out.println("\n----- Student Records -----");
        System.out.println("ID\tName\t\tGPA");
        System.out.println("----------------------------");

        Node temp = head;

        while (temp != null) {
            System.out.println(temp.student);
            temp = temp.next;
        }
    }

    // Check duplicate ID
    boolean idExists(int id) {
        return search(id) != null;
    }
}
