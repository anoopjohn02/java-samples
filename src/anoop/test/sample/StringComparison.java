package anoop.test.sample;

public class StringComparison {
    public static void main(String... args) {
        String text = "single distinct meaningful element of speech or writing";
        StringBuilder builder = new StringBuilder(5);  //  Line 1
        builder.append("abcdefghijklmnopqrstuvwxyz");            //  Line 2
        char[] myCharArray;                                     //  Line 3
        if ("hello" == "hello") myCharArray = new char[5];
        builder.getChars(0, 5, myCharArray, 0);  //  Line 4
        System.out.println(new String(myCharArray).trim() + "*"); // Line 4
    }
}
