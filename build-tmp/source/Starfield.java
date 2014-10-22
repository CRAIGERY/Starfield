import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

Particle[] starz;

public void setup()
{
	size (500,500);
	starz = new Particle[500];
	for (int i = 0; i <= starz.length - 1; i ++)
	{
		starz [i] = new NormalParticle();
		starz[starz.length-1] = new oddballParticle();
	}
	
}
public void draw()
{
	background(0);
	for(int i = 0; i<starz.length; i++)
	{
		starz[i].show();
		starz[i].move();
	}
}
	
class NormalParticle implements Particle
{
	double dX, dY, speed, angle;
	NormalParticle()
	{
		dX = 250;
		dY = 250;
		angle = Math.random()*(2*Math.PI);
		speed = Math.random()*(2*Math.PI);

	}
	public void move()
	{
		dX = dX + Math.cos(angle)*speed;
		dY = dY + Math.sin(angle)*speed;
		
	}
	public void show()
	{
		fill(255);
		ellipse((float)dX,(float)dY, 5, 5);
	}
}
interface Particle
{
	public void show();
	public void move();
}
class oddballParticle implements Particle
{
	double locX, locY, angle, speed;
	oddballParticle()
	{
		locX  = 250;
		locY = 0;
	}
	public void show()
	{
		fill(255);
		ellipse((float)locX,(float)locY, 40, 40);
	}
	public void move()
	{
		locY = locY + 2;
	}
}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
