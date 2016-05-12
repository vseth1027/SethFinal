import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		ArrayList<Document> docs = new ArrayList<Document>();
		
		// read training data
		docs = DataReader.readTrainingFiles("c:\\data\\authors\\"); //change filepath
		
		// THIS CODE MAKES RANDOM GUESSES
		
		// array of all author names
		String[] names = {"matthew_wald", "jeff_bailey", "michelle_higgins", "micheline_maynard"};
		Random r = new Random();
		
		// Tester object
		Tester t = new Tester();
		
		// Get list of unknown test documents
		ArrayList<Document> testdocs = t.getTestDocuments("c:\\data\\authorstest\\");	//change filepath

		// HashMap for my answers
		HashMap<Integer, String> answers = new HashMap<Integer, String>();

		// Loop through document list.  Map each document id to a random author name
		for (Document d:testdocs) {
			answers.put(d.getId(), names[r.nextInt(4)]);	// make random guesses
		}
		
		// Check the solutions
		t.checkSolutions(answers, true);	
	}	
}