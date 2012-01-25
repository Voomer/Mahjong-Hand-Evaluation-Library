import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: Voomer
 * Date: 12/12/11
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 *
 */
public class TestWall extends TestCase {

    public void testDraw() {
        Wall wall = new Wall();
        for (int i = 0; i < 136; i++) {
            wall.deal();
        }
        assertTrue(wall.remainingTiles()== 0);

    }

    public void testShuffle() {
        Wall wall = new Wall();
        wall.shuffle();
        for (int i = 0; i < 136; i++) {
            System.out.println(wall.deal().getName());
        }
    }
}
