package ArvoreBi;

public class CArvAvl {
	
	public class Elemento{
	    private Object valor;
	    public Elemento(int valor){
	        this.valor = valor;
	    }
	    public void setValor(Object elemento){
	        this.valor = elemento;
	    }
	    public Object getValor(){
	        return this.valor;
	    }
	}
	
	private Elemento    ele;
    private CArvAvl   dir;
    private CArvAvl   esq;
    private int         bal;
    public CArvAvl(){
        this.ele = null;
        this.esq = null;
        this.dir = null;
        this.bal = 0;
    }
    public CArvAvl(Elemento elem){
        this.ele = elem;
        this.dir = null;
        this.esq = null;
        this.bal = 0;
        //System.out.println("Criei a arvore com o elemento "+elem.getValor());
    }
    public int calcularAltura(){
        if (this.esq == null && this.dir == null) { // nao tenho nenhum filho
            return 1;
        }
        else if (this.esq != null && this.dir == null){
            return 1 + this.esq.calcularAltura();
        }
        else if (this.esq == null && this.dir != null){
            return 1 + this.dir.calcularAltura();
        }
        else{
            return 1 + Math.max(this.esq.calcularAltura(), this.dir.calcularAltura());
        }
    }
    public void calcularBalanceamento(){
        if (this.dir == null && this.esq == null){
            this.bal = 0;
        }
        else if (this.esq == null && this.dir != null){
            this.bal = this.dir.calcularAltura() - 0;
        }
        else if (this.esq != null && this.dir == null){
            this.bal = 0 - this.esq.calcularAltura();
        }
        else{
            this.bal = this.dir.calcularAltura() - this.esq.calcularAltura();
        }
        if (this.dir != null) this.dir.calcularBalanceamento();
        if (this.esq != null) this.esq.calcularBalanceamento();
    }
    //--------- métodos de verificacao e rotacao
    public CArvAvl verificaBalanceamento(){
        if (this.bal >=2 || this.bal <= -2){
            if (this.bal >= 2){
                if (this.bal * this.dir.getBalanceamento() > 0){
                    System.out.println("Rotacao Simples Direita");
                    return rotacaoSimplesDireita();
                }
                else{
                    System.out.println("Rotacao Dupla Direita");
                    return rotacaoDuplaDireita();
                }
            }
            else{  // bal <= -2
                if (this.bal * this.esq.getBalanceamento() > 0){
                    System.out.println("Rotacao Simples Esquerda");
                    return rotacaoSimplesEsquerda();
                }
                else{
                    System.out.println("Rotacao Dupla Esquerda");
                    return rotacaoDuplaEsquerda();
                }
            }
        }
        this.calcularBalanceamento();
        if (this.esq != null) this.esq = this.esq.verificaBalanceamento();
        if (this.dir != null) this.dir = this.dir.verificaBalanceamento();
        return this;
    }
    public CArvAvl rotacaoSimplesDireita(){
    	CArvAvl filhoDir;
    	CArvAvl filhoDoFilho = null;
        filhoDir = this.getDireita();
        if (this.dir != null){
            if (this.dir.getEsquerda()!= null){
                filhoDoFilho = filhoDir.getEsquerda();
            }
        }
        filhoDir.setEsquerda(this);
        this.setDireita(filhoDoFilho);
        return filhoDir;
    }
    public CArvAvl rotacaoSimplesEsquerda(){
    	CArvAvl filhoEsq;
    	CArvAvl filhoDoFilho = null;
        filhoEsq = this.getEsquerda();
        if (this.esq != null){
            if (this.esq.getDireita()!= null){
                filhoDoFilho = filhoEsq.getDireita();
            }
        }
        filhoEsq.setDireita(this);
        this.setEsquerda(filhoDoFilho);
        return filhoEsq;
    }
    public CArvAvl rotacaoDuplaDireita(){
    	CArvAvl arvore       = this;
    	CArvAvl filhoDir     = this.getDireita();
    	CArvAvl filhoDoFilho = filhoDir.getEsquerda();
    	CArvAvl noInserido   = filhoDoFilho.getDireita();
        // parte 1: alinhar os caras
        filhoDir.setEsquerda(noInserido);
        filhoDoFilho.setDireita(filhoDir);
        this.setDireita(filhoDoFilho);
        // parte 2: tornar o filho à direita a nova raiz
        CArvAvl novoFilhoDireita = this.getDireita();
        arvore.setDireita(null);
        novoFilhoDireita.setEsquerda(arvore);
        return novoFilhoDireita;
    }
    public CArvAvl rotacaoDuplaEsquerda(){
    	CArvAvl arvore       = this;
    	CArvAvl filhoEsq     = this.getEsquerda();
    	CArvAvl filhoDoFilho = filhoEsq.getDireita();
    	CArvAvl noInserido   = filhoDoFilho.getEsquerda();
        // parte 1: alinhar os caras
        filhoEsq.setDireita(noInserido);
        filhoDoFilho.setEsquerda(filhoEsq);
        this.setEsquerda(filhoDoFilho);
        // parte 2: tornar o filho à esquerda a nova raiz
        CArvAvl novoFilhoEsquerda = this.getEsquerda();
        arvore.setEsquerda(null);
        novoFilhoEsquerda.setDireita(arvore);
        return novoFilhoEsquerda;
    }
    
    // metodos de controle;
    public boolean isEmpty(){
        return (this.ele == null);
    }
    public void imprimirPreOrdem(){
        if (!isEmpty()){
            System.out.print(this.ele.getValor() + "  ");
            if (this.esq != null){
                this.esq.imprimirPreOrdem();
            }
            if (this.dir != null){
                this.dir.imprimirPreOrdem();
            }
        }
    }
    public void imprimirInOrdem(){
        if (!isEmpty()){
            if (this.esq != null){
                this.esq.imprimirInOrdem();
            }
            System.out.print(this.ele.getValor() + "  ");
            if (this.dir != null){
                this.dir.imprimirInOrdem();
            }
        }
    }
    public void imprimirPosOrdem(){
        if (!isEmpty()){
            if (this.dir != null){
                this.dir.imprimirPosOrdem();
            }
            if (this.esq != null){
                this.esq.imprimirPosOrdem();
            }
            System.out.print(this.ele.getValor() + "  ");
        }
    }
    public CArvAvl inserir(Elemento novo){
        if (isEmpty()){
            this.ele = novo;
        }
        else{
        	CArvAvl novaArvore = new CArvAvl(novo);
            if (novo.getValor() < this.ele.getValor()){ // vou inserir na descendencia esquerda
                if (this.esq == null){ // sou um nó folha?
                    this.esq = novaArvore;
                    //System.out.println("Inseri o elemento "+ novo.getValor()+ " à esquerda de "+this.ele.getValor());
                }
                else{
                    this.esq = this.esq.inserir(novo); // repassei a resposnabilidade pra sub-árvore esquerda
                }
            }
            else if (novo.getValor() > this.ele.getValor()){ // vou inserir na descendenia direita
                if (this.dir == null){
                    this.dir = novaArvore;
                    //System.out.println("Inseri o elemento "+ novo.getValor()+ " à direita de "+this.ele.getValor());
                }
                else{
                    this.dir = this.dir.inserir(novo);
                }
            }
        }
        return this;
    }
    public CArvAvl remover(Object elemento){
        // caso 1 - achei o elemento e ele não tem filhos
        if (this.ele.getValor() == elemento){
            // ele é uma folha
            if (this.esq == null && this.dir == null){
                return null;
            }
            // agora, ele tem filhos
            else{
                // só tem filhos à esquerda (acaba sobrando a sub-árvore da esquerda)
                if (this.esq != null && this.dir == null){
                    return this.esq;
                }
                // só tem filhos à direita (acaba sobrando a sub-árvore da direita)
                else if (this.dir != null && this.esq == null){
                    return this.dir;
                }
                // tem os 2 filhos!! :o
                // o que fazer? (assumo o maior dentre os menores ou vice-versa)
                else{
                	CArvAvl aux = this.dir;
                    while (aux.esq != null){
                        aux = aux.esq;
                    }
                    this.setElemento(aux.getElemento());  // troco os valores
                    aux.getElemento().setValor(elemento);
                    // faço a árvore da direita receber a remoção do elemento (que vai estar numa folha)
                    this.dir = dir.remover(elemento);
                }
            }
        }
        else{
            // caso 2 - o elemento é menor, então vou removê-lo na esquerda
            if (elemento < this.ele.getValor()){
                if (this.esq != null){
                    this.esq = this.esq.remover(elemento);
                }
            }
            // caso 3 - o elemento é maior, então vou removê-lo na direita
            else if (elemento > this.ele.getValor()){
                if (this.dir != null){
                    this.dir = this.dir.remover(elemento);
                }
            }
        }
        return this;
            
    }
    public boolean busca(Object valor){
        if (isEmpty()){
            return false;
        }
        if (this.ele.getValor() == valor){
            return true;
        }
        else{
            if (valor < this.ele.getValor() ){
                if (this.esq == null){
                    return false;
                }
                else{
                    return this.esq.busca(valor); // repassei a responsabilidade para a subarvore esquerda
                }
            }
            else if (valor > this.ele.getValor()){
                if (this.dir == null){
                    return false;
                }
                else{
                    return this.dir.busca(valor);
                }
            }
            return false;
        }
    }
    // gets e sets
    
    public void setElemento(Elemento ele){
        this.ele = ele;
    }
    public void setDireita(CArvAvl dir){
        this.dir = dir;
    }
    public void setEsquerda(CArvAvl esq){
        this.esq = esq;
    }
    public int getBalanceamento(){
        return this.bal;
    }
    public void setBalanceamento(int bal){
        this.bal = bal;
    }
    public CArvAvl getDireita(){
        return this.dir;
    }
    public CArvAvl getEsquerda(){
        return this.esq;
    }
    public Elemento getElemento(){
        return this.ele;
    }
    // método de depuração
    public String printArvore(int level){
        String str = this.toString()+"\n";
        for (int i=0; i<level; i++){
                str += "\t";
        }
        if (this.esq != null){
            str += "+-ESQ: "+this.esq.printArvore(level + 1);
        }
        else{
            str += "+-ESQ: NULL";
        }
        str += "\n";
        for (int i=0; i<level; i++){
                 str += "\t";
        }
        if (this.dir != null){
            
            str += "+-DIR: "+this.dir.printArvore(level + 1); 
        }
        else{
            str += "+-DIR: NULL";
        }
        str += "\n";
        return str;
    }
    public String toString(){
        return "["+this.ele.getValor()+"] ("+this.bal+")";
    }
}
