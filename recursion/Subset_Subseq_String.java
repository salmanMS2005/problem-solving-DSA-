package javacodes;
import java.util.*;
public class Subset_Subseq_String {
    public static void main(String[] args) {
        String str="abbsdfa";
        Skip("",str);
        System.out.println();
        String str2="hfhfgaavfh";
        System.out.println(Skip2(str2));
        System.out.println();
        String str3="abc";
        seq("",str3);
        permutations("","abc");
        System.out.println(letterCombinations("23"));
        System.out.println(dices("",4));
    }
    static void Skip(String ans,String str){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch=str.charAt(0);
        if(ch=='a'){
            Skip(ans,str.substring(1));
        }else{
            Skip(ans+ch,str.substring(1));
        }
    }

    static String Skip2(String str){
        if(str.isEmpty()){
            return "";
        }
        char ch=str.charAt(0);
        if(ch=='a'){
            return Skip2(str.substring(1));
        }
        else{
            return ch + Skip2(str.substring(1));
        }
    }
    static void seq(String ans ,String str){
        if(str.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch=str.charAt(0);
        seq(ans+ch,str.substring(1));
        seq(ans,str.substring(1));
    }

    
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

//===================================================================================================================================


/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

    public static List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<String>();
        }

        List<String> list= new ArrayList<>();
        int limit=digits.charAt(0)-'0';
        int i=(limit-2)*3;
        if(limit>7){
            i+=1;
        }
        int len=i+3;
        if(limit==7||limit==9){
            len+=1;
        }

        for(;i<len;i++){
            char ch= (char)(i+'a');
            List<String> sublist=letterCombinations(digits.substring(1));
            if(sublist.isEmpty()){
                list.add(""+ch);
            }else{
                for(String str:sublist){
                    list.add(ch+str);
                }
            } 
        }
        return list;
    }
//===========================================================================================================================
    public static List<String> dices(String p,int target){
        if(target==0){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> ans=new ArrayList<>();
        for(int i=1;i<=6 && i<=target;i++){
            ans.addAll(dices(p+i,target-i));
        }
        return ans;
    }

/*
output:
[1111, 112, 121, 13, 211, 22, 31, 4]
*/
//=============================================================================================================================
}
