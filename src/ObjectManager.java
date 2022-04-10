import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager extends GamePanel implements ActionListener{
	
	
	Rocketship rocket;
	static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	ObjectManager(Rocketship rocket){
		this.rocket=(rocket);
	}
	public static void addProjectile(Projectile p){
	projectiles.add(p);
		
	}
	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		for(int i = 0; i<aliens.size(); i++) {
			aliens.get(i);
			for(int o = 0; o<projectiles.size(); i++) {
				projectiles.get(i);
		}
		}
	}
	void draw(Graphics g){
		spaceship.draw(g);
	}
	void purgeObjects(){
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			addAlien();
		}
	
}
