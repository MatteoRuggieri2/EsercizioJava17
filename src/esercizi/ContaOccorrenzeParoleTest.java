package esercizi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ContaOccorrenzeParoleTest {
	
	static ContaOccorrenzeParole cop;

	

//	@Test
//	void testAddParola() {
//		
//		// Creo una mappa
//		Map<String, Integer> wordsOccurrences = new HashMap<>();
//		wordsOccurrences.put("ciao", 1);
//		wordsOccurrences.put("sono", 1);
//		
//		// Creo una mappa uguale con la parola che andrò ad aggiungere per il test
//		Map<String, Integer> wordsOccurrencesWordAdded = new HashMap<>();
//		wordsOccurrences.put("ciao", 1);
//		wordsOccurrences.put("sono", 1);
//		wordsOccurrences.put("matteo", 1);
//		
//		assertEquals(wordsOccurrencesWordAdded, cop.addParola("matteo"));
//	}
	
	@Test
	void testCostructorMaxWords() {
		cop = new ContaOccorrenzeParole(10);
		assertEquals(10, cop.getMaxParole());
	}
	
	@Test
	void testCostructorString() {
		String string = "Ciao sono Matteo";
		
		Map<String, Integer> wordsOccurrences = new HashMap<>();
		wordsOccurrences.put("ciao", 1);
		wordsOccurrences.put("sono", 1);
		wordsOccurrences.put("matteo", 1);
		
		cop = new ContaOccorrenzeParole(string);
		assertTrue(wordsOccurrences.equals(cop.getWordsOccurrences()));
	}
	
	@Test
	void testCostructorVarArgs() {
		Map<String, Integer> wordsOccurrences = new HashMap<>();
		wordsOccurrences.put("schermo", 2);
		wordsOccurrences.put("tastiera", 1);
		
		cop = new ContaOccorrenzeParole("schermo", "tastiera", "schermo");
		assertTrue(wordsOccurrences.equals(cop.getWordsOccurrences()));
	}

}
