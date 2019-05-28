package ArvoreBi;

import java.util.Random;

public class vetorParte2 {
	int[] vetorA = new int[10000000];
	int[] vetorB = new int[10000000];
	int[] vetorC = new int[10000000];

	Random gerador = new Random();
	CArvBin arvoreA = new CArvBin();
	CArvBin arvoreB = new CArvBin();
	CArvBin arvoreC = new CArvBin();

	public void crescente() {
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 10000; j++) {
				if (vetorA[i] < vetorA[j]) {
					int aux = vetorA[i];
					vetorA[i] = vetorA[j];
					vetorA[j] = aux;
				}
			}
		}
	}

	public void decrescente() {
		for (int i = 0; i < 10000; i++) {
			for (int j = 0; j < 10000; j++) {
				if (vetorB[i] > vetorB[j]) {
					int aux = vetorB[i];
					vetorB[i] = vetorB[j];
					vetorB[j] = aux;
				}
			}
		}
	}

	public void random() {
		int i = 0;
		vetorC[i] = gerador.nextInt(9999);
	}

	public static void BBSortClassico(int[] vetor) {
		int i, j, temp;
		for (i = 0; i < vetor.length - 1; i++)
			for (j = 0; j < vetor.length - 1; j++)
				if (vetor[j] > vetor[j + 1]) {
					temp = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = temp;
				}
	}

	public static void BBSortAdap1(int[] vetor) {
		int i, temp;
		boolean HouveTroca = true;
		while (HouveTroca) {
			HouveTroca = false;
			for (i = 0; i < vetor.length - 1; i++)
				if (vetor[i] > vetor[i + 1]) {
					temp = vetor[i];
					vetor[i] = vetor[i + 1];
					vetor[i + 1] = temp;
					HouveTroca = true;
				}
		}
	}

	public static void BBSortAdap2(int[] vetor) {
		int i, j, temp, cont;
		cont = vetor.length - 1;
		for (i = 0; i < vetor.length - 1; i++) {
			for (j = 0; j < cont; j++)
				if (vetor[j] > vetor[j + 1]) {
					temp = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = temp;
				}
			cont--;
		}
	}
}