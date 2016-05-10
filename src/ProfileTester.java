import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ProfileTester {
	public static void main(String[] args) {
		// list of all documents
		ArrayList<Document> docs = new ArrayList<Document>();

		// array of all the author names
		String[] names = {"matthew_wald", "jeff_bailey", "michelle_higgins", "micheline_maynard"};

		// docs is an ArrayList of all the documents from all four authors
		// in no particular order.
		docs = DataReader.readTrainingFiles("c:\\data\\authors\\");
		
		// --== Assignment #1 Code Here ==--
		// - Loop through docs to separate the documents by author.
		// - Create a profile for each of the four authors using the
		//   Profile.createProfileFor( .. ) method.
		// - Use each profile's toString() method to display the results.		
	}
}