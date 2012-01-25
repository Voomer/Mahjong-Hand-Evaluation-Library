import junit.framework.TestCase;
import javax.jws.Oneway;
import java.util.Collections;
import java.util.LinkedList;

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

    public void testSort() {
        LinkedList<Tile> tiles = new LinkedList<Tile>();
        tiles.add(onePin);
        tiles.add(twoPin);
        tiles.add(oneChar);
        tiles.add(twoChar);
        tiles.add(oneDot);
        tiles.add(twoDot);
        tiles.add(new SuitTile("Dot", "3"));
        tiles.add(new SuitTile("Dot", "4"));
        tiles.add(east1);
        tiles.add(chun2);
        tiles.add(chun1);

        TileComparator comp = new TileComparator();
        Collections.sort(tiles, comp);
        assert(tiles.get(0).equals(onePin));
        assert(tiles.get(1).equals(twoPin));
        assert(tiles.get(2).equals(oneChar));
        assert(tiles.get(3).equals(twoChar));
        assert(tiles.get(4).equals(oneDot));
        assert(tiles.get(5).equals(twoDot));
        assert(tiles.get(6).equals(new SuitTile("Dot", "3")));
        assert(tiles.get(7).equals(new SuitTile("Dot", "4")));
        assert(tiles.get(8).equals(east1));
        assert(tiles.get(9).equals(chun2));
        assert(tiles.get(10).equals(chun2));

        Collections.shuffle(tiles);
        Collections.sort(tiles, comp);
        assert(tiles.get(0).equals(onePin));
        assert(tiles.get(1).equals(twoPin));
        assert(tiles.get(2).equals(oneChar));
        assert(tiles.get(3).equals(twoChar));
        assert(tiles.get(4).equals(oneDot));
        assert(tiles.get(5).equals(twoDot));
        assert(tiles.get(6).equals(new SuitTile("Dot", "3")));
        assert(tiles.get(7).equals(new SuitTile("Dot", "4")));
        assert(tiles.get(8).equals(east1));
        assert(tiles.get(9).equals(chun2));
        assert(tiles.get(10).equals(chun2));

    }

        public void testHand1(){
            LinkedList<Tile> tiles = new LinkedList<Tile>();
            tiles.add(new SuitTile("Bamboo", "2"));
            tiles.add(new SuitTile("Bamboo", "2"));
            tiles.add(new SuitTile("Bamboo", "2"));
            tiles.add(new SuitTile("Bamboo", "3"));
            tiles.add(new SuitTile("Bamboo", "4"));
            tiles.add(new SuitTile("Bamboo", "5"));
            tiles.add(new SuitTile("Bamboo", "5"));
            tiles.add(new SuitTile("Bamboo", "5"));
            tiles.add(new SuitTile("Dots", "2"));
            tiles.add(new SuitTile("Dots", "2"));
            tiles.add(new SuitTile("Dots", "2"));
            tiles.add(new HonorTile("Green"));
            tiles.add(new HonorTile("Green"));
            tiles.add(new HonorTile("Green"));
            Hand hand = new Hand(tiles);
            assert(hand.mahjong());
            assertEquals(hand.points("East", "East"), 36);
        }
    public void testHand2(){

            LinkedList<Tile> tiles = new LinkedList<Tile>();
            tiles.add(new SuitTile("Bamboo", "2"));
            tiles.add(new SuitTile("Bamboo", "2"));
            tiles.add(new SuitTile("Bamboo", "2"));
            tiles.add(new SuitTile("Bamboo", "2"));
            tiles.add(new SuitTile("Bamboo", "3"));
            tiles.add(new SuitTile("Bamboo", "4"));
            tiles.add(new HonorTile("Green"));
            tiles.add(new HonorTile("Green"));
            tiles.add(new HonorTile("Green"));
            tiles.add(new HonorTile("Red"));
            tiles.add(new HonorTile("Red"));
            tiles.add(new HonorTile("Red"));
            tiles.add(new HonorTile("North"));
            tiles.add(new HonorTile("North"));
            Hand hand = new Hand(tiles);
            assert(hand.mahjong());
            assertEquals(hand.points("East", "East"), 40);
    }

    public void testHand3(){
            LinkedList<Tile> tiles = new LinkedList<Tile>();
            tiles.add(new SuitTile("Bamboo", "2"));
            tiles.add(new SuitTile("Bamboo", "2"));
            tiles.add(new SuitTile("Bamboo", "2"));
            tiles.add(new SuitTile("Bamboo", "2"));
            tiles.add(new SuitTile("Bamboo", "3"));
            tiles.add(new SuitTile("Bamboo", "4"));
            tiles.add(new SuitTile("Bamboo", "5"));
            tiles.add(new SuitTile("Bamboo", "5"));
            tiles.add(new SuitTile("Bamboo", "5"));
            tiles.add(new SuitTile("Dot", "2"));
            tiles.add(new SuitTile("Dot", "2"));
            tiles.add(new SuitTile("Dot", "2"));
            tiles.add(new SuitTile("Dot", "2"));
            tiles.add(new SuitTile("Dot", "3"));
            tiles.add(new SuitTile("Dot", "4"));
            Hand hand = new Hand(tiles);
            assert(hand.mahjong());
            assertEquals(hand.points("East", "East"), 40);
    }

         public void testHand4() {
             LinkedList<Tile> tiles = new LinkedList<Tile>();
             Tile tile;
             Hand hand;
             for (int i = 1; i <= 9; i++) {
                 tiles.add(new SuitTile("Bamboo", "1"));
                 tiles.add(new SuitTile("Bamboo", "1"));
                 tiles.add(new SuitTile("Bamboo", "1"));
                 tiles.add(new SuitTile("Bamboo", "2"));
                 tiles.add(new SuitTile("Bamboo", "3"));
                 tiles.add(new SuitTile("Bamboo", "4"));
                 tiles.add(new SuitTile("Bamboo", "5"));
                 tiles.add(new SuitTile("Bamboo", "6"));
                 tiles.add(new SuitTile("Bamboo", "7"));
                 tiles.add(new SuitTile("Bamboo", "8"));
                 tiles.add(new SuitTile("Bamboo", "9"));
                 tiles.add(new SuitTile("Bamboo", "9"));
                 tiles.add(new SuitTile("Bamboo", "9"));
                 System.out.println("tile: "+ i);
                 tile = new SuitTile("Bamboo", i + "");
                 tiles.add(tile);
                 hand = new Hand(tiles);
                 assert(hand.mahjong());
             }
         }
}
