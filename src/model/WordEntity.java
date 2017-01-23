package model;

public class WordEntity {

	private String word;
	private String translation;
	private String transcription;
	
	public WordEntity(String word, String translation, String transcription) {
		this.word = word;
		this.translation = translation;
		this.transcription = transcription;
	}
	
	public String getWord() {
		return word;
	}
	
	public String getTranslation() {
		return translation;
	}
	
	public String getTranscription() {
		return transcription;
	}
	
}
