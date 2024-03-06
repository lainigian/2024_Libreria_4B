/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._libreria_4b;

import java.util.Scanner;
import utilita.Menu;

/**
 *
 * @author gian
 */
public class App {

    public static void main(String[] args) 
    {
        int numeroVociMenu=7;
        String[] vociMenu=new String[numeroVociMenu];
        int voceMenuScelta;
        Menu menu;
        Scaffale s1=new Scaffale();
        Scanner tastiera=new Scanner(System.in);
        String titolo,autore;
        int numeroPagine,ripiano, posizione;
        int esito;
        Libro lib;
        Libro[] elencoLibriOrdinatiAlfabeticamente;
        String [] elencoTitoliAutore;
        
        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tVisualizza tutti i volumi dello scaffale";
        vociMenu[2]="2 -->\tAggiungi volume (ripiano,posizione)";
        vociMenu[3]="3 -->\tCerca volume (ripiano, posizione)";
        vociMenu[4]="4 -->\tElimina volume (ripiano,posizione)";
        vociMenu[5]="5 -->\tMostra titoli di uno specifico autore";
        vociMenu[6]="6 -->\tMostra elenco dei volumi presenti ordinato alfabeticamente per titolo";
        
        menu=new Menu(vociMenu);
        
        
        
        
        
        do
        {
            System.out.println("MENU:");
            voceMenuScelta=menu.sceltaMenu();
            switch (voceMenuScelta) 
            {
                case 0:
                    System.out.println("Arrivederci");
                    break;
                case 1:
                    System.out.println(s1.toString());
                    break;
                case 2:
                    System.out.println("Premi invio per continuare..");
                    tastiera.nextLine();
                    System.out.println("Titolo --> ");
                    titolo=tastiera.nextLine();
                    System.out.println("Autore --> ");
                    autore=tastiera.nextLine();
                    System.out.println("Numero pagine --> ");
                    numeroPagine=tastiera.nextInt();
                    lib=new Libro(titolo,autore,numeroPagine);
                    System.out.println("Ripiano (0..4) --> ");
                    ripiano=tastiera.nextInt();
                    System.out.println("Posizione (0..14) --> ");
                    posizione=tastiera.nextInt();
                    esito=s1.setLibro(lib, ripiano, posizione);
                    if(esito==-1)
                        System.out.println("Posizione non valida!");
                    else if(esito==-3)
                        System.out.println("Ripiano non valido!");
                    else if(esito==-2)
                        System.out.println("Posizione occupata!");
                    else
                        System.out.println("Volume inserito correttamente.");
                    
                    break;
                case 3:
                    System.out.println("Ripiano (0..4) --> ");
                    ripiano=tastiera.nextInt();
                    System.out.println("Posizione (0..14) --> ");
                    posizione=tastiera.nextInt();
                    lib=s1.getLibro(ripiano, posizione);
                    if (lib==null)
                        System.out.println("Volume non trovato");
                    else
                        System.out.println("Libro cercato:\n"+lib.toString());
                    break;
                    
                case 4:
                    System.out.println("Ripiano (0..4) --> ");
                    ripiano=tastiera.nextInt();
                    System.out.println("Posizione (0..14) --> ");
                    posizione=tastiera.nextInt();
                    esito=s1.rimuoviLibro(ripiano, posizione);
                    if (esito==-3)
                        System.out.println("Ripiano non valido");
                    else if(esito==-1)
                        System.out.println("Posizione non valida");
                    else if(esito==-2)
                        System.out.println("La posizione è già vuota. Nessun libro è stto rimosso");
                    else    
                        System.out.println("Il libro è stato rimosso correttamente");
                    break;
                case 5:
                    System.out.println("Autore --> ");
                    autore=tastiera.nextLine();
                    elencoTitoliAutore=s1.elencoTitoliAutore(autore);
                    if (elencoTitoliAutore!=null)
                    {
                        for(int i=0;i<elencoTitoliAutore.length;i++)
                        {
                            System.out.println(elencoTitoliAutore[i]);
                        }
                    }
                    else
                        System.out.println("Nessun volume presente per l'autore scelto.");
                    break;
                
                case 6:
                    elencoLibriOrdinatiAlfabeticamente=s1.elencoLibriOrdinatoPerTitolo();
                    for(int i=0;i<elencoLibriOrdinatiAlfabeticamente.length;i++)
                    {
                        System.out.println(elencoLibriOrdinatiAlfabeticamente[i].toString());
                    }
                    break;
                    
            }
        }while(voceMenuScelta!=0);
        
    }
}
