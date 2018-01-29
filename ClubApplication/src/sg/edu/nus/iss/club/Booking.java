package sg.edu.nus.iss.club;

import java.util.Date;

public class Booking {
	private Member member;
	private Facility facility;
	
	private Date startDate;
	private Date endDate;
	
	
	
	public Booking(Member member, Facility facility, Date startDate, Date endDate) {
		super();
		this.member = member;
		this.facility = facility;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Facility getFacility() {
		return facility;
	}
	public void setFacility(Facility facility) {
		this.facility = facility;
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
	
	public boolean overlaps(Booking booking) {
		if ((this.getFacility().equals(booking.getFacility())) 
				&& (this.getEndDate().before(booking.getEndDate()))) {
			return true;
		}
		return false;
	}
	
}
