package javacodes;
import java.util.Arrays;
import java.lang.reflect.Array;

public class arrEasy {
    public static void main(String[] args) {
        int[] arr={0,0,4,3,0,8,9,9,0};
        zeroAtLast(arr);
        System.out.println(Arrays.toString(arr));
        int arr1[] =  {2,5,1,3,0};
        System.out.println(findLargestElement(arr1));
        int[] arr2 = {1, 2, 4, 6, 7, 5};
	    int n = arr.length;
	    getElements(arr2, n);

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
//======================================================================================================================================
/*
Example 1:
Input: arr[] = {2,5,1,3,0};
Output: 5
Explanation: 5 is the largest element in the array. 
    */
static int findLargestElement(int arr[]) {
    int max= arr[0];
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        max= arr[i];
      }
    }
    return max;
  }
//======================================================================================================================================
/*
Example 1:
Input: [1,2,4,7,7,5]
Output: Second Smallest : 2
Second Largest : 5
*/
static private void secondSmallLarge(int[] arr, int n)
{
if (n == 0 || n==1)
	{
		System.out.print(-1);
		System.out.print(" ");
		System.out.print(-1);
		System.out.print("\n");
	}
	int small = Integer.MAX_VALUE;
	int second_small = Integer.MAX_VALUE;
	int large = Integer.MIN_VALUE;
	int second_large = Integer.MIN_VALUE;
	int i;
	for (i = 0;i < n;i++)
	{
		small = Math.min(small,arr[i]);
		large = Math.max(large,arr[i]);
	}
	for (i = 0;i < n;i++)
	{
		if (arr[i] < second_small && arr[i] != small)
		{
			second_small = arr[i];
		}
		if (arr[i] > second_large && arr[i] != large)
		{
			second_large = arr[i];
		}
	}
	System.out.println("Second smallest is "+second_small);
	System.out.println("Second largest is "+second_large);
}
//============================================================================================================================   
/*

*/
}
