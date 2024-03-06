/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreria_4b;

/**
 *
 * @author gian
 */
public class Mensola 
{
    private final static int NUM_MAX_VOLUMI=15;
    private Libro[] volumi; 
    
    public Mensola()
    {
        volumi=new Libro[NUM_MAX_VOLUMI];
    }
    /**
     * Costruttore di copia
     * @param m 
     */
    
    public Mensola(Mensola m)
    {
         volumi=new Libro[NUM_MAX_VOLUMI];
         Libro lib;
         for(int i=0; i<m.getNumMaxVolumi();i++)
         {
             lib=m.getVolume(i);
             if (lib!=null)
                this.setVolume(lib, i);        
         }
    }
    
    public Mensola(Libro[] elencoLibri)
    {
         volumi=new Libro[NUM_MAX_VOLUMI];
         int numeroLibriDaAggiungere;
         
         //se i li bri da aggiungere sono troppi
         //ne aggiungo solo NUM_MAX_VOLUMI
         numeroLibriDaAggiungere=elencoLibri.length;
         if (numeroLibriDaAggiungere>NUM_MAX_VOLUMI)
             numeroLibriDaAggiungere=NUM_MAX_VOLUMI;
        
         //Copio l'i-esimo libro dell'array in  volumi
         for (int i=0;i<numeroLibriDaAggiungere;i++)
         {
             if (elencoLibri[i]!=null)
                setVolume(elencoLibri[i], i);
         }
         
         
    }
    
    /**
     * Aggiunge il volume alla mensola in posizione "posizione"
     * @param volume
     * @param posizione
     * @return 
     *  se la posizione non esiste --> return -1
        se la posizione è già occupata --> return -2
        se il libro viene posizionato --> return posizione

     */
    public int setVolume(Libro volume, int posizione)
    {
       /* if (posizione<0 || posizione>=NUM_MAX_VOLUMI)
            return -1; //Posizione non valida
       */
        
        try
        {
            if(volumi[posizione]!=null)
                return -2; //Posizione già occupata
            volumi[posizione]=new Libro(volume);
            return posizione;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return -1;
        }
        
        
    }
    
    /**
     * Restiuisce una compia del volume che si trova in posizione
     * @param posizione
     * @return 
     *  se la posizione è vuota --> return null
     *   se la posizione non è valida --> return null
     *   altrimenti --> return una copia del libro
     */
    public Libro getVolume(int posizione)
    {
        Libro lib;
        
    /*   if (posizione<0 || posizione>=NUM_MAX_VOLUMI)
            return null; 
    */  
        
        try
        {
            /*if (volumi[posizione]==null)
                return null;         */
            lib=volumi[posizione];
            return new Libro(lib); //restituisco una copia del libro
        }
        catch(ArrayIndexOutOfBoundsException | NullPointerException e)
        {
            return null;
        }
        
    }
    
    /**
     * Rimuove dalla mensola il volume
     * che si trova in posizione
     * @param posizione
     * @return 
     * se la posizione non è valida --> return -1
     * se la posizione è già vuota --> return -2
     * altrimenti --> return la posizione liberata
     */
    public int rimuoviVolume(int posizione)
    {
    /*    if(posizione<0 || posizione>NUM_MAX_VOLUMI)
            return -1; //Posizione non valida
    */
    try
        {
            if (volumi[posizione]==null)
                return -2; //posizione già vuota
            volumi[posizione]=null;
            return posizione;
        }
    catch(ArrayIndexOutOfBoundsException e)
        {
        return -1;
        }
        
        
    }
    
    public int getNumMaxVolumi()
    {
        return NUM_MAX_VOLUMI;
    }
    
    /**
     * Restituisce il numero di volumi presenti nella mensola
     * @return 
     */
    public int getNumVolumi()
    {
        int contatore=0;
        for(int i=0;i<NUM_MAX_VOLUMI;i++)
        {
            if(volumi[i]!=null)
                contatore++;
        }
        return contatore;
    }
    
    /**
     * Restituisce una stringa che rappresenta tutti i volumi
     * presenti nello scaffale
     * @return 
     */
    public String toString()
    {
        String s="";
        for(int i=0;i<NUM_MAX_VOLUMI;i++)
        {
            if (volumi[i]==null)
                s+=i+"-->\n";
            else
                s+=i+"-->\t"+volumi[i].toString()+"\n";
        }
        
        return s;
    }
            
    //Fare presenza Titolo
}
