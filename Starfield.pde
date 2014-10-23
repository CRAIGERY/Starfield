Particle[] starz;

void setup()
{
	size (500,500);
	starz = new Particle[500];
	for (int i = 0; i <= starz.length - 1; i ++)
	{
		starz [i] = new NormalParticle();
		starz[starz.length-1] = new oddballParticle();
		starz[10] = new jumbo();
	}
	
}
void draw()
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
		locX = 250;
		locY = 0;
	}
	public void show()
	{
		fill(255);
		ellipse((float)locX,(float)locY, 25, 25);
	}
	public void move()
	{
		locY = locY + 2;
	}
}
class jumbo extends NormalParticle
{
	int jumboSize;
	jumbo()
	{
		jumboSize = 50;
	}
	public void show()
	{
		ellipse(jumboSize,jumboSize,50,50);
		jumboSize++;
	}
}

