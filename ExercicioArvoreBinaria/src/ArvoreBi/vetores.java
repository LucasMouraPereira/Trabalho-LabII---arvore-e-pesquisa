package ArvoreBi;

import java.util.Random;

public class vetores {
	
	int[] vetorA = new int[10000000];
	int[] vetorB = new int[10000000];
	int[] vetorC = new int[10000000];
	
	Random gerador = new Random();
	CArvBin arvoreA = new CArvBin();
	CArvBin arvoreB = new CArvBin();
	CArvBin arvoreC = new CArvBin();
	
	public void crescente() {
		for (int i = 0; i < 10000000; i++) {
			for(int j =0; j < 10000000; j++) {
				if(vetorA[i] < vetorA[j]) {
					int aux = vetorA [i];
					vetorA[i] = vetorA[j];
					vetorA[j] = aux;
				}
			}
        }
		for(int j =0; j < 10000000; j++) {
			arvoreA.put(j,vetorA[j]);			
		}		
	}
	
	public void decrescente() {
		for (int i = 0; i < 10000000; i++) {
			for(int j =0; j < 10000000; j++) {
				if(vetorB[i] > vetorB[j]) {
					int aux = vetorB [i];
					vetorB[i] = vetorB[j];
					vetorB[j] = aux;
				}
			}   
        }
		for(int j =0; j < 10000000; j++) {
			arvoreB.put(j,vetorA[j]);
		}
	}
	public void random() {
		int i = 0;
		vetorC [i] = gerador.nextInt(9999999);
		
		for(int j =0; j < 10000000; j++) {
			arvoreC.put(j,vetorC[j]);
		}
	}
}
