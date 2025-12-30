package anoop.test.sample.String;

public class StringSamples {
    public static void main(String[] args) {
        String s1="anoop";
        String s2="anoop";
        String s3=s1;
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        s1="teena";
        System.out.println(s1==s3);
        System.out.println(s1.equals(s3));
        String s4=new String("anoop");
        System.out.println(s1==s4);
        System.out.println(s1.equals(s4));
    }
}
