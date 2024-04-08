/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;
import eccezioni.FileException;
import java.io.*;

/**
 * Rappresenta un file di testo.
 * Consente di scrivere una stringa sul file di testo o di leggere una stringa dal file di testo.
 * Quando viene istanziato, il file di testo può essere aperto:
 * - in scrittura in append
 * - in scrittura non in append
 * - in lettura.
 * Consente di chiudere il file.
 * @author Studente
 */
public class TextFile
{
    private char mode; //R=reader/lettura - W=writer/scrittura
    private BufferedReader reader;
    private BufferedWriter writer;
    
    /**
     * Costruttore non in append
     * @param nomeFile pathname del file fisico da leggere/scrivere
     * @param mode modalità di apertura del file, può asumere i seguenti valori:
     * - W o w per aprire il file in scrittura
     * - qualsiasi altra lettera per aprire il file in lettura
     * @throws FileNotFoundException viene sollevata se il file da leggere
     * non viene trovato. Se il file aperto in scrittura non viene
     * trovato esso viene creato.
     * @throws IOException Viene sollevata se non è possibile
     * accedere al file.
     */
    public TextFile(String nomeFile, char mode) throws FileNotFoundException, IOException
    {
	this.mode='R'; //modalità di default
	if(mode=='W' || mode=='w')
	    this.mode='W';
	if(this.mode=='R')
	    reader=new BufferedReader(new FileReader(nomeFile));
	else
	    writer=new BufferedWriter(new FileWriter(nomeFile));
    }
    
    /**
     * Costruttore (con append)
     * @param nomeFile pathname del file fisico da leggere/scrivere
     * @param mode modalità di apertura del file, può asumere i seguenti valori:
     * - W o w per aprire il file in scrittura
     * - qualsiasi altra lettera per aprire il file in lettura
     * @parm append se vale true il file aperto in scrittura viene aperto 
     * in appende, altrimenti viene aperto non in append.
     * @throws FileNotFoundException viene sollevata se il file da leggere
     * non viene trovato. Se il file aperto in scrittura non viene
     * trovato esso viene creato.
     * @throws IOException Viene sollevata se non è possibile
     * accedere al file.
     */
    public TextFile(String nomeFile, char mode, boolean append) throws FileNotFoundException, IOException
    {
	this.mode='R'; //modalità di default
	if(mode=='W' || mode=='w')
	    this.mode='W';
	if(this.mode=='R')
	    reader=new BufferedReader(new FileReader(nomeFile));
	else
	    writer=new BufferedWriter(new FileWriter(nomeFile,append));
    }
    
    /**
     * Scrive una stringa su file
     * @param line la stringa da scrivere 
     * @throws FileException viene sollevata se il file è 
     * aperto in lettura.
     * @throws IOException Viene sollevata se non è possibile
     * accedere al file.
     */
    public void toFile(String line) throws FileException, IOException
    {
	if(mode=='R')
	    throw new FileException("Errore: file aperto in lettura");
	writer.write(line);
	writer.newLine();
    }
    
    /**
     * Legge dal file e restituisce la stringa letta
     * La prima volta che viene invocato 
     * qiuesto metodo viene letta la prima riga del file,
     * in seguito, ogni volta che viene invocato questo metodo
     * la stringa letta è la successiva.
     * Quando viene raggiunta la fine del file il metodo 
     * solleva un'eccezione FileException.
     * @return la stringa letta
     * @throws FileException viene sollevata in due casi:
     *  1) se il file è aperto in scrittura
     *  2) quando viene raggiunta la fine del file
     * @throws IOException IOException Viene sollevata se non è possibile
     * accedere al file.
     */
    public String fromFile() throws FileException, IOException
    {
	if(mode=='W')
	    throw new FileException("Errore: file aperto in scrittura");
	String s=reader.readLine();
	if(s==null)
	    throw new FileException("Fine del file");
	return s;
    }
    
    /**
     * Chiude il file
     * @throws IOException IOException Viene sollevata se non è possibile
     * accedere al file.
     */
    public void closeFile() throws IOException
    {
	if(mode=='R')
	    reader.close();
	else
	    writer.close();
    }
}