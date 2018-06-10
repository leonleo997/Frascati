package implementation;

import java.util.ArrayList;

import interfaces.ISort;

public class QuickSort implements ISort{
	

	@Override
	public ArrayList<Integer>sort(ArrayList<Integer> numeros) {
		
		quicksort(numeros, 0, numeros.size()-1);
		return numeros;
	}
	
	public static void quicksort(ArrayList<Integer> numeros, int izq, int der) {

		  int pivote=numeros.get(izq); // tomamos primer elemento como pivote
		  int i=izq; // i realiza la búsqueda de izquierda a derecha
		  int j=der; // j realiza la búsqueda de derecha a izquierda
		  int aux;
		 
		  while(i<j){            // mientras no se crucen las búsquedas
		     while(numeros.get(i)<=pivote && i<j) i++; // busca elemento mayor que pivote
		     while(numeros.get(j)>pivote) j--;         // busca elemento menor que pivote
		     if (i<j) {                      // si no se han cruzado                      
		         aux= numeros.get(i);                  // los intercambia
		         numeros.set(i, numeros.get(j));
		         numeros.set(j, aux);
		     }
		   }
		  numeros.set(izq, numeros.get(j));; // se coloca el pivote en su lugar de forma que tendremos
		   numeros.set(j, pivote); // los menores a su izquierda y los mayores a su derecha
		   if(izq<j-1)
		      quicksort(numeros,izq,j-1); // ordenamos subarray izquierdo
		   if(j+1 <der)
		      quicksort(numeros,j+1,der); // ordenamos subarray derecho
		}

}
