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
        hand = new Hand(new ArrayList<Card>());
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

    @Test
	public void straightShouldBeSortedInDescendingRankOrder() {
        Hand straight = Hand.fromString("4d 6h 5s 3c 7c");
        assertThat(straight.toString(), is("7c 6h 5s 4d 3c"));
	}

    @Test
	public void straightShouldHaveFiveConsecutiveRanks() {
        Hand straight = Hand.fromString("4d 6h 5s 3c 7c");
        assertThat(straight.numConnected(), is(5));
	}

    @Test
	public void aceLowStraightShouldHaveFiveConsecutiveRanks() {
        Hand lowStraight = Hand.fromString("4d Ah 5s 3c 2c");
        assertThat(lowStraight.numConnected(), is(5));
	}

    @Test
	public void aceHighStraightShouldHaveFiveConsecutiveRanks() {
        Hand highStraight = Hand.fromString("Kd Ah Js Tc Qc");
        assertThat(highStraight.numConnected(), is(5));
	}

    @Test
	public void handShouldHaveTwoConsecutiveRanks() {
        Hand hand = Hand.fromString("4d 9h 5s Kc 7c");
        assertThat(hand.numConnected(), is(2));
	}
}
