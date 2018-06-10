package implementation;

import java.util.ArrayList;

import interfaces.ISort;

public class Insertion implements ISort {



	public ArrayList sort(ArrayList lista) {

		int largest;

		for (int i = 0; i < lista.size() - 1; i++)

		{

			largest = 0;

			for (int j = largest + 1; j < lista.size() - i; j++)

			{

				if (((Comparable) lista.get(largest)).compareTo(lista.get(j)) < 0)

				{

					largest = j;

				}

			}

			Comparable temp = (Comparable) lista.get(lista.size() - 1 - i);

			lista.set(lista.size() - 1 - i, lista.get(largest));

			lista.set(largest, temp);
			
		

		}
		return lista;
	}

}
