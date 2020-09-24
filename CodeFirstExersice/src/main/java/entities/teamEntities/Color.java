package entities.teamEntities;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color extends BaseEntity {
    private String name;
    private Team firstKit;
    private Team secondaryKit;

    public Color(String name) {
        this.name = name;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(mappedBy = "primaryKit")
    public Team getFirstKit() {
        return firstKit;
    }

    public void setFirstKit(Team firstKit) {
        this.firstKit = firstKit;
    }
    @OneToOne(mappedBy = "secondaryKit")
    public Team getSecondaryKit() {
        return secondaryKit;
    }

    public void setSecondaryKit(Team secondaryKit) {
        this.secondaryKit = secondaryKit;
    }
}
