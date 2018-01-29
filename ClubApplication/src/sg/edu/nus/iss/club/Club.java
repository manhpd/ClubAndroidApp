package sg.edu.nus.iss.club;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Club {

    private static final int ARRAY_SIZE_INCREMENT = 10;

    private int    numMembers = 0;
    private int    count = 0;
    private ArrayList<Member> members = new ArrayList<>();
    private HashMap<String,Facility> facilities = new HashMap<>();

    public Facility getFacility (String name) {
    	return this.facilities.get(name);
    }
    
    public void addFacility (Facility facility) {
    	this.facilities.put(facility.getName(), facility);
    }
    
    public void removeFacility (String name) {
    	this.facilities.remove(name);
    }
    
    public void showFacilities () {
    	 Iterator it = this.facilities.entrySet().iterator();
    	    while (it.hasNext()) {
    	        Map.Entry pair = (Map.Entry)it.next();
    	        ((Facility) pair.getValue()).show();
    	        it.remove(); // avoids a ConcurrentModificationException
    	    }

    }
    public Member getMember (int memberNum) {
    	 for (int i = 0; i < this.members.size(); i++) {
             if(members.get(i).getMemberNumber() == memberNum) {
            	 return members.get(i);
             }
          }
        return null;
    }

    public ArrayList<Member> getMembers () {
   
        return this.members;
    }

    public Member addMember (String surname, String firstName,
                                             String secondName) {
//        ensureArraySize ();
        numMembers++;
        Member m = new Member (surname, firstName, secondName,
                                                   numMembers);
//        members[numMembers - 1] = m;
        members.add(m);
        count++;
        return m;
    }

    public void removeMember (int memberNum) {
    	members.remove(memberNum);
    	count--;
    }

    public void showMembers () {
        
        for (int i = 0; i < this.members.size(); i++) {
           members.get(i).show();
        }
    }

//    public void ensureArraySize () {
//        if (numMembers >= members.length) {
//            Member newMembers[];
//            int newSize = numMembers + ARRAY_SIZE_INCREMENT;
//            newMembers = new Member[newSize];
//            for (int i = 0; i < numMembers; i++) {
//                newMembers[i] = members[i];
//            }
//            members = newMembers;
//        }
//    }

	public int getNumMembers() {
		return numMembers;
	}

	public void setNumMembers(int numMembers) {
		this.numMembers = numMembers;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static int getArraySizeIncrement() {
		return ARRAY_SIZE_INCREMENT;
	}

	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}

	
    
    
}
