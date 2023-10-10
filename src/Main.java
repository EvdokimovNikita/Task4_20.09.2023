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
        for (int i = 0; i < 50; i++) {
            // With the convenience method you don't need to pass 0 and array length each time you call the search.
            //int startPoint = 0;
            //int endPoint = resultsNewArrays.length;
            // Need better console output:
            System.out.println("Input: " + i + "; Output: " + binarySearchWithRecursion(i, resultsNewArrays));
            // Also you don't need separate vars to pass the value into method:
            //System.out.println(binarySearchWithRecursion(0, resultsNewArrays.length, i, resultsNewArrays));
        }
    }

    // Convenience method:
    // Also pay attention to parameter names, they are searcher and clearer, try to use more
    // compact variables naming:
    public static int binarySearchWithRecursion(int value, int[] array) {
        //return binarySearchWithRecursion(0, array.length, value, array);
        // Empty array check for improved method:
        if (array.length == 0) {
            return -1;
        }
        // Warning: 'improved' method needs array.length - 1 as param
        return binarySearchWithRecursionImproved(0, array.length - 1, value, array);
    }

    public static int binarySearchWithRecursion(int startPoint, int endPoint, int searchNum, int[] resultsNewArrays) {
        // As soon as you calculate (startPoint + endPoint) / 2 twice in the method,
        // it's nice to have it as a separate variable.
        int mid = (startPoint + endPoint) / 2;
        int result = resultsNewArrays[mid];
        if (result == searchNum) {
            return mid;
        } else if (result > searchNum) {
            // Those halt conditions are fine but it can be rewritten to only have return -1 once.
            // Check method binarySearchWithRecursionImproved
            if (startPoint + 1 == endPoint) {
                return -1;
            }
            endPoint = (startPoint + endPoint) / 2;
            // 2 returns are not necessary, you may just return once after ifs (see improved method).
            return binarySearchWithRecursion(startPoint, endPoint, searchNum, resultsNewArrays);
            // Pay attention idea says that if (result < searchNum) always true
            // indeed this condition is not needed there
        } else if (result < searchNum) {
            if (startPoint == endPoint - 1) {
                return -1;
            }
            startPoint = (startPoint + endPoint) / 2;
            return binarySearchWithRecursion(startPoint, endPoint, searchNum, resultsNewArrays);
        }

        return result;
    }

    // Pseudocode is there: https://atechdaily.com/posts/Algorithm-for-Binary-Search?q=trading+tips#gsc.tab=0&gsc.q=trading%20tips&gsc.page=1
    // Can you writhe java code using this pseudocode?
    // Btw, this pseudocode is bad for recursion as it will crash for empty array.
    // To avoid crash there can be additional in convenience method.
    public static int binarySearchWithRecursionImproved(int start, int end, int value, int[] array) {
        int mid = (start + end) / 2;
        int result = array[mid];
        if (result == value) {
            return mid;
        }
        if (start >= end) {
            return -1;
        }
        if (result < value) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
        return binarySearchWithRecursionImproved(start, end, value, array);
    }
}

