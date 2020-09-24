package entities.locationEntities;

import entities.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "continents")
public class Continent extends BaseEntity {
    private String name;

    private Set<Country> countries;
    public Continent(String name) {
        this.name = name;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToMany(mappedBy = "continents")
    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
