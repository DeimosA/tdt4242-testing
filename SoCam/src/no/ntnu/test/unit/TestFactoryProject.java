package no.ntnu.test.unit;

import junit.framework.TestCase;
import no.ntnu.fp.model.*;

import java.util.ArrayList;

public class TestFactoryProject extends TestCase {
    public void testGetVehicleIndex() {
        FactoryProject factoryProject = new FactoryProject();
        factoryProject.addVehicle(new Vehicle("3d", "log", new ArrayList<>(), "ser"));
        factoryProject.addVehicle(new Vehicle("4d", "log", new ArrayList<>(), "ser"));
        factoryProject.addVehicle(new Vehicle("5d", "log", new ArrayList<>(), "ser"));

        assertEquals(0, factoryProject.getVehicleIndex("3d"));
        assertEquals(1, factoryProject.getVehicleIndex("4d"));
        assertEquals(2, factoryProject.getVehicleIndex("5d"));
    }

    public void testCount() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("5d", "log", new ArrayList<>(), "ser"));
        vehicles.add(new Vehicle("4d", "log", new ArrayList<>(), "ser"));
        vehicles.add(new Vehicle("3d", "log", new ArrayList<>(), "ser"));

        ArrayList<SimpleEcu> ecus = new ArrayList<>();
        ecus.add(new SimpleEcu(1));
        ecus.add(new SimpleEcu(2));
        ecus.add(new SimpleEcu(3));
        ecus.add(new SimpleEcu(4));

        ArrayList<Software> softwares = new ArrayList<>();
        softwares.add(new Software());
        softwares.add(new Software());
        softwares.add(new Software());
        softwares.add(new Software());
        softwares.add(new Software());

        FactoryProject factoryProject = new FactoryProject(vehicles, softwares, ecus);

        assertEquals(3, factoryProject.getVehicleCount());
        assertEquals(4, factoryProject.getEcuCount());
        assertEquals(5, factoryProject.getSoftwareCount());
    }

    public void testGetters() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Vehicle testGetVehicle = new Vehicle("3d", "log", new ArrayList<>(), "ser");
        vehicles.add(new Vehicle("5d", "log", new ArrayList<>(), "ser"));
        vehicles.add(new Vehicle("4d", "log", new ArrayList<>(), "ser"));
        vehicles.add(testGetVehicle);

        ArrayList<SimpleEcu> ecus = new ArrayList<>();
        SimpleEcu testGetEcu = new SimpleEcu(3);
        ecus.add(new SimpleEcu(1));
        ecus.add(new SimpleEcu(2));
        ecus.add(new SimpleEcu(4));
        ecus.add(testGetEcu);

        ArrayList<Software> softwares = new ArrayList<>();
        Software testGetSoftware = new Software();
        softwares.add(new Software());
        softwares.add(testGetSoftware);
        softwares.add(new Software());
        softwares.add(new Software());
        softwares.add(new Software());

        FactoryProject factoryProject = new FactoryProject(vehicles, softwares, ecus);

        assertEquals(testGetVehicle, factoryProject.getVehicle(2));
        assertEquals(testGetEcu, factoryProject.getEcu(3));
        assertEquals(testGetSoftware, factoryProject.getSoftware(1));
    }

    public void testGetLatest(){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Vehicle testGetVehicle = new Vehicle("3d", "log", new ArrayList<>(), "ser");
        vehicles.add(new Vehicle("5d", "log", new ArrayList<>(), "ser"));
        vehicles.add(new Vehicle("4d", "log", new ArrayList<>(), "ser"));
        vehicles.add(testGetVehicle);

        ArrayList<SimpleEcu> ecus = new ArrayList<>();
        SimpleEcu testGetEcu = new SimpleEcu(3);
        ecus.add(new SimpleEcu(1));
        ecus.add(new SimpleEcu(2));
        ecus.add(new SimpleEcu(4));
        ecus.add(testGetEcu);

        ArrayList<Software> softwares = new ArrayList<>();
        Software testGetSoftware = new Software();
        softwares.add(new Software());
        softwares.add(new Software());
        softwares.add(new Software());
        softwares.add(new Software());
        softwares.add(testGetSoftware);

        FactoryProject factoryProject = new FactoryProject(vehicles, softwares, ecus);

        assertEquals(testGetVehicle, factoryProject.getLatestVehicle());
        assertEquals(testGetEcu, factoryProject.getLatestEcu());
        assertEquals(testGetSoftware, factoryProject.getLatestSoftware());
    }

    public void testEqual(){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Vehicle testGetVehicle = new Vehicle("3d", "log", new ArrayList<>(), "ser");
        vehicles.add(new Vehicle("5d", "log", new ArrayList<>(), "ser"));
        vehicles.add(new Vehicle("4d", "log", new ArrayList<>(), "ser"));
        vehicles.add(testGetVehicle);

        ArrayList<SimpleEcu> ecus = new ArrayList<>();
        SimpleEcu testGetEcu = new SimpleEcu(3);
        ecus.add(new SimpleEcu(1));
        ecus.add(new SimpleEcu(2));
        ecus.add(new SimpleEcu(4));
        ecus.add(testGetEcu);

        ArrayList<Software> softwares = new ArrayList<>();
        Software testGetSoftware = new Software();
        softwares.add(new Software());
        softwares.add(new Software());
        softwares.add(new Software());
        softwares.add(new Software());
        softwares.add(testGetSoftware);

        // creating the same factories
        FactoryProject factoryProject = new FactoryProject(vehicles, softwares, ecus);
        FactoryProject factoryProject2 = new FactoryProject(vehicles, softwares, ecus);

        // slighly altered version of each list.
        ArrayList<Vehicle> vehicles1 = new ArrayList<>(vehicles);
        vehicles1.remove(vehicles1.size() - 1);

        ArrayList<SimpleEcu> ecus1 = new ArrayList<>(ecus);
        ecus1.remove(ecus1.size() - 1);

        ArrayList<Software> softwares1 = new ArrayList<>(softwares);
        softwares1.remove(softwares1.size() - 1);

        FactoryProject factoryProject3 = new FactoryProject(vehicles1, softwares1, ecus1);

        assertEquals(true, factoryProject.equals(factoryProject2));
        assertEquals(false, factoryProject.equals(factoryProject3));



        // changing each list individually

        // different list of vehicles
        factoryProject3 = new FactoryProject(vehicles1, softwares, ecus);
        assertEquals("vehicle list is different, but they are said to be equal", false, factoryProject.equals(factoryProject3));

        // different list of softwares
        factoryProject3 = new FactoryProject(vehicles, softwares1, ecus);
        assertEquals("software list is different, but they are said to be equal", false, factoryProject.equals(factoryProject3));

        // different list of SimpleEcu
        factoryProject3 = new FactoryProject(vehicles, softwares, ecus1);
        assertEquals("simpleecu list is different, but they are said to be equal", false, factoryProject.equals(factoryProject3));


    }
}
