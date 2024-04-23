/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany._libreria_4b;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gian
 */
public class ScaffaleTest {
    
    public ScaffaleTest() {
    }

    
    
    
    /**
     * Test of setLibro method, of class Scaffale.
     */
    @Test
    public void testSetLibro() throws Exception 
    {
        Libro l1=new Libro("La divina commedia", "Dante",200);
        Libro atteso=new Libro("La divina commedia", "Dante",200);
        Libro attuale;
        Scaffale s1=new Scaffale();
        s1.setLibro(l1, 0, 0);
        attuale=s1.getLibro(0, 0);
        assertEquals(atteso, attuale, "set get Libto divina commedia");
    }

    /**
     * Test of getLibro method, of class Scaffale.
     */
    @Test
    public void testGetLibro() throws Exception {
    }

    /**
     * Test of rimuoviLibro method, of class Scaffale.
     */
    @Test
    public void testRimuoviLibro() throws Exception {
    }

    /**
     * Test of getNumRipiani method, of class Scaffale.
     */
    @Test
    public void testGetNumRipiani() {
    }

    /**
     * Test of getNumMaxLibri method, of class Scaffale.
     */
    @Test
    public void testGetNumMaxLibri_0args() {
    }

    /**
     * Test of getNumLibri method, of class Scaffale.
     */
    @Test
    public void testGetNumLibri_0args() {
    }

    /**
     * Test of getNumLibri method, of class Scaffale.
     */
    @Test
    public void testGetNumLibri_int() {
    }

    /**
     * Test of getNumMaxLibri method, of class Scaffale.
     */
    @Test
    public void testGetNumMaxLibri_int() {
    }

    /**
     * Test of elencoTitoliAutore method, of class Scaffale.
     */
    @Test
    public void testElencoTitoliAutore() {
    }

    /**
     * Test of elencoLibriOrdinatoPerTitolo method, of class Scaffale.
     */
    @Test
    public void testElencoLibriOrdinatoPerTitolo() {
    }

    /**
     * Test of toString method, of class Scaffale.
     */
    @Test
    public void testToString() {
    }
    
}
