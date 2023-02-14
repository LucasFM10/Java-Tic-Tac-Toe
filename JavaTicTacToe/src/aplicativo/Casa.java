package aplicativo;

public class Casa {

	String simbolo;
	int linha;
	int coluna;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return simbolo;
	}

	public Casa(String simbolo, int linha, int coluna) {
		this.simbolo = simbolo;
		this.linha = linha;
		this.coluna = coluna;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

}
