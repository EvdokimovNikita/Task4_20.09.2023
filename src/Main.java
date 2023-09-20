import java.util.Arrays;

// Бинарный поиск по массиву с рекурсией без использования Arrays.binarySearch
public class Main {
    public static void main(String[] args) {
        int[] testArrays = {2, 3, 6, 7, 10, 11, 12, 15, 19, 21, 22, 25, 29, 32, 33, 42};
        /*System.out.println("Исходный массив: " + Arrays.toString(testArrays));
        int searchNum = 412;*/
        //System.out.println("Искомый элемент: " + searchNum);
        SortedArrays newArrays = new SortedArrays();
        int[] resultsNewArrays = newArrays.sortedArrays(testArrays);
        System.out.println("Отсортированный массив: " + Arrays.toString(resultsNewArrays));
        /*int startPoint = 0;
        int endPoint = resultsNewArrays.length;
        System.out.println(binarySearchWithRecursion(startPoint, endPoint, searchNum, resultsNewArrays));*/
        for (int i = 0; i < 44; i++) {
            int startPoint = 0;
            int endPoint = resultsNewArrays.length;
            System.out.println(binarySearchWithRecursion(startPoint, endPoint, i, resultsNewArrays));
        }
    }

    public static int binarySearchWithRecursion(int startPoint, int endPoint, int searchNum, int[] resultsNewArrays) {
        int result = resultsNewArrays[(startPoint + endPoint) / 2];
        if (result == searchNum) {
            return (startPoint + endPoint) / 2;
        } else if (result > searchNum) {
            if (startPoint+1 == endPoint) {
                return -1;
            }
            endPoint = (startPoint + endPoint) / 2;
            return binarySearchWithRecursion(startPoint, endPoint, searchNum, resultsNewArrays);
        } else if (result < searchNum) {
            if (startPoint == endPoint - 1) {
                return -1;
            }
            startPoint = (startPoint + endPoint) / 2;
            return binarySearchWithRecursion(startPoint, endPoint, searchNum, resultsNewArrays);
        }

        return result;
    }
}

