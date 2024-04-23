/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreria_4b;

import eccezioni.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.Ordinatore;
import utilita.TextFile;

/**
 *
 * @author gian
 */
public class Scaffale implements Serializable
{
    private static final int NUM_RIPIANI=5;
    private Mensola[] ripiani;
    
    
    public Scaffale()
    {
        ripiani=new Mensola[NUM_RIPIANI];
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            //per ogni ripiano istanzio una mensola vuota
            ripiani[i]=new Mensola();
        }
    }
    
    /**
     * Costruttore di copia
     * @param scaf 
     */
    public Scaffale(Scaffale scaf)
    {
        //creo un array di mensole vuote
        ripiani=new Mensola[NUM_RIPIANI];
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            //per ogni ripiano istanzio una mensola vuota
            ripiani[i]=new Mensola();
        }
        
        //Copio ogni volume di scaf in this.ripiani
        Libro lib;
        for(int i=0;i<scaf.getNumRipiani();i++)
        {
            for(int j=0;j<scaf.getNumMaxLibri(i);j++)
            {
                try 
                {
                    lib=scaf.getLibro(i, j);
                    if (lib!=null)
                        this.setLibro(lib, i, j);
                    
                } 
                catch (EccezioneRipianoNonValido ex) 
                {
                    //non può succedere
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                    //Non può succedere
                } catch (EccezionePosizioneVuota ex) 
                {
                    //non fare nulla
                } 
                catch (EccezionePosizioneOccupata ex) 
                {
                    //non può succedere
                }
            }
        }
    }
    
   
    
    /**
     * Inserisce il libro nella posizione "posizione" 
     * del ripiano “ripiano”.
     * @param lib Il libro da aggiungere
     * @param ripiano
     * @param posizione
     * @return 
     *  se il ripiano non è valido --> return -3
        se la posizione non è valida --> return -1
        se la posizione non è vuota --> return -2
        se ok  return 0
     */
    public void setLibro(Libro lib,int ripiano, int posizione) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneOccupata
    {

        if (ripiano<0 || ripiano>=NUM_RIPIANI)
            throw new EccezioneRipianoNonValido();
        ripiani[ripiano].setVolume(lib, posizione);
    }
    
    /**
     * Restituisce il volume nella posizione "posizione" 
     * del ripiano “ripiano”.
     * @param ripiano
     * @param posizione
     * @return 
     * se il ripiano non è valido, la posizione non è valida o vuota --> return null
        se ok  ritorna l’oggetto libro
     */
    public Libro getLibro(int ripiano, int posizione) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneVuota
    {
        Libro lib;
        if (ripiano<0 || ripiano>=NUM_RIPIANI)
             throw new EccezioneRipianoNonValido();
        lib=ripiani[ripiano].getVolume(posizione);
        return lib;
    }
    
    /**
     * Rimuove il libro dal ripiano "ripiano" e posizione
     * "posizione"
     * @param ripiano
     * @param posizione
     * @return 
     *  se il ripiano non è valido --> return -3
        se la posizione non è valida --> return -1
        se già vuota --> return -2
        se ok  return 0
     */
    public void rimuoviLibro(int ripiano, int posizione) throws EccezioneRipianoNonValido, EccezionePosizioneNonValida, EccezionePosizioneVuota
    {     
        if(ripiano<0 || ripiano>NUM_RIPIANI)
            throw new EccezioneRipianoNonValido();   
        ripiani[ripiano].rimuoviVolume(posizione);
    }
    
    public int getNumRipiani()
    {
        return NUM_RIPIANI;
    }
    
    /**
     * Restituisce il massimo numero di volumi
     * che possono essere posti nello scaffale
     * @return 
     */
    public int getNumMaxLibri()
    {   
        int contaLibri=0;
        for(int i=0;i<NUM_RIPIANI;i++)
            contaLibri+=ripiani[i].getNumMaxVolumi();
        return contaLibri;
    }
    /**
     * Restituisce il numero di volumi presenti nello scaffale
     * @return 
     */
    public int getNumLibri()
    {
        int contaLibri=0;
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            contaLibri+=ripiani[i].getNumVolumi();
        }
        return contaLibri;
    }
    
    /**
     * Restituisce il numero di volumi presenti in un dato ripiano
     * @param ripiano
     * @return 
     * Se il ripiano non è valido --> return -1
     */
    public int getNumLibri(int ripiano)
    {
        if(ripiano<0 || ripiano>NUM_RIPIANI)
            return -1; //Ripiano non valido
        return ripiani[ripiano].getNumVolumi();
    }
    
    /**
     * Restituisce il massimo numero di libri
     * che possono essere posti in uno specifico
     * ripiano passato come parametro
     * @param ripiano
     * @return 
     */
    public int getNumMaxLibri(int ripiano)
    {
         if(ripiano<0 || ripiano>NUM_RIPIANI)
            return -1; //Ripiano non valido
        return ripiani[ripiano].getNumMaxVolumi();
    }
    
    /**
     * Restituisce un array contenente tutti i titoli
     * dell'autore passato come parametro
     * @param autoreDaCercare
     * @return array di stringhe
     */
    public String[] elencoTitoliAutore (String autoreDaCercare)
    {
        int contaLibriAutore=0;
        Libro lib;
        String[] elencoTitoliAutore;
        //Conto il numero di libri di quell'autore
        for(int i=0;i<getNumRipiani();i++)
        {
            for(int j=0;j<ripiani[i].getNumMaxVolumi();j++)
            {
                try 
                {
                    lib=this.getLibro(i, j);
                    if (lib.getAutore().equalsIgnoreCase(autoreDaCercare))
                        contaLibriAutore++;   
                } 
                catch (EccezioneRipianoNonValido ex) 
                {
                    //non succederà mai
                } 
                catch (EccezionePosizioneNonValida ex)
                {
                    //non succederà mai
                } catch (EccezionePosizioneVuota ex) 
                {
                        //non fare nulla.
                }
            }
        }
        
        if (contaLibriAutore==0)
            return null; //non ci sono libri di quell'autore.
        //Istanzio DINAMICAMENTE un array di stringhe
        elencoTitoliAutore=new String[contaLibriAutore];
        
        contaLibriAutore=0; //azzero il contatore per usarlo come contatore dell'array
        //Copio il titolo di ogni libro di quell'autore
        //nell'array elencoTitoliAutore
        for(int i=0;i<getNumRipiani();i++)
        {
            for(int j=0;j<ripiani[i].getNumMaxVolumi();j++)
            {
                try {
                    lib=this.getLibro(i, j);
                    if (lib.getAutore().equalsIgnoreCase(autoreDaCercare))
                    {
                        elencoTitoliAutore[contaLibriAutore]=lib.getTitolo();
                        contaLibriAutore++;
                    } 
                } 
                catch (EccezioneRipianoNonValido ex) 
                {   
                    //non succederà mai
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                       //non succederà mai
                } 
                catch (EccezionePosizioneVuota ex) 
                {
                    //non fare nulla
                }
            }
        }
        return elencoTitoliAutore;
    }
    
    /**
     * Restituisce un array contenente tutti i libri
     * presenti nello scaffale ordinati alfabateicamente 
     * per titolo
     * @return Array di libri
     */
    public Libro[] elencoLibriOrdinatoPerTitolo()
    {
        Libro[] elencoLibriOrdinato=new Libro[getNumLibri()];
        Libro lib;
        int c=0; //contatore
        for(int i=0;i<getNumRipiani();i++)
        {
            for(int j=0;j<getNumMaxLibri(i);j++)
            {
                try 
                {
                    lib=getLibro(i, j);
                    elencoLibriOrdinato[c]=lib;
                    c++; 
                } 
                catch (EccezioneRipianoNonValido ex) 
                {
                    //non succederà mai
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                    //non succederà mai
                } 
                catch (EccezionePosizioneVuota ex) 
                {
                    //non fare nulla
                }
            }
        }
        //ordino l'array dei libri presenti
        elencoLibriOrdinato=Ordinatore.ordinaLibriCrescente(elencoLibriOrdinato);
        return elencoLibriOrdinato;
        
    }
    
    
    public void esportaCSV(String nomeFileCSV) throws IOException
    {
        TextFile f1;
        Libro lib;
       
        f1= new TextFile(nomeFileCSV,'W'); //Apro ill file in scrittura
        String datiVolume;
        for(int i=0;i<getNumRipiani();i++)
        {
            for(int j=0;j<this.getNumMaxLibri(i);j++)
            {
                try 
                {
                    lib=this.getLibro(i, j);
                    datiVolume=i+";"+j+";"+lib.getTitolo()+";"+lib.getAutore()+";"+lib.getNumeroPagine();
                    f1.toFile(datiVolume);
                } 
                catch (EccezioneRipianoNonValido | EccezionePosizioneNonValida ex) 
                {
                        //Non succederà mai
                }                              
                catch (EccezionePosizioneVuota ex) 
                {
                        //non fare nulle, vai alla prossima posizione
                } 
                catch (FileException ex) 
                {
                    //non succederà mai
                }
            }
        }
        f1.closeFile();  //Tutti i volumi sono statoi scritti
    }
    
    public void importaCSV(String nomeFile) throws IOException
    {
        String rigaLetta;
        String[] datiVolume;
        TextFile f1;
        String titolo, autore;
        int numeroPagine, ripiano, posizione;
        Libro lib;
           
        //Importa da file CSV
        f1=new TextFile(nomeFile,'R');
        do
        {
            try
            {
                rigaLetta=f1.fromFile();
                datiVolume=rigaLetta.split(";");
                ripiano=Integer.parseInt(datiVolume[0]);
                posizione=Integer.parseInt(datiVolume[1]);
                titolo=datiVolume[2];
                autore=datiVolume[3];
                numeroPagine=Integer.parseInt(datiVolume[4]);
                lib=new Libro(titolo,autore,numeroPagine);
                try 
                {
                    this.setLibro(lib, ripiano, posizione);
                } 
                catch (EccezioneRipianoNonValido ex) 
                {
                   // System.out.println("Errore: ripiano "+ripiano+ " non corretto per il volume "+titolo);
                } 
                catch (EccezionePosizioneNonValida ex) 
                {
                   //  System.out.println("Errore: posizione "+posizione+ " non corretta per il volume "+titolo);
                }
                catch (EccezionePosizioneOccupata ex) 
                {
                  //   System.out.println("Nel ripiano  "+ripiano+ " e posizione "+posizione+" è già presente un volume. Il volume "+titolo+ " non sarà posizionato nello scaffale.");
                }
                catch (NumberFormatException e)
                {
                    //nulla
                }
            }
            catch (FileException ex) 
            {
                //fine del file
                f1.closeFile();
                System.out.println("Fine operazione di caricamento");
                break;
            }
        }while(true);                
    } 
    
    
    public void salvaDati(String nomeFile) throws FileNotFoundException, IOException
    {
        
        ObjectOutputStream writer=new ObjectOutputStream(new FileOutputStream(nomeFile));
        writer.writeObject(this);
        writer.flush();
        writer.close();
        System.out.println("Salvataggio avvenuto correttamente");

    }
    
    public Scaffale caricaDati(String nomeFile) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        Scaffale s;
        ObjectInputStream reader=new ObjectInputStream(new FileInputStream(nomeFile));
        s=(Scaffale)reader.readObject();
        reader.close();
        System.out.println("Caricamento effettuato correttamente");
        return s;
    }
    
    public String toString()
    {
        String s="";
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            s+="Ripiano "+i+":\n"+ripiani[i].toString();  
        }
        return s;
    }
    
    
}
