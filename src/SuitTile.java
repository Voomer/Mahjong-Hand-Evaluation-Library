/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 12/10/11
 * Time: 6:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class SuitTile extends Tile{
    public SuitTile(String suit, String rank) {
        super(suit + " " + rank);
        this.rank = rank;
        this.suit = name;
    }
    
    public boolean lessThanEquals(Tile otherTile) {
        return equals(otherTile) ||   lessThan(otherTile);
    }

    public boolean greaterThanEquals(Tile otherTile) {
        return equals(otherTile) ||   lessThan(otherTile);
    }
    
    public boolean lessThan(Tile otherTile) {
       return !greaterThan(otherTile);
    }

    public boolean greaterThan(Tile otherTile) {
        int result = otherTile.getSuit().compareTo(otherTile.getSuit());
        if (result == 0) {
            int rankResult = getRank().compareTo(otherTile.getRank());
            if (rankResult == 1) return true;
            else return false;
        }
        else if (result == 1)
            return true;
        else return false;
    }
}
