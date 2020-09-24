package entities.teamEntities;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position extends BaseEntity {
    private String positionDescription;
    private Set<Player> players;

    public Position(String positionDescription) {
        this.positionDescription = positionDescription;
    }
    @Column(name = "position_description")
    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }
    @OneToMany(mappedBy = "position")
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
