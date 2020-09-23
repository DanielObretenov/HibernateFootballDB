package FootballBetting.gameAssets;

import FootballBetting.betAssets.Bet;
import FootballBetting.betAssets.BetGame;
import FootballBetting.teamAssets.Player;
import FootballBetting.teamAssets.Team;
import entities.BaseEntity;


import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game extends BaseEntity {
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private LocalDateTime localDateTime;
    private BigDecimal homeToWinBet;
    private BigDecimal awayToWinBet;
    private BigDecimal drawBet;
    private Round round;
    private Competition competition;
    private Set<Player> players;
    private Set<GamePlayerStatistics> gamePlayerStatistics;
    private Set<Bet> bets;
    private Set<BetGame> betGamePredictions;

    public Game (){};

    @OneToOne
    @JoinColumn(name = "home_team", referencedColumnName = "id")
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }
    @OneToOne
    @JoinColumn(name = "away_team", referencedColumnName = "id")
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column(name = "home_team_goals",columnDefinition = "INT UNSIGNED")
    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }
    @Column(name = "away_team_goals",columnDefinition = "INT UNSIGNED")
    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    @Column(name = "date_time")
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Column(name = "home_team_to_win_bet")
    public BigDecimal getHomeToWinBet() {
        return homeToWinBet;
    }

    public void setHomeToWinBet(BigDecimal homeToWinBet) {
        this.homeToWinBet = homeToWinBet;
    }
    @Column(name = "away_team_to_win_bet")
    public BigDecimal getAwayToWinBet() {
        return awayToWinBet;
    }

    public void setAwayToWinBet(BigDecimal awayToWinBet) {
        this.awayToWinBet = awayToWinBet;
    }
    @Column(name = "draw_bet")
    public BigDecimal getDrawBet() {
        return drawBet;
    }

    public void setDrawBet(BigDecimal drawBet) {
        this.drawBet = drawBet;
    }

    @ManyToOne
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "player_statistics",
    joinColumns = @JoinColumn(name = "game_id"),
    inverseJoinColumns = @JoinColumn(name = "player_id"))
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @OneToMany(mappedBy = "game")
    public Set<GamePlayerStatistics> getGamePlayerStatistics() {
        return gamePlayerStatistics;
    }

    public void setGamePlayerStatistics(Set<GamePlayerStatistics> gamePlayerStatistics) {
        this.gamePlayerStatistics = gamePlayerStatistics;
    }

    @ManyToMany(mappedBy = "games")
    public Set<Bet> getBets() {
        return bets;
    }

    public void setBets(Set<Bet> bets) {
        this.bets = bets;
    }

    @OneToMany(mappedBy = "game")
    public Set<BetGame> getBetGamePredictions() {
        return betGamePredictions;
    }

    public void setBetGamePredictions(Set<BetGame> betGamePredictions) {
        this.betGamePredictions = betGamePredictions;
    }
}
