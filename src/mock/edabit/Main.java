package mock.edabit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Input is: 7 , 5");
        arrayofMultiples(7, 5);
        System.out.println("Input is: 12 , 10");
        arrayofMultiples(12, 10);
        System.out.println("Input is: 17 , 6");
        arrayofMultiples(17, 6);
        System.out.println("Input is: 0");
        squarePatch(0);
        System.out.println("Input is: 1");
        squarePatch(1);
        System.out.println("Input is: 3");
        squarePatch(3);
        System.out.println("Input is: 5");
        squarePatch(5);
        System.out.println(specialReverseString("Edabit"));
        System.out.println(specialReverseString("UPPER lower"));
        System.out.println(specialReverseString("1 23 456"));
        System.out.println(atBashCipher("apple"));
        System.out.println(atBashCipher("Hello world!"));
        System.out.println(atBashCipher("Christmas is the 25th of December"));
    }
    public static int[] arrayofMultiples(int num, int length) {
        int[] array = new int[length];
        for (int i = 1; i <= length; i++) {
            array[i - 1] = (i * num);
        }
        System.out.println(Arrays.toString(array));
        return array;
    }

    public static int[][] squarePatch(int n) {
        if (n == 0) {
            int[][] arr0 = new int[0][1];
            System.out.println(Arrays.deepToString(arr0));
            return arr0;
        }
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = n;
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        return arr;
    }

    public static String specialReverseString(String input) {
        List<Character> letterPosition = new ArrayList<>();
        List<Boolean> spacePositions = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            Character letter = input.charAt(i);
            if (letter == (' ')) {
                spacePositions.add(true);
            } else {
                letterPosition.add(letter.toLowerCase(letter));
                spacePositions.add(false);
            }
        }
        StringBuilder output = new StringBuilder();

        int reversePos = letterPosition.size() - 1;
        for (int j = 0; j < input.length(); j++) {
            Character letter = input.charAt(j);
            if (spacePositions.get(j)) {
                output.append(" ");
            } else {
                Character reverseLetter = letterPosition.get(reversePos);
                if (letter == letter.toUpperCase(letter)) {
                    output.append(reverseLetter.toUpperCase(reverseLetter));
                } else {
                    output.append(reverseLetter);
                }
                reversePos--;
            }
        }
        return output.toString();
    }

    public static String atBashCipher(String input) {
        StringBuilder output = new StringBuilder();
        System.out.println("\nEncoded");
        for (Character letter : input.toCharArray()) {
            System.out.print(encode(letter));
            output.append(encode(letter));
        }
        System.out.println("\nDecoded");
        for (Character letter : input.toCharArray()) {
            System.out.print(decode(encode(letter)));
        }
        System.out.println();
//        System.out.println();
        return output.toString();
    }

    public static Character encode(Character letter) {
        String upperBet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerBet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < upperBet.length(); i++) {
            if (letter == upperBet.charAt(i)) {
                return upperBet.charAt(upperBet.length() - 1 - i);
            } else if (letter == lowerBet.charAt(i)) {
                return lowerBet.charAt(lowerBet.length() - 1 - i);
            }
        }
        return letter;
    }

    public static Character decode(Character letter) {
        String upperBet = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String lowerBet = "zyxwvutsrqponmlkjihgfedcba";
        for (int i = 0; i < upperBet.length(); i++) {
            if (letter == upperBet.charAt(i)) {
                return upperBet.charAt(upperBet.length() - 1 - i);
            } else if (letter == lowerBet.charAt(i)) {
                return lowerBet.charAt(lowerBet.length() - 1 - i);
            }
        }
        return letter;
    }
}
