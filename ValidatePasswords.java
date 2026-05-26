import java.util.ArrayList;

public class ValidatePasswords {
  public static void main(String[] args) {
    String[] phrases = {"password", 
                      "hello world", 
                      "xyz", 
                      "123abc", 
                      "qwerty", 
                      "is this valid", 
                      " admin", 
                      "let me in", 
                      "computer ",
                      "areyouthere?"};                
    System.out.println("Notoriously bad passwords:");
    for (String str : phrases) {
      System.out.println(str);
    }
ArrayList<String> validPasswords = new ArrayList<>();
    int i = 0;
    do {
     String currentPassword = phrases[i];

      if (currentPassword.contains(" ") || currentPassword.length() < 6) {
        i++; 
        continue; 
      }
    validPasswords.add(currentPassword);
     i++;
    } while (i < phrases.length);

    System.out.println("Validated passwords (no spaces, length >= 6):");
    System.out.println(""); // just so its easier to see
    for (String validStr : validPasswords) {
      System.out.println(validStr);
    }
  }
}
