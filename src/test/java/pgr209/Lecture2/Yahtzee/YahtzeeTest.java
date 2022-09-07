package pgr209.Lecture2.Yahtzee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YahtzeeTest {

    @Test
    void testChance() {
        //Chance - Sum of all dice
        Yahtzee game = new Yahtzee(new Die[] {Die.ONE, Die.TWO, Die.TWO, Die.FIVE, Die.FIVE});
        assertEquals(15, game.sumPoints());
    }

    @Test
    void testSumOnes() {
        Yahtzee game = new Yahtzee(new Die[] {Die.ONE, Die.ONE, Die.ONE, Die.THREE, Die.FOUR});
        assertEquals(3, game.categorizeDice(Category.ONES));
    }

    @Test
    void testSumTwos() {
        Yahtzee game = new Yahtzee(new Die[] {Die.TWO, Die.TWO, Die.TWO, Die.THREE, Die.FOUR});
        assertEquals(6, game.categorizeDice(Category.TWOS));
    }

    @Test
    void testSumThrees() {
        Yahtzee game = new Yahtzee(new Die[] {Die.THREE, Die.THREE, Die.THREE, Die.SIX, Die.FOUR});
        assertEquals(9, game.categorizeDice(Category.THREES));
    }

    @Test
    void testPair() {
        Yahtzee game = new Yahtzee(new Die[] {Die.FIVE, Die.FIVE, Die.ONE, Die.TWO, Die.THREE});
        assertEquals(10, game.categorizeDice(Category.PAIR));
    }

    @Test
    void testPairHighest() {
        Yahtzee game = new Yahtzee(new Die[] {Die.ONE, Die.ONE, Die.FIVE, Die.FIVE, Die.THREE});
        assertEquals(10, game.categorizeDice(Category.PAIR));
    }

    @Test
    void testTwoPair() {
        Yahtzee game = new Yahtzee(new Die[] {Die.FIVE, Die.FIVE, Die.ONE, Die.ONE, Die.THREE});
        assertEquals(10, game.categorizeDice(Category.TWO_PAIRS));
    }

    @Test
    void testThreeOfAKind() {
        Yahtzee game = new Yahtzee(new Die[] {Die.ONE, Die.ONE, Die.FIVE, Die.FIVE, Die.FIVE});
        assertEquals(15, game.categorizeDice(Category.THREE_OF_A_KIND));
    }

    @Test
    void testFourOfAKind() {
        Yahtzee game = new Yahtzee(new Die[] {Die.ONE, Die.FIVE, Die.FIVE, Die.FIVE, Die.FIVE});
        assertEquals(20, game.categorizeDice(Category.FOUR_OF_A_KIND));
    }

    @Test
    void testYahtzee() {
        Yahtzee game = new Yahtzee(new Die[] {Die.ONE, Die.ONE, Die.ONE, Die.ONE, Die.ONE});
        assertEquals(50, game.categorizeDice(Category.YAHTZEE));
    }

    @Test
    void testFullHouse() {
        Yahtzee game = new Yahtzee(new Die[] {Die.ONE, Die.ONE, Die.TWO, Die.TWO, Die.TWO});
        assertEquals(8, game.categorizeDice(Category.FULL_HOUSE));
    }

}
