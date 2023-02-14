package aplicativo;

import java.util.Scanner;

import verificadoresDeFimDeJogo.VerificaColunas;
import verificadoresDeFimDeJogo.VerificaDiagonais;
import verificadoresDeFimDeJogo.VerificaLinhas;
import verificadoresDeFimDeJogo.VerificaVelha;

public class Jogo {

	Scanner scan = new Scanner(System.in);

	private String vezDeQuem;
	private boolean continuarJogando = true;
	private Tabuleiro tabuleiro;

	private VerificaLinhas verLinhas = new VerificaLinhas();
	private VerificaColunas verColunas = new VerificaColunas();
	private VerificaDiagonais verDiagonais = new VerificaDiagonais();
	private VerificaVelha verVelha = new VerificaVelha();

	public void jogar() {

		do {
			System.out.println(
					"Bem vindo ao Jogo da Velha.\nUse o teclado numérico para jogar.\nO jogador 'X' começa.\n");

			iniciarTabuleiro();

			vezDeQuem = "X";

			do {

				while (executarJogada());
				mostrarTabuleiroSemNumeros();
			} while (verificarFimDeJogo());

		} while (continuarJogando);

		scan.close();
	}

	public void iniciarTabuleiro() {
		tabuleiro = new Tabuleiro();
		for (int linha = 3; linha > 0; linha--) {
			for (int coluna = 0; coluna < 3; coluna++) {
				tabuleiro.getCasas().add(new Casa(Integer.toString((linha * 3) + coluna - 2), 3 - linha, coluna));
			}
		}
		mostrarTabuleiroComNumeros();
	}

	public void mostrarTabuleiroComNumeros() {
		System.out.print("-------------\n");
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				System.out.print("| " + tabuleiro.getCasas().get((linha * 3) + coluna) + " ");
			}
			System.out.print("| \n-------------\n");
		}
	}

	public void mostrarTabuleiroSemNumeros() {
		System.out.print("-------------\n");
		for (int linha = 0; linha < 3; linha++) {
			for (int coluna = 0; coluna < 3; coluna++) {
				String aux = tabuleiro.getCasas().get((linha * 3) + coluna).toString();
				if (!aux.equals("X") && !aux.equals("O")) {
					aux = " ";
				}
				System.out.print("| " + aux + " ");
			}
			System.out.print("| \n-------------\n");
		}
	}

	public boolean executarJogada() {

		String casaDesejada = new String();

		System.out.println("Digite o valor da casa a ser jogada:");

		casaDesejada = scan.nextLine();

		for (Casa casa : tabuleiro.getCasas()) {

			if (casa.toString().contains(casaDesejada) && !casaDesejada.equals("X") && !casaDesejada.equals("O") && casaDesejada.length() == 1) {
				casa.setSimbolo(vezDeQuem);
				return false;
			}
		}

		String casasRestantes = "";

		for (Casa casa : tabuleiro.getCasas()) {
			if (!casa.getSimbolo().equals("X") && !casa.getSimbolo().equals("O")) {
				casasRestantes = casasRestantes.concat(casa.getSimbolo() + ", ");
			}
		}
		casasRestantes = casasRestantes.concat(" ");

		casasRestantes = casasRestantes.replace(",  ", " ");

		System.out.println("Valor inválido.\nCasas restantes:\n" + casasRestantes + "\n");
		return true;

	}

	public void alternarTurno() {
		if (vezDeQuem.equals("X")) {
			vezDeQuem = "O";
		} else {
			vezDeQuem = "X";
		}
	}

	public boolean verificarFimDeJogo() {
		if (verLinhas.verificarFimDeJogo(this.tabuleiro) || verColunas.verificarFimDeJogo(this.tabuleiro)
				|| verDiagonais.verificarFimDeJogo(this.tabuleiro)) {
			fimDeJogo(vezDeQuem);
			return false;
		} else if (verVelha.verificarFimDeJogo(this.tabuleiro)) {
			fimDeJogo();
			return false;
		}
		alternarTurno();
		return true;
	}

	public void fimDeJogo(String vencedor) {

		System.out.println(vencedor + " é o campeão!");

		reiniciarOuEncerrar();
		return;
	}

	public void fimDeJogo() {

		System.out.println("Deu velha!");

		reiniciarOuEncerrar();

		return;
	}

	public void reiniciarOuEncerrar() {

		String respostaDoUsuario = " ";

		System.out.println("Deseja jogar novamente? (S/N)");

		respostaDoUsuario = scan.nextLine();

		while (!respostaDoUsuario.equals("S") && !respostaDoUsuario.equals("s") && !respostaDoUsuario.equals("N")
				&& !respostaDoUsuario.equals("n")) {
			System.out.println("Valor inválido, digite 'S',''s','N' ou 'n'.");
			respostaDoUsuario = scan.nextLine();
		}

		if (respostaDoUsuario.equals("S") || respostaDoUsuario.equals("s")) {
			System.out.println("Reiniciando jogo.");
		} else {
			continuarJogando = false;
			System.out.println("Obrigado por jogar nosso jogo!");
		}
	}

}
