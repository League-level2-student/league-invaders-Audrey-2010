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
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
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
	Timer frameDraw;
	Rocketship spaceship = new Rocketship(250, 700, 50, 50);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}
		else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	
	void updateMenuState() {
		
	}
	void updateGameState() {
		
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
		 
		 spaceship.draw(g);
		 if (gotImage) {
				g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
				
			} 

	 }
	 void drawEndState(Graphics g)  { 
		 g.setColor(Color.red);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		 g.setFont(gameoverFont);
		 g.setColor(Color.YELLOW);
			g.drawString("Game Over", 100, 100);
			g.setFont(enemieskilledFont); 
			g.setColor(Color.YELLOW);
			g.drawString("you killed enemies", 100, 300);
			g.setFont(restartFont);
			g.setColor(Color.YELLOW);
			g.drawString("press enter to play again", 70, 500);
	 }
GamePanel(){
    titleFont = new Font("Arial", Font.PLAIN, 48);
    pressPlayFont = new Font("Arial", Font.PLAIN, 30);
    instructionsFont = new Font("Arial", Font.PLAIN, 30);
    gameoverFont = new Font("Arial", Font.PLAIN, 48);
    enemieskilledFont = new Font("Arial", Font.PLAIN, 30);
    restartFont = new Font("Arial", Font.PLAIN, 30);
    frameDraw = new Timer(1000/60,this);
    frameDraw.start();
    if (needImage) {
        loadImage ("space.png");
    }

}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(currentState == MENU){
	    updateMenuState();
	}else if(currentState == GAME){
	    updateGameState();
	}else if(currentState == END){
	    updateEndState();
	}
	System.out.println("action");
	repaint();
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	    if (currentState == END) {
	        currentState = MENU;
	    } else {
	        currentState++;
	    }
	}  
	if(currentState == GAME) {
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		   if(spaceship.y>0) {
		
		    spaceship.up();
		   }
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
		    System.out.println("DOWN");
		    if(spaceship.y<=LeagueInvaders.HEIGHT) {
		    	
		    spaceship.down();
		    }
		}
		else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(spaceship.x>0) {
				
			
				spaceship.left();
			}
		    System.out.println("LEFT");
		}
		else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
		    System.out.println("RIGHT");
		    if(spaceship.x<LeagueInvaders.WIDTH) {
		    	
		    
		    	spaceship.right();
		    	//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
		    }
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
