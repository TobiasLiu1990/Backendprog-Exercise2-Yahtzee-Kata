package pgr209.Lecture2.Yahtzee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class YahtzeeTest {

    @Test
    void testChance() {
        //Chance - Sum of all dice
        Yahtzee game = new Yahtzee(new int[] {1,2,2,5,5});
        assertEquals(15, game.sumPoints());
    }

    @Test
    void testSumOnes() {
        Yahtzee game = new Yahtzee(new int[] {1,1,1,2,3,4});
        assertEquals(3, game.sumPairsOfOnes());
    }

    @Test
    void testSumTwos() {
        Yahtzee game = new Yahtzee(new int[] {2,2,2,3,4});

        assertEquals(6, game.sumPairsOfTwos());

    }

    @Test
    void testPairs() {
        Yahtzee game = new Yahtzee(new int[] {5,5,1,2,3});
        assertEquals(10, game.categorizeDice());
    }

}
