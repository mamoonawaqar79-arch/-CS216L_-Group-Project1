public class Stack {

    Student[] data = new Student[100];
    int top = -1;

    // Push
    void push(Student student) {

        if (top == data.length - 1) {
            System.out.println("Stack is full.");
            return;
        }

        data[++top] = student;
    }

    // Pop
    Student pop() {

        if (isEmpty())
            return null;

        return data[top--];
    }

    // Check empty
    boolean isEmpty() {
        return top == -1;
    }

    // Display stack
    void display() {

        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.println("\n----- Undo Stack -----");

        for (int i = top; i >= 0; i--)
            System.out.println(data[i]);
    }
}
