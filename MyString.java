import java.util.*;
public class MyString{
    public static void main(String[] args) {
        String s = new String("Hello World");
        String str = "New Name";
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();

        int length = str.length();
        char c = str.charAt(0);
        String sub = s.substring(0,5);
        char[] ch = s.toCharArray();
        String words = str.split(" ");
        int index = str.indexOf("World");
    }
}