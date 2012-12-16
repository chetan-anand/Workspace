
import javax.swing.JFrame ;
import javax.swing.JPanel ;
import javax.swing.JLabel ;
import java.awt.Dimension ;
import java.awt.Graphics ;
import java.awt.Graphics2D;
import java.awt.Toolkit ;
import java.awt.Color ;
import java.awt.event.MouseEvent ;
import java.awt.event.MouseListener ;
import java.awt.event.MouseAdapter ;
import java.awt.event.MouseMotionListener ;
import java.awt.event.MouseMotionAdapter ;
import java.awt.Robot ;
import java.awt.geom.* ;
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
class MyPanel extends JPanel implements MouseListener , MouseMotionListener{

	
	private int prevX, prevY, x, y = -1;
	private boolean dragging ;
	public boolean Connect1 = false ;
	public boolean Connect2 = false ;
	public int speci ; 
	Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize() ;
	public int boardWidth = (int)scrnSize.getWidth()-200 ;
	public int boardHeight = (int)scrnSize.getHeight()-300 ;
	ArrayList<ArrayList<Integer>> wires = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> rect = new ArrayList<Integer>() ;
	Iterator i1 = wires.iterator() ;
	int i=-1 ;
	
	
	MyPanel(){
	
		//setBackground(Color.black) ;
		addMouseListener(this) ;
		addMouseMotionListener(this) ;
		
	}
			
	public Dimension getPreferredSize(){
		return Toolkit.getDefaultToolkit().getScreenSize() ;
	}
	

	public void paintComponent(Graphics g){
		super.paintComponent(g) ;
		drawBoard(g) ;
		int index ;
		int col = 0;
		Iterator iter ;
		g.setColor(Color.red);
		for(index=0;index<=i;index++){
			System.out.println("e") ;
			iter = wires.get(index).iterator() ;
			col = 0;
			while(iter.hasNext()){
			
	g.drawLine(wires.get(index).get(col),wires.get(index).get(col+1),wires.get(index).get(col+2),wires.get(index).get(col+3)) ;
	
		iter.next() ;
		iter.next() ;
		iter.next() ;
		iter.next() ;
		col = col+4 ;
		}
		
		
	}
		/*Graphics2D g2D = (Graphics2D) g;
		System.out.println(" "+x1+" "+x2+" "+ctrlx+" "+ctrly) ;
		g.drawLine(x1,y1,ctrlx,ctrly) ;*/
		 
	}
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
		for(j=9;j<11;j++){
			g.drawLine(180,90+j*25,boardWidth,90+j*25) ;
		}
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
	
	public void mousePressed( MouseEvent evt ){
		
		wires.add(new ArrayList<Integer>());

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
		}
			
	}
	public void mouseReleased(MouseEvent evt) {
   		
   		try{						        // Called whenever the user releases the mouse button.
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
		
		catch(Exception e){}   
	}
	public void mouseDragged( MouseEvent evt ){
	
		if(dragging == false)
			return ;
			
		x = evt.getX() ;
		y = evt.getY() ;
		//wires.get(i).add(x) ;
		//wires.get(i).add(y) ;
		repaint() ;
		//System.out.println(" "+x+" "+y) ;
		
		
		prevX = x ;
		prevY = y ;
		
	}
	
	
	public void mouseEntered(MouseEvent evt) { }   // Some empty routines.
  	public void mouseExited(MouseEvent evt) { }    //    (Required by the MouseListener
   	public void mouseClicked(MouseEvent evt) { }   //    and MouseMotionListener
  	public void mouseMoved(MouseEvent evt) { } 
  	   //	
	
}


