//Class Mementos - where all created Mementos are saved in the form of an ArrayList.

import java.util.ArrayList;

public class Mementos {
	
	ArrayList<Memento> savedSentences = new ArrayList<Memento>();   //All Mementos saved here.

	public void addMemento(Memento m) {    //Method for adding a new Memento.
        savedSentences.add(m);
    }

	public Memento getMemento(int index) {  //Method for retrieving a given Memento.
        return savedSentences.get(index);
    }
} 