package com.bradhomework.cards;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * A standard deck of cards.
 */
@Slf4j
public class Deck implements Iterable<Card> {

    public static final int CARDS_IN_DECK = 52;

    /**
     * List of cards in deck.
     */
    private List<Card> cards = new ArrayList<Card>(CARDS_IN_DECK);

    /**
     * Constructs an unsorted deck of cards.
     */
    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    /**
     * Shuffles the cards in place.
     */
    public final void shuffle() {
        Random randomnizer = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int randomIndex = randomnizer.nextInt(cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, temp);
        }
    }

    /**
     * Deals one card from the deck.
     *
     * @return Card being dealt.
     */
    public final Card dealOneCard() {
        // If cards aren't defined or no cards remain return null.
        // Requirement is on "53rd call dealOneCard(), no card is dealt" so I'm assuming no card is null.
        if (cards == null || cards.size() == 0) {
            return null;
        }

        // More efficient to deal from effectively the bottom of the deck.
        return cards.remove(cards.size() - 1);
    }

    /**
     * Implements an iterator for cards in deck.
     *
     * @return an iterator of cards.
     */
    public final Iterator<Card> iterator() {
        return cards.iterator();
    }

}
