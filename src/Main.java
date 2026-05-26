import model.Cliente;
import model.Conta;
import model.Transacao;
import service.TransferenciaService;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("02085375111", "Pedro", "Rua 26 norte, conjunto8,casa 5", LocalDate.of(2003, 7, 25));
        Cliente cliente2 = new Cliente("05794865233", "Cláudio", "Avenida das palmeiras, chácara 4, casa 12", LocalDate.of(1985, 4, 16));

        Conta conta1 = new Conta("4102-8", 5000.82, "Corrente", "Ativa", cliente1);
        Conta conta2 = new Conta("9487-8", 10245.74, "Corrente", "Ativa", cliente2);
        Conta conta3 = new Conta("1486-8", 10245.74, "Corrente", "Inativa", cliente2);

        TransferenciaService service = new TransferenciaService();
     try {
         Transacao transacao = service.realizarTransferencia(conta2, conta1, 2500.51);
         System.out.println("Transferência realizada!");
         System.out.println("Status: " + transacao.getStatus());
         System.out.println("Valor: " + transacao.getValor());
         System.out.println("Saldo origem após transferência: " + conta2.getSaldo());
     }catch (Exception e) {
         System.out.println("Erro: " + e.getMessage());
     }


        // teste de saldo insuficiente
        // teste de saldo insuficiente
        try {
            service.realizarTransferencia(conta1, conta2, 99999.00);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            service.realizarTransferencia(conta3, conta1,4000);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());;
        }


        try {
            service.realizarTransferencia(conta2, conta1, -200);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());;
        }

        System.out.println("\n--- Histórico de transações ---");
        for (Transacao t : service.getHistorico()) {
            System.out.println("Valor: " + t.getValor() + " | Status: " + t.getStatus() + " | Data: " + t.getDataHora());
        }

    }
}
