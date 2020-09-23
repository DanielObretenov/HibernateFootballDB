package FootballBetting.betAssets;

import FootballBetting.UserInfo.User;
import FootballBetting.gameAssets.Game;
import entities.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name = "bets")
public class Bet extends BaseEntity {
    private BigDecimal betMoney;
    private LocalDateTime dateTime;
    private User user;
    private Set<Game> games;
    private Set<BetGame> betGamePredictions;

    public Bet(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    @Column(name = "bet_money")
    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }
    @Column(name = "date_time")
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany
    @JoinTable(name = "bet_games",
    joinColumns = @JoinColumn(name = "bet_id"),
    inverseJoinColumns = @JoinColumn(name = "game_id"))
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @OneToMany(mappedBy = "bet")
    public Set<BetGame> getBetGamePredictions() {
        return betGamePredictions;
    }

    public void setBetGamePredictions(Set<BetGame> betGamePredictions) {
        this.betGamePredictions = betGamePredictions;
    }
}
