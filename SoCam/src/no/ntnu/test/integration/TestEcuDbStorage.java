package no.ntnu.test.integration;

import junit.framework.TestCase;
import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.model.Ecu;
import no.ntnu.fp.model.Project;
import no.ntnu.fp.model.SimpleEcu;
import no.ntnu.fp.model.Software;
import no.ntnu.fp.storage.EcuDbStorage;

import java.util.ArrayList;

public class TestEcuDbStorage extends TestCase {

    public EcuDbStorage ecuDbStorage;

    public void setUp() {
        ecuDbStorage = new EcuDbStorage();
        FactoryProjectPanel.main(new String[] {"123"});
    }

    public void tearDown() {

    }

    public void testOpenSimpleEcu() {
        ArrayList<SimpleEcu> result = ecuDbStorage.openSimpleEcu();
        assertTrue(result.size() > 0);
    }

    // swID 3 === latest
    public void testIsUpdated() {
        Ecu firstEcu = new Ecu(1, 1, 1);
        Ecu secondEcu = new Ecu(1, 3, 1);
        assertFalse(ecuDbStorage.isUpdated(firstEcu));
        assertTrue(ecuDbStorage.isUpdated(secondEcu));
    }

    /*
    // Requires panel
    public void testAddEcu() {

    }
    */

    public void testGetEcuSoft() {
        Ecu ecu = new Ecu(1, 1, 1);
        int[] result = ecuDbStorage.getEcuSoft(ecu);
        assertTrue(result.length > 0);
    }

}

