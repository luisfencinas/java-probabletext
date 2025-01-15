package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//
//Because this is a class we need to build all the way, I decided to write comments throughout to show my 
//understanding and thought process during probable text.
// @author Luis Fernando Encinas
//
public class ProbableText {
	// Using strings to key our ArrayList Chars
	private OurHashMap<String, ArrayList<Character>> ngramMap;
	private StringBuilder book;

	// Have it take in nGramLength, wanted Text length and file name to use in Main
	public ProbableText(int ngramLength, int textLength, String file) throws FileNotFoundException {
		this.ngramMap = new OurHashMap<>();
		this.book = new StringBuilder();
		// Call methods in this list
		// Read Scanning entire book and adding to string
		read(file);
		// Building Map
		buildMap(ngramLength);
		// Generate our random Sentences to print until reaching text length
		generate(ngramLength, textLength);
	}

	private void read(String file) throws FileNotFoundException {
		// Wanted to ensure exception thrown if file not found!
		Scanner scanner = new Scanner(new File(file));
		// While file still has new lines, keep adding! :)
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			book.append(line).append(" ");
		}

		//
		scanner.close();
	}

	private void buildMap(int ngramLength) {
		// Goes ngram length at time, adding to either new key or existing.
		for (int i = 0; i <= book.length() - ngramLength; i++) {
			String ngram = book.substring(i, i + ngramLength);
			// just place holder char, to be changed or remain in space
			char nextChar = ' ';
			if (i + ngramLength < book.length()) {
				nextChar = book.charAt(i + ngramLength);
			}

			if (!ngramMap.containsKey(ngram)) {
				ngramMap.put(ngram, new ArrayList<>());
			}
			// Adds our char to either found key or added key
			ArrayList<Character> found = ngramMap.get(ngram);
			found.add(nextChar);
		}
	}

	private void generate(int ngramLength, int textLength) {
		// Randomizes our start point
		Random random = new Random();
		// Did minus ngramLength to avoid the back
		int startIndex = random.nextInt(book.length() - ngramLength);
		// finds our current randomed ngram
		String currentNgram = book.substring(startIndex, startIndex + ngramLength);
		// Constructs StringBuilder with currentNgram in mind.
		StringBuilder genText = new StringBuilder(currentNgram);
		// Continues for every character needed until reaching text wanted
		int currSentence = 1;
		for (int i = ngramLength; i < textLength; i++) {
			ArrayList<Character> found = ngramMap.get(currentNgram);
			// get random char in found ngram value list
			char nextChar = found.get(random.nextInt(found.size()));
			genText.append(nextChar);
			// changes n gram to add next char for ngram
			currentNgram = currentNgram.substring(1) + nextChar;
			// Tries to cut off at last white space to avoid cutting off words
			// Has 60 letters in mind before cutting off.
			if (i >= 60 * currSentence && nextChar == ' ') {
				genText.append("\n");
				currSentence++;
			}
		}

		System.out.println(genText.toString());
	}
}
