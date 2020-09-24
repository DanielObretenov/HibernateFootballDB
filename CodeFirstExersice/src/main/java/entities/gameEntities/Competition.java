package entities.gameEntities;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "competition")
public class Competition  extends BaseEntity {
    private String name;
    private Set<Game> games;
    private CompetitionType competitionType;


    public Competition(String name) {
        this.name = name;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "competition")
    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @ManyToOne
    @JoinColumn(name = "competition_type",referencedColumnName = "id")
    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }
}
