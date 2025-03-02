package esercizi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
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
	
	@Test
	void testDeleteParola() {
		cop = new ContaOccorrenzeParole("schermo", "tastiera", "schermo", "mouse");
		cop.deleteParola("Schermo");
		cop.deleteParola("mouse");
		
		assertFalse(cop.getWordsOccurrences().containsKey("schermo"));
		assertFalse(cop.getWordsOccurrences().containsKey("mouse"));
		assertTrue(cop.getWordsOccurrences().containsKey("tastiera"));
	}
	
	@Test
	void testContaParole() {
		cop = new ContaOccorrenzeParole("schermo", "tastiera", "schermo", "mouse");
		assertEquals(3, cop.contaParole());
	}
	
	@Test
	void testOccorrenzeParole() {
		cop = new ContaOccorrenzeParole("schermo", "tastiera", "schermo", "mouse");
		assertEquals(2, cop.occorrenzeParola("SCHERMO"));
		assertEquals(2, cop.occorrenzeParola("Schermo"));
		assertEquals(1, cop.occorrenzeParola("TASTIERA"));
		assertEquals(1, cop.occorrenzeParola("Tastiera"));
		assertEquals(1, cop.occorrenzeParola("MOUSE"));
		assertEquals(1, cop.occorrenzeParola("Mouse"));
		assertEquals(-1, cop.occorrenzeParola("WEBCAM"));
		assertEquals(-1, cop.occorrenzeParola("Webcam"));
	}
	
	@Test
	void testParoleConMaxOccorrenze() {
		String[] wordList = { "schermo", "mouse" };

		cop = new ContaOccorrenzeParole("schermo", "tastiera", "schermo", "mouse", "mouse");
		String[] result = cop.paroleConMaxOccorrenze();
		
		/* Ordino gli array dato che "assertArrayEquals" controlla anche l'ordine,
		non facendolo il test potrebbe fallire nonostante gli elementi contenuti
		al loro interno siano gli stessi. */
		Arrays.sort(wordList);
		Arrays.sort(result);

		assertArrayEquals(wordList, result);
	}
	
	@Test
	void testMaxOccorrenzeNum() {
		cop = new ContaOccorrenzeParole("schermo", "tastiera", "schermo", "mouse", "mouse");
		assertEquals(2, cop.maxOccorrenzeNum());
	}
	
	@Test
	void testToArrayParole() {
		String[] wordList = { "mela", "pera", "banana" };
		
		cop = new ContaOccorrenzeParole("mela", "pera", "banana");
		String[] result = cop.toArrayParole();
		
		Arrays.sort(wordList);
		Arrays.sort(result);
		
		assertArrayEquals(wordList, result);
	}
}
