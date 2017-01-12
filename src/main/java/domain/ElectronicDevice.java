package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by alan on 1/10/17.
 */
@Entity
public class ElectronicDevice extends SmartDevice {

    private double consoWattH;
    private Person person;


    public ElectronicDevice() {

    }

    public ElectronicDevice(String name, double consoWattH) {
        super(name);
        this.consoWattH = consoWattH;
    }

    public double getConsoWattH() {
        return consoWattH;
    }

    public void setConsoWattH(double consoWattH) {
        this.consoWattH = consoWattH;
    }

    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}


