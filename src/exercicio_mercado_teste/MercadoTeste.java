package exercicio_mercado_teste;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import exercicio_mercado.Mercado;
import exercicio_mercado.Produto;
import exercicio_mercado.SistemaMercado;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class MercadoTeste {

    @Test
    public void testObterPreco() {
        Mercado mercado = new Mercado();
        mercado.carregarProdutos("produtosMercado.txt");

        // Verifica se o preço de um produto existente é obtido corretamente
        assertEquals(10.50, mercado.obterPreco("Arroz"), 0.001);

        // Verifica se o preço de um produto inexistente é retornado como 0.0
        assertEquals(0.0, mercado.obterPreco("Café"), 0.001);
    }

    // Teste para verificar se os produtos são carregados corretamente
    @Test
    public void testCarregarProdutos() {
        Mercado mercado = new Mercado();
        mercado.carregarProdutos("produtosMercado.txt");

        // Verifica se a quantidade de produtos carregados é correta
        List<Produto> produtos = mercado.getProdutos();
        assertEquals(3, produtos.size());

        // Verifica se o nome e o preço dos produtos carregados estão corretos
        assertEquals("Arroz", produtos.get(0).getNome());
        assertEquals(10.50, produtos.get(0).getPreco(), 0.001);
        assertEquals("Feijão", produtos.get(1).getNome());
        assertEquals(5.75, produtos.get(1).getPreco(), 0.001);
        assertEquals("Macarrão", produtos.get(2).getNome());
        assertEquals(3.25, produtos.get(2).getPreco(), 0.001);
    }
}
