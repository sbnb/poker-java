package in.webplay.poker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class HandTest {
    Hand hand;

    @Before
    public void before() {
        hand = new Hand(null);
    }

    @Test
    public void shouldBeAbleToBuildAHandFromAString() {
        String cardStr = "As Ac Kd Kh 7c";
        Hand hand = Hand.fromString(cardStr);
        assertEquals(cardStr, hand.toString());
    }
        
    @Test
	public void shouldIdentifyThreeSameSuits() throws Exception {
		Hand threeFlush = Hand.fromString("2c 5d 8c Ac 7h");
		assertThat(threeFlush.numSameSuits(), is(3));
	}
    
    @Test
	public void flushShouldHaveFiveSameSuits() {
		Hand flush = Hand.fromString("2c 5c 8c Ac 7c");
		assertThat(flush.numSameSuits(), is(5));		
	}
}

//describe('POKER.Hand.numSameSuits()', function () {
//    it('trip aces should have two same suits', function () {
//        tripAces.numSameSuits().should.equal(2);
//    });
//
//    it('flush should have five same suits', function () {
//        flush.numSameSuits().should.equal(5);
//    });
//
//});
