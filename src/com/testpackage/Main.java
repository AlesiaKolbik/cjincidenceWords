package com.testpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.println("Введите строку слов, разделенных пробелами:");
        String stringOfSymbols = sca.nextLine();
        Scanner sca2 = new Scanner(System.in);
        System.out.println("Введите слово:");
        String word = sca2.nextLine();
        word = word.trim();
        ArrayList<String> arrayOfWords = split(stringOfSymbols);
        int numberOfMismatches = 0;
        for (int i = 0; i < arrayOfWords.size(); i++) {
            int lengthWordInArray = arrayOfWords.get(i).length();  //длинна слова в массиве
            int lengthWord = word.length();    //длинна заданного слова
            if (lengthWord == lengthWordInArray) {
                System.out.println(arrayOfWords.get(i));
            } else {
                numberOfMismatches++;
            }
            if (numberOfMismatches == arrayOfWords.size())
                System.out.println("Совпадений со словом " + word + " не найдено.");
        }


    }

    public static ArrayList<String> split(String string) {
        String separator = " ";
        ArrayList<String> words = new ArrayList<>(1000);
        for (int i = 0; i < string.length(); i++) {
            int startWord = findStartIndexNextWord(string, i, separator);
            int endWord = findLastIndexNextWord(string, startWord, separator);
            String word = getNextWord(string, startWord, endWord);
            words.add(word);
            i = endWord;
        }
        return words;
    }

    public static int findStartIndexNextWord(String string, int index, String separator) {
        while (separator.contains(String.valueOf(string.charAt(index)))) {
            index++;
        }
        return index;
    }

    public static int findLastIndexNextWord(String string, int index, String separator) {
        while (!separator.contains(String.valueOf(string.charAt(index)))) {
            index++;
        }
        return index;
    }

    public static String getNextWord(String string, int indexStart, int indexEnd) {
        String word = "";
        for (int i = indexStart; i < indexEnd; i++) {
            word += string.charAt(i);
        }
        return word;
    }
}
