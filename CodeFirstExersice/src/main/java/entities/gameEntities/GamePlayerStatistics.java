package entities.gameEntities;

import entities.teamEntities.Player;

import javax.persistence.*;

@Entity
@Table(name = "player_statistics")
public class GamePlayerStatistics {
    private GamePlayerId gamePlayerId;
    private Game game;
    private Player player;
    private int assists;
    private int goals;

    public GamePlayerStatistics(){
        setGamePlayerId(new GamePlayerId());
    }
    @EmbeddedId
    public GamePlayerId getGamePlayerId() {
        return gamePlayerId;
    }

    public void setGamePlayerId(GamePlayerId gamePlayerId) {
        this.gamePlayerId = gamePlayerId;
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
    @MapsId("playerId")
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Column
    public int getAssists() {
        return assists;
    }
    public void setAssists(int assists) {
        this.assists = assists;
    }
    @Column
    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
