package cs350f20task3;

import java.util.ArrayList;
import java.util.List;

public class TrackManager{
	
	private static List<A_Segment> segment = new ArrayList<A_Segment>();
	private boolean compileDone = false;
	//constructor
	public TrackManager(){
	}
	
	//add segment
	public void addSegments(A_Segment... segments) {
		if(segments.length == 0 || segments == null){ 
			return; 
		   }
	    if(compileDone){ 
	    	throw new RuntimeException("Cannot add segments after compile completed.");
	       }
		for(A_Segment segs: segments) {
			segment.add(segs);
		}
	}
	
	//Compiles the segments by joining their tips. This also validates the joins. [31]
	public void compile() {
	    if(this.compileDone) {
	        throw new RuntimeException("Compile cannot be run more than once.");
	      }
			for(A_Segment s1: segment){
				for(A_Segment s2: segment){
					if(s1 == s2) {
						continue;
					}
						combineJoin(s1, s2);
						}
						if (s1.getTipCJoin() == null || s1.getTipDJoin() == null) {
							throw new RuntimeException("Unconnected track segment with ID" + s1.getID());
						}
		    }
		    this.compileDone = true;
		   }
	
	//the compile method's helper
	private void combineJoin(A_Segment x, A_Segment y) {
	    Coordinates AC = x.getTipCCoordinates();
	    Coordinates AD = x.getTipDCoordinates();
	    Coordinates BC = y.getTipCCoordinates();
	    Coordinates BD = y.getTipDCoordinates();
	    
	    Join jc = null;
	    Join jd = null;

	    if (AC.isNear(BC)){
	    	jc = new Join(y, true);
	    }    
	    if (AC.isNear(BD)){
	    	jc = new Join(y, false); 
	    }
	    if (AD.isNear(BC)){ 
	    	jd = new Join(y, true);  
	    }
	    if (AD.isNear(BD)){ 
	    	jd = new Join(y, false); 
	    }

	    if(jc != null){ 
	      if (x.getTipCJoin() == null) {
	        x.joinTipC(jc);
	      }else{
	        throw new RuntimeException("More than two segments meet at " + AC.toString() );
	      }
	    }
	    
	    if(jd != null){ 
	      if(x.getTipDJoin() == null){
	        x.joinTipD(jd);
	      }else{
	        throw new RuntimeException("More than two segments meet at " + AD.toString() );
	      }
	    }
	  }
	
	//getSegments
	public java.util.List<A_Segment> getSegments(){
		return segment;
	}
  }


