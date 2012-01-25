/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 1/17/12
 * Time: 3:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class TileGenerator {
    public Tile getTile(String suit) {
        if (suit == "Green" || suit == "Red" || suit == "White")
            return new DragonHonorTile(suit);
        else
            return new WindHonorTile(suit);
    }
    
    public Tile getTile(String suit, String rank) {
        if (rank == "1" || rank == "9")
            return new TerminalSuitTile(suit, rank);
        else
            return new SimpleSuitTile(suit, rank);
    }
}
