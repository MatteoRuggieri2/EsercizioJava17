package esercizi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ContaOccorrenzeParoleTest {
	
	static ContaOccorrenzeParole cop;
	
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
	
	@Test
	void testAddParola() {
		Map<String, Integer> wordsOccurrences = new HashMap<>();
		wordsOccurrences.put("nasa", 2);
		wordsOccurrences.put("usa", 1);
		
		cop = new ContaOccorrenzeParole();
		cop.addParola("NASA");
		cop.addParola("Nasa");
		cop.addParola("USA");
		
		assertTrue(wordsOccurrences.equals(cop.getWordsOccurrences()));
	}
	
	@Test
	void testExists() {
		cop = new ContaOccorrenzeParole("schermo", "tastiera", "schermo");
		assertTrue(cop.exists("SCHERMO"));
		assertTrue(cop.exists("Schermo"));
		assertTrue(cop.exists("TASTIERA"));
		assertTrue(cop.exists("Tastiera"));
		assertFalse(cop.exists("MOUSE"));
		assertFalse(cop.exists("Mouse"));
	}

}
