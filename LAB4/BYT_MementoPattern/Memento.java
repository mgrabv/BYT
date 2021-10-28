// Memento Design Pattern
// Used to store an objects state at a point in time.

public class Memento {
	
	private String sentence;    //I will store states of objects that are sentences.
	
	public Memento(String sentenceToBeSaved) {  //Save a new state of a given sentence.
        sentence = sentenceToBeSaved;
    }
	
	public String getSavedSentence() {  //Return the saved state of a given sentence.
        return sentence;
    }
}