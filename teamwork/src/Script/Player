package GameObject;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Player {
	
	private static int sunCredit=50;

	public static int getSunCredit() {
		return sunCredit;
	}

	public static void incSunCredit(int sunCredit) {
		Player.sunCredit += sunCredit;
	}
	public static void setSunCredit(int sunCredit) {
		Player.sunCredit = sunCredit;
	}
	
	public static boolean redSunCredit(int sunCredit){
		if (Player.sunCredit>=sunCredit){
			Player.sunCredit-=sunCredit;
			return true;
		}
		else return false;
	}
	
	public static void render(Graphics g){
		Font fnt = new Font("arial",1,40);
		g.setFont(fnt);
		g.setColor(Color.white);
		String str="SunCredit: "+sunCredit;
		g.drawString(  str, 500, 700);
	}

}
