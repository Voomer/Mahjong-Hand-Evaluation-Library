import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 12/14/11
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class SequenceSet extends TileSet {
    public SequenceSet(){super();}
    public TileSet fallback(LinkedList<Tile> list) {
        TileSet set = new PairSet();
        while (!tiles.isEmpty()) {
            list.push(tiles.removeLast());
        }
        set.add(list.pop());
        return set;
    }
    public boolean full() { return tiles.size() == 3;}

    @Override
    public boolean canContain(Tile tile) {
        if (tiles.isEmpty())
            return true;
        else if (tiles.size() == 3)
            return false;
        else {
           int last = Integer.parseInt(tiles.getLast().rank) + 1;
           int othertile =  Integer.parseInt(tile.getRank());
            return tiles.getLast().suit == tile.suit && (Integer.parseInt(tiles.getLast().rank) + 1) == Integer.parseInt(tile.getRank());
        }
    }

}
