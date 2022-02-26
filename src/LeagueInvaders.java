import javax.swing.JFrame;

public class LeagueInvaders extends GamePanel{
 JFrame frame;
public static final int WIDTH = 500;
public static final int HEIGHT = 800;

LeagueInvaders(){
	frame = new JFrame();
	gpanel = new GamePanel();
}
 void setup() {
	 frame.add(gpanel);
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
}
}
