import java.time.Duration;
import java.time.LocalDateTime;
class Pet {
    private String name;
    private LocalDateTime lastFedTime; 
    public Pet(String name) {
        this.name = name;
        this.lastFedTime = LocalDateTime.now().minusHours(8); 
    }
    public void feed() {
        LocalDateTime currentTime = LocalDateTime.now();
        
        Duration timeSinceLastMeal = Duration.between(lastFedTime, currentTime);
        long hoursPassed = timeSinceLastMeal.toHours();
        if (hoursPassed >= 8) {
            System.out.println(name + " happily eats the meal!");
            this.lastFedTime = currentTime; 
        } else {
            long hoursToWait = 8 - hoursPassed;
            System.out.println("You cannot feed " + name + " yet! You must wait another " + hoursToWait + " hour(s).");
        }
    }
    public void setLastFedTimeForTesting(LocalDateTime customTime) {
        this.lastFedTime = customTime;
    }
}
public class PetSimulator {
    public static void main(String[] args) {
        Pet myPet = new Pet("Yoshi");
        System.out.println("First feeding");
        myPet.feed(); 
        System.out.println("")
        System.out.println("Immediate second feeding (Should fail)");
        myPet.feed(); 
        System.out.println("")
        System.out.println("\nSimulating a 3-hour gap (Should fail)");
        myPet.setLastFedTimeForTesting(LocalDateTime.now().minusHours(3));
        myPet.feed(); 
        System.out.println("")
        System.out.println("\nSimulating a 12-hour gap (Should succeed)");
        myPet.setLastFedTimeForTesting(LocalDateTime.now().minusHours(12));
        myPet.feed(); 
        System.out.println("")
    }
}
