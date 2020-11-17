package cs350f20task3;

public class SegmentStraight extends A_Segment{
	

	//constructor
	public SegmentStraight(java.lang.String id, Coordinates tipCCoordinates, Coordinates tipDCoordinates){
		super(id, tipCCoordinates, tipDCoordinates);
	}
	
	 //The calculatePosition's helper method
	 private Coordinates getTip(boolean isTipCorD) {
			if(isTipCorD == true) {
				return this.tipCCoordinates;
			}else {
				return this.tipDCoordinates;
			}
		  }

		  // Calculates the coordinates on the segment or joined segment(s) as a distance from the starting tip.
		  public Coordinates calculatePosition(boolean isFromTipCorD, double distance) {
		    Coordinates eTip = getTip(isFromTipCorD);
		    Coordinates neTip   = getTip(!isFromTipCorD);

		    if(Math.abs(distance - this.getLength()) < 0.01 ){
		      return neTip;
		    }else if( distance < this.getLength()){
		      double x = eTip.getX();
		      double y = eTip.getY();
		      double bearing = eTip.calculateBearing(neTip);
		      double angle = 450 - bearing;
		      
		      if(angle >= 360){ 
		    	  angle -= 360; 
		      }
		      x += distance * Math.cos(Math.toRadians(angle));
		      y += distance * Math.sin(Math.toRadians(angle));
		      return new Coordinates(x, y);
		      
		      }else{
		    	Join e;
		      if(isFromTipCorD == true){
		    	  e = tipDJoin;
		      }else{
		    	  e = tipCJoin;
		      }
		      
		      A_Segment seg;
		      if (e == null || (seg = e.getTargetSegment()) == null) {
		        throw new RuntimeException("Does it compile before?");
		      }
		      return seg.calculatePosition(e.isTargetSegmentTipCorD(), distance - this.getLength());
		    }
		  }

	//getLength 
	public double getLength(){
		if(this.tipCCoordinates == null & this.tipDCoordinates == null) {
			throw new NullPointerException("This length is null");
		}
		return tipCCoordinates.calculateDistance(tipDCoordinates);
	}
	
}
