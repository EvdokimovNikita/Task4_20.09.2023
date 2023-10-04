import java.util.Arrays;
public class SortedArrays {
    public int[] sortedArrays(int[] testArrays){
        Arrays.sort(testArrays);
        return testArrays;
    }
}

// It would look better this way:
class ArrayUtils {
    public int[] sort(int[] array) {
        Arrays.sort(array);
        return array;
    }
}
