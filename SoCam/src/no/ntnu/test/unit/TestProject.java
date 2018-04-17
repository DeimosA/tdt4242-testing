package no.ntnu.test.unit;

import junit.framework.TestCase;
import no.ntnu.fp.model.Person;
import no.ntnu.fp.model.Project;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class TestProject extends TestCase {
    public void testCount() {
        Project project = new Project();
        Person person1 = new Person(1, "name", "email", "street", "city", "vehicleID");
        Person person2 = new Person(1, "name", "email", "street", "city", "vehicleID");
        Person person3 = new Person(1, "name", "email", "street", "city", "vehicleID");
        Person person4 = new Person(1, "name", "email", "street", "city", "vehicleID");

        assertEquals(0, project.getPersonCount());
        project.addPerson(person1);
        project.addPerson(person2);
        project.addPerson(person3);
        project.addPerson(person4);

        assertEquals(4, project.getPersonCount());
    }

    public void testGetters() {
        Project project = new Project();
        Person person1 = new Person(1, "per", "email", "street", "city", "3");
        Person person3 = new Person(1, "lenny", "email", "street", "city", "1");
        Person person2 = new Person(1, "penny", "email", "street", "city", "11");
        Person person4 = new Person(9, "dude", "email", "street", "city", "32");

        assertEquals(0, project.getLargestCustId());
        project.addPerson(person1);
        project.addPerson(person3);
        project.addPerson(person2);
        project.addPerson(person4);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);

        ArrayList<Integer> resultList = project.getPersonIndex("pe");

        assertEquals(person1, project.getPerson(0));
        assertEquals(9, project.getLargestCustId());
        assertEquals(true, list.containsAll(resultList) && resultList.containsAll(list));

        assertEquals(3, project.getPersonIndex(32));
        assertEquals(-1, project.getPersonIndex(1111));
    }

    public void testIndexOf(){
        Project project = new Project();
        Person person1 = new Person(1, "per", "email", "street", "city", "vehicleID");
        Person person2 = new Person(1, "penny", "email", "street", "city", "vehicleID");
        Person person3 = new Person(1, "paal", "email", "street", "city", "vehicleID");
        Person person4 = new Person(1, "mister", "email", "street", "city", "vehicleID");

        project.addPerson(person1);
        project.addPerson(person2);
        project.addPerson(person4);


        assertEquals(2, project.indexOf(person4));
        assertEquals(-1, project.indexOf(person3));

    }

    public void testAddRemove() {
        Project project = new Project();
        Person person1 = new Person(1, "per", "email", "street", "city", "vehicleID");
        Person person2 = new Person(1, "penny", "email", "street", "city", "vehicleID");
        Person person3 = new Person(1, "paal", "email", "street", "city", "vehicleID");
        Person person4 = new Person(1, "mister", "email", "street", "city", "vehicleID");

        project.addPerson(person1);
        //project.addPerson(person2);
        project.addPerson(person3);
        project.addPerson(person4);


        assertEquals(true, project.contains(person3));
        
        project.removePerson(person3);
        assertEquals(false, project.contains(person3));

        assertEquals(false, project.contains(person2));
        }

    public void testGetIterator() {
        Project project = new Project();
        assertEquals(true, project.iterator() != null);

    }

    public void testEquals() {

        Project project0 = new Project();
        Project project1 = new Project();
        Project project2 = new Project();
        Project project3 = new Project();

        Person person1 = new Person(123, "aaa", "a", "a", "a", "a");
        Person person2 = new Person(12, "as", "a", "a", "a", "a");
        Person person3 = new Person(13, "ad", "a", "a", "a", "a");
        Person person4 = new Person(1, "aq", "a", "a", "a", "a");

        project0.addPerson(person1);
        project0.addPerson(person2);
        project0.addPerson(person3);

        project1.addPerson(person1);
        project1.addPerson(person2);
        project1.addPerson(person3);

        project2.addPerson(person1);
        project2.addPerson(person2);

        project3.addPerson(person1);
        project3.addPerson(person3);
        project3.addPerson(person4);

        // Equals itself
        assertTrue(project0.equals(project0));
        // Different object type
        assertFalse(project0.equals("String"));
        // Equal person list
        assertTrue(project0.equals(project1));
        // Different person count
        assertFalse(project0.equals(project2));
        // Different person list
        assertFalse(project0.equals(project3));

    }

    public void testPropertyAddRemove() {
        Project project = new Project();
        PropertyChangeListener propertyChangeListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        };

        project.addPropertyChangeListener(propertyChangeListener);
        project.removePropertyChangeListener(propertyChangeListener);
    }

    public void testToString(){
        Project project = new Project();
        Person person1 = new Person(1, "a", "amail", "astreet", "acity", "avehicle");
        Person person2 = new Person(2, "aa", "aamail", "aastreet", "aacity", "aavehicle");

        project.addPerson(person1);
        project.addPerson(person2);

        String expectedString = "project:\n";
        expectedString += person1.toString()+"\n";
        expectedString += person2.toString()+"\n";

        assertEquals(expectedString, project.toString());

    }

    public void testPropertyChange() {
        Project project = new Project();
        PropertyChangeEvent propertyChangeEvent = new PropertyChangeEvent(project, "list", "nada", "new");
        project.propertyChange(propertyChangeEvent);
    }
}
