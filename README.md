
Project Title
Student Record System

Description
The Student Record System is a small console-based Java application used to manage student records.

The system stores student information such as Student ID, Name, and GPA using a singly linked list. A stack is used to implement the undo feature for the last deleted student.

The project also implements Linear Search to find students by ID and Bubble Sort to sort students according to their GPA.

Data Structures Used
1. Singly Linked List
A singly linked list is used to store student records.

Each node contains:

Student ID
Student Name
GPA
Reference to the next node
2. Stack
A stack is used to store deleted student records so that the most recently deleted student can be restored using the Undo operation.

The stack implements:

Push
Pop
isEmpty
Algorithms Used
Searching
The project uses Linear Search to search for a student by Student ID.

Sorting
The project uses Bubble Sort to sort students by GPA in ascending order.

Features
The system provides the following features:

Add Student
Display Students
Search Student
Delete Student
Sort Students by GPA
Undo Last Delete
Exit
Input Validation
The program includes input validation for:

Menu choices
Student ID
Duplicate Student ID
Student name
GPA range
The GPA must be between 0.0 and 4.0.

Time Complexity
Operation	Data Structure / Algorithm	Time Complexity
Insert / Add Student	Singly Linked List	O(n)
Delete Student	Singly Linked List	O(n)
Search Student	Linear Search	O(n)
Sort by GPA	Bubble Sort	O(n²)
Push	Stack	O(1)
Pop	Stack	O(1)
Complexity Explanation
Insert / Add — O(n):
A new student is added at the end of the linked list. The program may need to traverse all existing nodes to reach the last node.

Delete — O(n):
The program searches for the student ID before deleting the node. In the worst case, it may traverse the complete linked list.

Search — O(n):
Linear Search checks students one by one. In the worst case, all students may need to be checked.

Sort — O(n²):
Bubble Sort repeatedly compares adjacent students. Its worst-case time complexity is O(n²).

Push — O(1):
A student is added directly to the top of the stack.

Pop — O(1):
A student is removed directly from the top of the stack.

Project Structure
Student Record System
│
├── SearchSort.java
└── README.md
