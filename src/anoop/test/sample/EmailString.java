package anoop.test.sample;

public class EmailString {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    private static int numUniqueEmails(String[] emails) {
        int index = 0;
        for (String email : emails){
            String localName = email.substring(0, email.indexOf('@'));
            String domainName = email.substring(email.indexOf('@'));
            localName = localName.replace(".","");
            if(localName.contains("+")){
                localName = localName.substring(0, localName.indexOf('+'));
            }

            String modEmail = localName + domainName;
            boolean isFound = false;
            for (String emailToCheck : emails){
                if(modEmail.equals(emailToCheck)){
                    isFound = true;
                }
            }
            if(!isFound ){
                emails[index] = modEmail;
                index++;
            } else if(modEmail.equals(email)){
                index++;
            }
        }
        return index;
    }
}
