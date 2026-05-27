//Changed it so that there is a nested for loop rather than a while loop. 

import java.util.ArrayList;

public class ValidatePasswords {
    public static void main(String[] args) {
        //I tried to break it up into two different sections
        String[][] phrases2D = {
            {"password", "hello world", "xyz", "123abc", "qwerty"}, //common guesses
            {"is this valid", " admin", "let me in", "computer ", "areyouthere?"} //less common and longer
        };

        System.out.println("Notoriously bad passwords:");
        for (int row = 0; row < phrases2D.length; row++) {
            for (int col = 0; col < phrases2D[row].length; col++) {
                System.out.println(phrases2D[row][col]);
            }
        }

        ArrayList<String> validPasswords = new ArrayList<>();

        for (int row = 0; row < phrases2D.length; row++) {
            for (int col = 0; col < phrases2D[row].length; col++) {
                String currentPassword = phrases2D[row][col];

                if (currentPassword.contains(" ") || currentPassword.length() < 6) {
                    continue; // Skips to the next iteration of the inner loop
                }
                validPasswords.add(currentPassword);
            }
        }

        System.out.println("\nValidated passwords (no spaces, length >= 6):");
        for (String validStr : validPasswords) {
            System.out.println(validStr);
        }
    }
}
