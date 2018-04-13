package no.ntnu.test.unit;

import junit.framework.TestCase;
import no.ntnu.fp.model.Ecu;

public class TestEcu extends TestCase {

    public void testConstructOne() {
        Ecu ecu = new Ecu(1);
        assertEquals(1, ecu.getEcuId());
        assertEquals(0, ecu.getSwId());
        assertEquals(0, ecu.getSubSwId());
        assertEquals(false, ecu.isNewest());

    }

    public void testConstructTwo() {
        Ecu ecu = new Ecu(1, 2, 3);
        assertEquals(1, ecu.getEcuId());
        assertEquals(2, ecu.getSwId());
        assertEquals(3, ecu.getSubSwId());
        assertEquals(false, ecu.isNewest());
    }

    public void testConstructThree() {
        Ecu ecu = new Ecu(1, 2, 3, true, 4);
        assertEquals(1, ecu.getEcuId());
        assertEquals(2, ecu.getSwId());
        assertEquals(3, ecu.getSubSwId());
        assertEquals(true, ecu.isNewest());
        assertEquals(4, ecu.getNewestSub());
    }

    public void testSetters() {
        Ecu ecu = new Ecu(1);
        ecu.setEcuId(3);
        ecu.setSwId(4);
        ecu.setSubSwId(5);
        ecu.setNewest(true);
        ecu.setNewestSub(6);

        assertEquals(3, ecu.getEcuId());
        assertEquals(4, ecu.getSwId());
        assertEquals(5, ecu.getSubSwId());
        assertEquals(true, ecu.isNewest());
        assertEquals(6, ecu.getNewestSub());
    }


}
