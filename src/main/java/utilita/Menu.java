/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe che rappresenta un menu
 * elencoVoci è un' array di stringhe dove ogni stringa rappresenta 
 * una voce del menu. Ad ogni voce del menu è associato un valore
 * intero. Alla prima voce è associato il valopre 0,
 * alla seconda voce il valore 1 ecc..
 * Ad esempio:
 * 0--> Esci                    valore associato=0
 * 1-->Fai questa cosa          valore associato=1
 * 2-->Fai quest'altra cosa     valore associato =2
 * ....
 * La classe consente di:
 *  - visualizzare le voci del menu
 *  - far scegliere all'utente una voce e restituire il valore associato alla voce scelta
 * 
 * 
 * @author Studente
 */
public class Menu
{
    private String[] elencoVoci;
    private int numeroVoci;
    /**
     * Costruttore
     * @param elencoVoci Rappresenta l'elenco di voci di cui è 
     * costituito il menu.
     */
    public Menu(String[] elencoVoci)
    {
	numeroVoci=elencoVoci.length;
	this.elencoVoci=new String[numeroVoci];
	for(int i=0;i<numeroVoci;i++)
	    this.elencoVoci[i]=elencoVoci[i];
    }
    /**
     * Visualizza le voci del menu
     */
    public void visualizzaMenu()
    {
	System.out.println("MENU:");
	for(int i=0;i<numeroVoci;i++)
	    System.out.println(elencoVoci[i]);
    }
    /**
     * Permette all'utente di scegliere una voce del menu
     * I valori interi associati alle voci del menu vanno
     * da 0 al numero di voci-1. 
     * Il metodo controlla il valore di input inserito 
     * accettandolo solo se è un numero intero compreso 
     * fra 0 e numero di voci-1.
     * @return Il valore intero associato alla voce scelta
     * 
     */
    public int sceltaMenu()
    {
	String inputUtente;
	int sceltaUtente=0;
	boolean inputUtenteOK=true;
	
	do{
	    //Scanner tastiera=new Scanner(System.in);
            ConsoleInput tastiera=new ConsoleInput();
	    inputUtenteOK=true;
	    visualizzaMenu();
	    System.out.print("Scelta --> ");
	    //inputUtente=tastiera.nextLine;
            
            try
            {
                sceltaUtente=tastiera.readInt();
                //verifico se il numero inserito è compreso nelle voci del menu              
                if(sceltaUtente<0 || sceltaUtente>numeroVoci-1)
                {
                     inputUtenteOK=false;
                     System.out.println("Voce non prevista");
                }  
            } 
            catch (IOException ex) 
            {
                System.out.println("Impossibile leggere da tastiera!");
            } 
            catch (NumberFormatException ex) 
            {
                System.out.println("Formato input non corretto");
                inputUtenteOK=false;
            }
	}while(!inputUtenteOK);
	return sceltaUtente;
    }
}