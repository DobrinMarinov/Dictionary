package controller;

import java.util.*;

import model.Dictionary;
import model.WordEntity;

public class UserInputController {
	
	private Scanner scanner = new Scanner(System.in);
	private Dictionary dictionary = new Dictionary();
	
	private enum MenuOption {
		ADD_NEW_WORD,
		DELETE,
		SEARCH,
		LIST,
		EXIT,
		INVALID
	}
	
	public void start() {
		
		boolean shouldExit = false;
		do {
			MenuOption selectedOption = showMenu();
			switch(selectedOption) {
			case ADD_NEW_WORD:
				addNewWord();
				break;
			case DELETE:
				deleteWord();
				break;
			case SEARCH:
				search();
				break;
			case LIST:
				listAllWords();
				break;			
			case EXIT:
				shouldExit = true;
				break;
			case INVALID:
				System.out.println("This option is not valid");
				break;
			}
			
		} while(!shouldExit);
		
	}
	
	private MenuOption showMenu() {
		System.out.println("MENU");
		System.out.println("----");
		
		System.out.println("1. Add new word");
		System.out.println("2. Delete word");
		System.out.println("3. Search");
		System.out.println("4. List all words");
		System.out.println("5. Exit");
		
		System.out.print("Enter option: ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		switch(choice) {
			case 1: return MenuOption.ADD_NEW_WORD;
			case 2: return MenuOption.DELETE;
			case 3: return MenuOption.SEARCH;
			case 4: return MenuOption.LIST;
			case 5: return MenuOption.EXIT;
			default: return MenuOption.INVALID;
		}		
	}
	
	private void addNewWord() {
		System.out.print("Enter (word = translation = transcription): ");
		String line = scanner.nextLine();
		String[] tokens = line.split("=");
		if(tokens.length == 3) {
			String word = tokens[0].trim();
			String translation = tokens[1].trim();
			String transcription = tokens[2].trim();
			
			WordEntity wordEntity = new WordEntity(word, translation, transcription);
			dictionary.addWord(wordEntity);
			
		} else {
			System.out.println("Wrong input");
		}
	}
	
	private void deleteWord() {
		System.out.print("Enter word: ");
		String word = scanner.nextLine();
		
		dictionary.deleteWord(word);
	}
	
	private void search() {
		System.out.print("Enter word: ");
		String word = scanner.nextLine();
		WordEntity wordEntity = dictionary.search(word);
		if(wordEntity != null) {
			System.out.println("Translation is: " + wordEntity.getTranslation());
			System.out.println("Transcription is: " + wordEntity.getTranscription());
		} else {
			System.out.println("No such word exists");
		}
	}
	
	private void listAllWords() {
		List<WordEntity> wordEntities = dictionary.getSortedWordEntities();
		
		for(WordEntity wordEntity : wordEntities) {
			System.out.println(wordEntity.getWord() + " - " + wordEntity.getTranslation() + " - " + wordEntity.getTranscription());
		}
	}
}
