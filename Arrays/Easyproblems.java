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
	int arr3[] = {1, 2, 3, 4, 5}, n = 5;
    		System.out.println(isSorted(arr3, n));
	int arr4[] = {1,1,2,2,2,3,3};
        	int k = removeDuplicates(arr);
        	System.out.println("The array after removing duplicate elements is ");
        	for (int i = 0; i < k; i++) {
            	System.out.print(arr4[i] + " ");
		}
	int n=5;
  		int arr5[]= {1,2,3,4,5};
  		solve(arr5, n);
	int[] arr6 = {1,2,3,4,5,6,7};
		int n = 7;
		int k = 2;
		Rotateeletoleft(arr6, n, k);
		System.out.print("After Rotating the k elements to left ");
		for (int i = 0; i < n; i++){
		System.out.print(arr6[i] + " ");
		}
		System.out.println();
	int arr7[]={1,2,3,4,5};
    		int num = 4;
    		int n = arr7.length;
    		int val = search(arr7,n,num);
	    	System.out.print(val);
	int n = 10, m = 7;
		  int arr81[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		  int arr82[] = {2, 3, 4, 4, 5, 11, 12};
		  ArrayList<Integer> Union = FindUnion(arr81, arr82, n, m);
		  System.out.println("Union of arr1 and arr2 is ");
		  for (int val: Union)
		  System.out.print(val+" ");
	int N = 5;
        	int arr9[] = {1, 2, 4, 5};
        	int ans = missingNumber(arr9, N);
        	System.out.println("The missing number is: " + ans);
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
Input: N = 5, array[] = {1,2,3,4,5}
Output: True.
*/
static boolean isSorted(int arr[], int n) {
    for (int i = 1; i < n; i++) {
      if (arr[i] < arr[i - 1])
        return false;
    }
    return true;
  }
//==============================================================================================================================
/*
Remove Duplicates in-place from Sorted Array
Input: arr[1,1,2,2,2,3,3]
Output: arr[1,2,3,_,_,_,_]
*/
    static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
//=================================================================================================================================
/*
Left Rotate the Array by One
Example 1:
Input: N = 5, array[] = {1,2,3,4,5}
Output: 2,3,4,5,1
*/
static void solve(int arr[], int n) {
  int temp = arr[0]; 
  for (int i = 0; i < n - 1; i++) {
    arr[i] = arr[i + 1];
  }
  arr[n - 1] = temp; 
  for (int i = 0; i < n; i++) {
    System.out.print(arr[i]+" ");
  }
//=================================================================================================================================
/*
Rotate array by K elements
Example 1:
Input: N = 7, array[] = {1,2,3,4,5,6,7} , k=2 , right
Output: 6 7 1 2 3 4 5
*/
 public static void Reverse(int[] arr, int start, int end) {
    while (start <= end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
  public static void Rotateeletoleft(int[] arr, int n, int k) {
    Reverse(arr, 0, k - 1);
    Reverse(arr, k , n - 1);
    Reverse(arr, 0, n - 1);
  }
//==================================================================================================================================
/*
Linear Search in C
Examples:
Example 1:
Input: arr[]= 1 2 3 4 5, num = 3
Output: 2
Explanation: 3 is present in the 2nd index
*/
static int search(int arr[],int n,int num)
{
    int i;
    for(i=0;i<n;i++)
    {
        if(arr[i]==num)
        return i;
    }
    return -1;
}
//====================================================================================================================================	
/*
Union of Two Sorted Arrays
Example 1:
Input:
n = 5,m = 5.
arr1[] = {1,2,3,4,5}  
arr2[] = {2,3,4,4,5}
Output:
 {1,2,3,4,5}
*/
static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
   int i = 0, j = 0;
  ArrayList<Integer > Union=new ArrayList<>(); 
  while (i < n && j < m) {
    if (arr1[i] <= arr2[j])
    {
      if (Union.size() == 0 || Union.get(Union.size()-1) != arr1[i])
        Union.add(arr1[i]);
      i++;
    } else 
    {
      if (Union.size() == 0 || Union.get(Union.size()-1) != arr2[j])
        Union.add(arr2[j]);
      j++;
    }
  }
  while (i < n)
  {
    if (Union.get(Union.size()-1) != arr1[i])
      Union.add(arr1[i]);
    i++;
  }
  while (j < m)
  {
    if (Union.get(Union.size()-1) != arr2[j])
      Union.add(arr2[j]);
    j++;
  }
  return Union;
}
//===============================================================================================================================
/*
Find the missing number in an array
Example 1:
Input Format: N = 5, array[] = {1,2,4,5}
Result: 3
Explanation: In the given array, number 3 is missing. So, 3 is the answer.
*/
    public static int missingNumber(int []a, int N) {

        //Summation of first N numbers:
        int sum = (N * (N + 1)) / 2;

        //Summation of all array elements:
        int s2 = 0;
        for (int i = 0; i < N - 1; i++) {
            s2 += a[i];
        }

        int missingNum = sum - s2;
        return missingNum;
    }
}
