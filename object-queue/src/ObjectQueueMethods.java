import java.util.Random;

public class ObjectQueueMethods {
    //====================ADDITIONAL METHODS======================


    // shuffles the queue, implementing Fisher–Yates shuffle
    static void shuffleQueue(ObjectQueue queue)
    {
        Random rand = new Random(); // created an object of a Random class

        for (int i = 0; i < queue.getSize() - queue.countNullValues(); i++) // this loop runs from 0 to size of the queue - 1
        {
            int randomIndex = rand.nextInt((queue.getSize() - queue.countNullValues())); // gives a random index from queue

            Object temp = queue.getQueueElement(i); // stores the first element of the queue to temp for swapping

            // performs the swapping if the random element is not null
            if(temp != null) {
                queue.setQueueElement(queue.getQueueElement(randomIndex), i);
                queue.setQueueElement(temp, randomIndex);
            }
        }
    }

    static void swapElement(ObjectQueue queue, int index1, int index2) {
        // these 3 lines of code swap values of queue in given indexes
        Object temp = queue.getQueueElement(index1);
        queue.setQueueElement(queue.getQueueElement(index2), index1);
        queue.setQueueElement(temp, index2);
    }

    // change all values according to their index number
    static void toIndexes(ObjectQueue queue) {
        for(int i = 0; i < queue.getSize(); i++) {
            queue.setQueueElement(i, i);
        }
    }

}
