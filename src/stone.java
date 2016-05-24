
public class stone {

	private int xcor;
	private int ycor;
	private boolean player;
	
	public stone(int row,int col,boolean player){
		this.player = player;
		xcor = (37*col)+18;
		ycor = (37*row)+18;
		System.out.println(xcor+" "+ycor);
	}
	
	public int getx(){
		return xcor;
	}
	
	public int gety(){
		return ycor;
	}
	
	public boolean getPlayer(){
		return player;
	}
	
	
	
}
