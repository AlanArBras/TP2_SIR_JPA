package jpa;

import domain.EletronicDevice;
import domain.Heater;
import domain.Home;
import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;


public class JpaTest {

    private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
            test.createPersons();
        } catch (Exception e) {
            e.printStackTrace();
        }

        tx.commit();


        // TODOs


        manager.close();
        System.out.println("done");
    }

    private void createPersons() {
        List<Heater> heaters = new ArrayList<Heater>();
        heaters.add(new Heater("radiat1"));
        heaters.add(new Heater("radiat2"));
        heaters.add(new Heater("radiat3"));

        List<Home> homes = new ArrayList<Home>();
        homes.add(new Home("maison1", heaters));

        List<EletronicDevice> eletronicDevices = new ArrayList<EletronicDevice>();
        List<Person> friends = new ArrayList<Person>();
        Person poto1 = new Person("Huitel", "Alan", null, null, null);
        friends.add(poto1);
        manager.persist(poto1);

        Person poto2 = new Person("Barbe", "Camille", null, null, null);
        friends.add(poto2);
        manager.persist(poto2);


        Person person = new Person("Denoual", "Gwendal", null, null, friends);
        manager.persist(person);

    }


}
