
public class Tile  {

    protected String suit;
    protected String  rank;
    protected String name;

    public Tile(String name)
    {
        this.name = name.trim();
    }
    
    public String getSuit()
    {
        return suit;
    }
    
    public boolean equals(Tile tile) {
        return getName().equals(tile.getName());
    }

    public String getName() {
        return name;
    }
    
    public String getRank() {
        return rank;
    }

    public boolean simple () {
        return true;
    }

    public boolean honor () {
        return false;
    }

    public boolean dragon() {
        return false;
    }

    public boolean wind() {
        return false;
    }

}
