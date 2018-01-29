package sg.edu.nus.iss.club.test;

import static org.junit.Assert.*;

import org.junit.Test;

import sg.edu.nus.iss.club.Club;
import sg.edu.nus.iss.club.Facility;
import sg.edu.nus.iss.club.Member;

public class ClubTest {

	@Test
	public void test() {
		Club club = new Club ();
		Member removableMember;

        club.addMember ("Einstein", "Albert", null);
        club.addMember ("Picasso", "Pablo", "Ruiz");
        removableMember = club.addMember ("Webber","Andrew","Lloyd");
        club.addMember ("Baggio", "Roberto", null);
        club.addMember ("Raffles", "Stamford", null);

        System.out.println ("Current Members:");
        club.showMembers ();

        System.out.println ("Deleting " + removableMember);
        int id = removableMember.getMemberNumber ();
        club.removeMember (id);

        System.out.println ("Current members:");
        club.showMembers ();
        
        assertEquals(club.getCount(), 4);
        assertEquals(club.getMember(1).getFirstName(), "Albert");
        
        assertNull(club.getMember(4));
        
	}
	
	
	public void test2() {
		Club club = new Club ();
		Facility facility = new Facility("Study Room", "Room for group study.");

		club.addFacility(facility);
        assertEquals(club.getFacility("Study Room").getDescription(), "Room for group study.");
        
        club.removeFacility("Study Room");
        assertNull(club.getFacility("Study Room"));
 
        
	}

}
