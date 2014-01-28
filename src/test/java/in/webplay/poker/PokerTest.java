package in.webplay.poker;

import org.junit.Test;
import static org.junit.Assert.*;

public class PokerTest {
    @Test
    public void canConstructAPokerWithAName() {
        Poker poker = new Poker("Larry");
        assertEquals("Larry", poker.getName());
    }
}
