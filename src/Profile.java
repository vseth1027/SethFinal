import java.util.ArrayList;
import java.util.HashMap;

public class Profile {
	private int maxWordLength, minWordLength, meanWordLength;
	private int meanWordsPerSentence, meanCharactersPerSentence;
	private int meanNumUniqueWords;		 //mean number of unique words per 100 words
	private static final int INITIAL = 1;
	
	private Profile(ArrayList<Document> docs) {
		this.maxWordLength = findMaxWordLength(docs);
		this.minWordLength = findMinWordLength(docs);
		this.meanWordLength = findMeanWordLength(docs);
		findMeanCharactersandWordsPerSentence(docs);
		this.meanNumUniqueWords = findMeanNumUniqueWords(docs);
	}
	
	public int findMeanNumUniqueWords(ArrayList<Document> docs) {	
		
		int totalNumUniqueWords = 0, count = 0;
		
		for(Document d : docs) {
			String s = d.getText();
			String[] words = s.split(" ");
			for(int i = 0; i < words.length; i+= 100) {
				int uniqueWords = 0;
				for( int j = i; j < j + 100; j++) {
					if(isInBounds(words, j)) {
						System.err.println("running findMeanNumUniqueWords");
						String word = words[j];
						HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
						if(!wordMap.containsKey(word)) {
							wordMap.put(word, INITIAL);
							uniqueWords++;
						}
					}
				}
				totalNumUniqueWords += uniqueWords;
				count++;
			}
		}
		if(count == 0) return 0;
		return totalNumUniqueWords / count;
	}

	public boolean isInBounds(String[] words, int index) {
		if(index < 0 || index >= words.length) return false;
		return true;
	}

	public void findMeanCharactersandWordsPerSentence(ArrayList<Document> docs) {
		int totalNumCharacters = 0, numSentences = 0, numWords = 0;
		
		for(Document d: docs) {
			String s = d.getText();
			String[] sentences = s.split(".");
			for(String sentence : sentences) {
				totalNumCharacters += sentence.length();
				String[] words = sentence.split(" ");
				numWords += words.length;
				numSentences++;
			}
		}
		if(numSentences != 0) {
			meanCharactersPerSentence = totalNumCharacters / numSentences;
			meanWordsPerSentence = numWords / numSentences;
		}
		
	}

	public int findMeanWordLength(ArrayList<Document> docs) {
		int totalWordLengths = 0, numWords = 0;
		
		for(Document d: docs) {
			String s = d.getText();
			String[] words = s.split(" ");
			for(String word: words) {
				totalWordLengths += word.length();
				numWords++;
			}
		}
		if(numWords == 0) return 0;
		return totalWordLengths / numWords;
	}

	public int findMinWordLength(ArrayList<Document> docs) {
		int minWordLength = Integer.MAX_VALUE;
		
		for(Document d: docs) {
			String s = d.getText();
			String[] words = s.split(" ");
			for(String word: words) {
				if(word.length() < minWordLength) minWordLength = word.length();
			}
		}
		return minWordLength;
	}

	public int findMaxWordLength(ArrayList<Document> docs) {
		int maxWordLength = Integer.MIN_VALUE;
		
		for(Document d: docs) {
			String s = d.getText();
			String[] words = s.split(" ");
			for(String word: words) {
				if(word.length() > maxWordLength) maxWordLength = word.length();
			}
		}
		return maxWordLength;
	}

	public static Profile createProfileFor(Document doc) {
		/* modify this */
		return null;
	}
	
	public static Profile createProfileFor(ArrayList<Document> docs) {	
		return new Profile(docs);
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

	@Override
	public String toString() {
		return "Profile [maxWordLength=" + maxWordLength + ", minWordLength=" + minWordLength + ", meanWordLength="
				+ meanWordLength + ", meanWordsPerSentence=" + meanWordsPerSentence + ", meanCharactersPerSentence="
				+ meanCharactersPerSentence + ", meanNumUniqueWords=" + meanNumUniqueWords + "]";
	}
	
	
}