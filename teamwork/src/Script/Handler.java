package Script;
import GameObject.*;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	
	public static LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public static void tick(){
		for (int i=0 ; i<object.size();i++){
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public static void render(Graphics g){
		for (int i=0 ; i<object.size();i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
			
		}
	}
	public static void addObject(GameObject object){
		Handler.object.add(object);
	}
	public static void removeObject(GameObject object){
		Handler.object.remove(object);
	}
	
}
