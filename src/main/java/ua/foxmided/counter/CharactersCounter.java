package ua.foxmided.counter;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class CharactersCounter {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input your phrase here: ");
        String inputtedPhrase = in.nextLine();
        in.close();
        System.out.println(initializeCollections(inputtedPhrase));
    }

    public static String initializeCollections(String inputtedPhrase) {
        LinkedList<String> arrayOfCharacters = new LinkedList<>();
        LinkedList<String> nonRepeatCharacters = new LinkedList<String>();

        if (StringUtils.isBlank(inputtedPhrase)) {
            return "";
        } else {
            Collections.addAll(arrayOfCharacters, isContainLetterThanToUpperCase(inputtedPhrase).split(""));

            for (String arrayOfCharacter : arrayOfCharacters) {
                if (!nonRepeatCharacters.contains(arrayOfCharacter)) {
                    nonRepeatCharacters.add(arrayOfCharacter);
                }
            }
            return countCharacters(arrayOfCharacters, nonRepeatCharacters);
        }
    }

    public static String countCharacters(LinkedList<String> listOfCharacters,
                                         LinkedList<String> nonRepeatableCharacters) {

        StringBuilder countedCharacters = new StringBuilder();
        for (String finalCharacters : nonRepeatableCharacters) {
            if (finalCharacters.equals(" ")) {
                countedCharacters
                        .append("\"Space\" - ")
                        .append(Collections.frequency(listOfCharacters, finalCharacters))
                        .append("\n");
            } else {
                countedCharacters
                        .append('"').append(finalCharacters).append("\" - ")
                        .append(Collections.frequency(listOfCharacters, finalCharacters))
                        .append("\n");
            }
        }
        return countedCharacters.append("\nTotal - ").append(listOfCharacters.size()).toString();
    }

    public static String isContainLetterThanToUpperCase(String inputtedPhrase) {
        StringBuilder result = new StringBuilder();
        for (char toUpperCase : inputtedPhrase.toCharArray()) {
            if (Character.isLetter(toUpperCase)) {
                result.append(Character.toUpperCase(toUpperCase));
            } else {
                result.append(toUpperCase);
            }
        }
        return result.toString();
    }


}