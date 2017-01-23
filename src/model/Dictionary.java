package model;

import java.util.*;

public class Dictionary {

	private Map<String, WordEntity> wordEntities = new HashMap<>();
	
	public void addWord(WordEntity wordEntity) {
		wordEntities.put(wordEntity.getWord(), wordEntity);
	}
	
	public void deleteWord(String word) {
		wordEntities.remove(word);
	}
	
	public WordEntity search(String word) {
		return wordEntities.get(word);
	}
	
	public List<WordEntity> getSortedWordEntities() {
		List<WordEntity> wordEntitiesCopy = new ArrayList<>(wordEntities.values());
		Collections.sort(wordEntitiesCopy, new Comparator<WordEntity>() {

			@Override
			public int compare(WordEntity o1, WordEntity o2) {				
				return o1.getWord().compareTo(o2.getWord());
			}
		});
		
		return wordEntitiesCopy;
	}
	
}
