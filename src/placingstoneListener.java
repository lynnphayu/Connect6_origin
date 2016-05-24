import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class placingstoneListener implements MouseListener {
	
	private BoardUI ui;
	
	
	public placingstoneListener(BoardUI boardPanel){
		ui = boardPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if( e.getX() >= 15 && e.getX() <= 718 && e.getY() >= 15 && e.getY() <= 718 )
		ui.placingStone((e.getX()-15)/37,(e.getY()-40)/37,false);
		System.out.println(e.getX()+" "+e.getY());
		System.out.println((e.getX()-15)/37+" "+(e.getY()-15)/37);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
