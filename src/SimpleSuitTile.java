/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 1/17/12
 * Time: 3:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleSuitTile extends SuitTile {
    public SimpleSuitTile(String suit, String rank) {
        super(rank, suit);
    }

    public boolean simple() {
        return true;
    }
}
