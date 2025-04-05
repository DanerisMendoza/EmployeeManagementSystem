package challenges.easy;


import java.util.ArrayList;
import java.util.Arrays;

public class removeDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,4,5,6};
        ArrayList<Integer> uniqueArr = new ArrayList<Integer>();
        System.out.println(Arrays.toString(arr));
        for (int i=0; i<arr.length; i++){
            if(!uniqueArr.contains(arr[i])){
               uniqueArr.add(arr[i]);
            }
        }
        System.out.println(uniqueArr);
    }
}
