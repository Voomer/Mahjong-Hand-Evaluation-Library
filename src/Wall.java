import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 12/12/11
 * Time: 3:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class Wall {
    private ArrayList<Tile> tiles;
    Random generator;
    TileGenerator tileGen;
    public Wall() {
        tileGen = new TileGenerator();
        generator = new Random();
        tiles = new ArrayList<Tile>(136);
        for (int i = 0; i < 4; i++) {
            tiles.add(tileGen.getTile("Red"));
            tiles.add(tileGen.getTile("White"));
            tiles.add(tileGen.getTile("Green"));
            tiles.add(tileGen.getTile("South"));
            tiles.add(tileGen.getTile("North"));
            tiles.add(tileGen.getTile("West"));
            tiles.add(tileGen.getTile("East"));
            for (int j = 1; j <= 9; j++) {
                tiles.add(tileGen.getTile("Bamboo", j + ""));
                tiles.add(tileGen.getTile("Dot", j + ""));
                tiles.add(tileGen.getTile("Char", j + ""));
            }
        }
    }

    public Tile deal() {
        return tiles.remove(0);
    }
    
    public void shuffle() {
        Collections.shuffle(tiles);
    }
    
    public int remainingTiles()
    {
        return tiles.size();
    }
    
    @Override public String toString() {
      return tiles.toString();
    }

}

                                                                                    