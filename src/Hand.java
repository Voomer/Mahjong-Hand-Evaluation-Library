import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 1/4/12
 * Time: 5:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Hand {
    LinkedList<Tile> list;
    LinkedList<TileSet> tileSets;
    public Hand(LinkedList<Tile> list) {
        this.list = list;
        tileSets = new LinkedList<TileSet>();
    }

        public boolean mahjong(){
            Collections.sort(list, new TileComparator());
            tileSets = new LinkedList<TileSet>();
            tileSets.push(new FourSet());
            examine(tileSets);
            if (fiveSetHand(tileSets))
                return true;
            while (!(fiveSetHand(tileSets))) {
                if (!retry(tileSets))
                    return false;
                examine(tileSets);
            }
            return true;
        }


        public boolean fiveSetHand(LinkedList<TileSet> tileSets) {
            int pairCount = 0, fullCount = 0;
            if (tileSets.size() > 5) return false;
            for (TileSet tileSet : tileSets) {
                if (tileSet.full()) fullCount++;
            if (tileSet.pair()) pairCount++;
        }
            System.out.println("normal mahjong pairs: " + pairCount + " FullSets: " + fullCount );
        return (pairCount == 1 && fullCount == 5);
    }

    public void examine(LinkedList<TileSet> tileSets) {
        Tile t;
        while(!list.isEmpty()) {
            t = list.pop();
            if(tileSets.getFirst().full())  {
                if (list.size() > 2)
                    tileSets.push(new FourSet());
                else
                    tileSets.push(new ThreeSet());
                tileSets.getFirst().add(t);
            }
            else if(tileSets.getFirst().canContain(t)) {
               tileSets.getFirst().add(t);
            }
            else {
                list.push(t);
                if(!retry(tileSets))
                    return;
            }
        }
    }

    public boolean retry(LinkedList<TileSet> tileSets) {
        if (tileSets.isEmpty())
                return false;
        TileSet s = tileSets.pop();
        TileSet n = s.fallback(list);
        if (n != s) {
            tileSets.push(n);
            return true;
        }
        else 
            while (n == s && !tileSets.isEmpty()) {
                s = tileSets.pop();
                n = s.fallback(list);
            }
        if (n == s) return false;
        else {
            tileSets.push(n);
            return true;
        }
    }
    
    public int points(String prevailingWind, String myWind) {
        int points = 20;
        for (TileSet tileSet : tileSets) {
            points += tileSet.points(prevailingWind, myWind);
            System.out.println(tileSet.tiles.getFirst().getName() + " " +tileSet.points(prevailingWind, myWind));
        }
        return points;
    }

    public void pointsReport(String prevailingWind, String myWind) {
        int points = 0;
        for (TileSet tileSet : tileSets) {
            points += tileSet.points(prevailingWind, myWind);
        }
    }
}

class TileComparator implements Comparator<Tile> {
    
    public int compare(Tile tile1,Tile tile2) {
        int result = tile1.getSuit().compareTo(tile2.getSuit());
        if (result > 0) {
            return result;
        }
        else if (result == 0) {
            int rankResult = tile1.getRank().compareTo(tile2.getRank());
            if (rankResult > 0) return 1;
        }
        return -1;
    }
    
}