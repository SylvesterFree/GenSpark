import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static String playerName;
    static String spaces, ansWord, userGuess, score1;
    static boolean check1;
    static int counter, Score;

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Boolean continueGame = true;
        welcomeMessage();
        getWords();
        ansWord=genWord(getWords());
        spaces = spaces();
        counter = 0;
        while(continueGame == true){
            userGuess=getGuess();
            check1 = checkGuess(userGuess, ansWord);
            Result();
            if(userGuess.equals(ansWord)||spaces.equals(ansWord)||counter==6){
                continueGame = checkContinue();
            }
        }
        setScore(playerName, Score);
        boolean check2 = highScore();
        endMessage(check2);
    }

    public static void endMessage(boolean check2) {
        Path path = Paths.get("C:\\Users\\freeman\\IdeaProjects\\HangmanFunctional\\res\\HighScores.txt");
        if(check2 == true){
            System.out.println("You have the high score!");
            try {
                Files.writeString(path, Integer.toString(Score), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean highScore() {
            int highScore;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\freeman\\IdeaProjects\\HangmanFunctional\\res\\HighScores.txt"));
            try {
                String string = reader.readLine();
                if(string == null){
                    highScore = 0;
                }else {
                    highScore = Integer.parseInt(string);
                }
                if(Score>highScore){
                    return true;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void setScore(String playerName, int score) {
        score1 =""+playerName+" "+score;
        File f = new File("C:\\Users\\freeman\\IdeaProjects\\HangmanFunctional\\res\\Scores.txt");
        try {
            FileWriter fw = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(""+score1);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Boolean checkContinue() {
        System.out.println("Would you like to play again? (y or n)");
        String ans;

        ans = scan.next();
        if(ans.charAt(0) == 'n'){
            return false;
        }else if (ans.charAt(0) == 'y'){
            getWords();
            ansWord=genWord(getWords());
            spaces = spaces();
            return true;
        }
        return true;
    }

    public static String spaces() {
        String spaces="_".repeat(ansWord.length());
        return spaces;
    }

    public static void Result() {
        char check = userGuess.charAt(0);
        if(check1==false){
            counter++;
            System.out.println("that was a wrong guess");
            System.out.println(spaces);
            getHangman();
        }else if(check1==true && ansWord.equals(userGuess)){
            Score += 10;
            System.out.println("have guessed the right word");
            getHangman();   
        }else if((check1==true && !ansWord.equals(userGuess))){
            StringBuilder sb = new StringBuilder(spaces);
            sb.setCharAt(ansWord.indexOf(check), check);
            spaces = sb.toString();
            if(spaces.equals(ansWord)){
                Score += 10;
                System.out.println("have guessed the right word");
            }else{System.out.println("have guessed the right letter");}
            System.out.println(spaces);
            getHangman();
        }
    }

    public static void getHangman() {
        String Hangman;
        if (counter == 0) {
            try {
                Hangman = Files.readString(Path.of("C:\\Users\\freeman\\IdeaProjects\\HangmanFunctional\\res\\Image.txt"));
                System.out.println(Hangman);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (counter == 1) {
            try {
                Hangman = Files.readString(Path.of("C:\\Users\\freeman\\IdeaProjects\\HangmanFunctional\\res\\Image1.txt"));
                System.out.println(Hangman);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (counter == 2) {
            try {
                Hangman = Files.readString(Path.of("C:\\Users\\freeman\\IdeaProjects\\HangmanFunctional\\res\\Image2.txt"));
                System.out.println(Hangman);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (counter == 3) {
            try {
                Hangman = Files.readString(Path.of("C:\\Users\\freeman\\IdeaProjects\\HangmanFunctional\\res\\Image3.txt"));
                System.out.println(Hangman);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (counter == 4) {
            try {
                Hangman = Files.readString(Path.of("C:\\Users\\freeman\\IdeaProjects\\HangmanFunctional\\res\\Image4.txt"));
                System.out.println(Hangman);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (counter == 5) {
                try {
                    Hangman = Files.readString(Path.of("C:\\Users\\freeman\\IdeaProjects\\HangmanFunctional\\res\\Image5.txt"));
                    System.out.println(Hangman);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else if (counter == 6) {
                try {
                    Hangman = Files.readString(Path.of("C:\\Users\\freeman\\IdeaProjects\\HangmanFunctional\\res\\Image6.txt"));
                    System.out.println("You have reached the max number of guesses the answer was: "+ansWord);
                    Score =0;
                    System.out.println(Hangman);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }



    public static boolean checkGuess(String userGuess, String genWord) {
        return genWord.contains(userGuess);
    }

    public static String getGuess() {
        String userGuess;
        System.out.println("Guess a letter or the whole word: ");
        userGuess = scan.next();
        if(userGuess.matches(".*\\d.*")){
            System.out.println("No numbers please.");
            getGuess();
        }else if (userGuess.length()>1){
            getGuess();
        }
        return userGuess;
    }

    public static void welcomeMessage() {

        System.out.println("Welcome to Hangman please enter your name: ");
        playerName = scan.next();
    }

    public static String genWord(ArrayList<String> words) {
        Random ran = new Random();
        String ranWord = words.get(ran.nextInt(words.size()));
        return ranWord;
    }

    public static ArrayList<String> getWords() {
        ArrayList<String> words = new ArrayList<>();
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