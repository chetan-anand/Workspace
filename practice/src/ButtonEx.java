import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;

class MyFrame extends JFrame implements ActionListener
{
    DisplayCanvas canvas;
    
    private ImageIcon breadboard,resistor,capacitor,IC;
        private JLabel label1,label2,label3,label4;
        
        
	MyFrame()
	{
            super();
        getContentPane().setLayout(new BorderLayout());
        Container container = getContentPane();

            /* breadboard= new ImageIcon(getClass( ).getResource("breadboard.png"));
            
            label1= new JLabel(breadboard);
            add(label1);*/
		this.setVisible(true);
		this.setSize(1000,1000);
		this.setTitle("BREAD BOARD");
		Button b1=new Button("RESISTOR");
		Button b2=new Button("CAPACITOR");
		Button b3=new Button("IC");
		/*Button b4=new Button("BLACK");
		Button b5=new Button("WHITE");
		Button b6=new Button("PINK");
		Button b7=new Button("ORANGE");
		Button b8=new Button("CYAN");*/
		this.setLayout(new FlowLayout());
		this.add(b1);
		this.add(b2);
		this.add(b3);
		/*this.add(b4);
		this.add(b5);
		this.add(b6);
		this.add(b7);
		this.add(b8);*/
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		/*b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);*/
	}
	public void actionPerformed(ActionEvent ae)
	{
		String Label=ae.getActionCommand();
		if(Label.equals("RESISTOR"))
		{
                     getContentPane().setLayout(new BorderLayout());
        Container container = getContentPane();

        canvas = new DisplayCanvas(1);
        container.add(canvas, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        pack();
        setVisible(true);
       
		}
		if(Label.equals("CAPACITOR"))
		{
			 getContentPane().setLayout(new BorderLayout());
        Container container = getContentPane();

        canvas = new DisplayCanvas(2);
        container.add(canvas, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        pack();
        setVisible(true);
       
		}
		if(Label.equals("IC"))
		{
			this.setBackground(Color.BLUE);
		}
		if(Label.equals("BLACK"))
		{
			this.setBackground(Color.BLACK);
		}
		if(Label.equals("WHITE"))
		{
			this.setBackground(Color.WHITE);
		}
		if(Label.equals("PINK"))
		{
			this.setBackground(Color.PINK);
		}
		if(Label.equals("ORANGE"))
		{
			this.setBackground(Color.ORANGE);
		}
		if(Label.equals("CYAN"))
		{
			this.setBackground(Color.CYAN);
		}
	}
}

class ButtonEx
{
	public static void main(String[] args)
	{
		MyFrame gui=new MyFrame();
                 gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setVisible(true);
            gui.pack();
            
	}
}

class DisplayCanvas extends JPanel {
    private int x, y;
    private Image backimg;
    private Rectangle rect;
    private BufferedImage bi;

    DisplayCanvas(int i) {
        x=25;
        y=96;
        Image img=getToolkit().getImage("breadboard.png");
        backimg = img;
        Dimension size = new Dimension(852, 334);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        rect = new Rectangle(23, 91, 803, 176);

        setBackground(Color.white);
        setSize(450, 400);
        Image image = null;
        addMouseMotionListener(new DisplayCanvas.MouseMotionHandler());
if(i==1)
{
        image = getToolkit().getImage("resistor.png");
}
if(i==2)
{
        image = getToolkit().getImage("capacitor.png");
}

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

        bi = new BufferedImage(image.getWidth(this), image.getHeight(this), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = bi.createGraphics();
        g.drawImage(image, 0, 0, this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backimg, 0, 0, null);
        g.drawRect((int)rect.getX(),(int)rect.getY(), rect.getSize().width, rect.getSize().height);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(bi, x, y, this);
    }

    class MouseMotionHandler extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            if(rect.contains(x,y,120, 80))
                repaint();
        }
    }
}