package verificadoresDeFimDeJogo;

import aplicativo.Casa;
import aplicativo.Tabuleiro;

public class VerificaVelha extends VerificadorDeFimDeJogo {

	@Override
	public boolean verificarFimDeJogo(Tabuleiro tabuleiro) {
		for (Casa casa : tabuleiro.getCasas()) {
			if ((!casa.getSimbolo().equals("X")) && (!casa.getSimbolo().equals("O"))) {
				return false;
			}
		}

		return true;
	}

}
