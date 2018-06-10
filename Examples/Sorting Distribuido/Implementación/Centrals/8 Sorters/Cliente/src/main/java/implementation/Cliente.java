package implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.osoa.sca.annotations.Reference;

import interfaces.ISort;

public class Cliente implements Runnable {
	
	@Reference(name="ISort")
	private ISort sort;
	
	private GeneradorArchivos generador;
	
	private ArrayList<Character> lista;
	
	public void setSort(ISort sort) {
		this.sort = sort;
	}

	@Override
	public void run() {
		
		System.out.println("Intenta hacer peticion de Sort");
		System.out.println("===========================================================================");
		
		generador = new GeneradorArchivos();
		generador.generarArhivos();
		System.out.println("Se generaron los archivos");
		
		try {
			for (int i = 0; i < GeneradorArchivos.tamanos.length; i++) {
				lista = new ArrayList<Character>();
				BufferedReader br = new BufferedReader(new FileReader(GeneradorArchivos.ruta+"archivo"+(i+1)));
				for (int j = 0; j < GeneradorArchivos.tamanos[i]; j++) {
					lista.add(br.readLine().charAt(0));
				}
				br.close();
				System.out.println("Se obtuvo el arreglo "+(i+1)+" de tamano "+GeneradorArchivos.tamanos[i]);
				long t1 = System.currentTimeMillis();
				lista = sort.sort(lista);
				long t2 = System.currentTimeMillis();
				long tiempo = t2-t1;
				System.out.println("Se ordeno el arreglo "+(i+1)+" en "+tiempo+" milisegundos");
				
				File archivo = new File("./src/main/resources/"+"archivo"+lista.size());
				if (archivo.exists() == false) {
					try {
						archivo.createNewFile();
						PrintWriter pw = new PrintWriter(new FileWriter(archivo));
						for (int j = 0; j < lista.size(); j++) {
							if(j<lista.size()-1) {
								pw.write("" + lista.get(j) + "\n");
							}
							else {
								pw.write("" + lista.get(j));
							}
						
						}
						pw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}	
				}
			}
			System.out.println("Fin... :)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

}
