package org.example.game;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testGutterGame() {
        rollMany(20, 0);
        assertEquals(0, game.Score());
    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);
        assertEquals(20, game.Score());
    }

    @Test
    public void testOneSpare() {
        rollSpare();
        game.Roll(3);
        rollMany(17, 0);
        assertEquals(16, game.Score());
    }

    @Test
    public void testOneStrike() {
        rollStrike();
        game.Roll(3);
        game.Roll(4);
        rollMany(16, 0);
        assertEquals(24, game.Score());
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);
        assertEquals(300, game.Score());
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.Roll(pins);
        }
    }

    private void rollSpare() {
        game.Roll(5);
        game.Roll(5);
    }

    private void rollStrike() {
        game.Roll(10);
    }
}
