
public class HonorTile extends Tile {

    public HonorTile(String suit) {
        super(suit);
        this.suit = suit;
        rank = "";
    }

    public boolean lessThanEquals(Tile otherTile) {
        return equals(otherTile);
    }

    public boolean greaterThanEquals(Tile otherTile) {
        return equals(otherTile);
    }

    public boolean lessThan(Tile otherTile) {
        return greaterThan(otherTile);
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
