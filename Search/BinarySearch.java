package LAB211.SearchCode;

import java.util.*;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int m = 0;
        int n = arr.length - 1;

        while (m <= n) {
            int mid = m + (n - m) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                m = mid + 1;
            } else {
                n = mid - 1; 
            }
        }

        return -1;
    }
}
