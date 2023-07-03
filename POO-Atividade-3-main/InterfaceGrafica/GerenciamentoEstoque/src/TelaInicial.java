import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaInicial extends JFrame {

    private JPanel panel;

    public TelaInicial() {
        setTitle("Manipulação de Arquivos");
        setLayout(new FlowLayout());

        this.panel = new JPanel();
        this.panel.setLayout(new FlowLayout());
        this.panel.setPreferredSize(new Dimension(500, 500));
        add(this.panel);

        criarBotao("Cadastrar", new ButtonCadastrarHandler());
        criarBotao("Listar", new ButtonListarHandler());
        criarBotao("Sair", new ButtonSairHandler());

        setSize(new Dimension(500, 500));
        setPreferredSize(new Dimension(500, 500));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void criarBotao(String label, ActionListener handler) {
        JButton button = new JButton(label);
        button.addActionListener(handler);
        button.setPreferredSize(new Dimension(300, 80));
        this.panel.add(button);
    }

    private class ButtonCadastrarHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Cadastro();
        }
    }

    private class ButtonListarHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Listagem();

        }
    }

    private class ButtonSairHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
