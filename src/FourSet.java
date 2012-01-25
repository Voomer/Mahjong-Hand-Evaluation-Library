import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 12/14/11
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class FourSet extends TileSet {

    public FourSet() {super();}
    public TileSet fallback(LinkedList<Tile> list) {
        TileSet threeSet = new ThreeSet();
        while (!tiles.isEmpty()) {
            list.push(tiles.pop());
        }
        return threeSet.add(list.pop());
    }

    public boolean full() { return tiles.size() == 4;}

    public int points(String prevailingWinds, String myWind) {
        if (tiles.getFirst().simple()) return 16;
        else return 32;
    }
}
