package pgr209.Lecture2.Yahtzee;

import java.util.Arrays;
import java.util.HashMap;

public class Yahtzee {

    private final Die[] dieArray;
    private final Category[] pairPointsCategory = {Category.PAIR, Category.TWO_PAIRS, Category.THREE_OF_A_KIND, Category.FOUR_OF_A_KIND, Category.YAHTZEE, Category.FULL_HOUSE}; //not used yet

    public Yahtzee(Die[] dieArray) {
        this.dieArray = dieArray;
    }


    //Add the die to a HashMap, which also checks if there are more than 1 of each die.
    public int categorizeDice(Category inputCategory) {
        HashMap<Die, Integer> dieFrequency = new HashMap<>();

        //Add all values from Die to HashMap first.
        for (Die d : Die.values()) {
            dieFrequency.put(d, 0);
        }

        //Check if the dice in the dieArray exist and add to HashMap. Also checks for duplicates.
        for (Die d : dieArray) {
            if (dieFrequency.containsKey(d)) {
                dieFrequency.put(d, dieFrequency.get(d) + 1);               //Since Key = Die, if duplicate is found, we increment the Value -> Knows how many of each die we have.
            }
        }

        /*
            Now all the dice are categorized in the dieFrequency HashMap.
            This will be used to calculate points depending on the category.
         */

        //Switch to check the points according to the amount of dice in every category from the HashMap
            //!! NOT PAIR, TWO_PAIRS etc... !!
        switch (inputCategory) {
            case ONES -> {return dieFrequency.get(Die.ONE); }
            case TWOS -> {return dieFrequency.get(Die.TWO) * 2; }
            case THREES -> {return dieFrequency.get(Die.THREE) * 3; }
            case FOURS -> {return dieFrequency.get(Die.FOUR) * 4; }
            case FIVES -> {return dieFrequency.get(Die.FIVE) * 5; }
            case SIXES -> {return dieFrequency.get(Die.SIX) * 6; }
        }

        //Now to find points if there are a PAIR, TWO_PAIRS etc...
        if (inputCategory == Category.PAIR) return findEquals(dieFrequency, 2);
        if (inputCategory == Category.TWO_PAIRS) return findEquals(dieFrequency, 2);
        if (inputCategory == Category.THREE_OF_A_KIND) return findEquals(dieFrequency, 3);
        if (inputCategory == Category.FOUR_OF_A_KIND) return findEquals(dieFrequency, 4);
        if (inputCategory == Category.FULL_HOUSE) return findEquals(dieFrequency, 0);
        if (inputCategory == Category.YAHTZEE) return findEquals(dieFrequency, 5);


//        for (Category c : pairPointsCategory) {
//            if (inputCategory == c) {
//                return findEquals(dieFrequency, 1); //kan 1 generaliseras?
//            }
//        }

        return -1;
    }

    //Find the highest valued pair.
    public int findEquals(HashMap<Die, Integer> dieFrequency, int diePairCategory) {
        int points = 0;
        int pointsFullHouse = 0;

        //All kind of pairs.
        if (diePairCategory >= 0 && diePairCategory <= 4) {

            for (Die d : dieFrequency.keySet()) {
                if (diePairCategory != 0) {

                /*
                    If-statement below:
                    Gets the highest valued pair:
                    Checks if there are more than 2 dice && if the die's value is > points (which would be true the first time as points is initialized as = 0)
                    So points will be assigned to the current highest value.
                    Then it loops until it finds a higher valued pair.
                */
                    if (dieFrequency.get(d) >= diePairCategory && d.dieValue() > points) {
                        points = d.dieValue();
                    }
                }
                //Hopefully checks for FULL HOUSE. Now it should have found the most valued pairs.
                else {
                    if (dieFrequency.get(d) == 2 || dieFrequency.get(d) == 3) {      //If there are 3 pairs and 2 pairs
                        if (dieFrequency.get(d) == 3) {
                            pointsFullHouse = d.dieValue() * 3;
//                            dieFrequency.replace(d, 0);
                        }
                        if (dieFrequency.get(d) == 2) {
                            pointsFullHouse += d.dieValue() * 2;
//                            dieFrequency.replace(d, 0);
                        }
                    }
                }
            }
            points += pointsFullHouse;
        }
        //FULL HOUSE
        //After we found a pair, need to check if its the highest, then if there are 2 or 3.
            //If highest + 3 pair - save.
            //If lowest 2 pair - remove.


        //YAHTZEE - All dice land on same value
        if (diePairCategory == 5) {
            for (Die d : dieFrequency.keySet()) {
                if (dieFrequency.get(d) == 5) {
                    return 50;
                }
            }
            return 0;
        }

        if (diePairCategory == 0) {     //Condition for Full house
            return points;
        }
        else {
            return points * diePairCategory;
        }
    }


    /*
        Small straight: If the dice read 1,2,3,4,5, the player scores 15 (the sum of all the dice), otherwise 0.

        Large straight: If the dice read 2,3,4,5,6, the player scores 20 (the sum of all the dice), otherwise 0.
     */


    //Small and Large Straight
    public String findStraight() {
        /*
            Sortera alla tärningar.                     CHECK
            se om de är i ordning.                      CHECK
            om värde 1 och 6 finns, inte straight
         */
        int[] findStraight = new int[5];

        for (int i = 0; i < dieArray.length; i++) {
            findStraight[i] = dieArray[i].dieValue();
        }

        //Sorted the array, now to check the condition for small/large straight
        Arrays.sort(findStraight);
        System.out.println(Arrays.toString(findStraight));

        if (findStraight[0] == 1) {     //If first die = 1 after sort, it cant be Large straight.
            for (int i = 0; i < findStraight.length; i++) {
                if (findStraight[i] != findStraight[i+1] - 1) {
                    return "Wrong";
                }
            }
            return "Small Straight";


        } else if (findStraight[4] == 6) {

        }


        //***
        for (int i = 0; i < findStraight.length - 1; i++) {
            if (findStraight[i] != findStraight[i+1] - 1) {
                if (findStraight[i] == 1) {
                    return "Small straight";
                }
                else {
                    return "Large straight";
                }
            }
        }
        return "Nothing";
    }


    public int sumPoints() {
        int chancePoints = 0;

        for (Die d : dieArray) {
            chancePoints += d.dieValue();
        }
        return chancePoints;
    }


}
