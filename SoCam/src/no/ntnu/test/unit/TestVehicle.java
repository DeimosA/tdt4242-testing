package no.ntnu.test.unit;

import junit.framework.TestCase;
import no.ntnu.fp.model.Ecu;
import no.ntnu.fp.model.Vehicle;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class TestVehicle extends TestCase {
    public void testEcuCount() {
        Vehicle vehicle = new Vehicle();
        for(int i = 0; i < 5; i++){
            vehicle.addEcu(new Ecu(i));
        }
        assertEquals(5, vehicle.getEcuCount());
    }

    public void testEcuGet() {
        Vehicle vehicle = new Vehicle();
        Ecu ecu1 = new Ecu(1);
        Ecu ecu2 = new Ecu(2);
        vehicle.addEcu(ecu1);
        vehicle.addEcu(ecu2);

        assertEquals(ecu1, vehicle.getEcu(0));
        assertEquals(ecu2, vehicle.getEcu(1));

        ArrayList ecus = new java.util.ArrayList();
        ecus.add(ecu1);
        ecus.add(ecu2);
        assertEquals(ecus, vehicle.getEcus());

        vehicle.removeEcu(ecu1);
        ecus.remove(ecu1);
        assertEquals(ecus, vehicle.getEcus());
    }

    public void testEcuRemove(){
        Vehicle vehicle = new Vehicle();
        Ecu ecu1 = new Ecu(1);
        Ecu ecu2 = new Ecu(2);
        vehicle.addEcu(ecu1);
        vehicle.addEcu(ecu2);

        ArrayList<Ecu> ecus = new java.util.ArrayList<>();
        ecus.add(ecu2);

        vehicle.removeEcu(ecu1);
        assertEquals(ecus, vehicle.getEcus());

    }

    public void testLargestEcuID() {
        Vehicle vehicle = new Vehicle();

        assertEquals(0, vehicle.getLargestEcuId());
        for(int i = 1; i <= 3; i++){
            vehicle.addEcu(new Ecu(i*10));
        }

        assertEquals(30, vehicle.getLargestEcuId());
    }

    public void testContainsEcu() {
        Vehicle vehicle = new Vehicle();
        Ecu ecu1 = new Ecu(1);
        Ecu ecu2 = new Ecu(2);

        vehicle.addEcu(ecu1);
        vehicle.addEcu(ecu2);

        assertEquals(true, vehicle.contains(ecu1));
        assertEquals(true, vehicle.contains(ecu2));

        vehicle.removeEcu(ecu1);
        assertEquals(false, vehicle.contains(ecu1));
    }

    public void testSetters() {


        ArrayList<Ecu> ecus = new java.util.ArrayList<>();
        ecus.add(new Ecu(1));
        ecus.add(new Ecu(2));

        Vehicle vehicle = new Vehicle();
        vehicle.setHistoryLog("logger");
        vehicle.setVehicleID("32323d");
        vehicle.setSeries("series");
        vehicle.setEcus(ecus);

        assertEquals("logger", vehicle.getHistoryLog());
        assertEquals("32323d", vehicle.getVehicleID());
        assertEquals("series", vehicle.getSeries());
        assertEquals(ecus, vehicle.getEcus());
    }

    public void testConstruct() {
        ArrayList<Ecu> ecus = new java.util.ArrayList<>();
        ecus.add(new Ecu(1));
        ecus.add(new Ecu(2));
        Vehicle vehicle = new Vehicle("32323d", "logger", ecus, "series");
        assertEquals("logger", vehicle.getHistoryLog());
        assertEquals("32323d", vehicle.getVehicleID());
        assertEquals("series", vehicle.getSeries());
        assertEquals(ecus, vehicle.getEcus());
    }

    public void testIndexOf() {
        Vehicle vehicle = new Vehicle();
        Ecu ecu = new Ecu(1, 2, 3);
        Ecu ecu1 = new Ecu(3, 2, 3);
        vehicle.addEcu(ecu);
        vehicle.addEcu(ecu1);
        assertEquals(1, vehicle.indexOf(ecu1));
    }

    public void testGetIterator() {
        Vehicle vehicle = new Vehicle();
        assertEquals(true, vehicle.iterator() != null);
    }

    public void testFindDot() {
        // why does this even excist as a public non static function :S
        Vehicle vehicle = new Vehicle();
        assertEquals(3, vehicle.findDot("asd.asd"));
        assertEquals(-1, vehicle.findDot("asdasd"));
    }

    public void testPropertyChange() {
        Vehicle vehicle = new Vehicle();
        PropertyChangeEvent propertyChangeEvent = new PropertyChangeEvent(vehicle, "historyLog", "nada", "new");
        vehicle.propertyChange(propertyChangeEvent);
    }
}
