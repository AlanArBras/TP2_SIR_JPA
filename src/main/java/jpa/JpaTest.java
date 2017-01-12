package jpa;

import domain.ElectronicDevice;
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

        List<Person> gwendalsfriends = new ArrayList<Person>();
        List<Person> alansfriends = new ArrayList<Person>();

        Person friend = new Person("Barbe", "Camille", null, null, null);
        gwendalsfriends.add(friend);
        alansfriends.add(friend);
        manager.persist(friend);

        friend = new Person("Huitel", "Alan", null, null, alansfriends);
        gwendalsfriends.add(friend);
        manager.persist(friend);



        Person person = new Person("Denoual", "Gwendal", createHomes(), createElectronicDevices(), gwendalsfriends);
        manager.persist(person);

    }

    private List<Home> createHomes() {
        List<Heater> heaters = new ArrayList<Heater>();
        heaters.add(new Heater("heater11"));
        heaters.add(new Heater("heater12"));
        heaters.add(new Heater("heater13"));

        List<Home> homes = new ArrayList<Home>();
        homes.add(new Home("maison1", heaters));

        heaters = new ArrayList<Heater>();
        heaters.add(new Heater("heater21"));
        heaters.add(new Heater("heater22"));
        heaters.add(new Heater("heater23"));

        homes.add(new Home("maison2", heaters));
        return homes;
    }

    private List<ElectronicDevice> createElectronicDevices() {
        List<ElectronicDevice> electronicDevices = new ArrayList<ElectronicDevice>();
        electronicDevices.add(new ElectronicDevice("device1", 1000));
        electronicDevices.add(new ElectronicDevice("device2", 1200));
        electronicDevices.add(new ElectronicDevice("device3", 1500));
        return electronicDevices;
    }


}
