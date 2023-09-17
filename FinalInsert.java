package pruebasfinales;

import java.util.*;
import java.io.*;

import com.panayotis.gnuplot.GNUPlotParameters;
import com.panayotis.gnuplot.JavaPlot;

public class FinalInsert {

	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("insertionsort.dat"));
		
		Random random = new Random();
		int[] num = new int[1001];
		long inicio, tiempo;
		
		for(int i=1; i<num.length; i++) {
			num[i]=random.nextInt(1500);
			inicio = System.nanoTime();
			insertionSort(num);
			tiempo = System.nanoTime()-inicio;
			bw.write(i+"\t"+tiempo+"\n");
		}bw.close();
		
		JavaPlot jp = new JavaPlot();
		jp.addPlot("\"insertionsort.dat\"with lines");
		jp.setTitle("Ordenamiento por Insercion");
		GNUPlotParameters params = jp.getParameters();
		params.set("xlabel","'Cantidad de datos'");
		params.set("ylabel","'Tiempo en nanosegundos'");
		
		params.set("grid");
	}
	
	static void insertionSort(int[] lista) {
		for (int i = 1; i < lista.length; i++) {
            int key = lista[i];
            
            int j = i - 1;
             while (j >= 0 && lista[j] > key) {
                lista[j + 1] = lista[j];
                j--;
            }
            lista[j + 1] = key;
        }
	}

}