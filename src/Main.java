import java.util.Arrays;

// Бинарный поиск по массиву с рекурсией без использования Arrays.binarySearch
public class Main {
    public static void main(String[] args) {
        int[] testArrays = {3, 6, 7, 10, 11, 12, 15, 19, 21, 22, 25, 29};
        int searchNum = 3;
        System.out.println("Исходный массив: " + Arrays.toString(testArrays));
        System.out.println("Искомый элемент: " + searchNum);
        SortedArrays newArrays = new SortedArrays();
        int[] resultsNewArrays = newArrays.sortedArrays(testArrays);
        System.out.println("Отсортированный массив: " + Arrays.toString(resultsNewArrays));
        int startPoint = 0;
        int endPoint = resultsNewArrays.length;
        System.out.println(binarySearchWithRecursion(startPoint, endPoint, searchNum, resultsNewArrays));
    }

    public static int binarySearchWithRecursion(int startPoint, int endPoint, int searchNum, int[] resultsNewArrays) {
        int result = resultsNewArrays[(startPoint + endPoint) / 2];
        if (result == searchNum) {
            return result;
        } else if (result > searchNum) {
            endPoint = (startPoint + endPoint) / 2;
            result = resultsNewArrays[(startPoint + endPoint) / 2];
            binarySearchWithRecursion(startPoint, endPoint, searchNum, resultsNewArrays);
        } else if (result < searchNum) {
            startPoint = (startPoint + endPoint) / 2;
            result = resultsNewArrays[(startPoint + endPoint) / 2];
            binarySearchWithRecursion(startPoint, endPoint, searchNum, resultsNewArrays);
        }
        return result;
    }
}

