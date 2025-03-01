package esercizi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ContaOccorrenzeParole implements Parole {
	
	private String strInput;
	
	private int maxParole; //TODO Quando lo uso?
	
//	private String paroleInput;
	
//	private String[] paroleInputArr;
	
	private Map<String, Integer> wordsOccurrences = new HashMap<>();

//	public static void main(String[] args) {
//		ContaOccorrenzeParole contaOccorrenzeParole = new ContaOccorrenzeParole();
//		contaOccorrenzeParole.run();
//
//	}
	
//	private void run() {
//		System.out.println("play");
//	}
	
	// Inizializza l'istanza senza alcuna parola predefinita
	ContaOccorrenzeParole () {
		
	}
	
	// Inizializza l'istanza senza alcuna parola predefinita, ma con un massimo impostato
	ContaOccorrenzeParole (int maxParole) {
		this.maxParole = maxParole;
	}
	
	// Divide le parole rimuovendo gli spazi e le inserisce nella mappa
	ContaOccorrenzeParole (String paroleInput) {
		insertWordsFromArrayToMap(paroleInput.split(" +"));
		
	}
	
	// Prende le singole parole e le inserisce nella mappa
	ContaOccorrenzeParole (String ... parole) { // VarArg parola,parola2,..parolan
		insertWordsFromArrayToMap(parole);
	}

	// Questa funzione aggiunge la parola passata nella mappa
	@Override
	public void addParola(String parola) {
		
		String parolaLC = parola.toLowerCase();
		
		if (this.wordsOccurrences.size() < this.maxParole) {
			
			// Se è già presente incremento il valore di 1, altrimenti la inserisco nella mappa e la inizializzo a 1
			if (exists(parolaLC)) {
				
				// Prendo il numero di occorrenze della stringa corrente
				int occurrencesNumber = this.wordsOccurrences.get(parolaLC);
				
				// Incremento di 1 il counter di occorrenze
				this.wordsOccurrences.put(parolaLC, ++occurrencesNumber);
				
			} else {
				// Creo un nuovo elemento e lo inizializzo a 1
				this.wordsOccurrences.put(parolaLC, 1);
			}
		}
		
	}

	// Questa funzione controlla se la parola passata esiste dentro la mappa
	@Override
	public boolean exists(String parola) {
		
		String parolaLC = parola.toLowerCase();
		
		// Ritorna true se si trova all'interno, altrimenti false
		return this.wordsOccurrences.containsKey(parolaLC);

	}

	// Questa funzione elimina l'elemento con la chiave uguale alla parola passata
	@Override
	public boolean deleteParola(String parola) {
		
		String parolaLC = parola.toLowerCase();
		
		if (exists(parolaLC)) {
			
			// Elimino parola
			this.wordsOccurrences.remove(parolaLC);
			return true;
			
		} else {
			return false;
		}
		
	}

	// Questa funzione conta le parole presenti nella mappa
	@Override
	public int contaParole() {
		return this.wordsOccurrences.keySet().size();
	}

	// Questa funzione restituisce il numero di occorrenze della parola passata
	@Override
	public int occorrenzeParola(String parola) {
		
		String parolaLC = parola.toLowerCase();
		
		// Se esiste la parola nella mappa ritorno il numero di occorrenze
		if (exists(parolaLC)) {
			return this.wordsOccurrences.get(parolaLC);
		}
		
		// Altrimenti torno -1
		return -1;
	}

	// Questa funzione ritorna le parole che hanno il numero massimo di occorrenze
	@Override
	public String[] paroleConMaxOccorrenze() {
		
		List<String> wordList = new ArrayList<>();
		
		// Mi ciclo tutte le parole per vedere l'ocorrenza max
		int maxOccurrences = maxOccorrenzeNum();
		
		// Per ogni parola, se il suo valore è uguale a "maxOccurrences" lo aggiungo a "wordList"
		for (Map.Entry<String, Integer> singleWord : this.wordsOccurrences.entrySet()) {
			
			if (singleWord.getValue() == maxOccurrences) {
				wordList.add(singleWord.getKey());
			}
 		}
		
		return (String[]) wordList.toArray();
	}

	// Questo funzione ritorna il numero massimo di occorrenze
	@Override
	public int maxOccorrenzeNum() {
		
		int maxOccurrences = 0;
				
		for (Map.Entry<String, Integer> singleWord : this.wordsOccurrences.entrySet()) {
			
			// Se le occorrenze della parola sono maggiori di quelli salvati, sovrascrivi
			if (singleWord.getValue() > maxOccurrences) {
				maxOccurrences = singleWord.getValue();
			}
 		}
		
		return maxOccurrences;
	}

	// Questa funzione trasforma la mappa di parole in un array di stringhe
	@Override
	public String[] toArrayParole() {
		return (String[]) this.wordsOccurrences.entrySet().toArray();
	}

	// Imposta la stringa sulla quale operare
	@Override
	public void setInputString(String strInput) {
		this.strInput = strInput;
	}
	
	// Inserisce tutte le parole di un array nella mappa "wordsOccurrences"
	private void insertWordsFromArrayToMap(String[] words) {
		for (String word : words) {
			addParola(word);
		}
	}

}
