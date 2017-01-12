package domain;

import javax.persistence.*;

/**
 * Created by alan on 1/10/17.
 */
@Entity
public class Heater {

    private long id;
    private String name;
    private Home home;

    public Heater(String name) {
        this.name = name;
    }

    public Heater() {
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
