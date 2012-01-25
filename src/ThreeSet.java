import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 12/14/11
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ThreeSet extends TileSet{
    public ThreeSet() {super();}

    public TileSet fallback(LinkedList<Tile> list) {
        TileSet seqSet = new SequenceSet();
        while (!tiles.isEmpty()) {
            list.push(tiles.pop());
        }
        seqSet.add(list.pop());
        return seqSet;
    }

    public boolean full() { return tiles.size() == 3;}

    public int points(String prevailingWinds, String myWind) {
        if (tiles.getFirst().simple()) return 4;
        else return 8;
    }
}
