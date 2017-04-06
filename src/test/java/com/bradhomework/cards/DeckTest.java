package com.bradhomework.cards;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Test class for Deck.
 */
@Slf4j
public class DeckTest {

    /**
     * Tests Deck constructor
     */
    @Test(groups = {"fast", "unit"})
    public void testDeck() {
        Deck deck = new Deck();
        assertThat(deck, is(notNullValue()));

        // Count cards left in deck
        Iterator<Card> cardIterator = deck.iterator();
        int cardCnt = 0;
        while(cardIterator.hasNext()) {
            cardCnt++;
            cardIterator.next();
        }
        assertThat(cardCnt, is(Deck.CARDS_IN_DECK));
    }

    /**
     * Tests shuffle function
     */
    @Test(groups = {"fast", "unit"})
    public void testShuffle() {
        Deck deck = new Deck();
        assertThat(deck, is(notNullValue()));

        // Save preShuffle deck values
        List<Card> preShuffle = new ArrayList<>();
        deck.iterator().forEachRemaining(preShuffle::add);

        deck.shuffle();

        // Save postShuffle deck values
        List<Card> postShuffle = new ArrayList<>();
        deck.iterator().forEachRemaining(postShuffle::add);

        // Assert not equal
        assertThat(preShuffle, is(not(postShuffle)));
    }

    /**
     * Tests dealOne deals a card and the number of cards left in deck reflects dealt card.
     */
    @Test(groups = {"fast", "unit"})
    public void testDealOne() {
        Deck deck = new Deck();
        assertThat(deck, is(notNullValue()));

        // Get deck values
        List<Card> cardList = new ArrayList<>();
        deck.iterator().forEachRemaining(cardList::add);

        int initialDeckSize = cardList.size();
        assertThat(initialDeckSize, is(equalTo(Deck.CARDS_IN_DECK)));

        Card card = deck.dealOneCard();
        assertThat(card, is(notNullValue()));

        // Get deck values after deal.
        cardList = new ArrayList<>();
        deck.iterator().forEachRemaining(cardList::add);

        // Assert one less card in deck
        assertThat(initialDeckSize - 1, is(equalTo(cardList.size())));
    }

    /**
     * Tests deal entire deck.
     */
    @Test(groups = {"fast", "unit"})
    public void testDealAll() {
        Deck deck = new Deck();
        assertThat(deck, is(notNullValue()));

        // Get deck values.
        List<Card> cardList = new ArrayList<>();
        deck.iterator().forEachRemaining(cardList::add);

        int initialDeckSize = cardList.size();
        assertThat(initialDeckSize, is(equalTo(Deck.CARDS_IN_DECK)));

        // deal all cards in deck.
        for (int i = 0; i < initialDeckSize; i++) {
            Card card = deck.dealOneCard();
            log.info("Dealing " +  card);
        }

        // Get deck values after deal.
        cardList = new ArrayList<>();
        deck.iterator().forEachRemaining(cardList::add);

        // Assert number of cards in deck is 0.
        assertThat(cardList.size(), is(equalTo(0)));
    }

    /**
     * Tests dealing more cards than cards in deck.
     */
    @Test(groups = {"fast", "unit"})
    public void testDealAllPlusOne() {
        Deck deck = new Deck();
        Card card;

        assertThat(deck, is(notNullValue()));

        // Get deck values.
        List<Card> cardList = new ArrayList<>();
        deck.iterator().forEachRemaining(cardList::add);

        int initialDeckSize = cardList.size();
        assertThat(initialDeckSize, is(equalTo(Deck.CARDS_IN_DECK)));

        // deal all cards in deck.
        for (int i = 0; i < initialDeckSize; i++) {
            card = deck.dealOneCard();
        }

        // Check subsequent calls return null
        card = deck.dealOneCard();
        assertThat(card, is(nullValue()));
    }

}
