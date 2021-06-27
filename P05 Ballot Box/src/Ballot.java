import java.util.ArrayList;

public class Ballot {
	private static ArrayList<Party> parties = new ArrayList<Party>();
	private static int counter;
	private Candidate[] votes;
	private final int ID;
	
	
	public static void addParty(Party p) {
		if(parties.size() == 0) {
			parties.add(p);
		}
		boolean partyAlreadyExists = false;
		for(int i = 0; i < parties.size(); i++) {
			if(parties.get(i).equals(p)) {
				partyAlreadyExists = true;
			}
		}
		if(!partyAlreadyExists) {
			parties.add(p);	
		}
	}
	
	public static ArrayList<Candidate> getCandidates(String office){
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		try {
			for(int i = 0; i < parties.size(); i++) {
				if(parties.get(i).getCandidate(office).getOffice().equals(office)) {
					candidates.add(parties.get(i).getCandidate(office));
				}
			}
		} catch(Exception e) {
			System.out.println("Office has no candidates");
		}
		return candidates;
	}
	
	public Ballot() {
		
		votes = new Candidate[Candidate.OFFICE.length];
		
		ID =(int) (Math.random() * Math.random() * 10000);
	}
	
	public Candidate getVote(String office) {
		int arraySpot = 0;
		if(office.equals("President")) {
			arraySpot = 0;
		}
		if(office.equals("Vice President")) {
			arraySpot = 1;
		}
		if(office.equals("Secretary")) {
			arraySpot = 2;
		}
		return votes[arraySpot];
	}
	
	private int getID() {
		return ID;
	}
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Ballot)){
			return false;
		}
		if(ID == ((Ballot) o).getID()) {
			return true;
		}
		return false; //delete
	}
	
	public void vote(Candidate c) {
		
		if(c.getOffice().equals("President")){
			votes[0] = c;
		}
		if(c.getOffice().equals("Vice President")) {
			votes[1] = c;
		}
		if(c.getOffice().equals("Secretary")) {
			votes[2] = c;
		}
		
	}
}
