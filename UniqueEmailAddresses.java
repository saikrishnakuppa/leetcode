import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        // hash set to store all the unique emails
        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            // split into two parts local and domain
            String[] parts = email.split("@");

            // split local by '+'
            String[] local = parts[0].split("\\+");

            // remove all '.', and concatenate '@' and append domain
            uniqueEmails.add(local[0].replace(".", "") + "@" + parts[1]);
        }

        return uniqueEmails.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}; 
        UniqueEmailAddresses sol = new UniqueEmailAddresses();
        System.out.println(sol.numUniqueEmails(emails));
    }
}