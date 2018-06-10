package implementation;

import java.util.ArrayList;

import interfaces.ISort;

public class BubbleSort implements ISort {

	@Override
	public ArrayList<Integer> sort(ArrayList<Integer> arreglo) {
		double tiempoInicio = System.currentTimeMillis();
		System.out.println("La cantidad de numeros a ordenar es de "+arreglo.size());
		bubbleSort(arreglo);
		double tiempoFinal = System.currentTimeMillis();
		System.out.println( "Tiempo: " + ((double)(tiempoFinal-tiempoInicio)) + " ms"  );
		System.out.println("Se ha ordenado el arreglo");
		return arreglo;
	}
	
	static void bubbleSort(ArrayList<Integer> arreglo) {  
        int n = arreglo.size();  
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(arreglo.get(j-1) > arreglo.get(j)){  
                                 //swap elements  
                                 temp = arreglo.get(j-1);  
                                 arreglo.set(j-1, arreglo.get(j));
                                 arreglo.set(j, temp);  
                         }  
                          
                 }  
         }  
  
    }  
    
}
