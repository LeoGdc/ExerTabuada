package br.senai.sp.jandira.model;

public class Conta {

	private int multiplicando;
	private int maximoMultiplicador;

	public void setMultiplicando(int multiplicando) {
		this.multiplicando = multiplicando;
	}

	public void setmaximoMultiplicador(int maximoMultiplicador) {
		this.maximoMultiplicador = maximoMultiplicador;
	}

	private int resultado;

	public String[] Tabuada() {

		String tabuada[] = new String[maximoMultiplicador + 1];

		for (int multiplicador = 0; multiplicador <= maximoMultiplicador; multiplicador++) {
			resultado = multiplicador * multiplicando;
			tabuada[multiplicador] = multiplicando + "X" + multiplicador + "=" + resultado;

		}
		return tabuada;
	}

}
