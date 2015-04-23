/*
 * Find Overlapping Date Intervals
 * --------------------------------
 * 
 * Ref : http://stackoverflow.com/questions/12573512/to-find-all-the-overlapping-date-ranges-from-a-given-list-of-date-ranges
 * 
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question114 {

	private boolean findOverlaps(DateInterval[] dateIntervals) {
		
		List<DateTuple> dateTuples = new ArrayList<DateTuple>();
		
		for(int i=0; i<dateIntervals.length; i++){
			DateTuple dtStart = new DateTuple(dateIntervals[i].getStartDate(), i+1, true);
			DateTuple dtEnd = new DateTuple(dateIntervals[i].getEndDate(), i+1, false);
			dateTuples.add(dtStart);
			dateTuples.add(dtEnd);
		}
		
		Collections.sort(dateTuples);
		
		Set<Integer> active = new HashSet<Integer>();
		boolean overlap = false;
		for(DateTuple dt : dateTuples){
			if(!dt.isStartDate){
				active.remove(dt.tupleId);
			}else{
				for(int activeDt : active){
					System.out.println(activeDt+"_"+dt.tupleId);
					overlap = true;
				}
				active.add(dt.getTupleId());
			}
		}
		
		return overlap;
	}

	public static void main(String[] args) throws ParseException {
		
		Question114 q = new Question114();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = formatter.parse("2010-12-31");
		Date d2 = formatter.parse("2011-03-31");
		Date d3 = formatter.parse("2011-04-02");
		Date d4 = formatter.parse("2011-12-31");
		Date d5 = formatter.parse("2011-06-12");
		Date d6 = formatter.parse("2012-03-31");
		Date d7 = formatter.parse("2012-03-31");
		Date d8 = formatter.parse("2012-09-30");
		Date d9 = formatter.parse("2012-06-30");
		Date d10 = formatter.parse("2013-01-01");
		
		DateInterval dint1 = new DateInterval(d1, d2);
		DateInterval dint2 = new DateInterval(d3, d4);
		DateInterval dint3 = new DateInterval(d5, d6);
		DateInterval dint4 = new DateInterval(d7, d8);
		DateInterval dint5 = new DateInterval(d9, d10);
		
		DateInterval[] dateIntervals = {dint1, dint2, dint3, dint4, dint5};
		
		boolean dateOverlap = q.findOverlaps(dateIntervals);
		if(dateOverlap){
			System.out.println("Date overlaps exist in the above date intervals.");
		}else{
			System.out.println("Zero date intervals.");
		}
	}

}

class DateTuple implements Comparable<DateTuple>{

	Date date;
	int tupleId;
	boolean isStartDate;
	
	public DateTuple(Date date, int tupleId, boolean isStartDate) {
		super();
		this.date = date;
		this.tupleId = tupleId;
		this.isStartDate = isStartDate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTupleId() {
		return tupleId;
	}

	public void setTupleId(int tupleId) {
		this.tupleId = tupleId;
	}

	public boolean isStartDate() {
		return isStartDate;
	}

	public void setStartDate(boolean isStartDate) {
		this.isStartDate = isStartDate;
	}

	@Override
	public int compareTo(DateTuple other) {
		
		int dateCmp = date.compareTo(other.date);
		
		if(dateCmp != 0){
			return dateCmp;
		}else{
			if(!isStartDate && other.isStartDate){
				return -1;
			}else if(isStartDate && !other.isStartDate){
				return 1;
			}else{
				return 0;
			}
		}
	}
	
}

class DateInterval{
	Date startDate;
	Date endDate;
	
	public DateInterval(Date startDate, Date endDate) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}

// Time complexity - O(nlogn)