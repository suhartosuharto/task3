package cs350f20task3;

public abstract class A_Segment{
	private String id;
	protected Coordinates tipCCoordinates;
	protected Coordinates tipDCoordinates;
	protected Join tipCJoin;
	protected Join tipDJoin;
	
	
	//constructor
	public A_Segment(String id, Coordinates tipCCoordinates, Coordinates tipDCoordinates) {
		this.id = id;
		this.tipCCoordinates = tipCCoordinates;
		this.tipDCoordinates = tipDCoordinates;
	}
	
	//calculatePosition
	public abstract Coordinates calculatePosition(boolean isFromTipCord, double distance);
	
	//the GetID method
	public String getID() {
			return this.id;
	}
	
	//Getlength
	public abstract double getLength();
	
	//getTipCoordinates
	public Coordinates getTipCCoordinates(){
		return tipCCoordinates;
	}
	
	//getTipCJoin
	public Join getTipCJoin() {
		return tipCJoin;
	}
	
	//getTipDCoordinates
	public Coordinates getTipDCoordinates() {
		return tipDCoordinates;
	}
	
	//getTipDJoin
	public Join getTipDJoin() {
		return tipDJoin;
	}
	
	//joinTpC
	public void joinTipC(Join join) {
		if(this.tipCJoin != null) {
			throw new RuntimeException("Cannot join same tip more than once");
		}
		this.tipCJoin = join;
	}
	
	//joinTipD
	public void joinTipD(Join join) {
		if(this.tipDJoin != null) {
			throw new RuntimeException("Cannot join same tip more than once");
		}
		this.tipDJoin = join;
	}
	
	//toString = not required.
	/*public String toString() {
	}*/

}
