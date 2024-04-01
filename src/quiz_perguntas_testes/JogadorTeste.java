package quiz_perguntas_testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import quiz_perguntas.Arquivo;
import quiz_perguntas.Pergunta;
import quiz_perguntas.Resposta;

class JogoTeste {

    private Arquivo jogo = new Arquivo();

    @Test
    void carregaArquivoTest() {
        jogo.lerArquivo();
        assertEquals(50, jogo.getPerguntas().size());
        Pergunta quarta = jogo.getPerguntas().get(3);
        assertEquals("A água ferve a 100 graus Celsius", quarta.getTitulo());
        assertTrue(quarta.isRespostaCorreta());
    }


    @Test
    void fazCorrecaoAcertoTest() {
        Pergunta pergunta = new Pergunta("ABCD , EFGH", true);
        Resposta r = new Resposta(pergunta, true);
        assertEquals("acerto", r.correcao());
    }

    @Test
    void fazCorrecaoErroTest() {
        Pergunta pergunta = new Pergunta("ABCD , EFGH", true);
        Resposta r = new Resposta(pergunta, false);
        assertEquals("erro", r.correcao());
    }

    @Test
    void calculaPontuacaoTest() {
        assertEquals(2, jogo.calculaPontuacao(respostasControladas()));
    }

    @Test
    void gravarRespostasTest() {
        ArrayList<Resposta> respostas = respostasControladas();
        jogo.gravaResultado(respostas);
        String conteudoArq = jogo.lerRespostas();
        assertEquals("1,A,acerto\n2,B,acerto\n3,C,erro\n4,D,erro\n", conteudoArq);
    }

    @Test
    void sorteiaRodada() {
        jogo.lerArquivo();
        Pergunta primeira = jogo.getPerguntas().get(0);
        Pergunta segunda = jogo.getPerguntas().get(1);
        assertEquals("As baleias são mamíferos.", primeira.getTitulo());
        assertEquals("O sol gira em torno da Terra.", segunda.getTitulo());
        ArrayList<Pergunta> sorteadas = jogo.sorteiaRodada(10);
        primeira = sorteadas.get(0);
        segunda = sorteadas.get(1);
        assertNotEquals("As baleias são mamíferos.", primeira.getTitulo());
        assertNotEquals("O sol gira em torno da Terra.", segunda.getTitulo());
        assertEquals(10, sorteadas.size());

    }

    private ArrayList<Resposta> respostasControladas() {
        ArrayList<Resposta> respostas = new ArrayList<Resposta>();
        Pergunta pa = new Pergunta("A", false);
        Pergunta pb = new Pergunta("B", false);
        Pergunta pc = new Pergunta("C", true);
        Pergunta pd = new Pergunta("D", true);
        respostas.add(new Resposta(pa, false));
        respostas.add(new Resposta(pb, false));
        respostas.add(new Resposta(pc, false));
        respostas.add(new Resposta(pd, false));
        return respostas;
    }
}
