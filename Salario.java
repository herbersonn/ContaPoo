import java.util.Scanner;

class Salario {
    private String nomeTitular;
    private int numero;
    private double saldo;

    public Salario(String nomeTitular, int numero, double saldoInicial) {
        this.nomeTitular = nomeTitular;
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

    public String getNomeTitular() {
        return nomeTitular;
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

            System.out.print("Digite o nome do titular: ");
            String nomeTitular = scanner.nextLine();
            System.out.print("Digite o número da conta: ");
            int numero = scanner.nextInt();
            System.out.print("Digite o saldo inicial: ");
            double saldoInicial = scanner.nextDouble();

            Salario salario = new Salario(nomeTitular, numero, saldoInicial);

            while (true) {
                System.out.println("\nEscolha uma opção: ");
                System.out.println("1 - Depositar");
                System.out.println("2 - Sacar");
                System.out.println("Outro número - Sair");
                int opcao = scanner.nextInt();

                if (opcao == 1) {
                    System.out.print("Digite o valor a depositar: ");
                    double valor = scanner.nextDouble();
                    salario.depositar(valor);
                } else if (opcao == 2) {
                    System.out.print("Digite o valor a sacar: ");
                    double valor = scanner.nextDouble();
                    salario.sacar(valor);
                } else {
                    System.out.println("Encerrando o programa...");
                    break;
                }
            }
            scanner.close();
        }
    }
}