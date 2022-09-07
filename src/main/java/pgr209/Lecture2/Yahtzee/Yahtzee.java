package pgr209.Lecture2.Yahtzee;

import java.util.HashMap;

public class Yahtzee {

    private Die[] dieArray;

    public Yahtzee(Die[] dieArray) {
        this.dieArray = dieArray;
        Die[] a  = Die.values();
    }

    /*
        Categorize all the dice.
            - Find pairs
            - Find sum.
     */
    public int categorizeDice() {
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





        return 10;
    }

    public int sumPoints() {
        int chancePoints = 0;

        for (Die d : dieArray) {
            chancePoints += d.dieValue();
        }
        return chancePoints;
    }

    public int sumPairsOfOnes(int category) {
        int counter = 0;

        for (Die d : dieArray) {
            if (d.dieValue() == category) {
                counter++;
            }
        }
        return counter * category;
    }

}
