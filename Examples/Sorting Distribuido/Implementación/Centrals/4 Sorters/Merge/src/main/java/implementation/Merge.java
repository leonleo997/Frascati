package implementation;

import java.util.ArrayList;

import interfaces.IMerge;

public class Merge implements IMerge{
	
	@Override
	public ArrayList<Character> merge(ArrayList<ArrayList<Character>> listas, int tamanioListafinal) {
		
		ArrayList<Character> listaOrdenada = new ArrayList<Character>();
		
		
		int w = 0;//lista1
		int x = 0;//lista2
		int y = 0;//lista3
		int z = 0;//lista4
//		int a = 0;//lista5
//		int b = 0;//lista6
//		int c = 0;//lista7
//		int d = 0;//lista8


		ArrayList<Character> lista1 = listas.get(0);
		ArrayList<Character> lista2 = listas.get(1);
		ArrayList<Character> lista3 = listas.get(2);
		ArrayList<Character> lista4 = listas.get(3);
//		ArrayList<Character> lista5 = listas.get(4);
//		ArrayList<Character> lista6 = listas.get(5);
//		ArrayList<Character> lista7 = listas.get(6);
//		ArrayList<Character> lista8 = listas.get(7);


		for (int i = 0; i < tamanioListafinal; i++) {

			if(lista1.get(w).compareTo(lista2.get(x))<=0
			&& lista1.get(w).compareTo(lista3.get(y))<=0
			&& lista1.get(w).compareTo(lista4.get(z))<=0) {
				listaOrdenada.add(lista1.get(w));
				if(w<lista1.size()-1) {
					w++;
				}
			}
			
			else if(lista2.get(x).compareTo(lista1.get(w))<=0
			&& lista2.get(x).compareTo(lista3.get(y))<=0
			&& lista2.get(x).compareTo(lista4.get(z))<=0) {
				listaOrdenada.add(lista2.get(x));
				if(x<lista2.size()-1) {
				x++;	
				}
			}
			
			else if(lista3.get(y).compareTo(lista1.get(w))<=0
			&& lista3.get(y).compareTo(lista2.get(x))<=0
			&& lista3.get(y).compareTo(lista4.get(z))<=0) {
				listaOrdenada.add(lista3.get(y));
				if(y<lista3.size()-1) {
					y++;
				}
			}
			
			else if(lista4.get(z).compareTo(lista1.get(w))<=0
			&& lista4.get(z).compareTo(lista2.get(x))<=0
			&& lista4.get(z).compareTo(lista3.get(y))<=0) {
				listaOrdenada.add(lista4.get(z));
				if(z<lista4.size()-1) {
					z++;
				}
			}
			
//			else if(lista5.get(a).compareTo(lista1.get(w))<=0
//			&& lista5.get(a).compareTo(lista2.get(x))<=0
//			&& lista5.get(a).compareTo(lista3.get(y))<=0
//			&& lista5.get(a).compareTo(lista4.get(z))<=0
//			&& lista5.get(a).compareTo(lista6.get(b))<=0
//			&& lista5.get(a).compareTo(lista7.get(c))<=0
//			&& lista5.get(a).compareTo(lista8.get(d))<=0) {
//				listaOrdenada.add(lista5.get(a));
//				if(a<lista5.size()-1) {
//					a++;
//				}
//			}
//			
//			else if(lista6.get(b).compareTo(lista1.get(w))<=0
//			&& lista6.get(b).compareTo(lista2.get(x))<=0
//			&& lista6.get(b).compareTo(lista3.get(y))<=0
//			&& lista6.get(b).compareTo(lista5.get(a))<=0
//			&& lista6.get(b).compareTo(lista4.get(z))<=0
//			&& lista6.get(b).compareTo(lista7.get(c))<=0
//			&& lista6.get(b).compareTo(lista8.get(d))<=0) {
//				listaOrdenada.add(lista6.get(b));
//				if(b<lista6.size()-1) {
//					b++;
//				}
//			}
//			
//			else if(lista7.get(c).compareTo(lista1.get(w))<=0
//			&& lista7.get(c).compareTo(lista2.get(x))<=0
//			&& lista7.get(c).compareTo(lista3.get(y))<=0
//			&& lista7.get(c).compareTo(lista5.get(a))<=0
//			&& lista7.get(c).compareTo(lista4.get(z))<=0
//			&& lista7.get(c).compareTo(lista6.get(b))<=0
//			&& lista7.get(c).compareTo(lista8.get(d))<=0) {
//				listaOrdenada.add(lista7.get(c));
//				if(c<lista7.size()-1) {
//					c++;
//				}
//			}
//			
//			else if(lista8.get(d).compareTo(lista1.get(w))<=0
//			&& lista8.get(d).compareTo(lista2.get(x))<=0
//			&& lista8.get(d).compareTo(lista3.get(y))<=0
//			&& lista8.get(d).compareTo(lista5.get(a))<=0
//			&& lista8.get(d).compareTo(lista4.get(z))<=0
//			&& lista8.get(d).compareTo(lista7.get(c))<=0
//			&& lista8.get(d).compareTo(lista6.get(b))<=0) {
//				listaOrdenada.add(lista8.get(d));
//				if(d<lista8.size()-1) {
//					d++;
//				}
//			}
//	
			
		}	
		
		System.out.println("La lista "+listaOrdenada.size()+" se ha ordenado");
		
		return listaOrdenada;
	}
	


}
