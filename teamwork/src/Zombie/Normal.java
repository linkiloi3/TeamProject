package Zombie;

import java.awt.Color;
import java.awt.Graphics;

import GUI.ObjType;
import GameObject.Utility;
import Script.Game;
import Script.SpriteSheet;

public class Normal extends Enemy implements ZombieInterface{
	private static int power=10;
	private Utility utility=Utility.getInstance();
	public Normal(int x,int y){
		super(x,y,7,1,10);
	}
	public void render(Graphics g){
		utility.draw(ObjType.Normal, x, y, g);
		
	}
	@Override
	public int getPower() {
		return power;
	}
}
