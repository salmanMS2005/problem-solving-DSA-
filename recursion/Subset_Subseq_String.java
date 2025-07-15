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
}
