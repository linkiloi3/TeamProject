package Zombie;

import java.util.Random;

import Script.Handler;

public class ZombieFactory {
	private int x=1000;
	private int y;
	public static int rand(int max){
		Random rn=new Random(System.currentTimeMillis());
		return(rn.nextInt(max));
	}
	public int newZombie(int power){
		while (1==1){
			int objID;
			objID=rand(4);
			y=180+rand(5)*90;
			Enemy temp=null;
			if (objID==0) temp=new Normal(x,y);
			if (objID==1) temp=new ConeHead(x,y);
			if (objID==2) temp=new Fastzombie(x,y);
			if (objID==3) temp=new BucketHead(x,y);
			if (((ZombieInterface) temp).getPower()>power) temp=null;
			else {
				Handler.addObject(temp);
				power-=((ZombieInterface) temp).getPower();
			}
			if (temp==null) break;
		}
		return power;
	}
}
