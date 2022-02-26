import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;
	GamePanel gpanel;
	Font titleFont;
	Font pressPlayFont;
	Font instructionsFont;
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
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
		 g.setColor(Color.BLACK);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	 }
	 void drawEndState(Graphics g)  { 
		 g.setColor(Color.red);
		 g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	 }
GamePanel(){
    titleFont = new Font("Arial", Font.PLAIN, 48);
    pressPlayFont = new Font("Arial", Font.PLAIN, 30);
    instructionsFont = new Font("Arial", Font.PLAIN, 30);
}
}
