/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 1/17/12
 * Time: 3:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class TerminalSuitTile extends SuitTile {
    public TerminalSuitTile(String suit, String rank) {
        super(rank, suit);
    }

    public boolean simple() {return false;}
}
