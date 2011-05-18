import java.awt.Container;
import javax.swing.JFrame;


public class Main{
public static void main(String[] args){
		
	
    	JFrame frame = new JFrame("AaluCross");
		frame.setSize(660, 400);
		frame.setLocation(350,140);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	draw d = new draw(frame);
			
		
	    frame.show();
		

	    Container contentPane = frame.getContentPane();
	    contentPane.add(d);


	    

	}

	


}
