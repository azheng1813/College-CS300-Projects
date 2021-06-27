import java.util.ArrayList;

public class BallotBox {
	private ArrayList<Ballot> ballots;
	
	public BallotBox() {
		ballots = new ArrayList<Ballot>();
	}
	
	public int getNumBallots() {
		return ballots.size();
	}
	
	public Candidate getWinner(String office) {
		//ballots.get(0);
		ArrayList<Candidate> officeCandidates = Ballot.getCandidates(office);
		if(officeCandidates.size() == 0) {
			return null;
		}
		int[] candVotes = new int[officeCandidates.size()];
		for(int i = 0; i < ballots.size(); i++) {
			Candidate vote = ballots.get(i).getVote(office);
			for(int x = 0; x < officeCandidates.size(); x++) {
				if(officeCandidates.get(x).equals(vote)) {
					candVotes[x]++;
					break;
				}
			}
		}
		
		int mostVotesEle = 0;
		int mostVotes = 0;
		for(int i = 0; i < candVotes.length; i++) {
			if(candVotes[i] > mostVotes) {
				mostVotes = candVotes[i];
				mostVotesEle = i;
			}
		}
		if(mostVotes == 0) {
			return null;
		}
		
		
		return officeCandidates.get(mostVotesEle);
		
		//set up variable for num of candidates for office, create array with size, count for people in that 
	}
	
	public void submit(Ballot b) {
		boolean ballotExists = false;
		for(int i = 0; i < ballots.size(); i++) {
			if(b.equals(ballots.get(i))) {
				ballotExists = true;
			}
		}
		if(!ballotExists) {
			ballots.add(b);
		}
	}
}
