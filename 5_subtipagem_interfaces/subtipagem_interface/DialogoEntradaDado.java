package subtipagem_interface;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class DialogoEntradaDado extends JDialog implements ActionListener, KeyListener {

	private JTextField campo;
	private JButton botao;
	private RetornoDialogo retorno;
	private IDoc doc;

	public DialogoEntradaDado(IDoc doc) {

		this.doc = doc;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setTitle("Informe " + this.doc.getTipo());
		this.setSize(300, 100);
		this.campo = new JTextField("", this.doc.getTamanho());
		this.campo.addKeyListener(this);
		this.botao = new JButton("OK");
		this.botao.addActionListener(this);
		this.getContentPane().add(campo);
		this.getContentPane().add(botao);
		this.pack();
	}

	public void mostra() {
		this.setVisible(true);
	}

	public void quandoOk(RetornoDialogo retorno) {
		this.retorno = retorno;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String valor = campo.getText();
		if (valor.length() != doc.getTamanho()) {
			JOptionPane.showMessageDialog(DialogoEntradaDado.this,
					doc.getTipo() + " deve ter " + doc.getTamanho() + " caracteres", "ERRO", JOptionPane.ERROR_MESSAGE); // generalizar
			campo.requestFocus();
			campo.selectAll();
			return;
		}

		if (this.doc instanceof Placa) {
			for (int i = 0; i < 3; i++) {
				char c = valor.charAt(i);
				if (c < 65 || c < 90 && c < 97 || c > 122) {
					JOptionPane.showMessageDialog(DialogoEntradaDado.this,
							this.doc.getTipo() + " os 3 dígitos iniciais são letras", "ERRO",
							JOptionPane.ERROR_MESSAGE);
					campo.requestFocus();
					campo.select(i, i + 1);
					return;
				} else {
					for (int i1 = this.doc.getTamanho() - 1; i1 > 2; i1--) {
						char c1 = valor.charAt(i1);
						if (c1 < 48 || c1 > 57) { // só números
							JOptionPane.showMessageDialog(DialogoEntradaDado.this,
									this.doc.getTipo() + " os 4 digitos finais são números", "ERRO",
									JOptionPane.ERROR_MESSAGE);
							campo.requestFocus();
							campo.select(i1, i1 + 1);
							return;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < valor.length(); i++) {
				char c = valor.charAt(i);
				if (c < 48 || c > 57) { // só números
					JOptionPane.showMessageDialog(DialogoEntradaDado.this,
							this.doc.getTipo() + " deve ter apenas números", "ERRO", JOptionPane.ERROR_MESSAGE);
					campo.requestFocus();
					campo.select(i, i + 1);
					return;
				}
			}
			if (this.doc instanceof Hora) {
				int hora = Integer.parseInt(valor.substring(0, 2));
				int minutos = Integer.parseInt(valor.substring(2, 4));
				if (hora > 23 || minutos > 59) {
					JOptionPane.showMessageDialog(DialogoEntradaDado.this, this.doc.getTipo() + " horário inválido",
							"ERRO", JOptionPane.ERROR_MESSAGE);
					campo.requestFocus();
					return;
				}
			}
			if (this.doc instanceof Data) {
				int dia = Integer.parseInt(valor.substring(0, 2));
				int mes = Integer.parseInt(valor.substring(2, 4));
				int ano = Integer.parseInt(valor.substring(4, 8));
				if (dia == 0 || mes == 0 || ano == 0) {
					JOptionPane.showMessageDialog(DialogoEntradaDado.this, this.doc.getTipo() + " data inválida",
							"ERRO", JOptionPane.ERROR_MESSAGE);
					campo.requestFocus();
					return;
				}
			}
		}

		// se especificado um retorno envia um Documento preenchido para ele
		if (retorno != null)
			this.doc.setValor(valor);
		retorno.recebe(this.doc);
		this.dispose(); // fecha o diálogo
	}

//---------------------
	@Override
	public void keyTyped(KeyEvent e) {
		// deixa apertar backspace e delete
		if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == KeyEvent.VK_DELETE)
			return;
		// não deixa entrar mais caracteres
		if (campo.getText().length() == this.doc.getTamanho())
			e.consume();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/* NOPE */ }

	@Override
	public void keyReleased(KeyEvent e) {
		/* NOPE */ }

}