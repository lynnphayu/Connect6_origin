
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BoardUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Image bgimage;
	private List<stone> placedStones = new ArrayList<stone>();
	public boolean isStarted=false;
	
	public BoardUI(){
		URL bgimageurl = getClass().getResource("/img/bgimage.png");
		bgimage = new ImageIcon(bgimageurl).getImage();
		
	}
	
	@Override
	protected void paintComponent(Graphics g){
		
		g.drawImage(bgimage, 0, 0, null);
        g.setColor(Color.white); 
		
        for (int i=1; i<19; i++) {
			int gridpos = ((703/19)*i)+15;
	        g.drawLine(gridpos,15,gridpos,718);    
	        g.drawLine(15,gridpos,718,gridpos);
		}
		
		for(stone s : this.placedStones){
			if(s.getPlayer()==false)
				g.setColor(Color.black);
			else
				g.setColor(Color.white);
				g.fillOval(s.getx(), s.gety(), 32, 32);
		}
		
	}
	
	public void placingStone(int col, int row,boolean player){
		if(isStarted){	
			placedStones.add(new stone(row,col,player));	
			this.repaint();
		}
	}
	
	public void start(String color){
		isStarted=true;
		
	}
}
