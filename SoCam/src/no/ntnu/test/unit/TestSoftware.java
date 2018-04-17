package no.ntnu.test.unit;

import junit.framework.TestCase;
import no.ntnu.fp.model.Software;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TestSoftware extends TestCase{
    public void testConstructorOne() {
        Software software = new Software();
        assertEquals(0, software.getSwVersion());
        assertEquals(0, software.getMinorVersion());
        assertEquals("", software.getUrl());
    }

    public void testConstructorTwo() {
        Software software = new Software(1, 2, "someurl");
        assertEquals(1, software.getSwVersion());
        assertEquals(2, software.getMinorVersion());
        assertEquals("someurl", software.getUrl());
    }

    public void testSetters() {
        Software software = new Software();
        software.setSwVersion(1);
        software.setMinorVersion(2);
        software.setUrl("someurl");
        assertEquals(1, software.getSwVersion());
        assertEquals(2, software.getMinorVersion());
        assertEquals("someurl", software.getUrl());
    }

    public void testAddRemovePropertyChange() {
        Software software = new Software();
        PropertyChangeListener propertyChangeListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        };

        software.addPropertyChangeListener(propertyChangeListener);
        software.removePropertyChangeListener(propertyChangeListener);
    }
}
