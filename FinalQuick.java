package pruebasfinales;

import java.util.*;
import java.io.*;

import com.panayotis.gnuplot.GNUPlotParameters;
import com.panayotis.gnuplot.JavaPlot;

public class FinalQuick {
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("quicksort.dat"));
		Random random = new Random();
		int[] num = new int[1001];
		long inicio, tiempo;
		
		for(int i=1; i<num.length; i++) {
			num[i]=random.nextInt(1500);
			inicio = System.nanoTime();
			quickSort(num, 0, num.length - 1);
			tiempo = System.nanoTime()-inicio;
			bw.write(i+"\t"+tiempo+"\n");
		}bw.close();
		
		JavaPlot jp = new JavaPlot();
		jp.addPlot("\"quicksort.dat\"with lines");
		jp.setTitle("Ordenamiento Quick");
		GNUPlotParameters params = jp.getParameters();
		params.set("xlabel","'Cantidad de datos'");
		params.set("ylabel","'Tiempo en nanosegundos'");
		
		params.set("grid");
	}
	
	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int partition(int[] arr, int low, int high){
		
		int pivot = arr[high];

		int i = (low - 1);

		for (int j = low; j <= high - 1; j++) {

			if (arr[j] < pivot) {

				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	static void quickSort(int[] arr, int low, int high)
	{
		if (low < high) {

			int pi = partition(arr, low, high);

			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}
	
}
