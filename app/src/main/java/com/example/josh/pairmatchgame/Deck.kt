package com.example.josh.pairmatchgame

import java.util.*

/**
 * Created by Josh on 3/31/2017.
 */
class Deck {
    //    val isEvened: Int = if (deckSize % 2 == 0) deckSize else deckSize - 1
    val cards: Array<Card> = Array(52, { it -> Card((it % 13), getSuit(it)) })
    var cardsInDeck: MutableList<Card> = cards.toMutableList()

    private fun getSuit(i: Int) = when (i / 13) {
        0 -> clubs
        1 -> diamonds
        2 -> hearts
        else -> spades
    }

    fun drawCard(): Card = cardsInDeck.removeAt(0)

    fun reset() {
        cardsInDeck = cards.toMutableList()
        cardsInDeck.forEach { it.faceUp = false }
        Collections.shuffle(cardsInDeck)

    }

}