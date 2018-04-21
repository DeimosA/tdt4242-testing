package no.ntnu.test.integration;

import junit.framework.TestCase;
import no.ntnu.fp.gui.EcuPanel;
import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.model.*;
import no.ntnu.fp.storage.CreateFactoryDB;
import no.ntnu.fp.storage.EcuDbStorage;
import no.ntnu.fp.storage.InsertTestDataFactoryDb;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class TestEcuDbStorage extends TestCase {

    public EcuDbStorage ecuDbStorage;

    public void setUp() {
        // Reset DB first
        CreateFactoryDB.main(new String[0]); // This will log SQLException, but don't worry
        InsertTestDataFactoryDb.main(new String[0]);
        ecuDbStorage = new EcuDbStorage();
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

    public void testAddEcu() {
        SimpleEcu simpleEcu = new SimpleEcu(5, 5);
        ecuDbStorage.addEcu(simpleEcu, new EcuPanel(new FactoryProjectPanel()));

        ArrayList<SimpleEcu> sEcuList = ecuDbStorage.openSimpleEcu();
        boolean sEcuFound = false;
        for (SimpleEcu sEcu : sEcuList) {
            if (simpleEcu.getEcuId() == sEcu.getEcuId() && simpleEcu.getSwId() == sEcu.getSwId()) {
                sEcuFound = true;
            }
        }
        assertTrue(sEcuFound);
    }

    public void testGetEcuSoft() {
        Ecu ecu = new Ecu(1, 1, 1);
        int[] result = ecuDbStorage.getEcuSoft(ecu);
        assertTrue(result.length > 0);
    }

    public void testThroughEcuPanel() {
        FactoryProjectPanel fpPanel = new FactoryProjectPanel();
        fpPanel.getNewVehiclePanel().getNwpecuPanel().getNvPanel().setModel(new Vehicle());
        FactoryProject fpModel = new FactoryProject();
        fpPanel.setModel(fpModel);
        EcuPanel ecuPanel = new EcuPanel(fpPanel);
        SimpleEcu simpleEcu = new SimpleEcu(4, 4);
        fpModel.addEcu(simpleEcu);
        ecuPanel.setModel(simpleEcu);
        ecuPanel.setEditable(true);

        try {
            Field saveButtonField = EcuPanel.class.getDeclaredField("saveBtn");
            saveButtonField.setAccessible(true);
            JButton saveButton = (JButton) saveButtonField.get(ecuPanel);
            saveButton.doClick();
            ArrayList<SimpleEcu> sEcuList = ecuDbStorage.openSimpleEcu();
            boolean sEcuFound = false;
            for (SimpleEcu sEcu : sEcuList) {
                if (simpleEcu.getEcuId() == sEcu.getEcuId() && simpleEcu.getSwId() == sEcu.getSwId()) {
                    sEcuFound = true;
                }
            }
            assertTrue(sEcuFound);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail();
        }
    }

}

