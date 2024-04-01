package exercicio_mercado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Mercado {
    private List<Produto> produtos;

    public Mercado() {
        this.produtos = new ArrayList<>();
    }

    public void carregarProdutos(String arquivoProdutos) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoProdutos))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String nomeProduto = dados[0];
                double preco = Double.parseDouble(dados[1]);
                produtos.add(new Produto(nomeProduto, preco));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double obterPreco(String nomeProduto) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                return produto.getPreco();
            }
        }
        return 0.0;
    }
    public List<Produto> getProdutos() {
        return produtos;
    }
}