import java.util.Scanner;

public class Dragon {

    public static void main(String[] args) {
        Scanner ans = new Scanner(System.in);

        int ender = 0;
        while (ender == 0){
            int random = (int) ((Math.random() * (3 - 1)) + 1);
            System.out.println(" ");
            System.out.println("You are in a land full of dragons.");
            System.out.println("In front of you, you see two caves.");
            System.out.println("In one cave, the dragon is friendly and will share his treasure with you.");
            System.out.println("The other dragon is greedy and hungry and will eat you on sight.");
            System.out.println("Which cave will you go into? (1 or 2)\"");
            int value = ans.nextInt();
            System.out.println("You approach the cave...");
            System.out.println("It is dark and spooky...");
            System.out.println("A large dragon jumps out in front of you!");
            if (value == random) {
                System.out.println("He offers his treasure!");
            } else {
                System.out.println("He opens his jaws and... Gobbles you down in one bite!");
                ender += 1;
            }
        }
    }
}
