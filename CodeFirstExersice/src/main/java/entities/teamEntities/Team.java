package entities.teamEntities;

import entities.gameEntities.Game;
import entities.locationEntities.Town;
import entities.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team extends BaseEntity {
   private String name;
   private String logo;
   private String initials;
   private BigDecimal budget;
   private Town town;
   private Color primaryKit;
   private Color secondaryKit;
   private Set<Player> players;
   private Game homeGame;
   private Game awayGame;


    public Team(String name) {
        this.name = name;
        setInitials(name);
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    @Column
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        if (this.initials.length() >= 3){
            this.initials = initials.substring(0,3).toUpperCase();
        }else {
            this.initials = initials.toUpperCase();
        }
    }
    @Column
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
    @ManyToOne
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @OneToOne
    @JoinColumn(name = "primary_kit_id", referencedColumnName = "id")
    public Color getPrimaryKit() {
        return primaryKit;
    }

    public void setPrimaryKit(Color primaryKit) {
        this.primaryKit = primaryKit;
    }

    @OneToOne
    @JoinColumn(name = "secondary_kit_id", referencedColumnName = "id")
    public Color getSecondaryKit() {
        return secondaryKit;
    }

    public void setSecondaryKit(Color secondaryKit) {
        this.secondaryKit = secondaryKit;
    }

    @OneToMany(mappedBy = "team")
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @OneToOne(mappedBy = "homeTeam")
    public Game getHomeGame() {
        return homeGame;
    }

    public void setHomeGame(Game homeGame) {
        this.homeGame = homeGame;
    }
    @OneToOne(mappedBy = "awayTeam")
    public Game getAwayGame() {
        return awayGame;
    }

    public void setAwayGame(Game awayGame) {
        this.awayGame = awayGame;
    }
}
