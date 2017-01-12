package domain;

import javax.persistence.*;

/**
 * Created by alan on 1/10/17.
 */
@Entity
public class Heater extends SmartDevice {

    private Home home;

    public Heater() {
    }

    public Heater(String name) {
        super(name);
    }


    @ManyToOne
    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }
}
