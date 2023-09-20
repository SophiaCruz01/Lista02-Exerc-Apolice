import java.util.Scanner;

public class Apolice {
    private int numero;
    private String nome;
    private int idade;
    private char sexo;
    private double valorAutomovel;
    private double valorApolice;

    public Apolice() {
    }

    public Apolice(int numero, String nome, int idade, char sexo, double valorAutomovel) {
        this.numero = numero;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.valorAutomovel = valorAutomovel;
        this.valorApolice = calcularValor();
    }

    public double calcularValor() {
        if (sexo == 'M' && idade <= 25) {
            return valorAutomovel * 10 / 100;
        } else if (sexo == 'M' && idade > 25) {
            return valorAutomovel * 5 / 100;
        } else if (sexo == 'F') {
            return valorAutomovel * 2 / 100;
        } else {
            return 0.0;
        }
    }

    public String imprimir() {
        String info = "Número: " + numero + "\n";
        info += "Nome: " + nome + "\n";
        info += "Idade: " + idade + "\n";
        info += "Sexo: " + sexo + "\n";
        info += "Valor Automóvel: " + valorAutomovel + "\n";
        info += "Valor Apólice: " + valorApolice + "\n";
        return info;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Apolice apolice = null;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1 - Criar Apólice");
            System.out.println("2 - Ver Dados Apólice");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Número: ");
                    int numero = scanner.nextInt();
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    System.out.print("Sexo (M/F): ");
                    char sexo = scanner.next().charAt(0);
                    System.out.print("Valor do Automóvel: ");
                    double valorAutomovel = scanner.nextDouble();

                    apolice = new Apolice(numero, nome, idade, sexo, valorAutomovel);
                    System.out.println("Apólice criada com sucesso!");
                    break;
                case 2:
                    if (apolice != null) {
                        System.out.println(apolice.imprimir());
                    } else {
                        System.out.println("Nenhuma apólice criada ainda.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
