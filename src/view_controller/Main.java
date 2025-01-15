package view_controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

import model.ProbableText;

//@author Luis F Encinas
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// Obtain a file name and number of probable characters to print from the users
		// to do
		// whatever you have to do to have the book be input to print the number of
		// characters.
		// You also need the length of the ngram, The dialog should look something like
		// this:
		//
		// Enter book name: Alice
		// How many letters? 120
		// Enter ngram length 8
		//
		// came rattling in at the Queen's ears--" the Rabbit say,
		// "A barrowful will do, to begin. Alice gave a sudden
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter book name: ");
		String bookName = scanner.nextLine();

		System.out.print("Enter ngram length: ");
		int ngramLength = scanner.nextInt();

		System.out.print("How many letters? ");
		int textLength = scanner.nextInt();

		String filePath = "books/" + bookName; // Assuming the book file is named after the bookName

		ProbableText probableText = new ProbableText(ngramLength, textLength, filePath);

		scanner.close();
	}
}