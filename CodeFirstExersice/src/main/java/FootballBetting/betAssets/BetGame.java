package FootballBetting.betAssets;

import FootballBetting.gameAssets.Game;

import javax.persistence.*;

@Entity
@Table(name = "bet_games")
public class BetGame {
    private BetGameId betGameId;
    private Game game;
    private Bet bet;
    private ResultPrediction resultPrediction;

    public BetGame(){
        setBetGameId(new BetGameId());
    }

    @EmbeddedId
    public BetGameId getBetGameId() {
        return betGameId;
    }

    public void setBetGameId(BetGameId betGameId) {
        this.betGameId = betGameId;
    }

    @ManyToOne
    @MapsId("gameId")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
    @ManyToOne
    @MapsId("betId")
    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    @ManyToOne
    @JoinColumn(name = "result_prediction")
    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
