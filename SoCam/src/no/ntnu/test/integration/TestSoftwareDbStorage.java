package no.ntnu.test.integration;

import jdk.nashorn.internal.ir.annotations.Ignore;
import junit.framework.TestCase;
import no.ntnu.fp.gui.FactoryProjectPanel;
import no.ntnu.fp.gui.SoftwarePanel;
import no.ntnu.fp.model.Project;
import no.ntnu.fp.model.Software;
import no.ntnu.fp.storage.SoftwareDbStorage;
import no.ntnu.fp.net.co.ConnectionImpl;
import java.util.ArrayList;

public class TestSoftwareDbStorage extends TestCase {

    private SoftwareDbStorage softwareDbStorage;

    public void setUp() {
        softwareDbStorage = new SoftwareDbStorage();
        FactoryProjectPanel.main(new String[] {"123"});
    }

    public void tearDown() {

    }

    public void testLoad() {
        Project project = softwareDbStorage.load();
        assertEquals(project, null);
    }

    public void testSave() {
        Project project = null;
        softwareDbStorage.save(project);
        assertEquals(1, 1);
    }

    public void testOpenSoftware() {
        ArrayList<Software> software = softwareDbStorage.openSoftware();
        assertTrue(software.size() > 0);
    }

    /*
    public void testAddSoftware() {
        Software software = new Software(1, 1,"url");
        String message = softwareDbStorage.addSoftware(software, null);
        System.out.println(message);
    } */

    public void testSwInSwArchive() {
        boolean result = softwareDbStorage.swInSwArchive(1);
        assertTrue(result);
    }

    public void testGetBiggestSubId() {
        int result = softwareDbStorage.getBiggestSubId(1);
        assertEquals(result, 2);
    }

}

