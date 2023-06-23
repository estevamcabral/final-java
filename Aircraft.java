import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author estevamcabral1308@gmail.com
 * @author fefe.franceschini@gmail.com
 */
/**
 * Aircraft representa uma aeronave com assentos para venda.
 * Os assentos são organizados em um arranjo bidimensional.
 * Os assentos podem ser vendidos, exibiddos e bloqueados e ocupados.
 * Os dados dos passageiros que compraram assentos podem ser armazenados e consultados.
 * Os assentos e informações de venda podem ser gravados e lidos em um arquivo.
 */
public class Aircraft {
    Passangers passenger;
    private Seats[][] seats;

    /**
     * Construtor da classe Aircraft.
     * Inicializa o arranjo de assentos da aeronave.
     */
    public Aircraft() {
        this.seats = new Seats[23][4];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < 4; j++) {
                Seats seat = new Seats();
                seats[i][j] = seat;
            }
        }
    }

    /**
     * Método para vender um assento da aeronave.
     * Verifica se o assento está ocupado ou livre.
     * Cria um objeto de passageiro e armazena as informações do mesmo após a compra.
     * Verifica se o assento ao lado pode ser reservado.
     * Imprime o valor total da venda.
     *
     * @param command o comando de venda do assento.
     * @param numVoo  o número do voo.
     * @throws Exception em caso de erro ao ler a entrada do usuário.
     */
    public void sell(String command, String numVoo) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println(command);
        String choice = command.substring(5);

        char letter = choice.charAt(0);

        int number = Integer.parseInt(choice.substring(1));

        int line;
        int column;

        switch (letter) {
            case 'A':
            case 'a':
                column = 0;
                break;
            case 'B':
            case 'b':
                column = 1;
                break;
            case 'C':
            case 'c':
                column = 2;
                break;
            case 'D':
            case 'd':
                column = 3;
                break;
            default:
                column = -1;
        }

        line = number - 1;

        if (this.seats[line][column].getLivre() == false)
            System.out.println("OCCUPIED SEAT!");
        else {
            String seat = String.valueOf(letter) + number;
            passenger = new Passangers(numVoo, seat);
            this.seats[line][column].takeSeat();

            int next;
            if (column == 0 || column == 2) {
                next = column + 1;
            } else {
                next = column - 1;
            }

            if (this.seats[line][next].getLivre() == true) {
                System.out.println("Would you like to book the seat on the side? (S/n)");
                String confirm = sc.next();
                if (confirm.startsWith("S") || confirm.startsWith("s")) {
                    this.seats[line][next].takeSeat();
                    this.seats[line][next].Blocked();
                }
            }
            System.out.println("Total: " + seats[line][column].checkValue(line, column, seats) + "$");
        }
    }

    /**
     * Método para exibir os assentos da aeronave.
     * Imprime a disposição dos assentos, indicando se estão livres, ocupados ou bloqueados.
     *
     * @param nameDestination o destino do voo.
     * @param hour a hora do voo.
     * @param numVoo o número do voo.
     */
    public void print(String nameDestination, String hour, String numVoo) {
        System.out.printf("POA -> %s\n", nameDestination);
        System.out.println(hour + " " + numVoo);

        System.out.println("    A  B     C  D");
        for (int i = 0; i < this.seats.length; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < this.seats[i].length; j++) {
                if (this.seats[i][j].getBlocked() == true) {
                    System.out.print("[X]");
                } else {
                    if (this.seats[i][j].getLivre() == false) {
                        System.out.print("[O]");
                    } else {
                        System.out.print("[ ]");
                    }
                }
                if (j == 1) {
                    System.out.print("   ");
                }
            }
            System.out.printf(" %2d%n", i + 1);
            if (i == 1 || i == 7) {
                System.out.println();
            }
        }
        System.out.println("    A  B     C  D");
    }

    /**
     * Método para escrever no arquivo do voo o status dos assentos (livres ou ocupados).
     *
     * @param numVoo o número do voo.
     * @throws Exception em caso de erro ao escrever no arquivo.
     */
    public void write(String numVoo) throws Exception {
        PrintStream file = new PrintStream(new FileOutputStream(numVoo + ".txt"));
        for (int i = 0; i < this.seats.length; i++) {
            for (int j = 0; j < this.seats[i].length; j++) {
                file.print(this.seats[i][j].getLivre() + " ");
            }
            file.println();
        }
        file.close();
    }

    /**
     * Método para ler o arquivo do voo e restaurar o status dos assentos.
     *
     * @param numVoo o número do voo.
     * @throws Exception em caso de erro ao ler o arquivo.
     */
    public void read(String numVoo) throws Exception {
        FileInputStream file = new FileInputStream(numVoo + ".txt");
        Scanner in = new Scanner(file);
        for (int i = 0; i < this.seats.length; i++) {
            for (int j = 0; j < this.seats[i].length; j++) {
                if (in.nextBoolean() == false) {
                    this.seats[i][j].takeSeat();
                }
            }
        }
        in.close();
        file.close();
    }

    /**
     * Método para mostrar as informações do passageiro que comprou um assento específico.
     *
     * @param numVoo o número do voo.
     * @throws Exception em caso de erro ao ler a entrada do usuário.
     */
    public void whobuy(String numVoo) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter seat for information:");
        String whichSeat = sc.next();
        passenger.read(numVoo, whichSeat);
    }
}
