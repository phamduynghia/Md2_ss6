import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class exercise3_ss6 {
    public static void main(String[] args) {

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an email address to validate: ");
        String email = scanner.nextLine();

        if (email.matches(regex)) {
            System.out.println("The email address is valid.");
        } else {
            System.out.println("The email address is invalid.");
        }

        scanner.close();
    }
}

