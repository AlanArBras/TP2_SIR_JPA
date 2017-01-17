package domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alan on 1/10/17.
 */
@Entity
public class Person {

    private long id;
    private String nom;
    private String prenom;
    private List<Home> homes;
    private List<ElectronicDevice> electronicDevices;
    private List<Person> friends;


    public Person() {

    }

    public Person(String nom, String prenom, List<Home> homes, List<ElectronicDevice> electronicDevices, List<Person> friends) {
        this.nom = nom;
        this.prenom = prenom;
        this.homes = homes;
        this.electronicDevices = electronicDevices;
        this.friends = friends;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    public List<Home> getHomes() {
        return homes;
    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    public List<ElectronicDevice> getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(List<ElectronicDevice> electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    @ManyToMany
    @JoinTable(
            name = "PERSON_FRIENDS",
            joinColumns = @JoinColumn(name = "ID_PERSON", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_FRIEND", referencedColumnName = "ID")
    )
    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }
}
