import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Conta {
    private String titular;
    private int numero;
    private double saldo;

    public Conta(String titular, int numero, double saldoInicial) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado. Saldo atual: " + saldo);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque efetuado com sucesso. Saldo atual: " + saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    public String getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            List<Conta> contas = new ArrayList<>();
            int numeroSequencial = 1;

            while (true) {
                System.out.println("\nEscolha uma opção: ");
                System.out.println("1 - Criar Conta");
                System.out.println("2 - Ver Saldo");
                System.out.println("3 - Sacar");
                System.out.println("4 - Depositar");
                System.out.println("Outro número - Sair");
                int opcao = scanner.nextInt();

                if (opcao == 1) {
                    scanner.nextLine(); // Limpar o buffer
                    System.out.print("Digite o nome do titular: ");
                    String titular = scanner.nextLine();
                    System.out.print("Digite o saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    Conta novaConta = new Conta(titular, numeroSequencial++, saldoInicial);
                    contas.add(novaConta);
                    System.out.println("Conta criada com sucesso! Número da conta: " + novaConta.getNumero());

                } else if (opcao >= 2 && opcao <= 4) {
                    System.out.print("Digite o número da conta: ");
                    int numeroConta = scanner.nextInt();
                    Conta contaEncontrada = null;
                    for (Conta conta : contas) {
                        if (conta.getNumero() == numeroConta) {
                            contaEncontrada = conta;
                            break;
                        }
                    }
                    if (contaEncontrada == null) {
                        System.out.println("Conta não encontrada.");
                        continue;
                    }

                    if (opcao == 2) {
                        System.out.println("Saldo da conta: " + contaEncontrada.getSaldo());
                    } else if (opcao == 3) {
                        System.out.print("Digite o valor a sacar: ");
                        double valor = scanner.nextDouble();
                        contaEncontrada.sacar(valor);
                    } else if (opcao == 4) {
                        System.out.print("Digite o valor a depositar: ");
                        double valor = scanner.nextDouble();
                        contaEncontrada.depositar(valor);
                    }
                } else {
                    System.out.println("Encerrando o programa...");
                    break;
                }
            }
            scanner.close();
        }
    }
}