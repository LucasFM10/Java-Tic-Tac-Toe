package verificadoresDeFimDeJogo;

import aplicativo.Tabuleiro;

public class VerificaColunas extends VerificadorDeFimDeJogo {

	@Override
	public boolean verificarFimDeJogo(Tabuleiro tabuleiro) {
		for (int j = 0; j < 3; j++) {
			if (tabuleiro.procurarCasaPorCoordenada(0, j).getSimbolo()
					.equals(tabuleiro.procurarCasaPorCoordenada(1, j).getSimbolo())
					&& tabuleiro.procurarCasaPorCoordenada(0, j).getSimbolo()
							.equals(tabuleiro.procurarCasaPorCoordenada(2, j).getSimbolo())) {
				return true;
			}
		}
		return false;
	}

}
