import java.util.ArrayList;

public class Profile {
	private int maxWordLength, minWordLength, meanWordLength;
	private int meanWordsPerSentence, meanCharactersPerSentence;
	private int meanNumUniqueWords;		 //mean number of unique words per 100 words
	
	private Profile( /* modify this */ ) {
		/* modify this as you see fit */
	}
	
	public static Profile createProfileFor(Document doc) {
		/* modify this */
		return null;
	}
	
	public static Profile createProfileFor(ArrayList<Document> docs) {
		/* modify this */
		return null;
	}
	
	// Return the n-dimensional distance between A and B
	// Smaller numbers are more similar.
	public static double similarity(Profile A, Profile B) {
		return 0;
	}

	public int getMaxWordLength() {
		return maxWordLength;
	}

	public int getMinWordLength() {
		return minWordLength;
	}

	public int getMeanWordLength() {
		return meanWordLength;
	}

	public int getMeanWordsPerSentence() {
		return meanWordsPerSentence;
	}

	public int getMeanCharactersPerSentence() {
		return meanCharactersPerSentence;
	}

	public int getMeanNumUniqueWords() {
		return meanNumUniqueWords;
	}
}