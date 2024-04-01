package exercicio_mercado;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class SistemaMercado {
    public static double main(String[] args) {
        Mercado mercado = new Mercado();
        mercado.carregarProdutos("produtosMercado.txt");

        List<String> carrinho = new ArrayList<>();
        List<Integer> quantidades = new ArrayList<>();

        while (true) {
            String[] opcoes = { "Arroz", "Feijão", "Macarrão", "Finalizar Compra" };

            String escolhaProduto = (String) JOptionPane.showInputDialog(null, "Escolha um produto:",
                    "Produtos Disponíveis", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolhaProduto.equals("Finalizar Compra")) {
                break;
            }

            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade de " + escolhaProduto + ":"));

            carrinho.add(escolhaProduto);
            quantidades.add(quantidade);
        }

        double totalCompra = 0.0;

        for (int i = 0; i < carrinho.size(); i++) {
            String produto = carrinho.get(i);
            int quantidade = quantidades.get(i);
            double precoUnitario = mercado.obterPreco(produto);
            totalCompra += precoUnitario * quantidade;
        }

        JOptionPane.showMessageDialog(null, "Total da compra: R$" + totalCompra);

        return totalCompra;
    }
}
