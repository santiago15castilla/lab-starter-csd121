package part1.logging;

import java.util.List;

public class CensoriousLogger implements Logger {

    private final List<String> bannedWords; //stores the list of hidden words in a constructor

    public CensoriousLogger(List<String> bannedWords) {
        this.bannedWords = bannedWords; //we customize the constructor to tell it which words to censor.
    }

    @Override
    public void log(String message, LogLevel level) {
        for (String word : bannedWords) { //loop through every banned word and replace it in the message.
            message = message.replaceAll("(?i)" + word, "*".repeat(word.length())); //"(?i)" makes the replacement case-insensitive.
        }                                                     // "*".repeat(word.length()) creates the right number of * symbols.
        System.out.println(formatMessage(message, level));
    }
}