package entities.gameEntities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GamePlayerId implements Serializable {
    private static final  long serialVersionUID = 1l;
    private long gameId;
    private long playerId;

    public GamePlayerId(){};

    public GamePlayerId(long gameId, long playerId) {
        super();
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamePlayerId that = (GamePlayerId) o;
        return gameId == that.gameId &&
                playerId == that.playerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, playerId);
    }
}
