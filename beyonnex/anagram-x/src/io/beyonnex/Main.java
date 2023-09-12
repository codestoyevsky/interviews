package io.beyonnex;

import java.util.*;

public class Main {
    private static Map<String, List<String>> anagramMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an action:");
            System.out.println("1 - Check if two texts are anagrams of each other.");
            System.out.println("2 - Show all anagrams for a given text.");
            System.out.println("3 - Exit the program.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the first text:");
                    String str1 = scanner.next();
                    System.out.println("Enter the second text:");
                    String str2 = scanner.next();
                    boolean areAnagrams = areAnagrams(str1, str2);
                    if (areAnagrams) {
                        System.out.println("These texts are anagrams.");
                    } else {
                        System.out.println("These texts are not anagrams.");
                    }
                    break;
                case 2:
                    System.out.println("Enter a text to find anagrams:");
                    String input = scanner.next();
                    List<String> anagrams = findAnagrams(input);
                    if (anagrams.isEmpty()) {
                        System.out.println("No anagrams found for the given text.");
                    } else {
                        System.out.println("Anagrams for " + input + ": " + anagrams);
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static boolean areAnagrams(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    private static List<String> findAnagrams(String input) {
        List<String> anagrams = anagramMap.get(input);
        if (anagrams == null) {
            anagrams = new ArrayList<>();
            for (String key : anagramMap.keySet()) {
                if (areAnagrams(input, key)) {
                    anagrams.add(key);
                }
            }
            anagramMap.put(input, anagrams);
        }
        return anagrams;
    }
}