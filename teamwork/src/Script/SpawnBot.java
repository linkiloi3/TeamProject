package Script;
import Zombie.*;
import GUI.ID;
import GUI.State;

public class SpawnBot {
	// this class use to start game
	private static int power=0;
	private static int i=200;
	static long now=System.currentTimeMillis()-1000;
	private static ZombieFactory createNew=new ZombieFactory();
	
	public static boolean onSpawnDuration(int i){
		long spawnDuration=Math.max((6000-(int)Math.sqrt(Math.sqrt(i))*2),20);
		return System.currentTimeMillis()-now>spawnDuration;
	}
	
	public static void tick(){
		i+=100;
		if ( ( onSpawnDuration(i) ) && ( State.getGameState()==ID.Game ) ){
			now=System.currentTimeMillis();
			power+=(int) Math.sqrt(Math.sqrt(i))*2;
			// calculate the amount of spawn
			power=createNew.newZombie(power);
		}
		else if (State.getGameState()!=ID.Game){
			i=200;
			power=0;
		}
	}

}
