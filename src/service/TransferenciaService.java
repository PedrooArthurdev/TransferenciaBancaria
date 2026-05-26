package service;

import exception.ContaInativaException;
import exception.SaldoInsuficienteException;
import model.Conta;
import model.StatusTransacao;
import model.Transacao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransferenciaService {
    private List<Transacao> historico = new ArrayList<>();

    public Transacao realizarTransferencia(Conta origem, Conta destino, double valor) {
        if (!origem.getStatus().equals("Ativa")) {
            throw new ContaInativaException("Conta de origem está inativa");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser positivo");
        }

        if (origem.getSaldo() < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        origem.setSaldo((origem.getSaldo() - valor));
        destino.setSaldo((destino.getSaldo() + valor));

        Transacao transacao = new Transacao(origem, destino, valor, LocalDateTime.now(), StatusTransacao.APROVADA);
        historico.add(transacao);
        return transacao;

        }

    public List<Transacao> getHistorico() {
        return historico;
    }
}



