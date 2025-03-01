# Collection

## ContaOccorrenzeParole

L'obiettivo di questo esercizio è l'utilizzo di **Map**, **Collections**, **loop**, **Scanner**, **interface** e **varArg**.

Creare la classe `ContaOccorrenzeParole` che implementa l'interfaccia `Parole`, con relativo JUnit di test `ContaOccorrenzeParoleTest`.

All'interno della classe `ContaOccorrenzeParole` inserire i seguenti costruttori:

```java
class ContaOccorrenzeParole implements Parole {
    ContaOccorrenzeParole ()
    ContaOccorrenzeParole (int maxParole) // 10
    ContaOccorrenzeParole (String paroleInput) // "parola1 parola2 par.."
    ContaOccorrenzeParole (String ... parole) // parola1, parola2, ...
}
```

### Output

I vari _costruttori_ permettono di specificare le parole da gestire come una stringa con parole separate da spazi, oppure come parametri variabili separati da virgole.

Il costruttore vuoto e quello con il numero massimo di parole _inizializzano_ solo l'istanza senza alcuna parola predefinita.
In questo caso, senza nessuna stringa di input specificata al momento dell’istanziazione, i metodi restituiranno array vuoti di stringhe o zero in caso di valori numerici, **senza andare in exception**.

### Consigli

Utilizza il metodo `setInputString()` definito nell’interfaccia `Parole` per impostare la stringa da trattare.

## Files

**Parole.java**

```java
public interface Parole {
    public void addParola(String parola); // Inserisce una parola in Map
    public boolean exists(String parola); // Restituisce true se la parola è presente
    public boolean deleteParola(String parola); // Elimina una parola
    public int contaParole();  // Restituisce il numero delle parole inserite
    public int occorrenzeParola(String parola); // Restituisce le occorrenze di una parola (-1 se non esiste)
    public String[] paroleConMaxOccorrenze(); // Restituisce le parola con il numero massimo di occorrenze
    public int maxOccorrenzeNum(); // Restituisce il numero massimo di occorrenze
    public String[] toArrayParole();  // Restituisceun array con tutte la parole inserite
    public void setInputString(String strInput); // Imposta la stringa sulla quale operare
}
```
