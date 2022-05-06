import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	GamePanel gpanel;
	Font titleFont;
	Font pressPlayFont;
	Font instructionsFont;
	Font gameoverFont;
	Font enemieskilledFont;
	Font restartFont;
	Font scoreFont;
	Timer frameDraw;
	Timer alienSpawn;

	ObjectManager objectmanager = new ObjectManager();
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void startGame() {
		objectmanager = new ObjectManager();
		alienSpawn = new Timer(1000, objectmanager);
		alienSpawn.start();
		objectmanager.score = 0;
	}

	void updateMenuState() {

	}

	void updateGameState() {
		objectmanager.update();
		if (objectmanager.rocket.isActive == false) {
			currentState = END;
		}

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE_INVADERS", 30, 100);
		g.setFont(pressPlayFont);
		g.setColor(Color.YELLOW);
		g.drawString("press enter to start", 100, 300);
		g.setFont(instructionsFont);
		g.setColor(Color.YELLOW);
		g.drawString("press space for instructions", 70, 500);

	}

	void drawGameState(Graphics g) {

		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
			objectmanager.draw(g);

		}

		g.setFont(scoreFont);
		g.setColor(Color.WHITE);
		g.drawString(objectmanager.getScore() + "", 40, 40);

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(gameoverFont);
		g.setColor(Color.YELLOW);
		g.drawString("Game Over", 100, 100);
		g.setFont(enemieskilledFont);
		g.setColor(Color.YELLOW);
		g.drawString("you killed " + objectmanager.score + " enemies", 100, 300);
		g.setFont(restartFont);
		g.setColor(Color.YELLOW);
		g.drawString("press enter to play again", 70, 500);
	}

	GamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		pressPlayFont = new Font("Arial", Font.PLAIN, 30);
		instructionsFont = new Font("Arial", Font.PLAIN, 30);
		gameoverFont = new Font("Arial", Font.PLAIN, 48);
		enemieskilledFont = new Font("Arial", Font.PLAIN, 30);
		restartFont = new Font("Arial", Font.PLAIN, 30);
		scoreFont = new Font("Arial", Font.PLAIN, 20);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		if (needImage) {
			loadImage("space.png");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}

		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (currentState == GAME) {

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("UP");
				if (objectmanager.rocket.y > 0) {

					objectmanager.rocket.up();
					// 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
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				ObjectManager.addProjectile(objectmanager.rocket.getProjectile());
				System.out.println("SPACE");

			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("DOWN");
				if (objectmanager.rocket.y <= LeagueInvaders.HEIGHT) {

					objectmanager.rocket.down();
				}
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (objectmanager.rocket.x > 0) {

					objectmanager.rocket.left();
				}
				System.out.println("LEFT");
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
				if (objectmanager.rocket.x < LeagueInvaders.WIDTH) {

					objectmanager.rocket.right();
					// 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
					if (currentState == END) {
						alienSpawn.stop();
					}
				}

			}
		}

		if (currentState == END) {
			alienSpawn.stop();
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
				if (currentState == GAME) {
					startGame();
				}
			}
			if (currentState == END) {

				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}
