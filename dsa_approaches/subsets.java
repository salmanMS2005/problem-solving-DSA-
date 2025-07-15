import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2={1,2,2};
        System.out.println(Arrays.toString(arr));
        List<List<Integer>> ans1=subsets(arr1);
        for(List<Integer> num : ans1){
            System.out.println(num);
        }
        List<List<Integer>> ans2=subsetduplicates(arr2);
        for(List<Integer> num : ans2){
            System.out.println(num);
        }
        permutations("","abc");
    }

static List<List<Integer>> subsets (int[] arr){
        List<List<Integer>> outer =new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num: arr){
            int n=outer.size();
            for(int i=0;i<n;i++){
                ArrayList<Integer> inner =new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
}

/* output : [1, 2, 3]
[]
[1]
[2]
[1, 2]
[3]
[1, 3]
[2, 3]
[1, 2, 3]
*/


static List<List<Integer>> subsetduplicates(int[] arr){
    Arrays.sort(arr);
    List<List<Integer>> outer =new ArrayList<>();
    outer.add(new ArrayList<>());
    int start=0;
    int end=0;
    for(int i=0;i<arr.length;i++){
        if(i>0 && arr[i]==arr[i-1]){
            start=end+1;
        }
        end=outer.size()-1;
        int n=outer.size();
        for(int j=start;j<n;j++){
            ArrayList<Integer> inner=new ArrayList<>(outer.get(j));
            inner.add(arr[i]);
            outer.add(inner);
        }
    }
    return outer;
}

/*
output:
[]
[1]
[2]
[1, 2]
[2, 2]
[1, 2, 2]
*/

static void permutations(String p,String str){
        if(str.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch= str.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String l=p.substring(i,p.length());
            permutations(f+ch+l,str.substring(1));
        }
    }

/*
output:
cba
bca
bac
cab
acb
abc
*/
}
    
