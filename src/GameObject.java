import java.awt.Rectangle;

public class GameObject {
int x;
int y;
int width;
int height;
Rectangle collisionBox;

int speed = 0;
boolean isActive = false;
GameObject(int x, int y, int width, int height ){
	this.x=(x);
	this.y=(y);
	this.height=(height);
	this.width=(width);
	collisionBox = new Rectangle(x, y, width, height);
	
}
void update(){
	collisionBox.setBounds(x, y, width, height);
	
}
super.update();
}
