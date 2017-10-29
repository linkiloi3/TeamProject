package GUI;
import GameObject.*;

public class State {
	private static ID gameState=ID.Menu;

	public static ID getGameState() {
		return gameState;
	}

	public static void setGameState(ID gameState) {
		State.gameState = gameState;
	}
	
}
