import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Profile {
	private int maxWordLength, minWordLength, meanWordLength;
	private int meanWordsPerSentence, meanCharactersPerSentence;
	private final int INITIAL = 1;
	
	private Profile(ArrayList<Document> docs) {
		String text = "";
		for(Document d : docs) {
			String s = d.getText();
			text += s;
		}
		setFields(text);
	}

	public boolean isInBounds(String[] words, int index) {
		if(index < 0 || index >= words.length) return false;
		return true;
	}

	// Return the n-dimensional distance between A and B
	// Smaller numbers are more similar.
	public static double similarity(Profile p1, Profile p2) { 
		
		System.out.println(p1 +  " " + p2);
		double maxWordDiff = (double)p1.getMaxWordLength() - p2.getMaxWordLength();
		double minWordDiff = (double)(p1.getMinWordLength()) - p2.getMinWordLength();
		double meanWordLengthDiff = (double)(p1.getMeanWordLength()) - p2.getMeanWordLength();
		double meanWordsSentDiff = (double)(p1.getMeanWordsPerSentence()) - p2.getMeanWordsPerSentence();
		double meanCharacterSentDiff = (double)(p1.getMeanCharactersPerSentence()) - p2.getMeanCharactersPerSentence();
		
		return Math.sqrt( (maxWordDiff*maxWordDiff ) + (minWordDiff*minWordDiff) + (meanWordLengthDiff*meanWordLengthDiff) +
				(meanWordsSentDiff*meanWordsSentDiff) + (meanCharacterSentDiff*meanCharacterSentDiff));
	}

	public void setFields(String text) {
		int totalNumCharacters = 0, numSentences = 0, numWords = 0;
		int minWordLength = Integer.MAX_VALUE, maxWordLength = Integer.MIN_VALUE;
		int totalWordLengths = 0;
		HashMap<String, Word> wordMap= new HashMap<String, Word>();
		
		String[] sentences = text.split("\\.");
		for(String sentence : sentences) {
			totalNumCharacters += sentence.length();
			String[] words = sentence.split(" ");
				
			for(String word: words) {
				if(word.length() < minWordLength) minWordLength = word.length();
	
				if(word.length() > maxWordLength) maxWordLength = word.length();
				totalWordLengths += word.length();
				
				if(!wordMap.containsKey(word)) {
					wordMap.put(word, new Word(word, INITIAL));
				} else {
					Word w = wordMap.get(word);
					wordMap.put(word, new Word(word,w.getFrequency() + 1));
				}
			}
			numWords += words.length;
			numSentences++;
		}
		
		ArrayList<Word> sortedWords = (ArrayList<Word>) wordMap.values();		// fix these parts
		Collections.sort(sortedWords);											// figure out problem
			
		if(numSentences != 0) {
			meanCharactersPerSentence = totalNumCharacters / numSentences;
			meanWordsPerSentence = numWords / numSentences;
		}
		this.minWordLength = minWordLength;
		this.maxWordLength = maxWordLength;
		if(numWords != 0) this.meanWordLength = totalWordLengths / numWords;
		
	}

	public static Profile createProfileFor(Document doc) {
		ArrayList<Document> docs = new ArrayList<Document>();
		docs.add(doc);
		return new Profile(docs);
	}
	
	public static Profile createProfileFor(ArrayList<Document> docs) {	
		return new Profile(docs);
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

	@Override
	public String toString() {
		return "Profile [maxWordLength=" + maxWordLength + ", minWordLength=" + minWordLength + ", meanWordLength="
				+ meanWordLength + ", meanWordsPerSentence=" + meanWordsPerSentence + ", meanCharactersPerSentence="
				+ meanCharactersPerSentence  + "]";
	}
	
	
}