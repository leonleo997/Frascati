package implementation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.osoa.sca.annotations.Reference;

import interfaces.IMerge;
import interfaces.IPartialSort;
import interfaces.ISort;

public class Control implements ISort {
	
	@Reference(name="IPartialSort1")
	private IPartialSort partialSort1;
	@Reference(name="IPartialSort2")
	private IPartialSort partialSort2;
	@Reference(name="IPartialSort3")
	private IPartialSort partialSort3;
	@Reference(name="IPartialSort4")
	private IPartialSort partialSort4;
	@Reference(name="IPartialSort5")
	private IPartialSort partialSort5;
	@Reference(name="IPartialSort6")
	private IPartialSort partialSort6;
	@Reference(name="IPartialSort7")
	private IPartialSort partialSort7;
	@Reference(name="IPartialSort8")
	private IPartialSort partialSort8;
	@Reference(name="IMerge")
	private IMerge merge;
	
	private ArrayList<Character> lista1;
	private ArrayList<Character> lista2;
	private ArrayList<Character> lista3;
	private ArrayList<Character> lista4;
	private ArrayList<Character> lista5;
	private ArrayList<Character> lista6;
	private ArrayList<Character> lista7;
	private ArrayList<Character> lista8;

	
	//Este hilo es el que me permitir hacer los sorts paralelamente entregndoles los TPartialSorts
	private ArrayList<ArrayList<Character>> listasArrayList;
	
	private CyclicBarrier barreraFin;
	
	@Override
	public ArrayList<Character> sort(ArrayList<Character> lista) {
		// TODO Auto-generated method stub
		barreraFin = new CyclicBarrier(7);
		System.out.println("****La operacion fue recibida, tamanio: " + lista.size() +" #s****");		
		
		listasArrayList = new ArrayList<ArrayList<Character>>();

		
		int m1 = (lista.size()-1)/2; //50% --
		int m2 = m1/2; //25% --
		int m4 = m2/2; //12% --
	    int m3 = m2+m4; //37% --
	    int m5 = m1+m4; //62%
	    int m6 = m1+m2; //75%
	    int m7 = m6+m4; //88%
	    
		
		lista1 = new ArrayList<Character>(lista.subList(0, m4));
		lista2 = new ArrayList<Character>(lista.subList(m4+1, m2));
		lista3 = new ArrayList<Character>(lista.subList(m2+1, m3));
		lista4 = new ArrayList<Character>(lista.subList(m3+1, m1));
		lista5 = new ArrayList<Character>(lista.subList(m1+1, m5));
		lista6 = new ArrayList<Character>(lista.subList(m5+1, lista.size()-1));
		lista7 = new ArrayList<Character>(lista.subList(m6+1, m7));
		lista8 = new ArrayList<Character>(lista.subList(m7+1, lista.size()-1));


		Thread t1 = new Thread() {
            public void run() {
            	lista1=partialSort1.partialSort(lista1,0,lista1.size()-1);
                System.out.println("hilo ejecutandose");
                try {                	
                    barreraFin.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
		};
		
		
		Thread t2 = new Thread() {
            public void run() {
            	
            	lista2=partialSort2.partialSort(lista2,0,lista2.size()-1);
                try {
                    
                    System.out.println("hilo ejecutandose");
                    barreraFin.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
		};
		Thread t3 = new Thread() {
            public void run() {
            	
            	lista3=partialSort3.partialSort(lista3,0,lista3.size()-1);
                try {
                    
                    System.out.println("hilo ejecutandose");
                    barreraFin.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
		};
		Thread t4 = new Thread() {
            public void run() {
            	
            	lista4=partialSort4.partialSort(lista4,0,lista4.size()-1);
                try {
                    
                    System.out.println("hilo ejecutandose");
                    barreraFin.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
		};
		Thread t5 = new Thread() {
            public void run() {
            	
            	lista5=partialSort5.partialSort(lista5,0,lista5.size()-1);
                try {
                    
                    System.out.println("hilo ejecutandose");
                    barreraFin.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
		};
		Thread t6 = new Thread() {
            public void run() {
            	
            	lista6=partialSort6.partialSort(lista6,0,lista6.size()-1);
                try {
                    
                    System.out.println("hilo ejecutandose");
                    barreraFin.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
		};
		Thread t7 = new Thread() {
            public void run() {
            	
            	lista7=partialSort7.partialSort(lista7,0,lista7.size()-1);
                try {
                    
                    System.out.println("hilo ejecutandose");
                    barreraFin.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
		};
		Thread t8 = new Thread() {
            public void run() {
            	
            	lista8=partialSort8.partialSort(lista8,0,lista8.size()-1);
                try {
                    
                    System.out.println("hilo ejecutandose");
                    barreraFin.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
		};

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();


		
		try {
			barreraFin.await();

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
        System.out.println("Todos los nodos ya ordenaron");
        
        
        listasArrayList.add(lista1);
        listasArrayList.add(lista2);
        listasArrayList.add(lista3);
        listasArrayList.add(lista4);
        listasArrayList.add(lista5);
        listasArrayList.add(lista6);
        listasArrayList.add(lista7);
        listasArrayList.add(lista8);

        
        lista = merge.merge(listasArrayList, lista.size());
		
		System.out.println("****La operacion finalizada****");
		
		return lista;
	}
	
}
