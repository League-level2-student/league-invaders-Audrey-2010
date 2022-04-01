import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager extends GamePanel implements ActionListener{
	
	
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	ObjectManager(Rocketship rocket){
		this.rocket=(rocket);
	}
	void addProjectile(Projectile p){
	projectiles.add(p);
		
	}
	void addAlien(Alien a) {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		for(int i = 0; i<aliens.size(); i++) {
			aliens.get(i);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien(aliens <random.nextInt()>);
	}
}
