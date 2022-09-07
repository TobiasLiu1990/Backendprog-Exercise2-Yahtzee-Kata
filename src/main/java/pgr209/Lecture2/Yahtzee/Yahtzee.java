package pgr209.Lecture2.Yahtzee;

import java.util.HashMap;

public class Yahtzee {

    private final Die[] dieArray;
    private final Category[] pairPointsCategory = {Category.PAIR, Category.TWO_PAIRS, Category.THREE_OF_A_KIND, Category.FOUR_OF_A_KIND, Category.YAHTZEE, Category.FULL_HOUSE};

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

        //Switch used to find the points if the category are pairs of the same value.
            //NOT PAIR, TWO_PAIRS etc...
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

        return 11111;
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
                    If die exists more than eg 2 times and points will be 0 on first run, so the die-value will always be bigger -> true.
                    So if die exists 2 times -> Points = 2.
                    Then on next run, is the current dies value larger than 2?
                        True -> set the new value.
                        Now we have the highest valued pair.
                */
                    if (dieFrequency.get(d) >= diePairCategory && d.dieValue() > points) {          //Found biggest pair.
                        points = d.dieValue();
                    }
                    //Found the highest valued PAIR!
                } else {
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

        //Now to check FULL HOUSE
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





    //Small and Large Straight
    public int straight() {
        //            if (diePairCategory == 5) {
        //                int fullHouse = 5;
        //
        //                for (Die die : dieFrequency.keySet()) {
        //                    if (dieFrequency.get(die) == 1 && fullHouse > 0) {
        //                        fullHouse--;
        //                    }
        //                }
        //            }

        return 0;
    }

    public int sumPoints() {
        int chancePoints = 0;

        for (Die d : dieArray) {
            chancePoints += d.dieValue();
        }
        return chancePoints;
    }


}
