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
import GameObject.Utility;
import Plant.*;


public class MouseInput extends MouseAdapter{
	
	private Plant plant;
	private int objID;
	private PlantFactory createPlant = new PlantFactory();
	private final int numOfPlant=4;
	private Utility utility=Utility.getInstance();
	public MouseInput (){
	}
	
	private void collectSun(int x,int y){
		for (int i=0;i<Handler.object.size();i++){
			GameObject temp=Handler.object.get(i);
			if ((temp instanceof Sun) && 
					utility.mouseOver(x,y,temp.getX(), temp.getY(), 30, 30)) {
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
		if (utility.mouseOver(x, y,10,10, numOfPlant*50, 50) && (objID==0)){
			objID=((x-10)/50+1);
			plant=createPlant.newPlant(objID, 0, 0);
			
		} else
		if (TreeRemover.onTreeRemover(x, y)){
			objID=100;
		}else
		if ((x>100) && (x<=1000) && (y>100) && (y<625)){
			if (objID==0) {
				this.collectSun(x,y);
			}
			if (plant!=null) 
				if(PlayBoard.getPlanted(x, y)==false) {
					plant.placePlant(x, y);
				}
				else {
					Anou.setAnou("already planted there");
				}
			plant=null;	
			if (objID==100) TreeRemover.removeTree(x, y);
			objID=0;
		}
		else if (objID!=0){
			Anou.setAnou("action can't be done there");
			plant=null;
			objID=0;
		}
		}
	}
	

}
