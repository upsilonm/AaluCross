import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

class draw extends JPanel implements MouseListener {

	Graphics2D g;
	boolean started = false;

	int[] drawA = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int[] drawC = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	JFrame ref;

	public draw(JFrame r) {
		ref = r;
		ref.addMouseListener(this);
		move();

	}

	public void paint(Graphics G) {

		g = (Graphics2D) G;
		g.setColor(Color.BLACK);

		g.fillRect(0, 0, 660, 400);
		g.setColor(Color.WHITE);

		g.fillRect(140, 70, 8, 225);
		g.fillRect(220, 70, 8, 225);

		g.fillRect(73, 137, 225, 8);
		g.fillRect(73, 217, 225, 8);

		if (turn)
			drawCross(100);
		else
			drawAalu(100);

		for (int i : drawA)
			drawAalu(i);
		for (int j : drawC)
			drawCross(j);

	}

	public void drawAalu(int position) {

		int[] co = getArea(position);
		g.setColor(Color.green);
		g.fillOval(co[0] + 15, co[1] + 15, 39, 39);
		g.setColor(Color.black);
		g.fillOval(co[0] + 22, co[1] + 22, 25, 25);

	}

	public void drawCross(int position) {

		g.setColor(Color.RED);
		int[] co = getArea(position);

		int nPoints = 4;
		int[] xPoints = { co[0] + 15, co[0] + 20, co[0] + 50, co[0] + 45 };
		int[] yPoints = { co[1] + 15, co[1] + 10, co[1] + 45, co[1] + 50 };
		g.fillPolygon(xPoints, yPoints, nPoints);

		xPoints[0] = co[0] + 45;
		xPoints[1] = co[0] + 50;
		xPoints[2] = co[0] + 20;
		xPoints[3] = co[0] + 15;
		yPoints[0] = co[1] + 10;
		yPoints[1] = co[1] + 15;
		yPoints[2] = co[1] + 50;
		yPoints[3] = co[1] + 45;

		g.fillPolygon(xPoints, yPoints, nPoints);

	}

	public int[] getArea(int boxNum) {

		int[] point = { 0, 0 };
		switch (boxNum) {
		case 1:
			point[0] = 73;
			point[1] = 70;
			break;
		case 2:
			point[0] = 148;
			point[1] = 70;
			break;
		case 3:
			point[0] = 228;
			point[1] = 70;
			break;
		case 4:
			point[0] = 73;
			point[1] = 145;
			break;
		case 5:
			point[0] = 148;
			point[1] = 145;
			break;
		case 6:
			point[0] = 228;
			point[1] = 145;
			break;
		case 7:
			point[0] = 73;
			point[1] = 225;
			break;
		case 8:
			point[0] = 148;
			point[1] = 225;
			break;
		case 9:
			point[0] = 228;
			point[1] = 225;
			break;

		case 100:
			point[0] = 570;
			point[1] = 300;
			break;

		default:
			point[0] = -500;
			point[1] = -500;
			break;

		}
		return point;

	}

	boolean turn = false;
	boolean winner = false;
	boolean gameOver = false;

	int computerMove = 0;
	int playerMove = 0;

	public void move() {

		if (!gameOver) {

			if (!turn) {
				computerMove = getMove(false);
				
				if ((computerMove > 9 || computerMove < 0)
						|| !(drawA[computerMove - 1] == 0 && drawC[computerMove - 1] == 0)) {
					return;
				} 
				else {
					drawA[computerMove - 1] = computerMove;
					containd[computerMove - 1] = 2;
				}

			}

			else {
				playerMove = getMove(true);
				if ((playerMove > 9 || playerMove < 0)
						|| !(drawA[playerMove - 1] == 0 && drawC[playerMove - 1] == 0)) {
					return;
				} else {
					drawC[playerMove - 1] = playerMove;
					containd[playerMove - 1] = 1;
				}

			}
			turn = !turn;
			repaint();

		}

	}

	int[] containd = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	boolean startFirst = false;

	public int getMove(boolean player) {
		
		int choice;

		if (player) {
			return pox;
		} 
		else {

			if (startFirst == false){
				
				startFirst = true;
				
				int[] choices = {1,3,7,9};
				Random r = new Random();
				choice = r.nextInt(choices.length);
				return choice;
			}
			
			else{
				
				for(int x:containd) //remove before merge
					System.out.print(x); //remove before merge
				
				
				System.out.println(playerMove);//remove before merge
				
				if(playerMove!=7)
					return 7;
				
				else
					return 1;
				
					
			}

		}

		return 9;

	}

	int pox = 1;

	public void setMove(int num) {
		pox = num;

	}

	public void mouseEntered(MouseEvent me) {

	}

	public void mouseReleased(MouseEvent me) {

	}

	public void mousePressed(MouseEvent me) {

		Point currentPoint = me.getPoint();
		Component com = me.getComponent();

		if (turn) {

			for (int i = 0; i < 9; i++) {

				int[] temp = getArea(i + 1);
				if (currentPoint.x > temp[0] - 3
						&& currentPoint.x < temp[0] + 73
						&& currentPoint.y > temp[1] + 25
						&& currentPoint.y < temp[1] + 95) {
					setMove(i + 1);
					move();
					return;
				}
			}
		}

		else
			move();

	}

	public void mouseClicked(MouseEvent me) {

	}

	public void mouseExited(MouseEvent me) {

	}

}