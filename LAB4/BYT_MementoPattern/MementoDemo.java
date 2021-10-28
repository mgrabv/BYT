//Demo for the Memento Design Pattern

public class MementoDemo {

    public static int savedFiles = 0;
    public static int currentSave = 0;
    
    static Mementos mementos = new Mementos();
    static Origin origin = new Origin();

   public static void main(String[] args) {     //Main method - imitating a User saving new sentences, reverting or loading next states from the current state of the sentence.
       setAndSaveSentence("This is the first sentence.");
       setAndSaveSentence("This is the second sentence.");
       setAndSaveSentence("This is the third sentence.");
       origin.viewCurrentSentence();
       System.out.println("Current save: " + currentSave);

       System.out.println("Reverting to the second sentence...");
       revert();
       origin.viewCurrentSentence();    //Should display the "second sentence".
       System.out.println("\n");

       System.out.println("Revering to the first sentence...");
       revert();
       origin.viewCurrentSentence();    //Should display the "first sentence".
       System.out.println("\n");

       System.out.println("Trying to revert from the first sentence...");
       revert();                          //Should display that it's impossible to revert further as we are currently on the first saved sentence.
       System.out.println("\n");

       System.out.println("Loading next saved sentence from the first sentence...");
       loadNext();
       origin.viewCurrentSentence();    //Should display the "second sentence".
       System.out.println("\n");

       System.out.println("Loading next saved sentence from the second sentence...");
       loadNext();
       origin.viewCurrentSentence();    //Should display the "third sentence".
       System.out.println("\n");

       System.out.println("Trying to 'loadNext' further from the third statement...");
       loadNext();                          //Should display that it's impossible to 'loadNext' further as we are currently on the last saved sentence.
       System.out.println("\n");
   }

   public static void setAndSaveSentence(String sentence) {    //Set and save a given sentence.
       origin.set(sentence);
       mementos.addMemento(origin.storeInMemento());
       savedFiles++;
       currentSave = savedFiles;    //Current save is the new save when a new sentence is set (!!!).
       System.out.println("Currently there is/are: " + savedFiles + " files saved.\n");
   }

   public static void revert() {     //Revert to previous saved state.
       if (currentSave > 1) {
           currentSave--;

           origin.set(origin.restoreFromMemento(mementos.getMemento(currentSave - 1))); //Decrementing by one because indexes start from 0.
           System.out.println("Current save: " + currentSave);
       }
       else {
           System.out.println("There are no more saved sentences, the current sentence is the first one saved.");
       }
   }

   public static void loadNext() {     //LoadNext - load the next saved state.
       if (savedFiles > currentSave) {
           currentSave++;

           origin.set(origin.restoreFromMemento(mementos.getMemento(currentSave - 1))); //Decrementing by one because indexes start from 0.
           System.out.println("Current save: " + currentSave);
       }
       else {
           System.out.println("There are no more saved sentences, the current sentence is the last one saved.");
       }
   }
}