package esercizi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
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

}
