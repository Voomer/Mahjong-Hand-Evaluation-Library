
public class HonorTile extends Tile {

    public HonorTile(String suit) {
        super(suit);
        this.suit = suit;
        rank = "0";
    }

    public boolean lessThanEquals(Tile otherTile) {
        return equals(otherTile);
    }

    public boolean greaterThanEquals(Tile otherTile) {
        return equals(otherTile);
    }

    public boolean lessThan(Tile otherTile) {
        return false;
    }

    public boolean greaterThan(Tile otherTile) {
       return false;
    }

    public boolean simple() {
        return false;
    }
}
