package no.ntnu.test.integration;

import junit.framework.TestCase;
import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.model.Project;
import no.ntnu.fp.model.Vehicle;
import no.ntnu.fp.storage.VehicleDbStorage;

import java.util.ArrayList;

public class TestVehicleDbStorage extends TestCase {

    public VehicleDbStorage vehicleDbStorage;

    public void setUp() {
        vehicleDbStorage = new VehicleDbStorage();
        FactoryProjectPanel.main(new String[] {"123"});
    }

    public void tearDown() {

    }

    public void testLoad() {
        Project project = vehicleDbStorage.load();
        assertEquals(project, null);
    }

    public void testOpenVehicles() {
        ArrayList<Vehicle> result = vehicleDbStorage.openVehicles();
        assertTrue(result.size() > 0);
    }

    public void testGetVehicleIds() {
        ArrayList<Integer> result = vehicleDbStorage.getVehicleIds(3,1);
        assertTrue(result.size() > 0);
    }
}

