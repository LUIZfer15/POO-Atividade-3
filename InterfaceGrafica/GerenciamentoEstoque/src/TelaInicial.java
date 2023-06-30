import java.awt.Dimension;
import java.awt.FlowLayout;

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

        setSize(new Dimension(500, 500));
        setPreferredSize(new Dimension(500, 500));
    }

}
