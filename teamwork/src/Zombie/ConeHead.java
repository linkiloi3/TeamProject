package Zombie;
import Script.Game;
import Script.SpriteSheet;

import java.awt.Graphics;

import GUI.ObjType;
import GameObject.Utility;

public class ConeHead extends Enemy implements ZombieInterface{
	private static int power=30;
	private Utility utility=Utility.getInstance();
	public ConeHead(int x,int y){
		super(x,y,15,1,15);
	}
	public void render(Graphics g){
		utility.draw(ObjType.Conehead, x, y, g);
	}
	@Override
	public int getPower() {
	// TODO Auto-generated method stub
		return power;
	}
}
