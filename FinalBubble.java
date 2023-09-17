package pruebasfinales;

import java.util.*;
import java.io.*;

import com.panayotis.gnuplot.GNUPlotParameters;
import com.panayotis.gnuplot.JavaPlot;

public class FinalBubble {
	
	public static void main(String args[]) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter("bubblesort.dat"));
		Random random = new Random();
		int[] num = new int[100];
		long inicio, tiempo;
		
		for(int i=1; i<num.length; i++) {
			num[i]=random.nextInt(1500);
			inicio = System.nanoTime();
			bubbleSort(num, num.length);
			tiempo = System.nanoTime()-inicio;
			bw.write(i+"\t"+tiempo+"\n");
		}bw.close();
		
		JavaPlot jp = new JavaPlot();
		jp.addPlot("\"bubblesort.dat\"with lines");
		jp.setTitle("Ordenamiento por Burbuja");
		GNUPlotParameters params = jp.getParameters();
		params.set("xlabel","'Cantidad de datos'");
		params.set("ylabel","'Tiempo en nanosegundos'");
		
		params.set("grid");
		
	}
	
	static void bubbleSort(int arr[], int n){
		int i, j, temp;
		boolean swapped;
		
		for (i = 0; i < n - 1; i++) {
			swapped = false;
				for (j = 0; j < n - i - 1; j++) {
					if (arr[j] > arr[j + 1]) {
						temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
						swapped = true;
					}
				}

					if (swapped == false)
						break;
				}
			}

}
