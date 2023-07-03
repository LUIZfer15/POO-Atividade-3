import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cadastro extends JFrame {

    private JPanel panel;
    private JTextField textFieldId;
    private JTextField textFieldNome;
    private JTextField textFieldDescricao;
    private JTextField textFieldPreco;
    private JTextField textFieldQuantidadeEstoque;

    public Cadastro() {
        setTitle("Cadastrar Produto");
        setLayout(new FlowLayout());

        this.panel = new JPanel();
        this.panel.setLayout(new FlowLayout());
        this.panel.setPreferredSize(new Dimension(500, 500));
        add(panel);

        criarTextFieldId("Identificador do produto");
        criarTextFieldNome("Nome do produto");
        criarTextFieldDescricao("Descrição do produto");
        criarTextFieldPreco("Valor do produto");
        criarTextFieldQuantidadeEstoque("Quantidade do produto");

        criarBotao("Salvar Texto", new ButtonSalvarArquivoTextoHandler());
        criarBotao("Salvar Binario", new ButtonSalvarArquivoBinarioHandler());
        criarBotao("Voltar", new ButtonVoltarHandler());

        setSize(new Dimension(500, 500));
        setPreferredSize(new Dimension(500, 500));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void criarLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setPreferredSize(new Dimension(400, 40));
        this.panel.add(label);
    }

    private void criarTextFieldId(String texto) {
        criarLabel(texto);
        this.textFieldId = new JTextField();
        this.textFieldId.setPreferredSize(new Dimension(400, 40));
        this.panel.add(this.textFieldId);
    }

    private void criarTextFieldNome(String texto) {
        criarLabel(texto);
        this.textFieldNome = new JTextField();
        this.textFieldNome.setPreferredSize(new Dimension(400, 40));
        this.panel.add(this.textFieldNome);
    }

    private void criarTextFieldDescricao(String texto) {
        criarLabel(texto);
        this.textFieldDescricao = new JTextField();
        this.textFieldDescricao.setPreferredSize(new Dimension(400, 40));
        this.panel.add(this.textFieldDescricao);
    }

    private void criarTextFieldPreco(String texto) {
        criarLabel(texto);
        this.textFieldPreco = new JTextField();
        this.textFieldPreco.setPreferredSize(new Dimension(400, 40));
        this.panel.add(this.textFieldPreco);
    }

    private void criarTextFieldQuantidadeEstoque(String texto) {
        criarLabel(texto);
        this.textFieldQuantidadeEstoque = new JTextField();
        this.textFieldQuantidadeEstoque.setPreferredSize(new Dimension(400, 40));
        this.panel.add(this.textFieldQuantidadeEstoque);
    }

    private void criarBotao(String label, ActionListener handler) {
        JButton button = new JButton(label);
        button.addActionListener(handler);
        button.setPreferredSize(new Dimension(300, 80));
        this.panel.add(button);
    }

    private Produto criarProduto() {
        Produto produto = new Produto();
        produto.setId(Integer.parseInt(this.textFieldId.getText()));
        produto.setNome(this.textFieldNome.getText());
        produto.setDescricao(this.textFieldDescricao.getText());
        produto.setPreco(Float.parseFloat(this.textFieldPreco.getText()));
        produto.setQuantidadeEstoque(Integer.parseInt(this.textFieldQuantidadeEstoque.getText()));
        return produto;
    }

    private class ButtonSalvarArquivoTextoHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Produto produto = criarProduto();
            Arquivos.salvarTxt(produto);
            JOptionPane.showMessageDialog(null, "Produto salvo no arquivo TXT!");
        }
    }

    private class ButtonSalvarArquivoBinarioHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Produto produto = criarProduto();
            Arquivos.salvarBinario(produto);
            JOptionPane.showMessageDialog(null, "Produto salvo no arquivo Binário!");
        }
    }

    private class ButtonVoltarHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
        }
    }
}
