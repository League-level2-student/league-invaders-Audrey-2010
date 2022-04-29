import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {

	Rocketship rocket;
	static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score = 0;

	ObjectManager(Rocketship rocket) {
		this.rocket = (rocket);
	}

	public static void addProjectile(Projectile p) {
		projectiles.add(p);

	}
	
	int getScore() {
		return score;
		
	}

	void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();

		}
		for (int o = 0; o < projectiles.size(); o++) {
			projectiles.get(o).update();
		}
		checkCollision();
		purgeObjects();
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	void purgeObjects() {
		for(int i = 0; i<aliens.size(); i++) {
			if(aliens.get(i).isActive==false) {
				aliens.remove(i);
			}
			
		}
		for(int i = 0; i<projectiles.size(); i++) {
			if(projectiles.get(i).isActive==false) {
				projectiles.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		addAlien();
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {

			if (rocket.collisionBox.intersects(aliens.get(i).collisionBox)) {
				rocket.isActive = false;
			}

			for (int i1 = 0; i1 < projectiles.size(); i1++) {
				if (aliens.get(i).collisionBox.intersects(projectiles.get(i1).collisionBox)) {
					projectiles.get(i1).isActive = false;
					aliens.get(i).isActive = false;
					score=+1;
					

				}
			}
		}

	}

}
