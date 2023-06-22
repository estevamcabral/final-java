import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileInputStream;

/**
 * Revisão com objeto Aircraft.
 * 
 * @author fefe.franceschini@gmail.com
 * @see https://www.flyporter.com/en/about-porter/our-fleet/embraer-e195-e2
 */
public class Aircraft
{
    Passangers passageiro = new Passangers();
    private Seats[][] seats;
    public Aircraft() {
        this.seats = new Seats[23][4];
        for(int i= 0;i<seats.length;i++){
            for(int j= 0; j<4;j++){
            Seats assento= new Seats();
            seats[i][j]= assento;
            }
        }
    }
    
    public void sell(String command, String numVoo) throws Exception {
        for(int i= 0;i>=0;i++){
            Scanner sc= new Scanner(System.in);
        System.out.println(command);
        String choice = command.substring(5);
        System.out.println(choice);
        
        char letter = choice.charAt(0);
        System.out.println(letter);
        
        int number = Integer.parseInt(choice.substring(1));        
        System.out.println(number);

        int line;
        int column;
        
        switch(letter) {
            case 'A' :
            case 'a' :
                        column = 0;
                        break;
            case 'B' :
            case 'b' :
                        column = 1;
                        break;
            case 'C' :
            case 'c' :
                        column = 2;
                        break;
            case 'D' :
            case 'd' :
                        column = 3;
                        break;
            default:
                        column = -1;
        }
        
        line = number - 1;
        if (this.seats[line][column].getLivre()== false)
            System.out.println("Assento OCUPADO!");
        else {
            System.out.println("Digite seu nome: ");
            passageiro.nome = sc.nextLine();
            System.out.println("Digite o CPF do passageiro:");
            passageiro.cpf = sc.nextLine();

            this.seats[line][column].tomarAssento();
            passageiro.write(numVoo, letter, number, passageiro.nome, passageiro.cpf);
            int next;
            if (column == 0 || column == 2) {
                next = column + 1;
            } else {
                next = column - 1;
            }
            if (this.seats[line][next].getLivre()==true) {
                System.out.println("Deseja reservar o assento ao lado? (S/n)");
                String confirm= sc.next();
                if(confirm.startsWith("S")||confirm.startsWith("s")){
                    this.seats[line][next].tomarAssento();
                }
            }
        }
        System.out.println("Deseja comprar outro assento?");
        String confirm2=sc.next();
        if(confirm2.startsWith("N")||confirm2.startsWith("n")){
                    break;
        }
        }
    }
    public void print(String nameDestination,String hour,String numVoo) {
        System.out.printf("POA ->%s\n", nameDestination);
        System.out.println(hour+ " " +numVoo);
        
        System.out.println("    A  B     C  D");      
        // percorre cada linha
        for (int i = 0; i < this.seats.length; i++) {
            // mostra uma linha matriz
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < this.seats[i].length; j++) {            
                if (this.seats[i][j].getLivre()== false)
                    System.out.print("[O]");
                else
                    System.out.print("[ ]");
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
    public void write(String numVoo) throws Exception {
        System.out.println(numVoo);
        PrintStream file = new PrintStream(new FileOutputStream(numVoo + ".txt"));
        for (int i = 0; i < this.seats.length; i++) {
            for (int j = 0; j < this.seats[i].length; j++) {
                    file.print(this.seats[i][j].getLivre() +" ");
            }
            file.println();
        }
        file.close();
        file.close();
    }
    
    public void read() throws Exception {
        FileInputStream file = new FileInputStream("seats.txt");
        Scanner in = new Scanner(file);
        for (int i = 0; i < this.seats.length; i++) {
            for (int j = 0; j < this.seats[i].length; j++) {            
                    //completar
            }
        }
        in.close();
        file.close();            
    }
    public void whobuy(String numVoo) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("DIGITE O ASSENTO PARA OBTER INFORMAÇÕES: ");
        String assento = sc.next();
        passageiro.read(numVoo, assento);
    }
}
