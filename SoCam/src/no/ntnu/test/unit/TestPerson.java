package no.ntnu.test.unit;

import junit.framework.TestCase;
import no.ntnu.fp.model.Person;

public class TestPerson extends TestCase{
    
    public void testPersonConstruct() {
        Person person1 = new Person(1, "Tom", "a@a.com", "Krok 8", "Bergen", "3d");

        assertEquals(1, person1.getCustId());
        assertEquals("Tom", person1.getName());
        assertEquals("a@a.com", person1.getEmail());
        assertEquals("Krok 8", person1.getStreet());
        assertEquals("Bergen", person1.getCity());
        assertEquals("3d", person1.getVehicleID());
    }

    public void testPersonSetters() {
        Person person1 = new Person(0);

        person1.setCustId(1);
        person1.setName("Tom");
        person1.setEmail("a@a.com");
        person1.setStreet("Krok 8");
        person1.setCity("Bergen");
        person1.setVehicleID("3d");

        assertEquals(1, person1.getCustId());
        assertEquals("Tom", person1.getName());
        assertEquals("a@a.com", person1.getEmail());
        assertEquals("Krok 8", person1.getStreet());
        assertEquals("Bergen", person1.getCity());
        assertEquals("3d", person1.getVehicleID());
    }

    public void testPersonEqual() {
        Person person1 = new Person(1, "Tom", "a@a.com", "Krok 8", "Bergen", "3d");
        Person person2 = new Person(2, "Tom", "a@a.com", "Krok 8", "Bergen", "3d");
        // same person, should be tue
        assertEquals(true, person1.equals(person2));

        // changing each attribute and expecting person to be different for each attribute.
        person2.setName("Geir");
        assertEquals("Different name, and person is considered the same", false, person1.equals((person2)));
        person2.setName("Tom");

        person2.setEmail("asd@a.com");
        assertEquals("different email, and person is considered the same",false, person1.equals(person2));
        person2.setEmail("a@a.com");

        person2.setStreet("a 90");
        assertEquals("different street, and person is considered the same", false, person1.equals(person2));
        person2.setStreet("Krok 8");

        person2.setCity("Oslo");
        assertEquals("different city, and person is considered the same", false, person1.equals(person2));
        person2.setCity("Bergen");

    }

}
