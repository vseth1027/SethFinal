import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ProfileTester {
	public static void main(String[] args) {
		// list of all documents
		ArrayList<Document> docs1 = new ArrayList<Document>();
		ArrayList<Document> docs2 = new ArrayList<Document>();
		ArrayList<Document> docs3 = new ArrayList<Document>();
		ArrayList<Document> docs4 = new ArrayList<Document>();

		// array of all the author names
		String[] names = {"matthew_wald", "jeff_bailey", "michelle_higgins", "micheline_maynard"};

		// docs is an ArrayList of all the documents from all four authors
		// in no particular order.
		docs1 = DataReader.readTrainingFiles("c:\\data\\authors\\");
		docs2 = DataReader.readTrainingFiles("c:\\data\\authors\\");
		docs3 = DataReader.readTrainingFiles("c:\\data\\authors\\");
		docs4 = DataReader.readTrainingFiles("c:\\data\\authors\\");
		// check to see whether Mr. Dobervich sent me the authors files
		
		// --== Assignment #1 Code Here ==--
		// - Loop through docs to separate the documents by author.
		for(Document d : docs1) {		// resulting list contains work of names[0]
			String a = d.getAuthor();
			if(!a.equals(names[0])) docs1.remove(d);
		}
		
		for(Document d : docs2) {		// resulting list contains work of names[1]
			String a = d.getAuthor();
			if(!a.equals(names[1])) docs2.remove(d);
		}
		
		for(Document d: docs3) {		// resulting list contains work of names[2]
			String a = d.getAuthor();
			if(!a.equals(names[2])) docs3.remove(d);
		}
		
		for(Document d: docs4) {		// resulting list contains work of names[3]
			String a = d.getAuthor();
			if(!a.equals(names[3])) docs4.remove(d);
		}
		// - Create a profile for each of the four authors using the
		//   Profile.createProfileFor( .. ) method.
		Profile waldProfile = Profile.createProfileFor(docs1);
		Profile baileyProfile = Profile.createProfileFor(docs2);
		Profile higginsProfile = Profile.createProfileFor(docs3);
		Profile maynardProfile = Profile.createProfileFor(docs4);
		
		// - Use each profile's toString() method to display the results.	
		waldProfile.toString();
		baileyProfile.toString();
		higginsProfile.toString();
		maynardProfile.toString();
	}
}