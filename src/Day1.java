import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    File day1Input = new File("src/day_1_input.txt");

    public int figureOutCalibrationSum() {
        List<Integer> calibrationArray = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(day1Input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //go through each character and figure out the numbers
                List<Integer> numbersFromLine = new ArrayList<>();
                for (int i = 0; i < data.length(); i++) {
                    if (Character.isDigit(data.charAt(i))) {
                        numbersFromLine.add(Character.digit(data.charAt(i), 10));
                    }
                }

                //pick first and last ones
                String remainingDigits = "";

                if (numbersFromLine.size() == 1) {
                    //dupe this number
                    remainingDigits = numbersFromLine.get(0) + "" + numbersFromLine.get(0);
                } else {
                    remainingDigits = numbersFromLine.get(0) + "" + numbersFromLine.get(numbersFromLine.size() - 1);
                }

                calibrationArray.add(Integer.parseInt(remainingDigits));
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int sum = 0;

        for (Integer number: calibrationArray) {
            sum += number;
        }
        System.out.println("============");

        return sum;
    }

    public int figureOutCalibrationSumPart2() {
        List<Integer> calibrationArray = new ArrayList<>();
        int index = 1;
        try {
            Scanner myReader = new Scanner(day1Input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //be ghetto and use regex to turn the strings into numbers first lol
                String convertedString = new StringBuilder().append(data).toString();

                //regular cases
                convertedString = convertedString.replaceAll("one", "o1ne");
                convertedString = convertedString.replaceAll("two", "t2wo");
                convertedString = convertedString.replaceAll("three", "th3ree");
                convertedString = convertedString.replaceAll("four", "f4our");
                convertedString = convertedString.replaceAll("five", "fi5ve");
                convertedString = convertedString.replaceAll("six", "s6ix");
                convertedString = convertedString.replaceAll("seven", "se7ven");
                convertedString = convertedString.replaceAll("eight", "ei8ght");
                convertedString = convertedString.replaceAll("nine", "n9ine");
                //go through each character and figure out the numbers
                List<Integer> numbersFromLine = new ArrayList<>();
                for (int i = 0; i < convertedString.length(); i++) {
                    if (Character.isDigit(convertedString.charAt(i))) {
                        numbersFromLine.add(Character.digit(convertedString.charAt(i), 10));
                    }
                }

                //pick first and last ones
                String remainingDigits = "";

                if (numbersFromLine.size() == 1) {
                    //dupe this number
                    remainingDigits = numbersFromLine.get(0) + "" + numbersFromLine.get(0);
                } else {
                    remainingDigits = numbersFromLine.get(0) + "" + numbersFromLine.get(numbersFromLine.size() - 1);
                }

                calibrationArray.add(Integer.parseInt(remainingDigits));
                System.out.println(index + ": " + remainingDigits);
                index++;
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int sum = 0;

        for (Integer number: calibrationArray) {
            sum += number;
        }
        System.out.println("============");

        return sum;
    }
}
