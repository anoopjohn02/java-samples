package anoop.test.sample;


public class MultiplyStringNums {

    public static void main(String[] args) {

        System.out.println("Answer: " + multiply("123", "456"));

    }

    public static String multiply(String num1, String num2) {
        int [] record = new int[num1.length() + num2.length()];
        for(int i = num1.length() -1 ; i>=0; i--){
            System.out.println("WHEN I = "+ i +": " + convert(record));
            for(int j = num2.length() -1 ; j>=0; j--){
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int mult = n1 * n2;

                int p1 = i + j;
                int p2 = i + j + 1;

                int sum = mult + record[p2];
                record[p1] = record[p1] + (sum/10);
                record[p2] = sum % 10;
                System.out.println("    When J = "+ j +": " + convert(record));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int reco : record){
            if(!(sb.length() == 0 && reco == 0)){
                sb.append(reco);
            }
        }

        return sb.toString();
    }

    private static String convert(int [] record){
        StringBuilder sb = new StringBuilder();
        for(int reco : record){
            sb.append(reco);
        }
        return sb.toString();
    }

}
