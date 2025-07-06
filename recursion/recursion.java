package javacodes;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        pattern1(0,0,4);
        int[] arr={2,7,5,4,6,8};
        int[] mergearr={8,7,6,5,4,3,2,1};
        int[] bubble=bubblesort(arr,0, 1,arr.length-1);
        int[] selection=selectionsort(arr,0,1,0);
        mergesortInplace(mergearr,0,mergearr.length);
        System.out.println(Arrays.toString(mergearr));
        System.out.println(Arrays.toString(bubble));
        System.out.println(Arrays.toString(selection));
        
    }
    //Pattern
    static void pattern1(int r,int c,int n){
        if(r==n){
            return;
        }
        if(c<=r){
            System.out.print("*");
            pattern1(r,c+1,n);
        }
        else{
            System.out.println();
            pattern1(r+1,0,n);
        }
    }//end

    
    //Bubblesort
    static int[] bubblesort(int[] arr,int l,int r,int len){
        if(len==1){
            return arr;
        }
        if(arr[l]>arr[r]){
            swap(arr,l,r);
        }
        if(r<len){
            return bubblesort(arr,l+1,r+1,len);
        }
        else{
            return bubblesort(arr,0,1,len-1);
        }
    }//end
    
//Selectionsort
    static int[] selectionsort(int[] arr,int l,int r,int min){
        if(l== arr.length-1){
            return arr;
        }
        if(r<arr.length){
            if(arr[min]>arr[r]) {
                min = r;
            }
            return selectionsort(arr, l, r + 1,min);
        }
        swap(arr, l,min);
        return selectionsort(arr,l+1,l+2,l+1);
    }


static void swap(int[] arr, int l, int r) {
    int temp=arr[l];
    arr[l]=arr[r];
    arr[r]=temp;
}//end

    
//Mergesort inplace:   
static void mergesortInplace(int[] arr,int s,int e){
        if(e-s==1){
            return;
        }
        int mid=s + (e-s)/2;
        mergesortInplace(arr,s,mid);
        mergesortInplace(arr,mid,e);
        merge(arr,s,mid,e);
}

static void merge(int[] arr,int s,int mid,int e){
        int[] mix=new int[e-s];

        int i=s;
        int j=mid;
        int k=0;

        while(i<mid && j<e){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
                k++;
            }
            else{
                mix[k]=arr[j];
                j++;
                k++;
            }
        }
        while(i<mid){
            mix[k]=arr[i];
            i++;
            k++;
        }
        while(j<e){
            mix[k]=arr[j];
            j++;
            k++;
        }
        for(int l=0;l<mix.length;l++){
            mix[l+s]=arr[l];
        }
}
//end

  
}
