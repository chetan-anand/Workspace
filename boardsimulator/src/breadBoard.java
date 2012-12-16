
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame ;
import javax.swing.JPanel ;
import javax.swing.JLabel ;

import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension ;
import java.awt.Graphics ;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit ;
import java.awt.Color ;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent ;
import java.awt.event.MouseListener ;
import java.awt.event.MouseAdapter ;
import java.awt.event.MouseMotionListener ;
import java.awt.event.MouseMotionAdapter ;
import java.awt.Robot ;
import java.awt.geom.* ;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.* ;

class breadBoard extends javax.swing.JFrame{
	private static void launchFrame(){
		
		JFrame board = new JFrame("BreadBoard") ;
		board.add(new MyPanel()) ;
		board.setDefaultCloseOperation(EXIT_ON_CLOSE) ;
		board.pack() ;
		board.setVisible(true) ;
	}
	public static void main( String[] args ){
		launchFrame() ;
	}
}
class MyPanel extends JPanel implements MouseListener,MouseMotionListener{

	private static final int Centre = 0;

	JFrame frame;
	MyPanel drawpanel;
	private BufferedImage bi,b2 , b3 , b4;
	private int prevX, prevY, x, y = -1;
	private boolean dragging ;
	public boolean Connect1 = false ;
	public boolean Connect2 = false ;
	private Rectangle rect;
	public int speci ; 
	Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize() ;
	public int boardWidth = (int)scrnSize.getWidth()-200 ;
	public int boardHeight = (int)scrnSize.getHeight()-300 ;

	int i=-1 ;
	
	private breadBoard window;
    private int startX = -1;
    private int startY = -1;
    private int a = -1;
    private int b = -1;
    private int curX = -1;
    private int curY = -1;
    private boolean inDrag = false;
    public int[] x1 = new int[100];
    public int[] y1 = new int[100];
    public int[] x2 = new int[100];
    public int[] y2 = new int[100];
    public int[] r1 = new int[100];
    public int[] c1 = new int[100];
    public int[] r2 = new int[100];
    public int[] c2 = new int[100];
//    public int[] id = new int[100];
    public int[][] mat = new int[68+1][68+1];
    public int num = 0;
	private Graphics2D g;
	public int flag;
    
    public ImageIcon icon,icon1,icon2,icon3,icon4;
    public JLabel dragLabel1,dragLabel2,dragLabel3,dragLabel4,dragLabel5;  
    public JLabel dragLabela[]=new JLabel[2];
    public JLabel dragLabelb[]=new JLabel[2];
    public JLabel dragLabelc[]=new JLabel[2];
    public JLabel dragLabeld[]=new JLabel[2];
    MyPanel(){
	
		//setBackground(Color.black) ;
 
		addMouseListener(this) ;
		addMouseMotionListener(this) ;
		icon1 = new ImageIcon("chip.png","random");
		icon2 = new ImageIcon("capacitor.png","random");
		icon3 = new ImageIcon("resistor.png","random");
		icon4 = new ImageIcon("LED.png","random");
		dragLabel1 = new JLabel(icon1);
		
		for(int i=0;i<2;i++)
		{
			dragLabela[i]=new JLabel(icon1);
			add(dragLabela[i]);
		}
		add(dragLabel1);
		dragLabel2 = new JLabel(icon2);
		for(int i=0;i<2;i++)
		{
			dragLabelb[i]=new JLabel(icon2);
			add(dragLabelb[i]);
		}
		add(dragLabel2);
		dragLabel3 = new JLabel(icon3);
		for(int i=0;i<2;i++)
		{
			dragLabelc[i]=new JLabel(icon3);
			add(dragLabelc[i]);
		}
		add(dragLabel3);
		dragLabel4 = new JLabel(icon4);
		for(int i=0;i<2;i++)
		{
			dragLabeld[i]=new JLabel(icon4);
			add(dragLabeld[i]);
		}
		add(dragLabel4);
			/*add(dragLabel1);
			add(dragLabel2);
			add(dragLabel3);
			add(dragLabel4);*/
			
		for(int j=0;j<2;j++)
		{
			dragLabela[j].setBounds(startX, startY, icon1.getIconWidth(), icon1.getIconHeight());
			dragLabela[j].addMouseMotionListener(this);
			dragLabela[j].addMouseListener(this);
		}	
		
		for(int j=0;j<2;j++)
		{
			dragLabelb[j].setBounds(startX, startY, icon2.getIconWidth(), icon2.getIconHeight());
			dragLabelb[j].addMouseMotionListener(this);
			dragLabelb[j].addMouseListener(this);
		}
		
		for(int j=0;j<2;j++)
		{
			dragLabelc[j].setBounds(startX, startY, icon3.getIconWidth(), icon3.getIconHeight());
			dragLabelc[j].addMouseMotionListener(this);
			dragLabelc[j].addMouseListener(this);
		}
		
		for(int j=0;j<2;j++)
		{
			dragLabeld[j].setBounds(startX, startY, icon4.getIconWidth(), icon4.getIconHeight());
			dragLabeld[j].addMouseMotionListener(this);
			dragLabeld[j].addMouseListener(this);
		}
	}
			
	public Dimension getPreferredSize(){
		return Toolkit.getDefaultToolkit().getScreenSize() ;
	}
	

	public void paintComponent(Graphics g){
		super.paintComponent(g) ;
		
		 super.paintComponent(g);
	     Graphics2D g2 = (Graphics2D)g;
	     drawBoard(g2) ;
	     g2.setColor(Color.RED);
	     g2.setStroke(new BasicStroke(5));
//	g2.draw(new RoundRectangle2D.Double(11,11,985,420,50,50));
	    
	     g2.setStroke(new BasicStroke(1.5f));
	g2.setColor(Color.BLUE);

		
	
		
		
		g.setColor(Color.red);
		//g.setColor(Color.GREEN);
        if(inDrag){
        	for(int i=0;i<num;i++)
        	{
        		g2.drawLine(startX, startY, curX, curY);
        		g2.drawLine(x1[i], y1[i], x2[i], y2[i]);
        	}
 //       	drawCoordinates(g);
        }
        else if(!inDrag){
        	for(int i=0;i<num;i++)
        	{
        		g2.drawLine(startX, startY, curX, curY);
        		g2.drawLine(x1[i], y1[i], x2[i], y2[i]);
        	}
        }
		//}	
	

	/*Graphics2D g2D = (Graphics2D) g;
		System.out.println(" "+x1+" "+x2+" "+ctrlx+" "+ctrly) ;
		g.drawLine(x1,y1,ctrlx,ctrly) ;*/
	
	

     
	}

	/*Graphics2D g2D = (Graphics2D) g;
		System.out.println(" "+x1+" "+x2+" "+ctrlx+" "+ctrly) ;
		g.drawLine(x1,y1,ctrlx,ctrly) ;*/
	public void drawBoard(Graphics g){
		

		//g.setColor(Color.white) ;
		//g.fillRect(120,75,boardWidth-50,boardHeight+45) ;
		g.setColor(Color.black) ;
		int i,j ;
		int count  ;
		for(j=0;j<2;j++){
			count = 0 ;
			for(i=180;i<boardWidth;i=i+20){
				if(count!=22)
				g.fillRect(i,90+j*25,10,10) ;
				
				else{
					speci = i ;
				}
				
				count++ ;
			}
		}
		g.setColor(Color.green) ;
		for(j=2;j<4;j++){
			g.drawLine(180,90+j*25,boardWidth,90+j*25) ;
		}
		g.setColor(Color.black) ;
		for(j=4;j<9;j++){
			for(i=180;i<boardWidth;i=i+20){
				g.fillRect(i,90+j*25,10,10) ;
			}
		}
		g.setColor(Color.green) ;
//		for(j=9;j<11;j++){
//			g.drawLine(180,90+j*25,boardWidth,90+j*25) ;
//		}
		g.setColor(Color.black) ;
		for(j=11;j<16;j++){
			for(i=180;i<boardWidth;i=i+20){
				g.fillRect(i,90+j*25,10,10) ;
			}
		}
		g.setColor(Color.green) ;
		for(j=16;j<18;j++){
			g.drawLine(180,90+j*25,boardWidth,90+j*25) ;
		}
		g.setColor(Color.black) ;
		for(j=18;j<20;j++){
			count = 0 ;
			for(i=180;i<boardWidth;i=i+20){
				if(count!=22)
				g.fillRect(i,90+j*25,10,10) ;
				
				else ;
				
				count++ ;
			}
		}


		g.setColor(Color.green) ;
		g.drawString("V+",90,90+9*25) ;
		g.setColor(Color.red) ;
		g.fillRect(100,90+9*25,20,20) ;
		g.setColor(Color.blue) ;
		g.fillRect(100,90+10*25,20,20) ;
		g.setColor(Color.black) ;
		g.drawLine(50,90+10*25+10,100,90+10*25+10) ;
		g.drawLine(50,90+10*25+10,50,90+10*25+10+40) ;
		g.drawLine(25,90+10*25+10+40,75,90+10*25+10+40) ;
		g.drawLine(35,90+10*25+10+40+10,65,90+10*25+10+40+10) ;
		g.drawLine(42,90+10*25+10+40+20,58,90+10*25+10+40+20) ;
		
		g.setColor(Color.CYAN) ;
		g.fillRect(600, 700, 50, 50) ;

	}
	
	public void mousePressed( MouseEvent e ){
		
		/*wires.add(new ArrayList<Integer>());

		i++ ;
		x = evt.getX() ;
		y = evt.getY() ;
		System.out.println(" "+x+" "+y) ;
		
		if(dragging == true)
			return ;
			
		else{
			try{
				prevX = x ;
				prevY = y ;
				
				 Robot robot = new Robot() ;
				System.out.println(" "+robot.getPixelColor(evt.getX(),evt.getY())+" "+Color.white) ;
				Connect1 = false ;
				int i1 ;
				int j1 ;
				for(i1=180;i1<boardWidth ;i1=i1+20){
				
					for(j1=0;j1<20;j1++){
					
						if((x>i1&&x<i1+10)&&(y>90+j1*25&&y<90+j1*25+10))
							
							if(i1==speci&&(j1==0||j1==1||j1==18||j1==19)) ;
							
							else
							Connect1 = true ;
							
					}
				}
					
				if(Connect1){
					System.out.println("a") ;
					wires.get(i).add(prevX) ;
					wires.get(i).add(prevY) ;
					repaint() ;
					dragging = true ;
				}
				
				else{
				
				 System.out.println("b") ;
				 dragging = false ;
				}
			
			}
			
			catch(Exception e){
			
			}
		}*/
		
		inDrag = true;
        a = startX = e.getX();
        b = startY = e.getY();
        x1[num]= e.getX();
        y1[num]= e.getY();
			
			
	}
	public void mouseReleased(MouseEvent e) {
   		
   		/*try{						        // Called whenever the user releases the mouse button.
   			Robot robot = new Robot() ;				        // If the user was drawing a curve, the curve is done,		
   			System.out.println(" "+robot.getPixelColor(evt.getX(),evt.getY())+" "+Color.white) ;
   			
   			Connect2 = false ;
   			int i1 ,j1 ;
   			int x = evt.getX() ;
   			int y = evt.getY() ;
   			if(Connect1){
				for(i1=180;i1<boardWidth;i1=i1+20){
				
					for(j1=0;j1<20;j1++){
					
						if((x>i1&&x<i1+10)&&(y>90+j1*25&&y<90+j1*25+10))
							
							if(i1==speci&&(j1==0||j1==1||j1==18||j1==19)) ;
							
							else
							Connect2 = true ;
							
					}
				}
   			
				if(Connect2){	
   				System.out.println("c") ;        // so we should set drawing to false and get rid of
   				wires.get(i).add(evt.getX()) ;
   				wires.get(i).add(evt.getY()) ;
   				repaint() ;// the graphics context that we created to use during
   				System.out.println(" "+evt.getX()+" "+evt.getY()) ;
				}// the drawing.
				else{
					System.out.println("d") ;
					wires.get(i).remove(wires.get(i).size()-1) ;
					wires.get(i).remove(wires.get(i).size()-1) ;
   			
				}
   			}
   			
   	   	 if (dragging == false)
   	       		return;  // Nothing to do because the user isn't drawing.
   	      
   	    	dragging = false;
   	    
   		
		}
		
		catch(Exception e){}  */ 
		inDrag = false; 
        x2[num]= e.getX();
        y2[num]= e.getY();
        

        System.out.println("Coordinates of "+(num));
//   	System.out.println(" row1= "+(y1[num]-90)/25 + " column1= "+(x1[num]-180)/20 +" row2="+(y2[num]-90)/25 + " colunm2= "+(x2[num]-180)/20);
    	
    	if(((y1[num]-90)/25) +1 > 2)
    	{
    		if(((y1[num]-90)/25) +1 > 9)
    		{
    			if(((y1[num]-90)/25) +1 > 12)
    			{
    				r1[num] = ((y1[num]-90)/25) -5 ; 
//        			r2[num] = ((y2[num]-90)/25) -5 ;
    			}
    			else
    			{
    				r1[num] = ((y1[num]-90)/25) -3 ; 
//        			r2[num] = ((y2[num]-90)/25) -5 ;
    			}
    		}
    		else
    		{
    			r1[num] = ((y1[num]-90)/25) -1 ; 
//        		r2[num] = ((y2[num]-90)/25) -2 ;
    		}
    	}
    	else 
    	{
    		r1[num] = ((y1[num]-90)/25) +1 ; 
//    		r2[num] = ((y2[num]-90)/25) +1 ;
    	}
    	
    	
    	if(((y2[num]-90)/25) +1 > 2)
    	{
    		if(((y2[num]-90)/25) +1 > 9)
    		{
    			if(((y1[num]-90)/25) +1 > 12)
    			{
//    				r1[num] = ((y1[num]-90)/25) -5 ; 
        			r2[num] = ((y2[num]-90)/25) -5 ;
    			}
    			else
    			{
//    				r1[num] = ((y1[num]-90)/25) -3 ; 
        			r2[num] = ((y2[num]-90)/25) -3 ;
    			}
    		}
    		else
    		{
//    			r1[num] = ((y1[num]-90)/25) -2 ; 
        		r2[num] = ((y2[num]-90)/25) -1 ;
    		}
    	}
    	else 
    	{
//    		r1[num] = ((y1[num]-90)/25) +1 ; 
    		r2[num] = ((y2[num]-90)/25) +1 ;
    	}    
    	
    	
    	c1[num] = ((x1[num]-180)/20) +1 ;
    	c2[num] = ((x2[num]-180)/20) +1 ;
    	
    	
    	{
   		 try
            {
   				for(int i=0; i<5;i++)
   				{
   					if(r1[i] > 2 && r1[i] < 7)
   					{
   						if(r2[i] > 2 && r2[i] < 7)
   						{
   							mat[c1[i]][c2[i]+4+4] = 1;
   							mat[c2[i]+4+4][c1[i]] = 1;
   						}	
   						else if(r2[i] <= 2 && c2[i] < 23)
   						{
   							mat[c1[i]][r2[i]] = 1;
   							mat[r2[i]][c1[i]] = 1;
   						}
   						else if(r2[i] <= 2 && c2[i] > 23)
   						{
   							mat[c1[i]][r2[i]+2] = 1;
   							mat[r2[i]+2][c1[i]] = 1;
   						}	
   						else if (r2[i] >= 7)
   						{
   							if(r2[i] <= 12)
   							{
   								mat[c1[i]][c2[i]+30+4+4] = 1;
   								mat[c2[i]+30+4+4][c1[i]] = 1;
   							}	
   							else if(r2[i] > 12 && c2[i] < 23)	
   							{
   								mat[c1[i]][r2[i]-8] = 1;				
   								mat[r2[i] -8][c1[i]] = 1;
   							}
   							else if(r2[i] > 12 && c2[i] > 23)	
   							{
   								mat[c1[i]][r2[i]-6] = 1;				
   								mat[r2[i] -6][c1[i]] = 1;
   							}
   						}	
   					}
   					
   					else if(r1[i] <= 2 && c1[i] < 23)
   					{
   						if(r2[i] > 2 && r2[i] < 7)
   						{
   							mat[r1[i]][c2[i]+4+4] = 1;
   							mat[c2[i]+4+4][r1[i]] = 1;
   						}	
   						else if(r2[i] <= 2 && c2[i] < 23)
   						{
   							mat[r1[i]][r2[i]] = 1;
   							mat[r2[i]][r1[i]] = 1;
   						}
   						else if(r2[i] <= 2 && c2[i] > 23)
   						{
   							mat[r1[i]][r2[i]+2] = 1;
   							mat[r2[i]+2][r1[i]] = 1;
   						}	
   						else if (r2[i] >= 7)
   						{
   							if(r2[i] <= 12)
   							{
   								mat[r1[i]][c2[i]+30+4+4] = 1;
   								mat[c2[i]+30+4+4][r1[i]] = 1;
   							}	
   							else if(r2[i] > 12 && c2[i] < 23)	
   							{
   								mat[r1[i]][r2[i]-8] = 1;				
   								mat[r2[i] -8][r1[i]] = 1;
   							}
   							else if(r2[i] > 12 && c2[i] > 23)	
   							{
   								mat[r1[i]][r2[i]-6] = 1;				
   								mat[r2[i] -6][r1[i]] = 1;
   							}
   						}	
   					}
   					
   					else if(r1[i] <= 2 && c1[i] > 23)
   					{
   						if(r2[i] > 2 && r2[i] < 7)
   						{
   							mat[r1[i]+2][c2[i]+4+4] = 1;
   							mat[c2[i]+4+4][r1[i]+2] = 1;
   						}	
   						else if(r2[i] <= 2 && c2[i] < 23)
   						{
   							mat[r1[i]+2][r2[i]] = 1;
   							mat[r2[i]][r1[i]+2] = 1;
   						}
   						else if(r2[i] <= 2 && c2[i] > 23)
   						{
   							mat[r1[i]+2][r2[i]+2] = 1;
   							mat[r2[i]+2][r1[i]+2] = 1;
   						}	
   						else if (r2[i] >= 7)
   						{
   							if(r2[i] <= 12)
   							{
   								mat[r1[i]+2][c2[i]+30+4+4] = 1;
   								mat[c2[i]+30+4+4][r1[i]+2] = 1;
   							}	
   							else if(r2[i] > 12 && c2[i] < 23)	
   							{
   								mat[r1[i]+2][r2[i]-8] = 1;				
   								mat[r2[i] -8][r1[i]+2] = 1;
   							}
   							else if(r2[i] > 12 && c2[i] > 23)	
   							{
   								mat[r1[i]+2][r2[i]-6] = 1;				
   								mat[r2[i] -6][r1[i]+2] = 1;
   							}
   						}	
   					}
   					
   					else if (r1[i] >= 7)
   					{
   						if(r1[i] <= 12)
   						{
   							if(r2[i] > 2 && r2[i] < 7)
   							{
   								mat[c1[i]+30][c2[i]+4+4] = 1;
   								mat[c2[i]+4+4][c1[i]+30] = 1;
   							}	
   							else if(r2[i] <= 2 && c2[i] < 23)
   							{
   								mat[c1[i]+30][r2[i]] = 1;
   								mat[r2[i]][c1[i]+30] = 1;
   							}
   							else if(r2[i] <= 2 && c2[i] > 23)
   							{
   								mat[c1[i]+30][r2[i]+2] = 1;
   								mat[r2[i]+2][c1[i]+30] = 1;
   							}	
   							else if (r2[i] >= 7)
   							{
   								if(r2[i] <= 12)
   								{
   									mat[c1[i]+30][c2[i]+30+4+4] = 1;
   									mat[c2[i]+30+4+4][c1[i]+30] = 1;
   								}	
   								else if(r2[i] > 12 && c2[i] < 23)	
   								{
   									mat[c1[i]+30][r2[i]-8] = 1;				
   									mat[r2[i] -8][c1[i]+30] = 1;
   								}
   								else if(r2[i] > 12 && c2[i] > 23)	
   								{
   									mat[c1[i]+30][r2[i]-6] = 1;				
   									mat[r2[i] -6][c1[i]+30] = 1;
   								}
   							}	
   						}
   						
   						else if(r1[i] > 12 && c1[i] < 23)
   						{
   							if(r2[i] > 2 && r2[i] < 7)
   							{
   								mat[r1[i]-8][c2[i]+4+4] = 1;
   								mat[c2[i]+4+4][r1[i]-8] = 1;
   							}	
   							else if(r2[i] <= 2 && c2[i] < 23)
   							{
   								mat[r1[i]-8][r2[i]] = 1;
   								mat[r2[i]][r1[i]-8] = 1;
   							}
   							else if(r2[i] <= 2 && c2[i] > 23)
   							{
   								mat[r1[i]-8][r2[i]+2] = 1;
   								mat[r2[i]+2][r1[i]-8] = 1;
   							}	
   							else if (r2[i] >= 7)
   							{
   								if(r2[i] <= 12)
   								{
   									mat[r1[i]-8][c2[i]+30+4+4] = 1;
   									mat[c2[i]+30+4+4][r1[i]-8] = 1;
   								}	
   								else if(r2[i] > 12 && c2[i] < 23)	
   								{
   									mat[r1[i]-8][r2[i]-8] = 1;				
   									mat[r2[i] -8][r1[i]-8] = 1;
   								}
   								else if(r2[i] > 12 && c2[i] > 23)	
   								{
   									mat[r1[i]-8][r2[i]-6] = 1;				
   									mat[r2[i] -6][r1[i]-8] = 1;
   								}
   							}
   						}
   						
   						else if(r1[i] > 12 && c1[i] > 23)
   						{
   							if(r2[i] > 2 && r2[i] < 7)
   							{
   								mat[r1[i]-6][c2[i]+4+4] = 1;
   								mat[c2[i]+4+4][r1[i]-6] = 1;
   							}	
   							else if(r2[i] <= 2 && c2[i] < 23)
   							{
   								mat[r1[i]-6][r2[i]] = 1;
   								mat[r2[i]][r1[i]-6] = 1;
   						}
   							else if(r2[i] <= 2 && c2[i] > 23)
   							{
   								mat[r1[i]-6][r2[i]+2] = 1;
   								mat[r2[i]+2][r1[i]-6] = 1;
   							}	
   							else if (r2[i] >= 7)
   							{
   								if(r2[i] <= 12)
   								{
   									mat[r1[i]-6][c2[i]+30+4+4] = 1;
   									mat[c2[i]+30+4+4][r1[i]-6] = 1;
   								}	
   								else if(r2[i] > 12 && c2[i] < 23)	
   								{
   									mat[r1[i]-6][r2[i]-8] = 1;				
   									mat[r2[i] -8][r1[i]-6] = 1;
   								}
   								else if(r2[i] > 12 && c2[i] > 23)	
   								{
   									mat[r1[i]-6][r2[i]-6] = 1;				
   									mat[r2[i] -6][r1[i]-6] = 1;
   								}
   							}
   						}
   					}
   				}
   	
    	
				for(int i=2; i<68 +1;i++)
					for(int j=1;j<i ;j++)
						if (mat[i][j] == 1)
							for(int k=1;k<68+1;k++)
								if (mat[j][k] == 1)
									mat[i][k] =1;
			 
				FileWriter fstream = new FileWriter("C:\\write.txt");
				  BufferedWriter out = new BufferedWriter(fstream);
				  
				 
                
               /* for(int i =1 ; i< 68+1; i++)
            	{
            		for(int j=0;j<68+1 ; j++)
            		{
            			if(i==j)
            				mat[i][j] = 1;
//            			fw.flush();
            			out.write(mat[i][j]);
                      
            		}	
            		out.append("\n");
            	}
                
//                fw.flush();
//                  fw.write(mat[r1[num]][c1[num]]);
                */
				  

					for(int i=2; i<68 +1;i++)
									for(int j=1;j<i ;j++)
										if (mat[i][j] == 1)
											for(int k=1;k<68+1;k++)
												if (mat[j][k] == 1)
													mat[i][k] =1;
							 
					                FileWriter out1;
					                String s=new String("");
					                out1 = new FileWriter("C:\\output.txt");
					                PrintWriter p;
					                p= new PrintWriter( out1 );
					                  for( int  count1=1;count1<68+1;count1++)
					                  {
					                     for(int count2=1;count2<68+1;count2++)
					                     { 
					                     
					     s+= Integer.toString(mat[count1][count2]);
					                                }
					                  s+="\n";
					                        }
					                 
					                        p.format("%s", s);
					                        p.close();
                out1.close();
         }catch (IOException e1){};
		
	}
	System.out.println("row1 = " + r1[num] + "col1 = " + c1[num] + "row2 = " + r2[num] + "col2 = " + c2[num]  );
	num ++;
//	repaint();
}
	

	public void mouseDragged( MouseEvent e ){
	
		/*if(dragging == false)
			return ;
			
		x = evt.getX() ;
		y = evt.getY() ;
		//wires.get(i).add(x) ;
		//wires.get(i).add(y) ;
		repaint() ;
		//System.out.println(" "+x+" "+y) ;
		
		
		prevX = x ;
		prevY = y ;*/
		flag=1;
		if(inDrag){
			 //       	for(int i=0;i<num;i++)
			        		curX=e.getX();
			        		curY=e.getY();
			            repaint();
			//int cj=10;
			//System.out.println("hello world\n");
			for(int i=0;i<2;i++)
			{
				//if (e.getSource()==dragLabel[i]) 
				//{
			            
			            if (e.getSource() == dragLabela[i]) 
						{
						flag=0;
						JComponent jc = (JComponent) dragLabela[i];
						repaint();
						jc.setLocation(jc.getX() + e.getX()-startX, jc.getY() + e.getY()- startY);
						break;
						}
						
						if (e.getSource() == dragLabelb[i]) 
						{
						flag=0;
						JComponent jc = (JComponent) dragLabelb[i];
						repaint();
						jc.setLocation(jc.getX() + e.getX()-startX, jc.getY() + e.getY()- startY);
						break;
						}
						
						if (e.getSource() == dragLabelc[i]) 
						{
						flag=0;
						JComponent jc = (JComponent) dragLabelc[i];
						repaint();
						jc.setLocation(jc.getX() + e.getX()-startX, jc.getY() + e.getY()- startY);
						break;
						}
						
						if (e.getSource() == dragLabeld[i]) 
						{
						flag=0;
						JComponent jc = (JComponent) dragLabeld[i];
						repaint();
						jc.setLocation(jc.getX() + e.getX()-startX, jc.getY() + e.getY()- startY);
						break;
						}	
				
		}	
		
		}	
	}
	
	
	public void mouseEntered(MouseEvent evt) { }   // Some empty routines.
  	public void mouseExited(MouseEvent evt) { }    //    (Required by the MouseListener
   	public void mouseClicked(MouseEvent evt) { }   //    and MouseMotionListener
  	public void mouseMoved(MouseEvent evt) { } 
  	   //	
	
}

