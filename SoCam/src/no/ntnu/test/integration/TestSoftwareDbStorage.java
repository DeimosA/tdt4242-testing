package no.ntnu.test.integration;

import junit.framework.TestCase;
import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.gui.SoftwarePanel;
import no.ntnu.fp.model.Project;
import no.ntnu.fp.model.Software;
import no.ntnu.fp.storage.CreateFactoryDB;
import no.ntnu.fp.storage.InsertTestDataFactoryDb;
import no.ntnu.fp.storage.SoftwareDbStorage;
import java.util.ArrayList;

public class TestSoftwareDbStorage extends TestCase {

    private SoftwareDbStorage softwareDbStorage;

    public void setUp() {
        // Reset DB first
        CreateFactoryDB.main(new String[0]); // This will log SQLException, but don't worry
        InsertTestDataFactoryDb.main(new String[0]);
        softwareDbStorage = new SoftwareDbStorage();
    }

    public void tearDown() {

    }

    public void testLoad() {
        Project project = softwareDbStorage.load();
        // Load just returns null
        assertEquals(project, null);
    }

    public void testSave() {
        Project project = new Project();
        softwareDbStorage.save(project);
        // Save doesn't actually do anything
        assertTrue(true);
    }

    public void testOpenSoftware() {
        ArrayList<Software> software = softwareDbStorage.openSoftware();
        assertTrue(software.size() > 0);
    }

    public void testAddSoftware() {
        int newMajor = 6;
        Software software = new Software(newMajor, 0,"url.com");
        SoftwarePanel softwarePanel = new SoftwarePanel(new FactoryProjectPanel());
        softwarePanel.setModel(software);
        softwareDbStorage.addSoftware(software, softwarePanel);

        assertTrue(softwareDbStorage.swInSwArchive(newMajor));
    }

    public void testSwInSwArchive() {
        boolean result = softwareDbStorage.swInSwArchive(1);
        assertTrue(result);
    }

    public void testGetBiggestSubId() {
        int result = softwareDbStorage.getBiggestSubId(1);
        assertEquals(result, 2);
    }

}

