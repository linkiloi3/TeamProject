package Script;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import GUI.Anou;
import GUI.ID;
import GUI.State;
import GameObject.GameObject;
import GameObject.Player;
import GameObject.Sun;
import GameObject.TreeRemover;
import Plant.Peashooter;
import Plant.Sunflower;
import Plant.Wallnut;
import Plant.WinterPea;

public class MouseInput extends MouseAdapter{
	
	private int pId;
	private final int numOfPlant=4;
	private final long starttime=System.currentTimeMillis();
	private long time[]={starttime,starttime,starttime,starttime};
	private long cd[]={1500,2000,5000,2500};
	public MouseInput (){
	}
	
	private void collectSun(int x,int y){
		for (int i=0;i<Handler.object.size();i++){
			GameObject temp=Handler.object.get(i);
			if ((temp instanceof Sun)&&(temp.getX()<=x)&&(temp.getY()<=y)
					&& (temp.getX()+30>=x) && (temp.getY()+30>=y)) {
				// sun collect
				Handler.removeObject(temp);
				Player.incSunCredit(50);
				break;
			}
		}
	}
	
	
	public void mousePressed(MouseEvent e) {
		if (State.getGameState()==ID.Game){
		int x=e.getX();
		int y=e.getY();
		if ((10<x)&&(y>10)&&(y<60)
				&&(x<numOfPlant*50+10)&&(pId==0))
			if (System.currentTimeMillis()-time[(x-10)/50]>cd[(x-10)/50]) {
			
				pId=((x-10)/50+1);
		
			}
			else Anou.setAnou("plant is on cooldown");
		else
			if (TreeRemover.onTreeRemover(x, y)){
				pId=100;
			}
			else{
			if ((x>100) && (x<=1000) && (y>100) && (y<625)){
				if (pId==0) {
					this.collectSun(x,y);
				}
				
				if ((pId==1)&&(PlayBoard.getPlanted(x,y)==false))
				if (Player.redSunCredit(100)){
					Handler.addObject(new Peashooter(x,y));
					Peashooter.incObjNum();
					time[0]=System.currentTimeMillis();
				}
				else {
					Anou.setAnou("not enough sun credit");
				}
				
				if ((pId==2)&&(PlayBoard.getPlanted(x,y)==false))
				if (Player.redSunCredit(50)){
					Handler.addObject(new Sunflower(x,y));
					Sunflower.incObjNum();
					time[1]=System.currentTimeMillis();
				}
				else {
					Anou.setAnou("not enough sun credit");
				}
				
				if ((pId==3)&&(PlayBoard.getPlanted(x,y)==false))
				if (Player.redSunCredit(50)){
					Handler.addObject(new Wallnut(x,y));
					Wallnut.incObjNum();
					time[2]=System.currentTimeMillis();
				}
				else {
					Anou.setAnou("not enough sun credit");
				}
				if ((pId==4)&&(PlayBoard.getPlanted(x,y)==false))
					if (Player.redSunCredit(175)){
						Handler.addObject(new WinterPea(x,y));
						WinterPea.incObjNum();
						time[3]=System.currentTimeMillis();
					}
					else {
						Anou.setAnou("not enough sun credit");
					}
				if (pId==100) TreeRemover.removeTree(x, y);
			}
			pId=0;
		}
	}
	

}
}