package Script;
import GameObject.*;
import Plant.Peashooter;
import Plant.Sunflower;
import Plant.Wallnut;
import Plant.WinterPea;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class PlantOption{
	
	private static int l[]={50,50,50,50};
	private static int cd50[]={30,40,100,50};
	private static int oldp[]={0,0,0,0};
	private static final int numOfPlant=4;
	private static long time[]={0,0,0,0};
	
	
	public PlantOption(){
	}
	
	public static void tick(){
		
		for (int i=0;i<numOfPlant;i++){
			if ((l[i]>0) && (System.currentTimeMillis()-time[i]>cd50[i])) {
				l[i]--;
				time[i]=System.currentTimeMillis();
			}
		}
		
		if (Peashooter.getObjNum()>oldp[0]){
			l[0]=50;
			oldp[0]++;
		}
		
		if (Sunflower.getObjNum()>oldp[1]) {
			l[1]=50;
			oldp[1]++;
		}
		
		if (Wallnut.getObjNum()>oldp[2]) {
			l[2]=50;
			oldp[2]++;
		}
		
		if (WinterPea.getObjNum()>oldp[3]) {
			l[3]=50;
			oldp[3]++;
		}
	}
	
	
	
	public static void render(Graphics g){
		g.setColor(Color.green);
		g.fillRect(10, 10, 50, 50);
		g.setColor(Color.gray);
		g.fillRect(10,10,50,l[0]);
		g.setColor(Color.orange);
		g.fillRect(60, 10, 50, 50);
		g.setColor(Color.gray);
		g.fillRect(60,10,50,l[1]);
		g.setColor(new Color(105,51,0));
		g.fillRect(110, 10, 50, 50);
		g.setColor(Color.gray);
		g.fillRect(110,10,50,l[2]);
		g.setColor(Color.blue);
		g.fillRect(160, 10, 50, 50);
		g.setColor(Color.gray);
		g.fillRect(160,10,50,l[3]);
		Font fnt = new Font("arial",1,20);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("100", 10, 60);
		
		g.drawString("50", 60, 60);
		
		g.drawString("50", 110, 60);
		
		g.drawString("175", 160, 60);
		fnt = new Font("arial",1,10);
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("WinterPea", 160, 70);
		g.drawString("PeaShooter", 10, 70);
		g.drawString("WallNut", 110, 70);
		g.drawString("SunFlower", 50, 70);
	}

}
