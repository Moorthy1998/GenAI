import java.io.Console;
import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        String oldPassword = "java123";
        Console console = System.console();
        Scanner sc = null;

        String enteredPassword;
        if (console != null) {
            enteredPassword = new String(console.readPassword("Enter old password: "));
        } else {
            sc = new Scanner(System.in);
            System.out.print("Enter old password: ");
            enteredPassword = sc.nextLine();
        }

        if (!enteredPassword.equals(oldPassword)) {
            System.out.println("Incorrect password. Reset denied.");
            if (sc != null) sc.close();
            return;
        }

        String newPassword;
        String confirmPassword;
        if (console != null) {
            newPassword = new String(console.readPassword("Enter new password: "));
            confirmPassword = new String(console.readPassword("Confirm new password: "));
        } else {
            System.out.print("Enter new password: ");
            newPassword = sc.nextLine();
            System.out.print("Confirm new password: ");
            confirmPassword = sc.nextLine();
        }

        if (!newPassword.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Reset denied.");
            if (sc != null) sc.close();
            return;
        }

        if (newPassword.length() < 6) {
            System.out.println("New password must be at least 6 characters. Reset denied.");
            if (sc != null) sc.close();
            return;
        }

        if (newPassword.equals(oldPassword)) {
            System.out.println("New password must differ from the old password. Reset denied.");
            if (sc != null) sc.close();
            return;
        }

        oldPassword = newPassword;
        System.out.println("Password reset successful!");

        if (sc != null) sc.close();
    }
}