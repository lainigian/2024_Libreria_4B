/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.io.*;

/**
 * Classe che rappresenta una Console di Input (tastiera)
 * Un oggeto istanza della classe Console Input espone dei metodi
 * che consentono di acquisire dalla tastiera 
 * variabili di ciascun tipo di dato nativo (int, short, double ecc...) 
 * e oggetti di tipo String.
 * @author Plona
 */
public class ConsoleInput
{
    private InputStreamReader input;
    private BufferedReader tastiera;
    
    /**
     * Costruttore
     */
    public ConsoleInput()
    {
	input=new InputStreamReader(System.in);
	tastiera=new BufferedReader(input);
    }
    
    /**
     * Metodo per la lettura di una stringa
     * @return la stringa letta
     * @throws IOException Errore di lettura
     */
    public String readString() throws IOException
    {
	return tastiera.readLine();
    }
    
    /**
     * Metodo per la lettura di un intero
     * @return l'intero letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Errore del formato
     */
    public int readInt() throws IOException, NumberFormatException
    {
	return Integer.parseInt(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un short
     * @return lo short letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Errore del formato
     */
    public short readShort() throws IOException, NumberFormatException
    {
	return Short.parseShort(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un long
     * @return il long letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Errore del formato
     */
    public long readLong() throws IOException, NumberFormatException
    {
	return Long.parseLong(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un float
     * @return il float letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Errore del formato
     */
    public float readFloat() throws IOException, NumberFormatException
    {
	return Float.parseFloat(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un double
     * @return il double letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Errore del formato
     */
    public double readDouble() throws IOException, NumberFormatException
    {
	return Double.parseDouble(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un boolean
     * @return true se inserito "true", false in tutti gli altri casi
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Errore del formato
     */
    public boolean readBoolean() throws IOException, NumberFormatException
    {
	return Boolean.parseBoolean(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un byte
     * @return il byte letto
     * @throws IOException Errore di lettura
     * @throws NumberFormatException Errore del formato
     */
    public byte readByte() throws IOException, NumberFormatException
    {
	return Byte.parseByte(tastiera.readLine());
    }
    
    /**
     * Metodo per la lettura di un char
     * @return il primo carattere di quello che hai inserito
     * @throws IOException Errore di lettura
     */
    public char readChar() throws IOException
    {
	return tastiera.readLine().charAt(0);
    }
}