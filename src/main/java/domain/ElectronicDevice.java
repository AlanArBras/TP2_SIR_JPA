package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by alan on 1/10/17.
 */
@Entity
public class ElectronicDevice {

    private long Id;
    private String nom;
    private double consoWattH;
    private Person person;


    public ElectronicDevice(){

    }

    public ElectronicDevice(String nom, double consoWattH) {
        this.nom = nom;
        this.consoWattH = consoWattH;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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


