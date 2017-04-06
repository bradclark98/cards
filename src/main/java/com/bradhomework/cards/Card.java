package com.bradhomework.cards;

import lombok.Getter;

/**
 * A standard card.
 */
@Getter
public class Card {

    /**
     * Suit of card.
     */
    private Suit suit;

    /**
     * Rank of card.
     */
    private Rank rank;

    /**
     * Constructs a Card.
     *
     * @param suit of card.
     * @param rank of card.
     */
    public Card(final Suit suit, final Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
