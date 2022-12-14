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
        assertEquals(3, game.countPoints(1));
    }

    @Test
    void testSumTwos() {
        Yahtzee game = new Yahtzee(new Die[] {Die.TWO, Die.TWO, Die.TWO, Die.THREE, Die.FOUR});
        assertEquals(6, game.countPoints(2));

    }

    @Test
    void testPairs() {
        Yahtzee game = new Yahtzee(new Die[] {Die.FIVE, Die.FIVE, Die.ONE, Die.TWO, Die.THREE});
        assertEquals(10, game.categorizeDice(Category.TWO_PAIRS));
    }

    @Test
    void testDieValue() {
        Die die = Die.TWO;
        int a = die.dieValue();
        System.out.println(a);
    }

}
