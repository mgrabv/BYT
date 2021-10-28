// Memento Design Pattern
// Origin class - the class from which every sentence originates.

public class Origin{
	
	private String sentence;
	
	public void set(String newSentence) {   //Set value of the current sentence.
	    sentence = newSentence;
	}

    public void viewCurrentSentence(){  //View the currently set sentence.
        System.out.println("The current sentence is: " + sentence);
    }

	public Memento storeInMemento() {   //Save the current version of the sentence as a new Memento.
	    return new Memento(sentence); 
	}
	
	public String restoreFromMemento(Memento memento) { //Restore a version of the sentence from a given Memento.
		sentence = memento.getSavedSentence();
		return sentence;
	}
	
}