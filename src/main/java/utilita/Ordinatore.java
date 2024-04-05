/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import com.mycompany._libreria_4b.Libro;

/**
 * Classe che contierne metodi statici 
 * per ordianre dei vettori
 * @author gian
 */
public class Ordinatore 
{
    /**
     * Scambia fra di loro gli elementi
     * in posizione pos1 e in  posizione pos2
     * di un array di interi v
     * @param v 
     * @param pos1 
     * @param pos2 
     */
    public static void scambia(int[] v, int pos1,int pos2)
    {
        int sost;
        sost=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=sost;
    }
    
    /**
     * 
     * Scambia fra di loro gli elementi
     * in posizione pos1 e in  posizione pos2
     * di un array di stringhe v
     * @param v 
     * @param pos1 
     * @param pos2 
     */
    public static void scambia(String[] v, int pos1,int pos2)
    {
        String sost;
        sost=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=sost;
    }
    
    /**
     * Restituisce una copia ordinata 
     * in ordine crescente di un vettore
     * v utilizzando l'algoritmo selction sort
     * @param v il vettore da ordinare
     * @return il vettore in ordine crescente
     */
    public static int[] selectionSortCrescente(int[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        int[] vOrdinato=new int[lunghezza];
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if (vOrdinato[j]<vOrdinato[i])
                    scambia(vOrdinato, i, j);
            }
        }
       return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata 
     * in ordine decrescente di un vettore
     * v utilizzando l'algoritmo selction sort
     * @param v il vettore da ordinare
     * @return il vettore in ordine decrescente
     */
    public static int[] selectionSortDecrescente(int[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        int[] vOrdinato=new int[lunghezza];
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if (vOrdinato[j]>vOrdinato[i])
                    scambia(vOrdinato, i, j);
            }
        }
       return vOrdinato;
    }
    
    
    /**
     * Restituisce una copia ordinata 
     * in ordine alfabetico crescente di un vettore
     * di stringhe v utilizzando l'algoritmo selction sort
     * @param v il vettore da ordinare
     * @return il vettore in ordine crescente
     */
    public static String[] selectionSortCrescente(String[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        String[] vOrdinato=new String[lunghezza];
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if (vOrdinato[j].compareToIgnoreCase(vOrdinato[i])<0)
                    scambia(vOrdinato, i, j);
            }
        }
       return vOrdinato;
    }
    
      /**
     * Restituisce una copia ordinata 
     * in ordine alfabetico decrescente di un vettore
     * di stringhe v utilizzando l'algoritmo selction sort
     * @param v il vettore da ordinare
     * @return il vettore in ordine decrescente
     */
    public static String[] selectionSortDecrescente(String[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        String[] vOrdinato=new String[lunghezza];
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if (vOrdinato[j].compareToIgnoreCase(vOrdinato[i])>0)
                    scambia(vOrdinato, i, j);
            }
        }
       return vOrdinato;
    }
    
    //BUBBLE SORT
        /**
         * Ordinamento crescente con bubble sort di un array di interi
         * @param a l'array ordinato
         * @return 
         */
        public static int[] bubbleSortCrescente(int[] a)
        {
            
            boolean scambioAvvenuto;
            int N=a.length;
            int[] ordinato=new int[N];
            //copio i valori di a nel nuovo vettore
            for (int i=0;i<N;i++)
            {
                ordinato[i]=a[i];
            }
            //Bubble sort
            do 
            {
                scambioAvvenuto=false;
                
                for(int i=0;i<N-1;i++)
                {
                    if (ordinato[i]>ordinato[i+1])
                    {
                        scambia(ordinato, i, i+1);
                        scambioAvvenuto=true;
                    }
                }
            }while (scambioAvvenuto);
           return ordinato; 
        } 
        
        /**
         * Ordinamento decrescente con bubble sort di un array di interi
         * @param a l'array ordinato
         * @return 
         */
        public static int[] bubbleSortDecrescente(int[] a)
        {
            
            boolean scambioAvvenuto;
            int N=a.length;
            int[] ordinato=new int[N];
            //copio i valori di a nel nuovo vettore
            for (int i=0;i<N;i++)
            {
                ordinato[i]=a[i];
            }
            //Bubble sort
            do 
            {
                scambioAvvenuto=false;
                
                for(int i=0;i<N-1;i++)
                {
                    if (ordinato[i]<ordinato[i+1])
                    {
                        scambia(ordinato, i, i+1);
                        scambioAvvenuto=true;
                    }
                }
            }while (scambioAvvenuto);
           return ordinato; 
        } 
       
    /**
         * Ordinamento crescente con bubble sort di un array di stringhe
         * @param a l'array ordinato
         * @return 
         */
        public static String[] bubbleSortCrescente(String[] a)
        {
            
            boolean scambioAvvenuto;
            int N=a.length;
            String[] ordinato=new String[N];
            //copio i valori di a nel nuovo vettore
            for (int i=0;i<N;i++)
            {
                ordinato[i]=a[i];
            }
            //Bubble sort
            do 
            {
                scambioAvvenuto=false;
                
                for(int i=0;i<N-1;i++)
                {
                    if (ordinato[i].compareTo(ordinato[i+1])>0)
                    {
                        scambia(ordinato, i, i+1);
                        scambioAvvenuto=true;
                    }
                }
            }while (scambioAvvenuto);
           return ordinato; 
        } 
        
        
        /**
         * Ordinamento decrescente con bubble sort di un array di stringhe
         * @param a l'array ordinato
         * @return 
         */
        public static String[] bubbleSortDecrescente(String[] a)
        {
            
            boolean scambioAvvenuto;
            int N=a.length;
            String[] ordinato=new String[N];
            //copio i valori di a nel nuovo vettore
            for (int i=0;i<N;i++)
            {
                ordinato[i]=a[i];
            }
            //Bubble sort
            do 
            {
                scambioAvvenuto=false;
                
                for(int i=0;i<N-1;i++)
                {
                    if (ordinato[i].compareTo(ordinato[i+1])<0)
                    {
                        scambia(ordinato, i, i+1);
                        scambioAvvenuto=true;
                    }
                }
            }while (scambioAvvenuto);
           return ordinato; 
        } 
        
     /**
     * Scambia fra di loro gli elementi
     * in posizione pos1 e in  posizione pos2
     * di un array di libri v
     * @param v 
     * @param pos1 
     * @param pos2 
     */
    public static void scambia(Libro[] v, int pos1,int pos2)
    {
        Libro sost;
        sost=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=sost;
    }
    
     /**
     * Restituisce una copia ordinata 
     * in ordine alfabetico di titolo di un vettore
     * di libri v utilizzando l'algoritmo selction sort
     * @param v il vettore da ordinare
     * @return il vettore in ordine crescente
     */
    public static Libro[] ordinaLibriCrescente(Libro[] v)
    {
        int lunghezza=v.length;
        //Creo una copia di v e lo chiamo vOrdinato
        Libro[] vOrdinato=new Libro[lunghezza];
        for(int i=0;i<lunghezza;i++)
            vOrdinato[i]=v[i];
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if (vOrdinato[i].getTitolo().compareToIgnoreCase(vOrdinato[j].getTitolo())>0)
                    scambia(vOrdinato, i, j);
            }
        }
       return vOrdinato;
    }
    
}
