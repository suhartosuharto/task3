package cs350f20task3;

public class Join{
	//constructor
	private A_Segment targetSegment;
	public boolean isTargetSegmentTipCorD;
	
	
	//constructor
	public Join(A_Segment targetSegment, boolean isTargetSegmentTipCorD) {
		this.targetSegment = targetSegment;
		this.isTargetSegmentTipCorD = isTargetSegmentTipCorD;
	}
	
	//getTargetSegment
	public A_Segment getTargetSegment() {
		return this.targetSegment;
	}
	
	//isTargetSegmentTipCorD
	public boolean isTargetSegmentTipCorD() {
		return this.isTargetSegmentTipCorD;
	}
	
	//this is not required
	/*public java.lang.String toString(){
		return null;
	}*/
}
