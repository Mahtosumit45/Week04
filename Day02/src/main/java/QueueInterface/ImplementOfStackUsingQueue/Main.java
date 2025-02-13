package QueueInterface.ImplementOfStackUsingQueue;
public class Main {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top: " + stack.top());  // Output: 3
        System.out.println("Pop: " + stack.pop());  // Output: 3
        System.out.println("Top after pop: " + stack.top());  // Output: 2
    }
}

