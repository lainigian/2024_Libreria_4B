/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.util.Scanner;

/**
 *
 * @author gian
 */
public class Menu 
{
    private String[] elencoVoci;
    private int numeroVoci;
    
    public Menu(String[] elenco)
    {
        numeroVoci=elenco.length;
        elencoVoci=new String [numeroVoci];
        for (int i=0;i<numeroVoci;i++)
            this.elencoVoci[i]=elenco[i];
    }
    
    public void visualizzaMenu()
    {
        for(int i=0;i<numeroVoci;i++)
        {
            System.out.println(elencoVoci[i]);
        }
    }
    
    public int sceltaMenu()
    {
        Scanner tastiera=new Scanner (System.in);
        int scelta=0;
        String sceltaStringa;
        boolean sceltaOK=true;
        
        do
        {
            sceltaOK=true;
            visualizzaMenu();
            System.out.println("Scegli --> ");
            sceltaStringa=tastiera.nextLine(); 
            //controllo che il primo carattere inserito 
            //sia un numero compreso fra 0 e 9
            if (sceltaStringa.charAt(0)<'0' || sceltaStringa.charAt(0)>'9')
            {
                sceltaOK=false;
                System.out.println("Input non corretto.");
            }
                
            else
            {
                //per ottenere "scelta" numerico, converto in intero la 
                //sottostringa costituirta dal solo primo carattere di
                //sceltaStringa
                String s="0";
                scelta=Integer.parseInt(s+sceltaStringa.charAt(0));
                //Verifico che la scelta non sia
                //minore di 0 e non sia maggiore o uguale 
                //al numero di voci
                if (scelta<0 || scelta >= numeroVoci)
                {
                    sceltaOK=false; 
                    System.out.println("Scelta non valida. Inserire un numero compreso fra 0 e "+(numeroVoci-1));
                }
                    
            }
        } while (!sceltaOK);
        return scelta;
    }
    
}
