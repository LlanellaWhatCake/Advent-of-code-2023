import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;
import java.util.stream.Collectors;

public class Day2 {

    File day2Input = new File("src/day_2_input.txt");

    public int figureOutPossibleGamesSum() {
        List<Integer> possibleGameIDs = new ArrayList<>();

        int possibleReds = 12;
        int possibleGreens = 13;
        int possibleBlues = 14;

        try {
            Scanner myReader = new Scanner(day2Input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                boolean gameIsPossible = true;

                int currentGameID = Integer.parseInt((data.split(":")[0]).replaceFirst("Game ", ""));

                //get all reds
                List<String> redMatches = Pattern.compile("[0-9]+ red")
                        .matcher(data)
                        .results()
                        .map(MatchResult::group)
                        .toList();

                //go through list, if a number is larger than possible, this game isn't possible
                for (String red: redMatches) {
                    int number = Integer.parseInt(red.split(" ")[0]);
                    if (number > possibleReds) {
                        gameIsPossible = false;
                    }
                }

                //get all greens
                List<String> greenMatches = Pattern.compile("[0-9]+ green")
                        .matcher(data)
                        .results()
                        .map(MatchResult::group)
                        .toList();

                //go through list, if a number is larger than possible, this game isn't possible
                for (String green: greenMatches) {
                    int number = Integer.parseInt(green.split(" ")[0]);
                    if (number > possibleGreens) {
                        gameIsPossible = false;
                    }
                }

                //get all blues
                List<String> blueMatches = Pattern.compile("[0-9]+ blue")
                        .matcher(data)
                        .results()
                        .map(MatchResult::group)
                        .toList();

                //go through list, if a number is larger than possible, this game isn't possible
                for (String blue: blueMatches) {
                    int number = Integer.parseInt(blue.split(" ")[0]);
                    if (number > possibleBlues) {
                        gameIsPossible = false;
                    }
                }

                if (gameIsPossible) {
                    possibleGameIDs.add(currentGameID);
                }

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("========");

        int sumOfIDs = 0;

        for (int id: possibleGameIDs) {
            sumOfIDs += id;
        }
        return sumOfIDs;
    }

    public int figureOutPossibleGamesSumPart2() {
        List<Integer> leastGamePowersList = new ArrayList<>();

        try {
            Scanner myReader = new Scanner(day2Input);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int gamePower = 0;

                int currentGameID = Integer.parseInt((data.split(":")[0]).replaceFirst("Game ", ""));

                //get all reds
                List<String> redMatches = Pattern.compile("[0-9]+ red")
                        .matcher(data)
                        .results()
                        .map(MatchResult::group)
                        .toList();

                //go through list and get largest red, that's the minimum
                int largestRed = 0;
                for (String red: redMatches) {
                    int number = Integer.parseInt(red.split(" ")[0]);
                    if (number > largestRed) {
                        largestRed = number;
                    }
                }

                //get all greens
                List<String> greenMatches = Pattern.compile("[0-9]+ green")
                        .matcher(data)
                        .results()
                        .map(MatchResult::group)
                        .toList();

                int largestGreen = 0;
                //go through list and get largest green, that's the minimum
                for (String green: greenMatches) {
                    int number = Integer.parseInt(green.split(" ")[0]);
                    if (number > largestGreen) {
                        largestGreen = number;
                    }
                }

                //get all blues
                List<String> blueMatches = Pattern.compile("[0-9]+ blue")
                        .matcher(data)
                        .results()
                        .map(MatchResult::group)
                        .toList();

                int largestBlue = 0;
                //go through list, if a number is larger than possible, this game isn't possible
                for (String blue: blueMatches) {
                    int number = Integer.parseInt(blue.split(" ")[0]);
                    if (number > largestBlue) {
                        largestBlue = number;
                    }
                }

                gamePower = largestRed * largestGreen * largestBlue;
                leastGamePowersList.add(gamePower);

            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("========");

        int sumOfIDs = 0;

        for (int id: leastGamePowersList) {
            sumOfIDs += id;
        }
        return sumOfIDs;
    }
}
