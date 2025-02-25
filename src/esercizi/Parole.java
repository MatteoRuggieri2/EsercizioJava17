package esercizi;

public interface Parole {
	
	/* Inserisce una parola in Map */
	public void addParola(String parola);
	
	/* Restituisce true se la parola è presente */
	public boolean exists(String parola);
	
	/* Elimina una parola */
	public boolean deleteParola(String parola);
	
	/* Restituisce il numero delle parole inserite */
	public int contaParole();
	
	/* Restituisce le occorrenze di una parola (-1 se non esiste) */
	public int occorrenzeParola(String parola);
	
	/* Restituisce le parola con il numero massimo di occorrenze */
	public String[] paroleConMaxOccorrenze();
	
	/* Restituisce il numero massimo di occorrenze */
	public int maxOccorrenzeNum();
	
	/* Restituisceun array con tutte la parole inserite */
	public String[] toArrayParole();
	
	/* Imposta la stringa sulla quale operare */
	public void setInputString(String strInput);
}
