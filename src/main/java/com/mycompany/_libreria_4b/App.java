/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._libreria_4b;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.EccezioneRipianoNonValido;
import eccezioni.FileException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.metal.MetalBorders;
import utilita.ConsoleInput;
import utilita.Menu;
import utilita.TextFile;

/**
 *
 * @author gian
 */
public class App 
{

    public static void main(String[] args) 
    {
        int numeroVociMenu=11;
        String[] vociMenu=new String[numeroVociMenu];
        int voceMenuScelta;
        Menu menu;
        Scaffale s1=new Scaffale();
      //  Scanner tastiera=new Scanner(System.in);
        ConsoleInput tastiera=new ConsoleInput();
        String titolo,autore;
        int numeroPagine,ripiano, posizione;
        TextFile f1 = null;
       
        Libro lib;
        Libro[] elencoLibriOrdinatiAlfabeticamente;
        String [] elencoTitoliAutore;
        String nomeFileCSV="volumi.csv";
        String nomeFileBinario="scaffale.bin";
        
        
        //Caricamento dati scaffale
        try 
        {
            ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nomeFileBinario));
            s1=(Scaffale)reader.readObject();
            reader.close();
            System.out.println("Caricamento effettuato correttamente");
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File non trovato");
        } 
        catch (IOException ex) 
        {
             System.out.println("Impossibile accedere al file");
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println("Impossibile leggere il dato memorizzato");
        }
        
        vociMenu[0]="0 -->\tEsci";
        vociMenu[1]="1 -->\tVisualizza tutti i volumi dello scaffale";
        vociMenu[2]="2 -->\tAggiungi volume (ripiano,posizione)";
        vociMenu[3]="3 -->\tCerca volume (ripiano, posizione)";
        vociMenu[4]="4 -->\tElimina volume (ripiano,posizione)";
        vociMenu[5]="5 -->\tMostra titoli di uno specifico autore";
        vociMenu[6]="6 -->\tMostra elenco dei volumi presenti ordinato alfabeticamente per titolo";
        vociMenu[7]="7 -->\tEsporta volumi in formato CSV";
        vociMenu[8]="8 -->\tImporta volumi dal file CSV";
        vociMenu[9]="9 -->\tSalva dati scaffale";
        vociMenu[10]="10 -->\tCarica dati scaffale";
        menu=new Menu(vociMenu);
        
        
        
        
        
        do
        {
            voceMenuScelta=menu.sceltaMenu();
            switch (voceMenuScelta) 
            {
                case 0: //Esci
                    System.out.println("Arrivederci");
                    break;
                case 1://Visualizza tutti
                    System.out.println(s1.toString());
                    break;
                case 2://Aggiungi volume                    
                    try 
                    {
                        System.out.println("Titolo --> ");
                        titolo=tastiera.readString();
                        System.out.println("Autore --> ");
                        autore=tastiera.readString();                                     
                        do
                        {
                            try
                            {
                               System.out.println("Numero pagine --> ");
                               numeroPagine=tastiera.readInt(); 
                               break;
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Formato non corretto.");
                            }   
                        }while(true);
                        
                        do
                        {
                            try
                            {
                                System.out.println("Ripiano (0..4) --> ");
                                ripiano=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Formato non corretto");
                            }
                        }while(true);
                       
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..14) --> ");
                                posizione=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Formato non corretto");
                            }
                        }while(true);
                        lib=new Libro(titolo,autore,numeroPagine);
                        s1.setLibro(lib, ripiano, posizione);
                        System.out.println("Volume inserito correttamente.");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore. Impossibile leggere da tastiera.");
                    }
                    catch (EccezioneRipianoNonValido ex) 
                    {
                        System.out.println("Ripiano non valido!");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida!");
                    } 
                    catch (EccezionePosizioneOccupata ex) 
                    {
                        System.out.println("Posizione occupata!");
                    }         
                   break;

                case 3: //getVolume
                    try 
                    {
                        do
                        {
                            try
                            {
                                System.out.println("Ripiano (0..4) --> ");
                                ripiano=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Formato non corretto");
                            }
                        }while(true);
                       
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..14) --> ");
                                posizione=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Formato non corretto");
                            }
                        }while(true);
                        lib=s1.getLibro(ripiano, posizione);
                        System.out.println("Libro cercato:\n"+lib.toString());
                    } 
                    catch(IOException e)
                    {
                        System.out.println("Errore. Impossibile leggere da tastiera");
                    }
                    catch (EccezioneRipianoNonValido ex) 
                    {
                        System.out.println("Ripiano non valido!");
                    } 
                    catch (EccezionePosizioneNonValida ex) 
                    {
                        System.out.println("Posizione non valida!");
                    } 
                    catch (EccezionePosizioneVuota ex)
                    {
                        System.out.println("Nessun volume presente in quel ripiano/posizione!");
                    }
                    break;
                    
                case 4://Rimuovi volume

                    try 
                    {
                        do
                        {
                            try
                            {
                                System.out.println("Ripiano (0..4) --> ");
                                ripiano=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Formato non corretto");
                            }
                        }while(true);
                       
                        do
                        {
                            try
                            {
                                System.out.println("Posizione (0..14) --> ");
                                posizione=tastiera.readInt();
                                break;
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("Formato non corretto");
                            }
                        }while(true);
                        s1.rimuoviLibro(ripiano, posizione);
                        System.out.println("Il libro è stato rimosso correttamente");
                        }
                        catch(IOException e)
                        {
                            System.out.println("Errore. Impossibile leggere da tastiera");
                        }
                        catch (EccezioneRipianoNonValido ex) 
                        {
                            System.out.println("Ripiano non valido");
                        } 
                        catch (EccezionePosizioneNonValida ex) 
                        {
                            System.out.println("Posizione non valida");
                        } 
                        catch (EccezionePosizioneVuota ex) 
                        {
                            System.out.println("La posizione è già vuota. Nessun libro è stto rimosso");
                    }
                  
                    break;

                case 5://Elenco titoli autore
                    try
                    {
                        System.out.println("Autore --> ");
                        autore=tastiera.readString();
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
                    }
                    catch (IOException e)
                    {
                        System.out.println("Errore. Imposssibile leggere da tastiera");
                    }
                    break;
                
                case 6: //ordine alfabetico titoli volumi
                    elencoLibriOrdinatiAlfabeticamente=s1.elencoLibriOrdinatoPerTitolo();
                    for(int i=0;i<elencoLibriOrdinatiAlfabeticamente.length;i++)
                    {
                        System.out.println(elencoLibriOrdinatiAlfabeticamente[i].toString());
                    }
                    break;
                
                case 7: 
                    try 
                    {
                        //Esporta CSV
                        s1.esportaCSV(nomeFileCSV);
                        System.out.println("Volumi esportati correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile espoertare su file");
                    }
                    break;

                case 8: 
                    try 
                    {
                        //carica datti csv
                        s1.importaDaCSV(nomeFileCSV);
                        System.out.println("Fine operazione di caricamento");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Errore. Impossibile caricare i volumi dal file.");
                    }
                
                    break;

                case 9: //serializazzione               
                    try 
                    {
                        s1.salvaDati(nomeFileBinario);
                        System.out.println("Salvataggio avvenuto correttamente");
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        System.out.println("File non trovato");
                    } 
                    catch (IOException ex) 
                    {
                         System.out.println("Impossibile accedere al file");
                    }
                    break;
                case 10:
                    try 
                    {
                        s1=s1.caricaDati(nomeFileBinario);
                        System.out.println("Caricamento effettuato correttamente");
                    } 
                    catch (FileNotFoundException ex) 
                    {
                        System.out.println("File non trovato");
                    } 
                    catch (IOException ex) 
                    {
                         System.out.println("Impossibile accedere al file");
                    } 
                    catch (ClassNotFoundException ex) 
                    {
                        System.out.println("Impossibile leggere il dato memorizzato");
                    }
                    break;
            }
        }while(voceMenuScelta!=0);
        
    }
}
