
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

/*public class board extends JPanel {
		public void paint(Graphics g) {
			g.setColor (Color.white);   
			g.fill3DRect (15, 55, 900, 575, true); 
			 }

  public static void main(String[] a) {
    JFrame f = new JFrame();
    f.setSize(1000, 1000);
    f.add(new board());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }

  
}*/




class Drawoval extends JComponent {

  public void paint(Graphics g) {
	  int i,j,k=0;
	  g.setColor (Color.black);   
		//g.fill3DRect (15, 55, 900, 575, true); 
	  g.draw3DRect(20, 68, 660, 350 , true);
	  g.setColor (Color.white); 
	  g.fillRect(20,239, 660, 10);
	  g.setColor (Color.black); 
	  g.draw3DRect(20,239, 660, 10 , true);
	  for(j=1;j<18;j++)
	  {if(j==3 || j==9||j==15)
	  {
	  j=j+1;
	  }
	  
		  for(i=2;i<33;i++)
		  { if((j==2  || j==1 ||j==16 || j==17) && i==17)
		  {
		  i=i+1;
		  }
			  g.drawRect (20*i, 20*j+60, 10, 10);
			  g.fill3DRect(20*i, 20*j+60, 10, 10,true);
		  }
	  }
	 // g.setColor (Color.white);   
		//g.fill3DRect (15, 55, 900, 575, true);
     
  }
}


public class board extends JPanel
{
  public static void main(String[] a) 
  {
	  
	  	JFrame window = new JFrame();
	  	window.setBounds(600, 600, 800, 600);
    	
    	//window.add(new board());
    	window.getContentPane().add(new Drawoval());
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	window.setVisible(true);
  }
}
