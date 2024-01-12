package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {

    public static String decodeMessage(String encodedMessage) {
        String[] words = encodedMessage.split("\\s+");
        StringBuilder decodedMessage = new StringBuilder();

        for (String word : words) {
            String decodedWord = decodeWord(word);
            decodedMessage.append(decodedWord).append(" ");
        }

        return decodedMessage.toString().trim();
    }

    private static String decodeWord(String encodedWord) {
        if (isVowelEncoded(encodedWord)) {
            return decodeVowels(encodedWord);
        } else if (isConsonantEncoded(encodedWord)) {
            return decodeConsonants(encodedWord);
        } else {
            return encodedWord;
        }
    }

    private static boolean isVowelEncoded(String word) {
        return word.matches(".*[1-5].*");
    }

    private static boolean isConsonantEncoded(String word) {
        return word.matches(".*[a-zA-Z&&[^aeiouAEIOU]].*");
    }

    public static String decodeVowels(String encoded) {
        Pattern pattern = Pattern.compile("[1-5]");
        Matcher matcher = pattern.matcher(encoded);

        StringBuilder decoded = new StringBuilder();

        int lastIndex = 0;
        while (matcher.find()) {
            int matchIndex = matcher.start();
            int number = Integer.parseInt(matcher.group());

            decoded.append(encoded, lastIndex, matchIndex);

            char replacement = getVowelReplacement(number);
            decoded.append(replacement);

            lastIndex = matcher.end();
        }

        decoded.append(encoded, lastIndex, encoded.length());

        return decoded.toString();
    }


    public static String decodeConsonants(String encoded) {
        StringBuilder result = new StringBuilder();
        for (char ch : encoded.toCharArray()) {
            if (Character.isLetter(ch) && !isVowel(ch)) {
                char replacement = getPreviousConsonant(ch);
                result.append(replacement);
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    private static char getVowelReplacement(int number) {
        switch (number) {
            case 1:
                return 'a';
            case 2:
                return 'e';
            case 3:
                return 'i';
            case 4:
                return 'o';
            case 5:
                return 'u';
            default:
                return '?';
        }
    }

    private static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    private static char getPreviousConsonant(char ch) {
        if (!Character.isLetter(ch) || isVowel(ch)) {
            return ch;
        }
        char lowerCh = Character.toLowerCase(ch);
        char previous = (char) (lowerCh - 1);
        while (isVowel(previous)) {
            previous = (char) (previous - 1);
        }
        return Character.isUpperCase(ch) ? Character.toUpperCase(previous) : previous;
    }

    public static void main(String[] args) {
        String encodedMessage = "t2st3ng vetviph neev m22t hsif gr3d";
        String decodedMessage = decodeMessage(encodedMessage);
        System.out.println("Encoded Message: " + encodedMessage);
        System.out.println("Decoded Message: " + decodedMessage);
    }
}
