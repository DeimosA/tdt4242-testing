package no.ntnu.test.unit;

import junit.framework.TestCase;
import no.ntnu.fp.model.SimpleEcu;

public class TestSimpleEcu extends TestCase{
    public void testConstructorOne() {
        SimpleEcu ecu = new SimpleEcu();
        assertEquals(0, ecu.getEcuId());
        assertEquals(0, ecu.getSwId());
    }

    public void testConstructorTwo() {
        SimpleEcu ecu = new SimpleEcu(2);
        assertEquals(2, ecu.getEcuId());
    }

    public void testConstructorTree() {
        SimpleEcu ecu = new SimpleEcu(2, 3);
        assertEquals(2, ecu.getEcuId());
        assertEquals(3, ecu.getSwId());
    }

    public void testSetters() {
        SimpleEcu ecu = new SimpleEcu();
        ecu.setEcuId(2);
        ecu.setSwId(3);
        assertEquals(2, ecu.getEcuId());
        assertEquals(3, ecu.getSwId());
    }
}
