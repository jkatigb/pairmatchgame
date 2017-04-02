import com.example.josh.pairmatchgame.GameModel
import com.example.josh.pairmatchgame.GamePresenter
import org.junit.Test

/**
 * Created by Josh on 3/31/2017.
 */
class GameTest {
    @Test
    fun kingInFirstFoundationPile() {
        var numGames = 0
        val maxGames = 10000

        for (i in 0..maxGames) {

            GameModel.resetGame()
            for (j in 1..100) {
                GamePresenter.onDeckTap()
                GamePresenter.onWasteTap()
                GameModel.tableauPiles.forEachIndexed { index, tableauPile ->
                    GamePresenter.onTableauTap(index, tableauPile.cards.lastIndex)
                }
            }
            if (GameModel.foundationPiles[0].cards.size == 13) {
                break
            }
        }
        GameModel.debugPrint()
        println("# Games: $numGames")
        assert(numGames < maxGames)
    }
}