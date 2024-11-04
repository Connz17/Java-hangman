import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

//refactor game

public class Main {


    public static void main(String[] args) {
        Pattern numbers = Pattern.compile("[0-9]");

        Scanner scanner = new Scanner(System.in);

        int lives = 0;
        System.out.println("What level would you lke to start at, Select a number: \nEasy = 1 \nNormal = 2 \nHard = 3");
        int level = scanner.nextInt();
        switch (level){
            case 1:
                lives = 7;
                break;
            case 2:
                lives = 5;
                break;
            case 3:
                lives = 3;
                break;
            default:
                System.err.println("Please Choose either 1, 2, or 3");
                Main.main(args);
        }


        StringBuilder lettersGuessed = new StringBuilder();

        System.out.println("Welcome to the JAVA Hangman game!! \nCan you guess all the letters and reveal the word?");

        //pull random word from Arraylist
        String word = Words.generateWord();
        System.out.println(word);

        // Create a function for this
        String[] answer = word.split("").clone();
        String[] hiddenWord = new String[word.length()];
        Arrays.fill(hiddenWord, "_");
        System.out.println(Arrays.toString(hiddenWord));


        System.out.println("\nYou have " + lives + " lives");

        while (lives > 0 && Arrays.toString(hiddenWord).contains("_")){


            System.out.println("\nwhat is your guess??");
            String guess = scanner.nextLine();
            Matcher matcher = numbers.matcher(guess);
            boolean matchFound = matcher.find();

            if (lettersGuessed.toString().contains(guess)){
                System.out.println(guess + "? You have already picked this letter. Try another one");
                continue;

            } else if (matchFound) {
            System.out.println("You can't use numbers, have another go");
            continue;

            } else if (guess.length() > 1) {
            System.out.println("Please only guess letters");
            continue;
            }


            if (word.contains(guess.toLowerCase())){
            System.out.println("Yess you are right");
                for (int i = 0; i < word.length(); i++) {
                    if (answer[i].contains(guess.toLowerCase())){
                    hiddenWord[i] = guess.toLowerCase();
                    }
                }

            } else {
            lives--;
            System.out.println("nooo " + guess + " wasn't a letter in the word");
            System.out.println("you have " + lives + " lives remaining");
            }

            lettersGuessed.append(guess + " ");
            System.out.println("letters guessed so far: \n" + lettersGuessed);
            System.out.print(Arrays.toString(hiddenWord));

            if (Arrays.toString(hiddenWord).contains("_")){

            } else {
            System.out.println("\nCongratulations!!!!!!! \nYou have won!!! And with " + lives + " lives remaining!");
            }

    }
        if (lives == 0){
            System.out.println("\nAhh unlucky, seems like you lost this one");
        }
        System.out.println("\nDo you want to play again? type Y or N");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("Y")){
            Main.main(args);
        } else {
            System.exit(0);
        }
    }

}
