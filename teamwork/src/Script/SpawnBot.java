package Script;
import Zombie.BucketHead;
import Zombie.ConeHead;
import Zombie.Fastzombie;
import Zombie.Normal;
import java.awt.Graphics;
import java.util.Random;

import GUI.ID;
import GUI.State;

public class SpawnBot {
	// this class use to start game
	private static int power=0;
	private static int i=200;
	static long now=System.currentTimeMillis()-1000;
	
	public SpawnBot(){
	}
	
	public static int rand(int max){
		Random rn=new Random();
		return(rn.nextInt(max));
	}
	
	public static int getPower() {
		return power;
	}
	
	public static void setPower(int power) {
		SpawnBot.power = power;
	}
	public static int spawnDuration(int i){
		if (6000-Math.sqrt(Math.sqrt(i))*2>50) return (6000-(int)Math.sqrt(Math.sqrt(i))*2);
		else return 50;
	}
	public static void tick(){
		i+=100;
		if ((System.currentTimeMillis()-now>spawnDuration(i)) && (State.getGameState()==ID.Game)){
			now=System.currentTimeMillis();
			power+=(int) Math.sqrt(Math.sqrt(i))*2;
			// calculate the amount of spawn
			int t;
			t=rand(4);
			if (t>=3)
			while (power>=40){
				//spawning
				Handler.addObject(new BucketHead(1000,180+rand(5)*90));
				power-=40;
			}
			if (t>=2)
			while (power>=37){
				//spawning
				Handler.addObject(new Fastzombie(1000,180+rand(5)*90));
				power-=37;
			}
			if (t>=1)
			while (power>=30){
				//spawning
				Handler.addObject(new ConeHead(1000,180+rand(5)*90));
				power-=30;
			}
			if (t>=0)
			while (power>=10){
				//spawning
				Handler.addObject(new Normal(1000,180+rand(5)*90));
				power-=10;
			}
		}
		else if (State.getGameState()!=ID.Game){
			i=200;
			power=0;
		}
	}
	public static void render(Graphics g){
		
	}
	
}
