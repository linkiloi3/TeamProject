package Zombie;

import java.awt.Color;
import java.awt.Graphics;

import GUI.ObjType;
import GameObject.Utility;
import Script.Game;
import Script.SpriteSheet;

public class Fastzombie extends Enemy implements ZombieInterface{
	private static int power=37;
	private Utility utility=Utility.getInstance();
	public Fastzombie(int x,int y){
		super(x,y,7,3,10);
	}
	public void render(Graphics g){
		utility.draw(ObjType.FastZombie, x, y, g);
		
	}
	@Override
	public int getPower() {
		return power;
	}
}
