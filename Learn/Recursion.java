package Learn;

import java.util.Scanner;

public class Recursion{
    public static void main(String[] args){
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int value = printName(s,counter);
        System.out.println(value);
    }
    public static int printName(String str,int counter){
        if(counter == 5){
            return counter;
        }
        System.out.println(str);
        return printName(str, counter+1);
        // printName(str, counter+1);
        // return counter;

    }
}