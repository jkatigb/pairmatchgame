package com.example.josh.pairmatchgame.no_android

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import com.example.josh.pairmatchgame.GameModel
import com.example.josh.pairmatchgame.GamePresenter
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by Josh on 3/31/2017.
 */

class FoundationPileView(ctx: Context, val index: Int) : ImageView(ctx) {
    init {
        imageResource = emptyPileDrawable
        onClick {
            GamePresenter.onFoundationTap(index)
        }
    }

    fun update() {
        val cards = GameModel.foundationPiles[index].cards
        imageResource = if (cards.isNotEmpty()) getResIdForCard(cards.last()) else emptyPileDrawable
    }


}

fun ViewManager.foundationPileView(index: Int, init: FoundationPileView.() -> Unit = {}) = ankoView({ FoundationPileView(it, index) }, 0, init)

