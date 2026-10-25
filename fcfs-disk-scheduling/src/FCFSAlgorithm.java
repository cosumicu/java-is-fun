import java.util.*;

public class FCFSAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of disk requests
        System.out.print("Enter the number of disk requests: ");
        int numRequests = scanner.nextInt();

        // Get the starting position of the disk head
        System.out.print("Enter the starting position of the disk head: ");
        int headPos = scanner.nextInt();

        // Get the positions of the disk requests
        int[] requests = new int[numRequests];
        System.out.println("Enter the positions of the disk requests:");
        for (int i = 0; i < numRequests; i++) {
            requests[i] = scanner.nextInt();
        }

        // Simulate the FCFS algorithm
        int totalHeadMovement = 0;
        int currentPos = headPos;
        for (int i = 0; i < numRequests; i++) {
            int distance = Math.abs(requests[i] - currentPos);
            totalHeadMovement += distance;
            currentPos = requests[i];
        }

        // Print the total head movement
        System.out.println("Total head movement: " + totalHeadMovement);
    }
}