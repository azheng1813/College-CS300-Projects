import java.lang.IllegalArgumentException;

public class Candidate {
	protected static final String[] OFFICE = new String[] {"President", "Vice President", "Secretary"};
	private String name;
	private String office;
	
	public Candidate(String name, String office) {
		this.name = name;
		this.office = office;
		boolean officeExists = false;
		for(int i = 0; i < OFFICE.length; i++) {
			if(OFFICE[i] == office) {
				officeExists = true;
			}
		}
		if(!officeExists) {
			throw new IllegalArgumentException("Office doesn't exist");
		}
		//need to throw IllegalArgumentException if office isn't found
	}

	
	public String getName() {
		return name;
	}
	
	public String getOffice() {
		return office;
	}
	
	@Override
	public String toString() {
		return name + " (" + office + ")";
	}
}	
