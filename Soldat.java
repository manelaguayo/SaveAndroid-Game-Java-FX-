package Ex2_SoldatsColors;

import java.util.Random;

import Ex1_BallMovement.Ball;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Soldat {

	private Image image;
	boolean color= getRandomBoolean();
	boolean costat= getRandomBoolean();
    private double width;
    private double height;
	double posx;
	double posy;
	double movx;
	
public boolean getRandomBoolean() {
	      return Math.random() < 0.5;
	}


public boolean isCostat() {
	return costat;
}


public void setCostat(boolean costat) {
	this.costat = costat;
}


public void init(){
	
	if (costat){
		
		this.posx= (-(Math.random()*300))-300;
		this.posy=(Math.random()*500);
		//this.movx=(Math.random()*7);
		this.movx=(Math.random()*2)+1;
		
		
	}else{
		
		this.posx= (Math.random()*900)+300;
		this.posx= 700;
		this.posy=Math.random()*(500);
		//this.movx=(Math.random()*7);
		this.movx=(Math.random()*2)+1;

	}
	
	this.setImage(); //Assignem color.
	
}

public double getWidth() {
	return width;
}

public boolean isColor() {
	return color;
}



public double getHeight() {
	return height;
}

public void removeImage(){
	
	this.image=null;
	
}


public void setImage(){
	
	if (this.color){
		
		Image i= new Image("file:src/Ex2_SoldatsColors/calabaza.png");
		
		image = i;
        width = i.getWidth();
        height = i.getHeight();
	}
	
	else{
		
		Image i= new Image("file:src/Ex2_SoldatsColors/fantasma.png");
		
		image = i;
        width = i.getWidth();
        height = i.getHeight();
	}
	
	
}

public void setPosition(double x)
{
	posx = x;
}

public void render(GraphicsContext gc)
{
    gc.drawImage( image, posx, posy );
}

public void imageMovement(){
	
	if (costat){
	
	this.setPosition(getPosx()+getMovx());
	
	}
	
	else if (!costat){
		
		this.setPosition(getPosx()-getMovx());
	}
	
}

public double getMovx() {
	return movx;
}


public void setMovx(double movx) {
	this.movx = movx;
}

public double getPosx() {
	return posx;
}


public void setPosx(double posx) {
	this.posx = posx;
}


public double getPosy() {
	return posy;
}


public void setPosy(double posy) {
	this.posy = posy;
}




}
