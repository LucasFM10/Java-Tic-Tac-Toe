package aplicativo;

import java.util.ArrayList;

public class Tabuleiro {

	private ArrayList<Casa> casas;

	public Tabuleiro() {
		this.casas = new ArrayList<Casa>();
	}

	public Casa procurarCasaPorCoordenada(int linha, int coluna) {
		for (Casa casa : casas) {
			if (casa.getLinha() == linha && casa.getColuna() == coluna) {
				return casa;
			}
		}
		return null;
	}

	public ArrayList<Casa> getCasas() {
		return casas;
	}

}
