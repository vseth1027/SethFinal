import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
	private static final int WALD = 0, BAILEY = 1, HIGGINS = 2, MAYNARD = 3;
	
	public static void main(String[] args) {
		ArrayList<Document> docs = new ArrayList<Document>();
		
		// read training data
		docs = DataReader.readTrainingFiles("D:\\JavaVidushi\\SethFinal\\authors"); 
		
		// THIS CODE MAKES RANDOM GUESSES
		
		// array of all author names
		String[] names = {"matthew_wald", "jeff_bailey", "michelle_higgins", "micheline_maynard"};
		Random r = new Random();
		
		// Tester object
		Tester t = new Tester();
		
		// Get list of unknown test documents
		ArrayList<Document> testdocs = t.getTestDocuments("D:\\JavaVidushi\\SethFinal\\authorstest");

		// HashMap for my answers
		HashMap<Integer, String> answers = new HashMap<Integer, String>();
		
		Profile waldProfile = ProfileGenerator.getWaldProfile();
		Profile baileyProfile = ProfileGenerator.getBaileyProfile();
		Profile higginsProfile = ProfileGenerator.getHigginsProfile();
		Profile maynardProfile = ProfileGenerator.getMaynardProfile();
		

		// Loop through document list.  Map each document id to a random author name
		for (Document d:testdocs) {
			Profile temp = Profile.createProfileFor(d);
			double sim1 = Profile.similarity(temp, waldProfile);
			double sim2 = Profile.similarity(temp, baileyProfile);
			double sim3 = Profile.similarity(temp, higginsProfile);
			double sim4 = Profile.similarity(temp, maynardProfile);
			double least = findLeast(sim1, sim2, sim3, sim4);
			
			if(least == sim1) answers.put(d.getId(), names[WALD]);
			answers.put(d.getId(), names[r.nextInt(4)]);	// make random guesses
		}
		
		// Check the solutions
		t.checkSolutions(answers, true);	
	}

	private static double findLeast(double sim1, double sim2, double sim3, double sim4) {
		double a = Math.min(sim1, sim2);
		double b = Math.min(sim3, sim4);
		return Math.min(a, b);
	}	
}