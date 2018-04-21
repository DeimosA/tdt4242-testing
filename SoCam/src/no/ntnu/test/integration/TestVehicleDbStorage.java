package no.ntnu.test.integration;

import junit.framework.TestCase;
import no.ntnu.fp.model.Project;
import no.ntnu.fp.model.Vehicle;
import no.ntnu.fp.storage.CreateFactoryDB;
import no.ntnu.fp.storage.InsertTestDataFactoryDb;
import no.ntnu.fp.storage.VehicleDbStorage;

import java.util.ArrayList;

public class TestVehicleDbStorage extends TestCase {

    public VehicleDbStorage vehicleDbStorage;

    public void setUp() {
        // Reset DB first
        CreateFactoryDB.main(new String[0]); // This will log SQLException, but don't worry
        InsertTestDataFactoryDb.main(new String[0]);
        vehicleDbStorage = new VehicleDbStorage();
    }

    public void tearDown() {

    }

    public void testLoad() {
        Project project = vehicleDbStorage.load();
        // Load just returns null
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

