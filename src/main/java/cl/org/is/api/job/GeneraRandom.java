/**
 * 
 */
package cl.org.is.api.job;

import java.util.Random;

/**
 * @author EA7129
 *
 */
public class GeneraRandom {
	
	public static  String Random() {
		// TODO Auto-generated method stub
		
		int n = 99; // numeros aleatorios
		int k = n; // auxiliar;
		int[] numeros = new int[n];
		int[] resultado = new int[n];
		Random rnd = new Random();
		int res;

		// se rellena una matriz ordenada del 1 al 31(1..n)
		for (int i = 0; i < n; i++) {
			numeros[i] = i + 1;
		}

		for (int i = 0; i < n; i++) {
			res = rnd.nextInt(k);
			resultado[i] = numeros[res];
			numeros[res] = numeros[k - 1];
			k--;

		}

		//Arrays.sort(resultado);
		// se imprime el resultado;
		System.out.println("El resultado de la matriz es:");
		
		String val = null;
		
		for (int i = 0; i < 1; i++) {
			
			String result = String.format("%02d", resultado[i]  );
			val = String.format("%02d", resultado[i]  );
			
			System.out.println(result);

			//System.out.println(resultado[i]);
			
			
		}
		return val;
		
		
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 99; // numeros aleatorios
		int k = n; // auxiliar;
		int[] numeros = new int[n];
		int[] resultado = new int[n];
		Random rnd = new Random();
		int res;

		// se rellena una matriz ordenada del 1 al 31(1..n)
		for (int i = 0; i < n; i++) {
			numeros[i] = i + 1;
		}

		for (int i = 0; i < n; i++) {
			res = rnd.nextInt(k);
			resultado[i] = numeros[res];
			numeros[res] = numeros[k - 1];
			k--;

		}

		//Arrays.sort(resultado);
		// se imprime el resultado;
		System.out.println("El resultado de la matriz es:");
		
		String val = null;
		
		for (int i = 0; i < 1; i++) {
			
			String result = String.format("%02d", resultado[i]  );
			val = String.format("%02d", resultado[i]  );
			
			System.out.println(result);

			//System.out.println(resultado[i]);
			
			
		}
		
		
		System.out.println("===="+val);
		
		System.out.println("=12==="+Random());
		
		

	}

}
