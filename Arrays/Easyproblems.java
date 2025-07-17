package javacodes;
import java.util.Arrays;
import java.lang.reflect.Array;

public class arrEasy {
    public static void main(String[] args) {
        int[] arr={0,0,4,3,0,8,9,9,0};
        zeroAtLast(arr);
        System.out.println(Arrays.toString(arr));
    }

  //============================================================================================================================================================================
/*283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
  */
  
    public static void zeroAtLast(int[] arr){
        int i=0;
        int j=1;
        while(i<arr.length && j<arr.length){
            if(arr[i]!=0 && arr[j]!=0){
                i++;
                j++;
            }
            else if(arr[i]==0 && arr[j]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
            else if(arr[i]==0 && arr[j]==0){
                j++;
            }
            else if(arr[i]!=0 && arr[j]==0){
                i++;
                j++;
            }
        }
    }
}
