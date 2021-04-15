package cobaia;

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
class DialogoEntradaDadoNumericoCEP 
  extends JDialog implements ActionListener, KeyListener {
  
  private JTextField campo;
  private JButton botao;
  private RetornoDialogoCEP retorno;

  public DialogoEntradaDadoNumericoCEP() {    
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new FlowLayout());
    this.setTitle("Informe o CEP");
    this.setSize(300, 100);    
    this.campo = new JTextField("", 8);
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
  
  public void quandoOk(RetornoDialogoCEP retorno) {
    this.retorno = retorno;
  }
 
  @Override
  public void actionPerformed(ActionEvent e) {
    String valor = campo.getText();
    if (valor.length() != 8) {
      JOptionPane.showMessageDialog(this, "CEP deve ter 8 números", "ERRO", JOptionPane.ERROR_MESSAGE);
      campo.requestFocus();
      campo.selectAll();
      return;
    }
    for (int i = 0; i < valor.length(); i++) {
      char c = valor.charAt(i);
      if (c < 48 || c > 57) { // só números
        JOptionPane.showMessageDialog(this, "CEP deve ter apenas números", "ERRO", JOptionPane.ERROR_MESSAGE);
        campo.requestFocus();
        campo.select(i, i + 1);
        return;
      }
    }  
    // 
    if (retorno != null) retorno.recebe(new CEP(valor));
    this.dispose(); // fecha o diálogo
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // deixa apertar backspace e delete
    if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == KeyEvent.VK_DELETE) return;
    if (campo.getText().length() == 8) e.consume();   
  }

  @Override
  public void keyPressed(KeyEvent e) { /* NOPE */ }

  @Override
  public void keyReleased(KeyEvent e) { /* NOPE */ }
 
}
