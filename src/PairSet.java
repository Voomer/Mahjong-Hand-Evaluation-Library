/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 12/14/11
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class PairSet extends TileSet {

    public boolean full() { return tiles.size() == 2;}

    public boolean pair() {
        return true;
    }

    public int points(String prevailingWind, String myWind) {
        if (tiles.getFirst().getSuit() == prevailingWind &&
              myWind == prevailingWind) return 4;
        else if (lucky(prevailingWind, myWind)) return 2;
        else return 0;
    }
}
