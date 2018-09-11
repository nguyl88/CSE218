import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NovelReader {
	private File file = new File("warAndPeace");
	private String wholeTextInput;
	private char[] vowels = {'a','e','i','o','u','y','A','E','I','O','U'};
	
	public NovelReader() {
		openNovel();
	}
	
	public void openNovel() {
		String line = " ";
			try {
				FileReader reader = new FileReader(file);
				BufferedReader in = new BufferedReader(reader);
				line = in.readLine();
				StringBuilder sb = new StringBuilder();
				
				while(line!=null) {
					sb.append(line);
					sb.append("\n");
					line = in.readLine();
				}
				wholeTextInput = sb.toString();
				
				in.close();
			} catch (IOException ex) {
				System.out.println("IOException occured");
				
			}
	}
	
		public int countSentences(){
			int counter = 0;
			
			String pat = "[.!?]+";
			Pattern pattern = Pattern.compile(pat);
			LinkedListTokens tokens = new LinkedListTokens();
			String[] tokenSplit = wholeTextInput.split(pat);
			Matcher match = pattern.matcher(wholeTextInput);
			
			while(match.find()) {
			counter++;
			} 
			//Storing words into the linked list
			for(int i = 0; i < tokenSplit.length; i++) {
				tokens.insertLast(tokenSplit[i]);
			}

			
			return counter;
		}
		
		public int countWords() {
			LinkedListTokens tokens = new LinkedListTokens();
			Pattern findWord = Pattern.compile("\\w+");
			Matcher findAllWords = findWord.matcher(wholeTextInput);
			
			int count = 0;
			while (findAllWords.find()) {
				count++;
				if (findAllWords.hitEnd()) {
					break;
				}
			}
			String[] words = wholeTextInput.split("\\s+");
			//Storing words into the linked list
			for(int i = 0; i < words.length; i++) {
				tokens.insertLast(words[i]);
				}
			
			return count;
		}
		
		public boolean isVowel(char temp) {
			for (int i = 0; i < vowels.length; i++) {
			if(temp == vowels[i]) {
				return true;
				}
			}
			return false;
		}
		
		/* Does not need linked list*/
		public int countSyllablesInWord(String word) {
			int counter = 0;
			char temp;
	
			for(int i = 0; i < word.length(); i++) {
				temp = word.charAt(i);
				if(temp =='e' && i == word.length()-1) {
					continue;
				}
				else if(isVowel(temp)) {
					counter += 1;
				}
			}
			return counter;
		}
		
		public int countSyllables() {
			int counter = 0;
			String allText;
			LinkedListTokens token = new LinkedListTokens();
			//Storing words into the linked list
			if (token.isEmpty()) {
				allText = token.insertFirst(wholeTextInput);
				counter = countSyllablesInWord(allText);
			} 
			return counter;
			
		}
		
		public double computeIndex() {
			int sentences = countSentences();
			int syllables = countSyllables();
			int words = countWords();
			
			double index = 205.835 - (84.6 * ((double)syllables/(double)words)) - 
					(1.015 * ((double)words / (double)sentences));
			return index;
		}
		
		
		public void display() {
			System.out.println("The number of sentences in War and Peace is " + countSentences() + "\n" +
							"The number of syllables is " + countSyllables() + "\n" +
							"The number of words are  " + countWords() + "\n" +
							"The Flesh Readability Score is " + computeIndex() + "\n" +
							"The Grade Level of the Novel is " + getFleshIndex());
		}
		
		public String getFleshIndex() {
			
		String gradeLevel =" ";
		 if (computeIndex() > 100) {
		      gradeLevel = "5th grader";
		    } else if (computeIndex() >= 90) {
		      gradeLevel = "6th grader";
		    } else if (computeIndex() >= 80) {
		      gradeLevel = "7th grader";
		    } else if (computeIndex() >= 70) {
		      gradeLevel = "8th grader";
		    } else if (computeIndex() >= 60) {
		      gradeLevel = "9th grader";
		    } else if (computeIndex() >= 50) {
		      gradeLevel = "High School";
		    } else if (computeIndex() >= 30) {
		      gradeLevel = "College";
		    } else if (computeIndex() > 0) {
		      gradeLevel = "Law School";
		    }
			return gradeLevel;

			
		}
		
}
