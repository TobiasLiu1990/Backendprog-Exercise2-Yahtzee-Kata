package pgr209.Lecture2.Yahtzee;

/**
 * This Enum is for returning the respective value of each die.
 * Eg. A generated die that lands on 4, returns the value 4.
 */

public enum Die {
    ONE, TWO, THREE, FOUR, FIVE, SIX;

    public int dieValue() {
        return switch (this) {
            case ONE -> 1;
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
        };
    }

}
