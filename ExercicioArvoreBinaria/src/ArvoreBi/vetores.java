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
		for (int i = 0; i < 10000; i++) {
			for(int j =0; j < 10000; j++) {
				if(vetorA[i] < vetorA[j]) {
					int aux = vetorA [i];
					vetorA[i] = vetorA[j];
					vetorA[j] = aux;
				}
			}
        }
		long tempoInicial = System.currentTimeMillis();
		for(int j =0; j < 10000; j++) {
			arvoreA.put(j,vetorA[j]);		
		}		
		long tempoFinal = System.currentTimeMillis();
		long tempoInicialPesquisa = System.currentTimeMillis();
		for(int j =0; j < 10000; j++) {
			arvoreA.get(j);		
		}		
		long tempoFinalPesquisa = System.currentTimeMillis();
		long tempoTotalInserir = tempoFinal-tempoInicial;
		long tempoTotalPesquisa = tempoFinalPesquisa - tempoInicialPesquisa;
       System.out.println("Crescente em milisegundos(Pesquisa)"+tempoTotalPesquisa);
       System.out.println("Crescente em milisegundos(Inser��o)"+tempoTotalInserir);
	
	}
	
	public void decrescente() {
		for (int i = 0; i < 10000; i++) {
			for(int j =0; j < 10000; j++) {
				if(vetorB[i] > vetorB[j]) {
					int aux = vetorB [i];
					vetorB[i] = vetorB[j];
					vetorB[j] = aux;
				}
			}   
        }
		long tempoInicial = System.currentTimeMillis();
		for(int j =0; j < 10000; j++) {
			
			arvoreB.put(j,vetorA[j]);
		}
		long tempoFinal = System.currentTimeMillis();
		
		long tempoInicialPesquisa = System.currentTimeMillis();
		for(int j =0; j < 10000; j++) {
			arvoreA.get(j);		
		}		
		long tempoFinalPesquisa = System.currentTimeMillis();
		long tempoTotalInserir = tempoFinal-tempoInicial;
		long tempoTotalPesquisa = tempoFinalPesquisa - tempoInicialPesquisa;
		 System.out.println("Decrescente em milisegundos(Pesquisa)"+tempoTotalPesquisa);
	       System.out.println("Decrescente em milisegundos(Inser��o)"+tempoTotalInserir);
		
	
	}
	public void random() {
		int i = 0;
		vetorC [i] = gerador.nextInt(9999);
		long tempoInicial = System.currentTimeMillis();
		for(int j =0; j < 10000; j++) {
		
			arvoreC.put(j,vetorC[j]);
		}
		long tempoFinal = System.currentTimeMillis();
		
		long tempoInicialPesquisa = System.currentTimeMillis();
		for(int j =0; j < 10000; j++) {
			arvoreA.get(j);		
		}		
		long tempoFinalPesquisa = System.currentTimeMillis();
		
		long tempoTotalInserir = tempoFinal-tempoInicial;
		long tempoTotalPesquisa = tempoFinalPesquisa - tempoInicialPesquisa;
		System.out.println("Random em milisegundos(Pesquisa)"+tempoTotalPesquisa);
	    System.out.println("Random em milisegundos(Inser��o)"+tempoTotalInserir);
		
	}
}
