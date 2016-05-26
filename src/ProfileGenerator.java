import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ProfileGenerator {
	static Profile waldProfile, baileyProfile, higginsProfile, maynardProfile;
	
	public static void generateProfiles() {
	
		// list of all documents
		ArrayList<Document> docs = new ArrayList<Document>();
		
		ArrayList<Document> docs1 = new ArrayList<Document>(); //stores work of names[0]
		ArrayList<Document> docs2 = new ArrayList<Document>(); //stores work of names[1]
		ArrayList<Document> docs3 = new ArrayList<Document>(); //stores work of names[2]
		ArrayList<Document> docs4 = new ArrayList<Document>(); //stores work of names[3]

		// array of all the author names
		String[] names = {"matthew_wald", "jeff_bailey", "michelle_higgins", "micheline_maynard"};

		// docs is an ArrayList of all the documents from all four authors
		// in no particular order.
		docs = DataReader.readTrainingFiles("assets/authors");
		
		
		// - Loop through docs to separate the documents by author.
		for(Document d : docs) {		
			String a = d.getAuthor();
			if(a.equals(names[0]))	docs1.add(d);
			if(a.equals(names[1])) 	docs2.add(d);
			if(a.equals(names[2]))	docs3.add(d);
			if(a.equals(names[3]))	docs4.add(d);
		}
		

		// - Create a profile for each of the four authors
		waldProfile = Profile.createProfileFor(docs1);
		baileyProfile = Profile.createProfileFor(docs2);
		higginsProfile = Profile.createProfileFor(docs3);
		maynardProfile = Profile.createProfileFor(docs4);
		
		//display the results.	
		System.out.println( waldProfile );
		System.out.println( baileyProfile );
		System.out.println( higginsProfile );
		System.out.println( maynardProfile );
	}
	
	public static Profile getWaldProfile() {
		return waldProfile;
	}
	
	public static Profile getBaileyProfile() {
		return baileyProfile;
	}
	
	public static Profile getHigginsProfile() {
		return higginsProfile;
	}
	
	public static Profile getMaynardProfile() {
		return maynardProfile;
	}
}