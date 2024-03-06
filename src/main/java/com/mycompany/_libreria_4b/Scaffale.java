/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreria_4b;

import utilita.Ordinatore;

/**
 *
 * @author gian
 */
public class Scaffale 
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
                lib=scaf.getLibro(i, j);
                if (lib!=null)
                    this.setLibro(lib, i, j);
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
    public int setLibro(Libro lib,int ripiano, int posizione)
    {
        int esito;
        if (ripiano<0 || ripiano>=NUM_RIPIANI)
            return -3;
        
        esito=ripiani[ripiano].setVolume(lib, posizione);
        if (esito>0)
            return 0;
        else
            return esito; //vale -1(posizione non valida) o -2 (posizione non libera)
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
    public Libro getLibro(int ripiano, int posizione)
    {
        Libro lib;
        if (ripiano<0 || ripiano>=NUM_RIPIANI)
            return null; //ripiano non valido
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
    public int rimuoviLibro(int ripiano, int posizione)
    {
        int esito;
        if(ripiano<0 || ripiano>NUM_RIPIANI)
            return -3;
        
        esito=ripiani[ripiano].rimuoviVolume(posizione);
        
        if(esito>=0)
            return 0; //rimozione ok
        else
           return esito; //-1 (posizione non valida) o -2 posizione vuota 
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
                lib=this.getLibro(i, j);
                if(lib!=null)
                {
                    if (lib.getAutore().equalsIgnoreCase(autoreDaCercare))
                        contaLibriAutore++;
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
                lib=this.getLibro(i, j);
                if(lib!=null)
                {
                    if (lib.getAutore().equalsIgnoreCase(autoreDaCercare))
                    {
                        elencoTitoliAutore[contaLibriAutore]=lib.getTitolo();
                        contaLibriAutore++;
                    }
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
                lib=getLibro(i, j);
                if (lib!=null)
                {
                    elencoLibriOrdinato[c]=lib;
                    c++;
                }
            }
        }
        //ordino l'array dei libri presenti
        elencoLibriOrdinato=Ordinatore.ordinaLibriCrescente(elencoLibriOrdinato);
        return elencoLibriOrdinato;
        
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
