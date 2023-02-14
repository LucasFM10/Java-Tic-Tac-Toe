package verificadoresDeFimDeJogo;

import aplicativo.Tabuleiro;

public class VerificaLinhas extends VerificadorDeFimDeJogo {

	@Override
	public boolean verificarFimDeJogo(Tabuleiro tabuleiro) {
		for (int i = 0; i < 3; i++) {

			if (tabuleiro.procurarCasaPorCoordenada(i, 0).getSimbolo()
					.equals(tabuleiro.procurarCasaPorCoordenada(i, 1).getSimbolo())
					&& tabuleiro.procurarCasaPorCoordenada(i, 0).getSimbolo()
							.equals(tabuleiro.procurarCasaPorCoordenada(i, 2).getSimbolo())) {
				return true;
			}

		}
		return false;
	}

}
