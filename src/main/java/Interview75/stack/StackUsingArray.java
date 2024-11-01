package Interview75.stack;

public class StackUsingArray<T> {
    private int maxSize;
    private T[] stackArray;
    private int top;

    // Constructor to initialize stack
    public StackUsingArray(int size) {
        this.maxSize = size;
        this.stackArray = (T[]) new Object[maxSize];
        this.top = -1; // Stack is initially empty
    }

    // Method to add an element to the stack
    public void push(T value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
        } else {
            stackArray[++top] = value; // Increment top and add the value
            System.out.println(value + " pushed onto stack.");
        }
    }

    // Method to remove an element from the stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            throw new RuntimeException("Stack is empty. Cannot pop.");
        } else {
            return stackArray[top--]; // Return top value and decrement top
        }
    }

    // Method to peek the top element of the stack without removing it
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No top element.");
            throw new RuntimeException("Stack is empty. No top element.");
        } else {
            return stackArray[top];
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Optional: Method to display stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
    public String returnString(){
        String str = "";
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {

            for (int i = 0; i <= top; i++) {
                str += stackArray[i];
            }
        }
        return str;
    }
}
