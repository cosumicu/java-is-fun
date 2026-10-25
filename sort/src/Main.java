public class Main {
    public static void main(String[] args) {
        int arr[] = {3, 2, 5, 6, 7, 9, 8, 1};

        System.out.println("unsorted array:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        //bubbleSort(arr);
        selectionSort(arr);
        System.out.println();

        System.out.println("sorted array(selection sort):");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // swap arr[i] and arr[minIdx]
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}