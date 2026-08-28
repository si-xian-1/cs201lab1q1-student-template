import java.util.*;

public class NumbersArray {

    public static void main(String[] args) {
        Integer[] input = {1,2,3,4,1,5};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));       
        
        System.out.println();

        input = new Integer[] {1,2,3,4,1,2,5,3};

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input))); 
    }

    // Write your methods here
    public static int findMax(Integer arr[]) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static Integer[] findDuplicates(Integer arr[]) {
        // Get the largest num in the array to set the array size for all the possible number in arr
        int checked_arr_size = findMax(arr) + 1;
        int checked_arr[] = new int[checked_arr_size];

        // Count total duplicated numbers for duplicate arr size
        int totalDuplicate = 0;

        // Count of each num appearance
        for (int i = 0; i < arr.length; i++) {
            checked_arr[arr[i]] += 1;
        }

        for (int i = 0; i < checked_arr.length; i++) {
            if (checked_arr[i] > 1) {
                totalDuplicate++;
            }
        }

        // Store duplicated array
        Integer duplicate_arr[] = new Integer[totalDuplicate];
        int idx = 0;
        for (int i = 0; i < checked_arr.length; i++) {
            if (checked_arr[i] > 1) {
                duplicate_arr[idx] = i;
                idx++;
            }
        }

        return duplicate_arr;
    }

    public static Integer[] findUnique(Integer arr[]) {
        // Get duplicated array for knowing total unique
        Integer duplicate_arr[] = findDuplicates(arr);
        
        List<Integer> unique_arr = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            boolean isFound = false;

            // Check if number has been duplicated
            for (int j = 0; j < duplicate_arr.length; j++) {
                if (arr[i] == duplicate_arr[j]) {
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                unique_arr.add(arr[i]);
            }
        }

        return unique_arr.toArray(new Integer[unique_arr.size()]);
    }
    
}

