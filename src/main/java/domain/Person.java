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
    private List<EletronicDevice> eletronicDevices;
    private List<Person> friends;



    public Person(){

    }

    public Person(String nom, String prenom, List<Home> homes, List<EletronicDevice> eletronicDevices, List<Person> friends) {
        this.nom = nom;
        this.prenom = prenom;
        this.homes = homes;
        this.eletronicDevices = eletronicDevices;
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

    @OneToMany(mappedBy = "person")
    public List<EletronicDevice> getEletronicDevices() {
        return eletronicDevices;
    }

    public void setEletronicDevices(List<EletronicDevice> eletronicDevices) {
        this.eletronicDevices = eletronicDevices;
    }

    @ManyToMany
    @JoinTable(
            name = "PERSON_FRIENDS",
            joinColumns = @JoinColumn(name = "ID_PERSON", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_FRIEND", referencedColumnName="ID")
    )
    public List<Person> getFriends() {
        return friends;
    }

    public void setFriends(List<Person> friends) {
        this.friends = friends;
    }
}
