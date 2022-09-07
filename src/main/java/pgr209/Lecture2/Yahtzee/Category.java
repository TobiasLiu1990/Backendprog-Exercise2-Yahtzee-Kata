package pgr209.Lecture2.Yahtzee;

/**
 * This Enum is used to categorize all the possible ways to earn points.
 * Eg. if the category SMALL_STRAIGHT is picked, that means that you have the dice of 1,2,3,4,5.
 */

public enum Category {
    //The Enums that share similar functionality are collected on the same line.

    ONES, TWOS, THREES, FOURS, FIVES, SIXES,

    PAIR, TWO_PAIRS, THREE_OF_A_KIND, FOUR_OF_A_KIND, YAHTZEE, FULL_HOUSE,

    SMALL_STRAIGHT, LARGE_STRAIGHT,

    CHANCE;

}
