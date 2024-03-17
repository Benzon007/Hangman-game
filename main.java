import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] wordList = {"ardvark", "baboon", "camel"};
    private static String chosenWord;
    private static int wordLength;
    private static boolean endOfGame;
    private static int lives;
    private static List<Character> display = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        chosenWord = wordList[random.nextInt(wordList.length)];
        wordLength = chosenWord.length();
        endOfGame = false;
        lives = 6;

        System.out.println(logo());

        for (int i = 0; i < wordLength; i++) {
            display.add('_');
        }

        Scanner scanner = new Scanner(System.in);

        while (!endOfGame) {
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (display.contains(guess)) {
                System.out.println("You've already guessed " + guess);
            }

            for (int position = 0; position < wordLength; position++) {
                char letter = chosenWord.charAt(position);
                if (letter == guess) {
                    display.set(position, letter);
                }
            }

            if (chosenWord.indexOf(guess) == -1) {
                System.out.println("You guessed " + guess + ", that's not in the word. You lose a life.");
                lives--;
                if (lives == 0) {
                    endOfGame = true;
                    System.out.println("You lose.");
                }
            }

            System.out.println(String.join(" ", display));

            if (!display.contains('_')) {
                endOfGame = true;
                System.out.println("You win.");
            }

            System.out.println(stages[lives]);
        }
    }

    private static String logo() {
        return "H A N G M A N";
    }

    private static final String[] stages = {
        "  +---+\n" +
        "  |   |\n" +
        "      |\n" +
        "      |\n" +
        "      |\n" +
        "      |\n" +
        "=========",
        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        "      |\n" +
        "      |\n" +
        "      |\n" +
        "=========",
        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        "  |   |\n" +
        "      |\n" +
        "      |\n" +
        "=========",
        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        " /|   |\n" +
        "      |\n" +
        "      |\n" +
        "=========",
        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        " /|\\  |\n" +
        "      |\n" +
        "      |\n" +
        "=========",
        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        " /|\\  |\n" +
        " /    |\n" +
        "      |\n" +
        "=========",
        "  +---+\n" +
        "  |   |\n" +
        "  O   |\n" +
        " /|\\  |\n" +
        " / \\  |\n" +
        "      |\n" +
        "========="
    };
}
