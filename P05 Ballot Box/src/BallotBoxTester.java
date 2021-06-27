
public class BallotBoxTester {
	public static boolean testCandidate() {
		Candidate a = new Candidate("John Smith", "President");
		Candidate b = new Candidate("John Doe", "Vice President");
		
		if(a.getName().equals(b.getName())) {
			return false;
		}
		
		if(a.getOffice().equals(b.getOffice())) {
			return false;
		}
		
		if(a.getName() != "John Smith") {
			return false;
		}
		
		if(b.getName() != "John Doe") {
			return false;
		}
		
		if(a.getOffice() != "President") {
			return false;
		}
		
		if(b.getOffice() != "Vice President") {
			return false;
		}
		
		if(a.toString().equals(a.getName() + " (" + a.getOffice() + ")")) {
			
		}
		else {
			return false;
		}
		
		
		if(b.toString().equals(b.getName() + " (" + b.getOffice() + ")")) {
			
		}
		else {
			return false;
		}
		
		return true;
	}
	
	public static boolean testPartyConstructor() {
		
		Party a = new Party("Lions");
		//test getName()
		if(a.getName() != "Lions") {
			return false;
		}
		//test getSize()
		if(a.getSize() != 0) {
			return false;
		}
		
		
		
		
		return true;
	}
	
	public static boolean testPartyGetCandidate() {
		Party a = new Party("Lions");
		boolean addTest = false;
		Candidate candA = new Candidate("John Smith", "President");
		Candidate candB = new Candidate("John Doe", "Vice President");
		Candidate candC = new Candidate("Jane Doe", "President");
		
		//test addCandidate method
		try {
			a.addCandidate(candA);
			a.addCandidate(candB);
			a.addCandidate(candC);
		} catch (Exception e) {
			addTest = true; //throws exception when 2 people running for same office
		}
		if(!addTest) {
			return false;
		} 
		
		if(a.getCandidate("President") != candA) {
			return false;
		}
		
		return true;
	}

	public static boolean testBallotGetCandidates() {
		Candidate cand1 = new Candidate("John Smith", "President");
		Candidate cand2 = new Candidate("John Doe", "President");
		Party a = new Party("Lions");
		Party b = new Party("Tigers");
		a.addCandidate(cand1);
		b.addCandidate(cand2);
		Ballot.addParty(a);
		Ballot.addParty(b);
		Ballot vote1 = new Ballot();
		Ballot vote2 = new Ballot();
		Ballot vote3 = new Ballot();
		vote1.vote(cand1);
		vote2.vote(cand2);
		vote3.vote(cand2);
		
		if(Ballot.getCandidates("Tresurer").size() != 0) {
			return false;
		}

		if(Ballot.getCandidates("President").size() != 2) {
			return false;
		}
		return true;
	}
	
	public static boolean testBallotGetVote() {
		Candidate cand1 = new Candidate("John Smith", "President");
		Party a = new Party("Lions");
		a.addCandidate(cand1);
		Ballot.addParty(a);
		Ballot vote1 = new Ballot();
		vote1.vote(cand1);
		
		if(!vote1.getVote("President").equals(cand1)) {
			return false;
		}
		
		return true;
	}
	
	public static boolean testBallotBox() {
		Candidate cand1 = new Candidate("John Smith", "President");
		Candidate cand2 = new Candidate("John Doe", "President");
		
		Party a = new Party("Lions");
		Party b = new Party("Tigers");
		
		a.addCandidate(cand1);
		b.addCandidate(cand2);
		
		Ballot.addParty(a);
		
		Ballot vote1 = new Ballot();
		Ballot vote2 = new Ballot();
		Ballot vote3 = new Ballot();
		
		BallotBox Ballots = new BallotBox();
		
		vote1.vote(cand1);
		vote2.vote(cand2);
		vote3.vote(cand2);
		
		
		//1st scenario
		Ballots.submit(vote1);
		
		if(!Ballots.getWinner("President").equals(cand1)) {
			return false;
		}
		
		
		//2nd scenario
		Ballot.addParty(b);
		Ballots.submit(vote2);
		
		if(!Ballots.getWinner("President").equals(cand1)) {
			return false;
		}
		
		
		//3rd scenario
		Ballots.submit(vote3);
		
		if(!Ballots.getWinner("President").equals(cand2)) {
			return false;
		}
		
		if(Ballots.getNumBallots() != 3) {
			return false;
		}
		
		return true;
	}

	
	public static void main(String args[]) {
		System.out.println(testCandidate());
		System.out.println(testPartyConstructor());
		System.out.println(testPartyGetCandidate());
		System.out.println(testBallotGetCandidates());
		System.out.println(testBallotGetVote());
		System.out.println(testBallotBox());
	
	}
	
}
