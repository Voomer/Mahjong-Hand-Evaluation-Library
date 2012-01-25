import sun.awt.windows.ThemeReader;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 12/13/11
 * Time: 12:37 AM
 * To change this template use File | Settings | File Templates.
 */
abstract public class TileSet {
    protected LinkedList<Tile> tiles;

    public TileSet()  {
        tiles = new LinkedList<Tile>();
    }

    @Override public String toString() {
       return tiles.toString();
    }

    public boolean canContain(Tile tile) {
        if (tiles.isEmpty())
            return true;
        else return tiles.getLast().equals(tile);
    }
    
    public TileSet add(Tile tile) {
        tiles.add(tile);
        return this;
    }
    
    abstract public boolean full() ;

    public TileSet fallback(LinkedList<Tile> list) {
        while (!tiles.isEmpty()) {
            list.push(tiles.removeLast());
        }
        return this;
    }

    public boolean pair() {
       return false;
    }

    public int points(String prevailingWinds, String myWind) {
        return 0;
    }
    
    public String sequenceSuit() {
        return tiles.getFirst().suit;
    }

    public boolean lucky(String prevailingWind, String myWind) {
      Tile tile = tiles.getFirst();
      if (tile.dragon() || tile.suit.equals(prevailingWind)
              || tile.suit.equals(myWind))
          return true;
      else
          return false;
    }
}
