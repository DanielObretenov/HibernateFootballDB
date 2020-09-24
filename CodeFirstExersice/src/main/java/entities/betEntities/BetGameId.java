package entities.betEntities;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BetGameId implements Serializable {
    private long betId;
    private long gameId;

    public BetGameId() {}

    public BetGameId(long betId, long gameId) {
        super();
        this.betId = betId;
        this.gameId = gameId;
    }

    public long getBetId() {
        return betId;
    }

    public void setBetId(long betId) {
        this.betId = betId;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetGameId betGameId = (BetGameId) o;
        return betId == betGameId.betId &&
                gameId == betGameId.gameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(betId, gameId);
    }
}
