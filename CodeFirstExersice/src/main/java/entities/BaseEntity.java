package entities;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    private long id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public BaseEntity(){

    }
}
