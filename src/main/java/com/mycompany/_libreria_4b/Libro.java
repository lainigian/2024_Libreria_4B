/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._libreria_4b;

import java.io.Serializable;

/**
 * Rappresenta un libro
 * costoPagina rappresenta il costo per realizzare ciascuna pagina del libro
 * COSTO FISSO rappresenta il costo fisso pre realizzare una copia del libro.
 * @author gian
 */
public class Libro implements Serializable
{
    private String titolo;
    private String autore;
    private int numeroPagine;
    private static double costoPagina=0.05;
    private final double COSTO_FISSO=5.5;

    /**
     * Costruttore
     * @param titolo titolo del libro
     * @param autore autore del libro
     * @param numeroPagine  numero pagine del libro
     */
    public Libro(String titolo, String autore, int numeroPagine) {
        this.titolo = titolo;
        this.autore = autore;
        this.numeroPagine = numeroPagine;
    }
    
    /**
     * Costruttore di copia
     * @param libro 
     */
    public Libro (Libro libro)
    {
        this.titolo=libro.getTitolo();
        this.autore=libro.getAutore();
        this.numeroPagine=libro.getNumeroPagine();
    }
    
    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public static double getCostoPagina() {
        return costoPagina;
    }

    public static void setCostoPagina(double costoP) 
    {
        costoPagina = costoP;
    }
    
    public double getCostoFisso()
    {
        return COSTO_FISSO;
    }
    
    /**
     * Calcola il prezzo di vendita di un libro
     * come somma fra il costo fisso e il prodotto
     * numeroPagine*costoPagina
     * @return 
     */
    public double prezzo()
    {
        double p;
        p=COSTO_FISSO+getCostoPagina()*getNumeroPagine();
        return p;
    }
    
    /**
     * Restituisce una stringa che contiene i dati di un libro
     * @return 
     */
    public String toString()
    {
        String s=getTitolo()+";"+getAutore()+";"+getNumeroPagine()+";"+prezzo()+"€";
        return s;
    }
}
