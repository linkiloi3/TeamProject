package Script;
import GameObject.*;
import Plant.Plant;

import java.awt.Color;
import java.awt.Graphics;

public class PlayBoard {
	
	private static final int r=90;
	
	public PlayBoard(){
	}
	
	
	public static boolean getPlanted(int x,int y) {
		x=(x-180)/r*r+180;
		y=(y-180)/r*r+180;
		for (int i = 0;i<Handler.object.size();i++){
			GameObject temp = Handler.object.get(i);
			if ((temp instanceof Plant)
					&& (x== temp.getX())
					&& (y== temp.getY())){
				return true;
			}
		}
		return false;
	}


	public static void render(Graphics g){
		for (int i=2;i<11;i++){
			for (int j=2;j<7;j++){
				if ((i+j)%2==0){
					g.setColor(Color.cyan);
				}
				else g.setColor(Color.blue);
				int x=i*r;
				int y=j*r;
				g.fillRect(x, y, r, r);
			}
		}
	}
}
