import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangGame {
    public static String spaces = "",p1 = "", ans, ranWord="";
    public static Scanner scan = new Scanner(System.in);
    private static int counter=0;

    public static void main(String[] args) {
            GetWords();
            GenWord(GetWords());
            formWord();
            ans="y";
            System.out.println("Welcome please enter your name: ");
            p1 = scan.nextLine();
            System.out.println("Hi "+p1+" the computer has thought of a random word. please try to guess it ");

            GuessWord();


        }

    private static void formWord() {
        spaces="";
        for(int i =0; i<ranWord.length(); i++){
            spaces += "_";
        }
    }

    private static void GuessWord() {
        String useGuess = "";

            while (spaces.equals(ranWord) == false && counter != 6 && ans!="n") {
                System.out.print("guess a letter or the word: ");
                useGuess = scan.nextLine();
                if (useGuess.length() == 1) {
                    char check = useGuess.charAt(0);
                    if (ranWord.indexOf(check) < 0) {
                        counter++;
                        Game();
                        GuessWord();
                    } else {
                        if(spaces.indexOf(check)>=0){
                            System.out.print("you already guess that ");
                        }else {
                            StringBuilder sb = new StringBuilder(spaces);
                            sb.setCharAt(ranWord.indexOf(check), check);
                            spaces = sb.toString();
                            System.out.println(spaces);
                            Game();
                            GuessWord();
                        }

                    }
                } else if (useGuess.length() <= ranWord.length() && useGuess.length() != 0 && useGuess.equals(ranWord) == false) {
                    counter++;
                    System.out.println(ranWord);
                    System.out.println(spaces);
                    Game();
                    GuessWord();
                } else if (useGuess.equals(ranWord) == true || spaces.equals(ranWord) == true) {

                    spaces = ranWord;
                    System.out.println(spaces);
                    System.out.println(ranWord);


                }
            }
            results();


    }

    private static void results() {
        if(spaces.equals(ranWord)==true){
            System.out.println("Congratulations you guessed " + spaces + " correct.");
            System.out.println("Would you like to play again? (y or n) ");
            ans = scan.nextLine();
            if(ans.charAt(0) == 'y'){
                counter=0;
                GenWord(GetWords());
                formWord();
                System.out.println("Hi "+p1+" the computer has thought of a random word. please try to guess it ");
                GuessWord();
            }
        }else{
            System.out.println("You didnt not guess "+ranWord);

        }
    }


    private static void Game() {
            if(counter == 0){
                System.out.println("Word choice");
                System.out.println(" +----+");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("    =====");
            }else if(counter == 1){
                System.out.println("Word choice");
                System.out.println(" +----+");
                System.out.println(" o    |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("    =====");
            }else if(counter == 2){
                System.out.println("Word choice");
                System.out.println(" +----+");
                System.out.println(" o    |");
                System.out.println("/     |");
                System.out.println("      |");
                System.out.println("    =====");
            }else if(counter == 3){
                System.out.println("Word choice");
                System.out.println(" +----+");
                System.out.println(" o    |");
                System.out.println("( )  |");
                System.out.println("      |");
                System.out.println("    =====");
            }else if(counter == 4){
                System.out.println("Word choice");
                System.out.println(" +----+");
                System.out.println(" o    |");
                System.out.println("(|)   |");
                System.out.println("      |");
                System.out.println("    =====");
            }else if(counter == 5){
                System.out.println("Word choice");
                System.out.println(" +----+");
                System.out.println(" o    |");
                System.out.println("(|)   |");
                System.out.println("(     |");
                System.out.println("    =====");
            }else if(counter == 6){
                System.out.println("Word choice");
                System.out.println(" +----+");
                System.out.println(" o    |");
                System.out.println("(|)   |");
                System.out.println("( )  |");
                System.out.println("    =====");
            }
    }

    public static void GenWord(ArrayList<String> words) {
            Random ran = new Random();
            ranWord = words.get(ran.nextInt(words.size()));

    }

    private static ArrayList<String> GetWords() {
            ArrayList<String> words = new ArrayList<>();
            String word="";
        try {
            Scanner reader = new Scanner(new FileInputStream("C:\\Users\\freeman\\Downloads\\Words\\word.txt"));
            while(reader.hasNextLine()) {
                words.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }return words;

    }
    }



