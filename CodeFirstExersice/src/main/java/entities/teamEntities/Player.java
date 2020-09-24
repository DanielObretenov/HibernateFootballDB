package entities.teamEntities;

import entities.gameEntities.Game;
import entities.gameEntities.GamePlayerStatistics;
import entities.BaseEntity;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player extends BaseEntity {
    private String name;
    private  int squadNumber;
    private boolean isInjured;
    private Position position;
    private Team team;
    private Set<Game> games;
    private Set<GamePlayerStatistics> gamePlayerStatistics;


    public Player(){};
    public Player(String name) {
        this.name = name;
    }


    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "squad_number")
    public int getSquadNumber() {
        return squadNumber;
    }


    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    @Column(name = "is_injured")
    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @ManyToOne
    @JoinColumn(name = "team_id",referencedColumnName = "id")
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @ManyToMany(mappedBy = "players",cascade = CascadeType.ALL)
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @OneToMany(mappedBy = "player")
    public Set<GamePlayerStatistics> getGamePlayerStatistics() {
        return gamePlayerStatistics;
    }

    public void setGamePlayerStatistics(Set<GamePlayerStatistics> gamePlayerStatistics) {
        this.gamePlayerStatistics = gamePlayerStatistics;
    }
}
