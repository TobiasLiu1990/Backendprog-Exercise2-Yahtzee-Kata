package pgr209.Lecture2.Yahtzee;

import java.util.HashMap;

public class Yahtzee {

    private Die[] dieArray;
    private Category[] pointCategory = Category.values();

    public Yahtzee(Die[] dieArray) {
        this.dieArray = dieArray;
    }


    /*
        Categorize all the dice.
            - Find pairs
            - Find sum.
     */
    public int categorizeDice(Category inputCategory) {
        HashMap<Die, Integer> dieFrequency = new HashMap<>();

        //Add all values from Die to HashMap first.
        for (Die d : Die.values()) {
            dieFrequency.put(d, 0);
        }

        //Check if our Dice exist and add to HashMap. Also checks for duplicates.
        for (Die d : dieArray) {
            if (dieFrequency.containsKey(d)) {
                dieFrequency.put(d, dieFrequency.get(d) + 1);
            }
        }

        //Find right category of points, calculate points.
        int points = 0;

        switch (inputCategory) {
            case ONES -> {return dieFrequency.get(Die.ONE);}
            case TWOS -> {return dieFrequency.get(Die.TWO) * 2;}
            case ONES -> {return dieFrequency.get(Die.ONE);}
            case ONES -> {return dieFrequency.get(Die.ONE);}
            case ONES -> {return dieFrequency.get(Die.ONE);}
            case ONES -> {return dieFrequency.get(Die.ONE);}
        }


            if (inputCategory) {
                points = findEquals(dieFrequency);
                return points;
            }




        return 0;
    }
    //TWO PAIRS
    public int findEquals(HashMap<Die, Integer> dieFrequency, int dieCategory) {
        int points = 0;

        for (Die d : dieFrequency.keySet()) {
            if (dieFrequency.get(d) >= dieCategory && points < d.dieValue()) {
                points = d.dieValue();
            }
        }

        return points*dieCategory;
    }

    public int sumPoints() {
        int chancePoints = 0;

        for (Die d : dieArray) {
            chancePoints += d.dieValue();
        }
        return chancePoints;
    }

    public int countPoints(int category) {
//        int numberOfDuplicates = 0;
//        for (Die d : dieArray) {
//            if (dieFrequency.get(d) >= 2) {
//
//            }
//        }

        int counter = 0;

        for (Die d : dieArray) {
            if (d.dieValue() == category) {
                counter++;
            }
        }
        return counter * category;
    }

}
