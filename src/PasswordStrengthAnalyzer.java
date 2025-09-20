/*
 * ============================================================
 *  PasswordStrengthAnalyzer.java
 * ============================================================
 *  Description : Console program that evaluates password strength
 *                using regex checks for length, uppercase, lowercase,
 *                digits, and special characters.
 *
 *  Author      : Brailyn Blackwell
 *  Date        : 01/06/25
 *
 *  How to Run  :
 *      1. Compile -> javac PasswordStrengthAnalyzer.java
 *      2. Run     -> java PasswordStrengthAnalyzer
 *
 *  Notes:
 *      - This program is intended for educational / practice use.
 *      - It does not replace professional security auditing.
 * ============================================================
 */


import java.util.Scanner;
import java.util.regex.*;

public class PasswordStrengthAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Password Strength Analyzer ===");
        System.out.print("Enter a password to test: ");
        String password = scanner.nextLine();

        int score = 0;

    
        if (password.length() >= 8) score++;
        if (Pattern.compile("[A-Z]").matcher(password).find()) score++;
        if (Pattern.compile("[a-z]").matcher(password).find()) score++;
        if (Pattern.compile("[0-9]").matcher(password).find()) score++;
        if (Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) score++;

    
        System.out.println("\nPassword Analysis:");
        switch (score) {
            case 5:
                System.out.println("Strength: Excellent");
                break;
            case 4:
                System.out.println("Strength: Strong ");
                break;
            case 3:
                System.out.println("Strength: Medium (Add more variety)");
                break;
            case 2:
                System.out.println("Strength: Weak (Too simple)");
                break;
            default:
                System.out.println("Strength: Very Weak (easily can be hacked)");
        }


        if (password.length() < 8)
            System.out.println("- Use at least 8 characters.");
        if (!Pattern.compile("[A-Z]").matcher(password).find())
            System.out.println("- Add at least one uppercase letter.");
        if (!Pattern.compile("[a-z]").matcher(password).find())
            System.out.println("- Add at least one lowercase letter.");
        if (!Pattern.compile("[0-9]").matcher(password).find())
            System.out.println("- Include at least one digit.");
        if (!Pattern.compile("[^a-zA-Z0-9]").matcher(password).find())
            System.out.println("- Add a special character (!,@,#,$, etc.).");

        scanner.close();
    }
}
