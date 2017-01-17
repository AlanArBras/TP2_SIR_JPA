package domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alan on 1/10/17.
 */
@Entity
public class Home {

    private long id;
    private String nomMaison;
    private Person person;
    
    //Les entités doivent de préférence ne contenir que les @ JPA, setteurs, getteurs ce qui correspond au code métier (les tables dans la BD en gros).
    //Les initialisations devront se faire de préférence dans une autre classe qui contient pas le @Entity comme les classes de test, ton main, etc..
    private List<Heater> heaters;

    public Home(String nomMaison, List<Heater> heaters) {
        this.nomMaison = nomMaison;
        this.heaters = heaters;
        initHeaters();
    }

    private void initHeaters() {
        if (heaters != null)
            for (Heater heater : heaters) {
                heater.setHome(this);
            }
    }

    public Home() {
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNomMaison() {
        return nomMaison;
    }

    public void setNomMaison(String nomMaison) {
        this.nomMaison = nomMaison;
    }

    @OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
    public List<Heater> getHeaters() {
        return heaters;
    }

    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }

    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
