package Zombie;
import Script.Game;
import Script.SpriteSheet;
import Script.Utility;

import java.awt.Graphics;

import GUI.ObjType;

public class BucketHead extends Enemy implements ZombieInterface{
	private static int power=40;
	public BucketHead(int x,int y){
		super(x,y,35,1,15);
	}
	public void render(Graphics g){
		Utility.draw(ObjType.Buckethead, x, y, g);
	}
	@Override
	public int getPower() {
		return power;
	}
}
