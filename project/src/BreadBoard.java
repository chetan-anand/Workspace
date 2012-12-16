import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class BreadBoard extends JFrame {
	DisplayCanvas canvas;

	public BreadBoard() {
		// super();
		getContentPane().setLayout(new BorderLayout());
		Container container = getContentPane();
		canvas = new DisplayCanvas(new ImageIcon("C:\\breadboard.png").getImage());
				
		container.add(canvas, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		pack();
		setVisible(true);
	}

	public static void main(String arg[]) {
		new BreadBoard();
	}

	class DisplayCanvas extends JPanel {
		// private MainWindow window;
		private int x, y;
		private Image backimg;
		private Rectangle rect;
		private BufferedImage bi;
		private JLabel status;

		DisplayCanvas(Image img) {

			// window=(new Breadboard)
			x = 25;
			y = 96;
			backimg = img;
			Dimension size = new Dimension(1000, 534);
			// Dimension size = new Dimension(852, 334);
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			// rect = new Rectangle(63, 191, 803, 176);
			rect = new Rectangle(23, 91, 803, 176);

			setBackground(Color.yellow);
			setSize(450, 400);
			addMouseMotionListener(new MouseMotionHandler());
			Image image= getToolkit().getImage("C:\\chip.png");

			MediaTracker mt = new MediaTracker(this);
			mt.addImage(image, 1);
			
			try {
				mt.waitForAll();
			} catch (Exception e) {
				System.out.println("Exception while loading image.");
			}

			if (image.getWidth(this) == -1) {
				System.out.println("No Image File");
				System.exit(0);
			}
			
			

			bi = new BufferedImage(image.getWidth(this), image.getHeight(this),
					BufferedImage.TYPE_INT_ARGB);

			Graphics2D g = bi.createGraphics();

			g.drawImage(image, 0, 0, this);
		
			// System.out.println("temASapx= "+x +"  temASaspy= "+y);
			status = new JLabel("Mouse Status Will Come Here", JLabel.CENTER);
			// status.setVerticalAlignment(.BOTTOM);
		}

		public void paintComponent(Graphics g) {
			// int tempx,tempy;
			super.paintComponent(g);
			g.drawImage(backimg, 0, 0, null);
			g.drawRect((int) rect.getX(), (int) rect.getY(),
					rect.getSize().width, rect.getSize().height);
			Graphics2D g2D = (Graphics2D) g;
			// tempx=x;tempy=y;
			// if((x==tempx+20||x==tempx-20)&&(y==tempy+20||y==tempy-20))
			g2D.drawImage(bi, x, y, this);
			status.setText("tempx= " + x + " tempy= " + y);
			System.out.println("tempx= " + x + "  tempy= " + y);
		}

		class MouseMotionHandler extends MouseMotionAdapter {
			public void mouseDragged(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				if (rect.contains(x, y, 26, 50))
					repaint();
			}
		}
	}
}
