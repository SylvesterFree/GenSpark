import java.util.Scanner;

public class Guess {
    public static int tracker, ender, userGuess, counter, userGuessMax, userGuessMin;
    public static String p1,ans1;
    public static Scanner Scan = new Scanner(System.in);
    public static Scanner Scan1 = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Hello! What is your name?");
        p1 = Scan.nextLine();
        System.out.print("Well, " + p1 + ", I am think of a number between 1 and 20.");
        gueess();
        }

    private static void gueess() {
        int ans = (int) (1 + Math.random() * 20);
        System.out.print("Take a guess.");
        userGuess = Scan.nextInt();
        while (counter != 6 && userGuess!=ans && ans1 != "n") {
            if (userGuess > ans) {
                System.out.print("Your guess is too high.");
                System.out.println("Take a guess");
                counter++;
                tracker++;
                userGuess = Scan.nextInt();
            } else if (userGuess < ans) {
                System.out.print("Your guess is too low.");
                System.out.println("Take a guess");
                counter++;
                tracker++;
                userGuess = Scan.nextInt();
            } else {
                Scan.close();
                System.out.println(ans1);
                System.out.print("Good job, " + p1 + "! You guess the right number in " + tracker + " guesses!");
                System.out.println("Would you like to play again? (y or n) ");
                ans1 = Scan1.nextLine();
            }
        }
        if(counter==6){
            userGuess = 21;
            System.out.print("You couldn't Guess the number in 6 tries!");
            System.out.println("Would you like to play again? (y or n) ");
            ans1 = Scan1.nextLine();
        }else{
            userGuess = 21;
            System.out.println("Would you like to play again? (y or n) ");
            ans1 = Scan1.nextLine();
            if(ans1.charAt(0) == 'y'){
                userGuess =0;
                gueess();
            }
        }

    }
}


