import junit.framework.TestCase;
import
import javax.jws.Oneway;

/**
* Created by IntelliJ IDEA.
* User: Voomer
* Date: 12/10/11
* Time: 11:58 PM
* To change this template use File | Settings | File Templates.
 *
*/




public class TileTestTest extends junit.framework.TestCase {
    HonorTile chun1;
    HonorTile chun2;
    HonorTile east1;
    HonorTile east2;
    SuitTile onePin;
    SuitTile twoPin;
    SuitTile oneDot;
    SuitTile twoDot;
    SuitTile oneChar;
    SuitTile twoChar;

    public void setUp() throws Exception {
        chun1 = new HonorTile("Red");
        chun2 = new HonorTile("Red");
        east1 = new HonorTile("East");
        east2 = new HonorTile("East");
        onePin = new SuitTile("Bamboo", "1");
        twoPin = new SuitTile("Bamboo", "2");
        oneDot = new SuitTile("Dot", "1");
        twoDot = new SuitTile("Dot", "2");
        oneChar = new SuitTile("Char", "1");
        twoChar = new SuitTile("Char", "2");

    }

    public void testHonors()
    {
        assertTrue(chun1.equals(chun2));
        assertFalse(chun1.equals(east1));
        assertFalse(chun1.greaterThan(east2));
        assertFalse(chun1.lessThan(east2));
        assertFalse(east1.greaterThan(east2));
        assertFalse(chun1.lessThanEquals(east2));
        assertTrue(east2.greaterThanEquals(east1));
        assertTrue(east2.greaterThanEquals(east2));
        assertTrue(east2.lessThanEquals(east2));
    }

    public void testSuits() {
        assertFalse(onePin.greaterThan(twoPin));
        assertTrue(twoPin.greaterThan(onePin));
        assertFalse(twoPin.lessThan(onePin));
        assertTrue(onePin.lessThan(twoPin));
        assertFalse(onePin.greaterThan(twoPin));
        assertTrue(onePin.lessThanEquals(onePin));
        assertFalse(oneDot.lessThanEquals(onePin));
        assertFalse(twoChar.greaterThan(oneDot));
    }

    public void testSuitsHonors() {
        assertFalse(onePin.greaterThan(east2));
        assertFalse(oneChar.greaterThan(chun1));
        assertFalse(oneDot.greaterThan(chun1));
        assertTrue(oneDot.greaterThan(onePin));
        assertFalse(chun1.lessThan(oneDot));
    }

}
