package com.example.josh.pairmatchgame

/**
 * Created by Josh on 3/31/2017.
 */

class TableauPile(var cards: MutableList<Card> = mutableListOf()) {
    init {
        if (cards.size > 0) cards.last().faceUp = true

    }

    fun addCards(newCards: MutableList<Card>): Boolean {
        if (cards.size > 0) {
            if (newCards.first().value == cards.last().value - 1  // or if the first value in the pile is equal to the last value - 1 of cards
                    && suitCheck(newCards.first(), cards.last())) { // and they're both different suits
                cards.addAll(newCards)
                return true
            }
        } else if (newCards.first().value == 12) {
            cards.addAll(newCards)
            return true
        }
        return false
    }

    fun removeCards(tappedIndex: Int) {
        for (i in tappedIndex..cards.lastIndex) {
            cards.removeAt(tappedIndex)

        }
        if (cards.size > 0) {
            cards.last().faceUp = true
        }


    }

    private fun suitCheck(c1: Card, c2: Card): Boolean {
        if (redSuits.contains(c1.suit) && blackSuits.contains(c2.suit)
                || (blackSuits.contains(c1.suit) && redSuits.contains((c2.suit)))) return true
        return false

    }
}