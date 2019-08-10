/**
 *
 */
package textgen;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

    private static final int LONG_LIST_LENGTH = 10;

    MyLinkedList<String> shortList;
    MyLinkedList<Integer> emptyList;
    MyLinkedList<Integer> longerList;
    MyLinkedList<Integer> list1;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // Feel free to use these lists, or add your own
        shortList = new MyLinkedList<String>();
        shortList.add("A");
        shortList.add("B");
        emptyList = new MyLinkedList<Integer>();
        longerList = new MyLinkedList<Integer>();
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            longerList.add(i);
        }
        list1 = new MyLinkedList<Integer>();
        list1.add(65);
        list1.add(21);
        list1.add(42);
    }


    /** Test if the get method is working correctly.
     */
    /*You should not need to add much to this method.
     * We provide it as an example of a thorough test. */
    @Test
    public void testGet() {
        //test empty list, get should throw an exception
        try {
            emptyList.get(0);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }

        // test short list, first contents, then out of bounds
        assertEquals("Check first", "A", shortList.get(0));
        assertEquals("Check second", "B", shortList.get(1));

        try {
            shortList.get(-1);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            shortList.get(2);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
        // test longer list contents
        for (int i = 0; i < LONG_LIST_LENGTH; i++) {
            assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
        }

        // test off the end of the longer array
        try {
            longerList.get(-1);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            longerList.get(LONG_LIST_LENGTH);
            fail("Check out of bounds");
        } catch (IndexOutOfBoundsException e) {
        }
    }


    /** Test removing an element from the list.
     * We've included the example from the concept challenge.
     * You will want to add more tests.  */
    @Test
    public void testRemove() {
        try {
            list1.remove(-1);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (Exception e) {
            assertThat(e.toString(), is("java.lang.IndexOutOfBoundsException"));
        }
        try {
            list1.remove(4);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (Exception e) {
            assertThat(e.toString(), is("java.lang.IndexOutOfBoundsException"));
        }
        int a = list1.remove(0);
        assertEquals("Remove: check a is correct ", 65, a);
        assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
        assertEquals("Remove: check size is correct ", 2, list1.size());
        int b = list1.remove(1);
        assertEquals("Remove: check b is correct ", 42, b);
        assertEquals("Remove: check size is correct ", 1, list1.size());
        int c = list1.remove(0);
        assertEquals("Remove: check c is correct ", 21, c);
        assertEquals("Remove: check size is correct ", 0, list1.size());
    }

    /** Test adding an element into the end of the list, specifically
     *  public boolean add(E element)
     * */
    @Test
    public void testAddEnd() {
        list1.add(77);
        int lastElementValue = list1.get(list1.size() - 1);
        assertEquals("AddEnd: check if last element is 77", 77, lastElementValue);
        list1.add(100);
        lastElementValue = list1.get(list1.size() - 1);
        assertEquals("AddEnd: check if last element is 100", 100, lastElementValue);
    }


    /** Test the size of the list */
    @Test
    public void testSize() {
        assertEquals("Check emptyList size", 0, emptyList.size());
        assertEquals("Check shortList size", 2, shortList.size());
        shortList.add("F");
        assertEquals("Check shortList size", 3, shortList.size());
    }


    /** Test adding an element into the list at a specified index,
     * specifically:
     * public void add(int index, E element)
     * */
    @Test
    public void testAddAtIndex() {
        shortList.add(0, "C");
        shortList.add(2, "D");
        assertEquals("Check after adding C at index 0 value at index 0", "C", shortList.get(0));
        assertEquals("Check after adding C at index 0 value at index 1", "A", shortList.get(1));
        assertEquals("Check after adding D at index 2 value at index 2", "D", shortList.get(2));
        assertEquals("Check after adding D at index 2 value at index 3", "B", shortList.get(3));
    }

    /** Test setting an element in the list */
    @Test
    public void testSet() {
        try {
            longerList.remove(-1);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (Exception e) {
            assertThat(e.toString(), is("java.lang.IndexOutOfBoundsException"));
        }
        try {
            longerList.remove(14);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (Exception e) {
            assertThat(e.toString(), is("java.lang.IndexOutOfBoundsException"));
        }
        try {
            longerList.set(2, null);
            fail("Expected an NullPointerException to be thrown");
        } catch (Exception e) {
            assertThat(e.toString(), is("java.lang.NullPointerException"));
        }
        longerList.set(2, 10);
        assertEquals("AddAtIndex: check value is correct ", (Integer) 10, longerList.get(2));
        assertEquals("AddAtIndex: check size is correct", 10, longerList.size());

        shortList.set(1, "C");
        assertEquals("AddAtIndex: check value is correct ", (String) "C", shortList.get(1));
        assertEquals("AddAtIndex: check size is correct", 2, shortList.size());
    }

}
