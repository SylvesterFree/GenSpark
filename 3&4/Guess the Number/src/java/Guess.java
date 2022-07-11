import java.util.InputMismatchException;
import java.util.Scanner;

public class Guess {
    public static int gotGuess, counter, ans, userGuess;
    public static String p1,ans1;
    public static Scanner Scan = new Scanner(System.in);
    public static Scanner Scan1 = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Hello! What is your name?");
        p1 = Scan.nextLine();
        CheckName(p1);
        guess();
    }

    public static String CheckName(String name) {

        if(name.matches("[a-zA-Z]+")){
            System.out.println("Welcome, " + name + ", I am think of a number between 1 and 20.");
            p1 = name;
            return name;
        }else{
            System.out.println("Please enter only Letters ");
            name = Scan.nextLine();
            CheckName(name);
        }
        return name;
    }

    private static void guess() {
        ans = (int) (1 + Math.random() * 20);
        System.out.print("Take a guess.");
        gotGuess = getGuess();
        while (counter <= 6 && gotGuess!=ans && ans1 != "n") {
        CheckGuess();
        }
        if(counter==6){
            gotGuess = 21;
            System.out.print("You couldn't Guess the number in 6 tries!");
            System.out.println("Would you like to play again? (y or n) ");
            ans1 = Scan1.nextLine();
        }else{
            gotGuess = 21;
            System.out.print("Good job, " + p1 + "! You guess the right number in " + counter + " guesses!");
            System.out.println(" Would you like to play again? (y or n) ");
            ans1 = Scan1.nextLine();
            if(ans1.charAt(0) == 'y'){
                gotGuess =0;
                guess();
            }
        }

    }

    public static int CheckGuess() {

            if (gotGuess > ans) {
                System.out.print("Your guess is too high.");
                System.out.println("Take a guess");
                gotGuess=getGuess();
                counter++;
                return gotGuess;
            } else if (gotGuess < ans) {
                System.out.print("Your guess is too low.");
                System.out.println("Take a guess");
                gotGuess=getGuess();
                counter++;
                return gotGuess;
            }

        return gotGuess;
    }

    static int getGuess() {
        try {
            userGuess = Scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Please enter in a number.");
            Scan.nextLine();
            userGuess = Scan.nextInt();
            counter--;
        }
        return userGuess;
    }
}


