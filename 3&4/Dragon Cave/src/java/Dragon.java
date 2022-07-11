import java.util.InputMismatchException;
import java.util.Scanner;

public class Dragon {
    public static int value = 0;
    public static Scanner ans = new Scanner(System.in);;
    public static void main(String[] args) {
        int ender = 0;
        while (ender == 0){
            int random = (int) ((Math.random() * (3 - 1)) + 1);
            System.out.println(" ");
            System.out.println("You are in a land full of dragons.");
            System.out.println("In front of you, you see two caves.");
            System.out.println("In one cave, the dragon is friendly and will share his treasure with you.");
            System.out.println("The other dragon is greedy and hungry and will eat you on sight.");
            System.out.println("Which cave will you go into? (1 or 2)\"");
            try {
                value = ans.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Please enter one or two");
                ans.nextLine();
                value = ans.nextInt();
            }
            checkInput(value);
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

    public static int checkInput(int check) {
        if(check == 1 || check == 2){
            value = check;
            return check ;
        }else{
            System.out.println("Please enter 1 or 2");
            try {
                check = ans.nextInt();
                value = check;
                checkInput(value);
            }catch (InputMismatchException e){
                System.out.println("Please enter one or two");
                ans.nextLine();
                check= ans.nextInt();
                value = check;
                checkInput(value);
            }
        }
        return check;
    }
}
