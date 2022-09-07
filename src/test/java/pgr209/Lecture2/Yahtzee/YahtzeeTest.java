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

}
