import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileInputStream;

/**
 * AircraftApp
 * @author estevamcabral1308@gmail.com
 * @author fefe.franceschini@gmail.com
 */
public class Aircraft
{
    //criar objeto seats da classe Seats e objeto passageiro da classe Passangers
    Passangers passenger = new Passangers();
    private Seats[][] seats;
    public Aircraft() {
        this.seats = new Seats[23][4];
        for(int i= 0;i<seats.length;i++){
            for(int j= 0; j<4;j++){
            //transformando cada posição do arranjo seats em um objeto assento
            Seats assento= new Seats();
            seats[i][j]= assento;
            }
        }
    }
    
    //método sell(venda de assento)
    public void sell(String command, String numVoo)throws Exception{
        //determinando a linha e a coluna do arranjo a ser vendida
        Scanner sc= new Scanner(System.in);
        System.out.println(command);
        String choice = command.substring(5);
        
        char letter = choice.charAt(0);
        
        int number = Integer.parseInt(choice.substring(1));        ;

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
        //verificar se está ocupado o assento ou não, usando o método getLivre()
        if (this.seats[line][column].getLivre()== false)
            System.out.println("OCUPPIED SEAT!");
        else {
            System.out.println("Enter the name of the passanger:");
            passenger.name = sc.nextLine();
            System.out.println("Enter the CPF of the passanger:");
            passenger.cpf = sc.nextLine();

            this.seats[line][column].takeSeat();
            passenger.write(numVoo, letter, number, passenger.name, passenger.cpf);
            //verificar assento do lado pode ser reservado
            int next;
            if (column == 0 || column == 2) {
                next = column + 1;
            } else {
                next = column - 1;
            }
            if (this.seats[line][next].getLivre()==true) {
                System.out.println("whould you like book the seat on the side? (S/n)");
                String confirm= sc.next();
                if(confirm.startsWith("S")||confirm.startsWith("s")){
                    this.seats[line][next].takeSeat();
                    this.seats[line][next].Blocked();
                }
            }
            //printar valor da venda
            System.out.println("Total:"+ seats[line][column].checkValue(line,column,seats));
        }
    }
    // método print(), printar os assentos da aeronave
    public void print(String nameDestination,String hour,String numVoo){
        System.out.printf("POA ->%s\n", nameDestination);
        System.out.println(hour+ " " +numVoo);
        
        System.out.println("    A  B     C  D");      
        // percorre cada linha
        for (int i = 0; i < this.seats.length; i++) {
            // mostra uma linha matriz e verificar se esta livre ou ocupada ou bloqueado
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < this.seats[i].length; j++) {            
                if(this.seats[i][j].getBlocked()== true){
                    System.out.print("[X]");
                }
                else{
                    if (this.seats[i][j].getLivre()== false){
                      System.out.print("[O]");  
                    }
                    else{
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
    //método write(), escrever no arquivo do voo se os assentos estao livres ou ocupados(true or false)
    public void write(String numVoo) throws Exception {
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
    //método read(), ler no inicio do programa o arquivo do voo
    public void read(String numVoo) throws Exception {
        FileInputStream file = new FileInputStream(numVoo+".txt");
        Scanner in = new Scanner(file);
        for (int i = 0; i < this.seats.length; i++) {
            for (int j = 0; j < this.seats[i].length; j++) {
                if (in.nextBoolean() == false){
                    this.seats[i][j].takeSeat();
                }
            }
        }
        in.close();
        file.close();            
    }
    //método whoBuy(), mostra quem comprou o assento
    public void whobuy(String numVoo) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the seat for informations:");
        String whichSeat= sc.next();
        passenger.read(numVoo, whichSeat);
    }
}
