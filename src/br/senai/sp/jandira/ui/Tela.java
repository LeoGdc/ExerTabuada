package br.senai.sp.jandira.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.senai.sp.jandira.model.Conta;

public class Tela {

	public void criarTela() {

		// ***font

		Font titulo = new Font("Arial", Font.BOLD, 40);

		// Header Frame

		JPanel header = new JPanel();
		header.setBounds(0, 0, 900, 75);
		header.setBackground(Color.WHITE);
		header.setLayout(null);

		// jFrame

		JFrame minhaTela = new JFrame();
		minhaTela.setSize(900, 700);
		minhaTela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		minhaTela.setTitle("Calc Tabuada");
		minhaTela.setLayout(null);

		// Jlabel tabuada

		JLabel lblTitulo = new JLabel("Tabuada");
		lblTitulo.setBounds(30, 30, 200, 40);
		header.add(lblTitulo);
		lblTitulo.setFont(titulo);
		lblTitulo.setForeground(Color.BLUE);

		// jLabel multiplicando

		JLabel lblMultiplicando = new JLabel();
		lblMultiplicando.setText("Multiplicando");
		lblMultiplicando.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMultiplicando.setBounds(20, 90, 200, 30);

		// Jlabel multiplicador

		JLabel lblMultiplicador = new JLabel();
		lblMultiplicador.setText("Multiplicador");
		lblMultiplicador.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMultiplicador.setBounds(20, 150, 200, 30);

		// Jlabel Resultados

		JLabel lblResultados = new JLabel();
		lblResultados.setText("Resultado:");
		lblResultados.setBounds(500, 80, 200, 30);
		lblResultados.setFont(new Font("Arial Black", Font.PLAIN, 26));

		// JTextField multiplicando

		JTextField tfmultiplicando = new JTextField();
		tfmultiplicando.setBounds(150, 90, 100, 30);

		// JTextField multiplicador

		JTextField tfmaximoMultiplicador = new JTextField();
		tfmaximoMultiplicador.setBounds(150, 150, 100, 30);

		// Jlabel Resultado

		JLabel lblresultadoCalc = new JLabel();
		lblresultadoCalc.setBounds(400, 600, 200, 30);
		lblresultadoCalc.setFont(new Font("Arial", Font.PLAIN, 20));

		// Button Calcular

		Button btnCalcular = new Button("Calcular");
		btnCalcular.setFont(new Font("arial", Font.PLAIN, 30));
		btnCalcular.setBounds(50, 250, 300, 60);
		btnCalcular.setBackground(new Color(2, 209, 23));

		// Button limpar

		Button btnLimpar = new Button("Limpar");
		btnLimpar.setFont(new Font("arial", Font.PLAIN, 30));
		btnLimpar.setBounds(50, 350, 300, 60);
		btnLimpar.setBackground(new Color(242, 16, 0));

		// *** lista tabuada

		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(500, 110, 200, 300);

		JList listTabuada = new JList();
		scroll.getViewport().add(listTabuada);

		DefaultListModel TabuadaModel = new DefaultListModel();

		listTabuada.setModel(TabuadaModel);

		// Tela

		minhaTela.getContentPane().add(lblTitulo);
		minhaTela.getContentPane().add(lblMultiplicando);
		minhaTela.getContentPane().add(lblMultiplicador);
		minhaTela.getContentPane().add(tfmultiplicando);
		minhaTela.getContentPane().add(tfmaximoMultiplicador);
		minhaTela.getContentPane().add(btnCalcular);
		minhaTela.getContentPane().add(btnLimpar);
		minhaTela.getContentPane().add(lblResultados);
		minhaTela.getContentPane().add(lblresultadoCalc);
		minhaTela.getContentPane().add(header);
		minhaTela.getContentPane().add(scroll);

		minhaTela.setVisible(true);

		Conta conta = new Conta();

		btnCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Conta tabuada = new Conta();

				int multiplicando = Integer.parseInt(tfmultiplicando.getText());
				int maximoMultiplicador = Integer.parseInt(tfmaximoMultiplicador.getText());

				tabuada.setMultiplicando(multiplicando);
				tabuada.setmaximoMultiplicador(maximoMultiplicador);

				String[] resultadoTabuada = tabuada.Tabuada();

				for (int i = 0; i < resultadoTabuada.length; i++) {
					TabuadaModel.addElement(resultadoTabuada[i]);
				}

			}
		});

		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tfmultiplicando.setText("");
				tfmaximoMultiplicador.setText("");
				tfmultiplicando.requestFocus();

				TabuadaModel.clear();

			}
		});

	}

}
