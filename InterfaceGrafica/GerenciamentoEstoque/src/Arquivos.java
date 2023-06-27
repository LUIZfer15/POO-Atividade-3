import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Arquivos {

    private static final String NOME_ARQUIVO_TXT = "produto.txt";
    private static final String NOME_ARQUIVO_BINARIO = "produto.binario";

    public static void salvarTxt(Produto produto) {
        FileWriter fileWriter = null;
        try {
            File file = new File(NOME_ARQUIVO_TXT);
            fileWriter = new FileWriter(file, true);
            String valorParaSalvar = produto.getId() + "##" + produto.getNome() + "##" + produto.getDescricao() + "##"
                    + produto.getPreco() + "##" + produto.getQuantidadeEstoque() + "\n";
            fileWriter.write(valorParaSalvar);
            JOptionPane.showMessageDialog(null, "O produto foi cadastrado com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o produto!");
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e2) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o arquivo após salvar o vaiculo!");
            }
        }
    }

    public static List<Produto> carregarTxt() {
        List<Produto> produtos = new ArrayList<Produto>(null);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            File file = new File(NOME_ARQUIVO_TXT);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String linha = bufferedReader.readLine();
            while (linha != null) {
                Produto produto = extrairObjetoDoArquivo(linha);
                produtos.add(produto);
                linha = bufferedReader.readLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo!");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {

                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar o arquivo!");
            }
        }
        return produtos;
    }

    private static Produto extrairObjetoDoArquivo(String linha) {
        Produto produto = new Produto();
        String[] split = linha.split("##");
        produto.setId(split[0]);
        produto.setNome(linha);
    }
}
