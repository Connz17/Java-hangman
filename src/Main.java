import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;



public class Main {


    public static void main(String[] args) {
        Pattern numbers = Pattern.compile("[0-9]");

        Scanner scanner = new Scanner(System.in);
        int lives = 5;

        StringBuilder lettersGuessed = new StringBuilder();

        //pull random word from Arraylist
        String word = Words.generateWord();
        System.out.println(word);


        String[] answer = word.split("").clone();
        String[] hiddenWord = new String[word.length()];
        Arrays.fill(hiddenWord, "_");
        System.out.println(Arrays.toString(hiddenWord));

        System.out.println("Welcome to the JAVA Hangman game.");
        System.out.println("\n You have " + lives + " lives");

        while (lives > 0 && Arrays.toString(hiddenWord).contains("_")){


            System.out.println( " \n what is your guess??");
            String guess = scanner.nextLine();
            Matcher matcher = numbers.matcher(guess);
            boolean matchFound = matcher.find();

            if (lettersGuessed.toString().contains(guess)){
                System.out.println("You have already picked this letter");
                continue;

            } else if (matchFound) {
            System.out.println("You can't use numbers");
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
            System.out.println("\n Congratulations!!!!!!! \n You have won!!! And with " + lives + " lives remaining!");
            }

    }

        System.out.println("\n Do you want to play again? type Y or N");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("Y")){
            Main.main(args);
        } else {
            System.exit(0);

        }
    }

}
