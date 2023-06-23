import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Passangers representa um passageiro que comprou um assento em um voo.
 * Armazena o nome e CPF do passageiro.
 * Permite escrever e ler as informações dos passageiros em um arquivo.
 * @author estevamcabral1308@gmail.com - 23108553
 * @author fefe.franceschini@gmail.com - 23102302
 */

public class Passangers{

    public String name;
    public String cpf;

    Scanner sc = new Scanner(System.in);

    /**
     * Construtor da classe Passangers.
     * Solicita o nome e CPF do passageiro e escreve as informações em um arquivo.
     * @param numVoo o número do voo.
     * @param seat o assento comprado pelo passageiro.
     * @throws Exception em caso de erro ao escrever no arquivo.
     */
    public Passangers (String numVoo, String seat) throws Exception{
        System.out.println("Enter name of the passenger:");
        this.name = sc.nextLine();
        System.out.println("Enter CPF of the passenger:");
        this.cpf = sc.nextLine();
        write(numVoo, seat, name, cpf);
    }

    /**
     * Método para escrever as informações do passageiro em um arquivo.
     * @param numVoo o número do voo.
     * @param seat o assento comprado pelo passageiro.
     * @param name o nome do passageiro.
     * @param cpf o CPF do passageiro.
     * @throws Exception em caso de erro ao escrever no arquivo.
     */
    public void write(String numVoo, String seat, String name, String cpf) throws Exception{
        PrintStream file = new PrintStream(new FileOutputStream("Passangers.txt", true));
        file.print(numVoo + " " + seat + " " + name + " " + cpf);
        file.println();
        file.close();
    }

    /**
     * Método estático para ler as informações de um passageiro a partir do número do voo e assento.
     * @param numVoo o número do voo.
     * @param whichSeat o assento a ser consultado.
     * @throws Exception em caso de erro ao ler o arquivo.
     */
    public static void read(String numVoo, String whichSeat) throws Exception {
        FileInputStream file2 = new FileInputStream("Passangers.txt");
        Scanner in = new Scanner(file2);
        String line = "";
        while(in.hasNextLine()){
            line = in.nextLine();
            if(line.startsWith(numVoo) && line.toLowerCase().contains(whichSeat.toLowerCase())){
                String[] parts = line.split(" ");
                String name = parts[2];
                String cpf = parts[3];
                System.out.println("Name: " + name);
                System.out.println("CPF: " + cpf);
                break;
            }
            if(!in.hasNextLine()){
                System.out.println("Seat is free!");
                break;
            }
        }
        in.close();
        file2.close();
    }
}