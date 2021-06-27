import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;

public class Party {
	private String name;
	private ArrayList<Candidate> candidates = new ArrayList<Candidate>();
	
	public Party(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSize() {
		return candidates.size();
	}
	
	public Candidate getCandidate(String office) {
		boolean candidateFound = false;
		int i;
		for(i = 0; i < candidates.size(); i++) {
			if (office.equals(candidates.get(i).getOffice())) {
				candidateFound = true;
				break;
			}
		}
		if(!candidateFound) {
			throw new NoSuchElementException("Candidate doesn't exist");
		}
		
		return candidates.get(i);
	}
	
	public void addCandidate(Candidate c) {
		
		for(int i = 0; i < candidates.size(); i++) {
			if(c.getOffice().equals(candidates.get(i).getOffice())) {
				throw new IllegalArgumentException("Another party member is running for this office");
			}
		}
		candidates.add(c);
	}
}
