import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;



public class MainWindow extends JFrame{
    private JLabel status;
    public MainWindow(){
        status = new JLabel("Mouse Status Will Come Here", JLabel.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new MouseDemoClass(this), BorderLayout.PAGE_START);
        getContentPane().add(status, BorderLayout.PAGE_END);
        setSize(500, 400);
    }
    
    public void setStatus(String message){
         status.setText(message);
    }
    
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}


class MouseDemoClass extends JPanel implements MouseListener, MouseMotionListener {
    private MainWindow window;
    private int startX = -1;
    private int startY = -1;
    private int curX = -1;
    private int curY = -1;
    private boolean inDrag = false;
    public int[] x1 = new int[100];
    public int[] y1 = new int[100];
    public int[] x2 = new int[100];
    public int[] y2 = new int[100];
    public int[] id = new int[100];
    public int num = 0;
    
    
    
    public MouseDemoClass(MainWindow myContainer) {
        window  = myContainer;
        setPreferredSize(new Dimension(300, 250));
        setBackground(new Color(162,140,119));
        addMouseListener(this);
        addMouseMotionListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getButton() == MouseEvent.NOBUTTON) {
            window.setStatus("No Mouse Button Clicked");
        } else if (e.getButton() == MouseEvent.BUTTON1) {
            window.setStatus("Left Mouse Button Clicked, click position is: (" + e.getX() + "," + e.getY() + "), number of clicks: " + e.getClickCount());
        } else if (e.getButton() == MouseEvent.BUTTON2) {
            window.setStatus("Middle Mouse Button Clicked");
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            window.setStatus("Right Mouse Button Clicked");
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        inDrag = true;
        startX = e.getX();
        startY = e.getY();
        x1[num]= e.getX();
        y1[num]= e.getY();
        window.setStatus("Mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        inDrag = false;
        window.setStatus("Mouse Released, selection from: "  + startX + "," + startY + " to " + curX + "," + curY);  
        x2[num]= e.getX();
        y2[num]= e.getY();
        num ++;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        window.setStatus("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        window.setStatus("Mouse Exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(inDrag){
 //       	for(int i=0;i<num;i++)
        		
            repaint();
        }
        curX = e.getX();
        curY = e.getY();
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        window.setStatus("Mouse Moved to: (" + e.getX() + ", " + e.getY() + ")");
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        if(inDrag){
        	for(int i=0;i<num;i++)
        	{
        		g.drawLine(startX, startY, curX, curY);
        		g.drawLine(x1[i], y1[i], x2[i], y2[i]);
        	}
 //       	drawCoordinates(g);
        }
        else if(!inDrag){
        	for(int i=0;i<num;i++)
        	{
//        		g.drawLine(startX, startY, curX, curY);
        		g.drawLine(x1[i], y1[i], x2[i], y2[i]);
        	}
        }
    }
    private void drawCoordinates(Graphics g) {

    	  // get width & height here (w,h)

    	  // define grid width (dh, dv)
/*
    	  for (int i = startX; i < curX; i += 1) {
    	    g.drawLine(startX, startY, curX, curY);
    	  }
    	  
    	  for (int j = startY; j < curY; j += 1) {
    	      g.drawLine(startX, startY, curX, curY);
    	  }
  */
    	}
}