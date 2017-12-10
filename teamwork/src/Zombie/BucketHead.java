package Zombie;
import Script.Game;
import Script.SpriteSheet;

import java.awt.Graphics;

import GUI.ObjType;
import GameObject.Utility;

public class BucketHead extends Enemy implements ZombieInterface{
	private static int power=40;
	private Utility utility=Utility.getInstance();
	public BucketHead(int x,int y){
		super(x,y,35,1,15);
	}
	public void render(Graphics g){
		utility.draw(ObjType.Buckethead, x, y, g);
	}
	@Override
	public int getPower() {
		return power;
	}
}
