import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        int choice = 0;
        int size;
        Scanner scan = new Scanner(System.in);

        // gets the maximum size from the user
        System.out.println("Enter the maximum size of the queue: ");
        size = scan.nextInt();

        ObjectQueue queue = new ObjectQueue(size); // instantiates an ObjectQueue class

        while(true) {
            // choices for transaction
            System.out.print("""
                    [1] Add an element
                    [2] Dequeue
                    [3] Display first element
                    [4] Display last element
                    [5] Is my queue empty?
                    [6] Shuffle the queue
                    [7] swap element/position
                    [8] change elements to its index
                    [9] Display queue
                    [0] Exit
                    """);

            choice = scan.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter an element to be added: ");
                    queue.enQueue(scan.next()); // add the element to be scanned, accepts numerical and string values as objects
                }
                case 2 -> {
                    queue.deQueue(); // remove the first element in the queue
                    System.out.println("Dequeued successfully.");
                }
                case 3 -> {
                    System.out.print("Displaying first element: ");
                    queue.displayFirstElement(); // displays first element
                }
                case 4 -> {
                    System.out.print("Displaying last element: ");
                    queue.displayLastElement(); // displays last element
                }
                case 5 -> {
                    if (queue.isEmpty()) { // check if empty
                        System.out.print("queue is empty.\n");
                    } else {
                        System.out.print("queue is not empty.\n");
                    }
                }
                case 6 -> ObjectQueueMethods.shuffleQueue(queue); // shuffle elements of the queue
                case 7 -> {
                    System.out.println("Enter the position of the value: ");
                    int a = scan.nextInt();
                    System.out.println("Enter the position of the value you want to swap with: ");
                    int b = scan.nextInt();
                    ObjectQueueMethods.swapElement(queue, (a-1), (b-1));
                    System.out.println("swapped successfully.");
                }
                case 8 -> {
                    ObjectQueueMethods.toIndexes(queue);
                    System.out.println("changed successfully.");
                }
                case 9 -> queue.displayElements(); // display all elements in the queue
                case 0 -> System.exit(0); // exit
                default -> {
                }
            }
        }
    }
}