import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class DataReader {
	
	public static ArrayList<Document> readTrainingFiles(String rootdir) {
		
		if (!rootdir.endsWith("\\"))
			rootdir = rootdir + "\\";

		ArrayList<Document> docs = new ArrayList<Document>();
		String[] authors = { "jeff_bailey", "matthew_wald", "michelle_higgins",
				"micheline_maynard" };
		String filepath;
		int counter = 1;
		
		for (String author : authors) {
			counter = 1;
			filepath = rootdir + author + "\\" + author + "_" + counter
					+ ".txt";
			Document doc = createDocumentFromFile(author, filepath);
			while (doc != null) {
				doc = createDocumentFromFile(author, filepath);
				docs.add(doc);
				counter++;
				filepath = rootdir + author + "\\" + author + "_" + counter
				+ ".txt";
				doc = createDocumentFromFile(author, filepath);
			}
		}
		
		return docs;
	}

	private static Document createDocumentFromFile(String author,
			String filepath) {
		
		ArrayList<Document> docs = new ArrayList<Document>();
		Scanner scanner;
		StringBuilder sb = new StringBuilder(500000);

		try {
			scanner = new Scanner(new FileReader(filepath));
			scanner.useDelimiter("\n");

			while (scanner.hasNext()) {
				sb.append(scanner.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + filepath);
			return null;
		}
		return new Document(sb.toString(), author);
	}
}