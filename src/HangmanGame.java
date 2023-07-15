import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"apple", "banana", "cherry", "grape", "orange"};
    private static final int MAX_GUESSES = 6;

    private String secretWord;
    private StringBuilder guessedWord;
    private int remainingGuesses;

    public HangmanGame() {
        secretWord = getRandomWord();
        guessedWord = createInitialGuessedWord(secretWord.length());
        remainingGuesses = MAX_GUESSES;
    }

    private String getRandomWord() {
        int randomIndex = (int) (Math.random() * WORDS.length);
        return WORDS[randomIndex];
    }

    private StringBuilder createInitialGuessedWord(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("_");
        }
        return sb;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (remainingGuesses > 0 && guessedWord.toString().contains("_")) {
            System.out.println("------------------------------");
            System.out.println("Secret Word: " + guessedWord.toString());
            System.out.println("Remaining Guesses: " + remainingGuesses);

            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            boolean correctGuess = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess.charAt(0)) {
                    guessedWord.setCharAt(i, guess.charAt(0));
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                remainingGuesses--;
                System.out.println("Incorrect guess!");
            }
        }

        System.out.println("------------------------------");
        if (guessedWord.toString().contains("_")) {
            System.out.println("Sorry, you lost! The secret word was: " + secretWord);
        } else {
            System.out.println("Congratulations! You won! The secret word is: " + secretWord);
        }

        scanner.close();
    }

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.play();
    }
}
