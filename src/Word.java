
public class Word implements Comparable<Word> {

	String text;
	Integer frequency;
	
	public Word(String s, Integer num) {
		text = s;
		frequency = num;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	@Override
	public int hashCode() {		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((frequency == null) ? 0 : frequency.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (frequency == null) {
			if (other.frequency != null)
				return false;
		} else if (!frequency.equals(other.frequency))
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public int compareTo(Word arg0) {
		if(this.frequency < arg0.getFrequency()) return -1;
		if(this.frequency > arg0.getFrequency()) return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "Word [text=" + text + "]";
	}
	
	
}
