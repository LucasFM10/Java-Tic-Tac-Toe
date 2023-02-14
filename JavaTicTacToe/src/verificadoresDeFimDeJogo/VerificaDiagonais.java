package verificadoresDeFimDeJogo;

import aplicativo.Tabuleiro;

public class VerificaDiagonais extends VerificadorDeFimDeJogo {

	@Override
	public boolean verificarFimDeJogo(Tabuleiro tabuleiro) {
		return (tabuleiro.procurarCasaPorCoordenada(0, 0).getSimbolo()
				.equals(tabuleiro.procurarCasaPorCoordenada(1, 1).getSimbolo())
				&& tabuleiro.procurarCasaPorCoordenada(0, 0).getSimbolo()
						.equals(tabuleiro.procurarCasaPorCoordenada(2, 2).getSimbolo())
				|| (tabuleiro.procurarCasaPorCoordenada(0, 2).getSimbolo()
						.equals(tabuleiro.procurarCasaPorCoordenada(1, 1).getSimbolo())
						&& tabuleiro.procurarCasaPorCoordenada(0, 2).getSimbolo()
								.equals(tabuleiro.procurarCasaPorCoordenada(2, 0).getSimbolo())));
	}
}