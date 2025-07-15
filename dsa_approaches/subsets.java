import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(Arrays.toString(arr));
        List<List<Integer>> ans=subsets(arr);
        for(List<Integer> num : ans){
            System.out.println(num);
        }
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
