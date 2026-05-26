#  Sistema de Transferências Bancárias

Projeto desenvolvido em Java para simular o fluxo real de transferências entre contas bancárias — com validações de negócio, tratamento de erros e histórico de transações.

A motivação foi simples: cansei de fazer tutoriais de "to-do list" que não chegam nem perto do que empresas usam no dia a dia. Quis construir algo que um dev júnior encontraria de verdade trabalhando num banco como Nubank ou C6.

---

## O que o sistema faz

- Cadastra clientes e contas bancárias
- Realiza transferências com validações reais de negócio
- Rejeita transferências com saldo insuficiente, conta inativa ou valor inválido
- Registra histórico de transações aprovadas com data e hora

---

## Regras de negócio implementadas

Antes de qualquer transferência o sistema valida:

1. **Conta de origem ativa** — se estiver inativa, lança `ContaInativaException`
2. **Valor positivo** — transferências com valor zero ou negativo são rejeitadas
3. **Saldo suficiente** — o saldo precisa cobrir o valor da transferência

Se alguma validação falhar, a transferência não acontece e nenhum saldo é alterado.

---

## Estrutura do projeto

```
src
├── exception
│   ├── ContaInativaException.java
│   └── SaldoInsuficienteException.java
├── model
│   ├── Cliente.java
│   ├── Conta.java
│   ├── StatusTransacao.java
│   └── Transacao.java
├── service
│   └── TransferenciaService.java
└── Main.java
```

---

## Tecnologias e conceitos usados

- Java 19
- Orientação a objetos — encapsulamento, associação entre classes
- `enum` para status fixos de transação (PENDENTE, APROVADA, RECUSADA)
- Exceções personalizadas com `RuntimeException` para erros de negócio
- `LocalDateTime` para registro preciso de data e hora
- `List` e `ArrayList` para histórico de transações

Dois conceitos que não tinha visto antes e aprendi construindo esse projeto: `enum` para representar valores fixos sem risco de erro de digitação, e `RuntimeException` para criar exceções com significado de negócio em vez de mensagens genéricas.

---

## Como rodar

**Pré-requisitos:** Java 11 ou superior instalado.

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/TransferenciaBancaria.git

# Abra no IntelliJ IDEA e rode a classe Main.java
```

---

## Próximos passos

Esse projeto é a base. O plano é evoluir em três etapas:

- [ ] **Spring Boot** — transformar em API REST para que outros sistemas possam consumir
- [ ] **Banco de dados** — persistir clientes, contas e transações com JPA + PostgreSQL
- [ ] **Testes automatizados** — cobrir todas as regras de negócio com JUnit

---

## Autor

Pedro — desenvolvedor em formação, construindo projetos reais para aprender de verdade.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?style=flat&logo=linkedin)](https://linkedin.com/in/seu-perfil)
[![GitHub](https://img.shields.io/badge/GitHub-black?style=flat&logo=github)](https://github.com/seu-usuario)
