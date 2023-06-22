import java.util.Scanner;
import java.time.LocalDate;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

/**
 * AircraftApp
 * @author estevamcabral1308@gmail.com
 * @author fefe.franceschini@gmail.com
 */
public class AircraftApp
{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        //vetor avião, 3 destinos diferentes
        Aircraft[] destiny = new Aircraft[3];
        destiny[0]= new Aircraft();
        destiny[1]= new Aircraft();
        destiny[2]= new Aircraft();
        // selecionar destino
        System.out.println("What is your destiny?");
        System.out.println("dia:"+ today.toString());
        System.out.printf("[1]Porto Alegre--> Rio de Janeiro\n");
        System.out.printf("[2]Porto Alegre--> São Paulo\n");
        System.out.printf("[3]Porto Alegre--> Recife\n");
        int destination= sc.nextInt();
        sc.nextLine();
         String nameDestination="";
         String hour="";
         String numVoo="";
         int pos= 0;
        if(destination==1){
            nameDestination= "Rio de Janeiro";
            hour= "06:30";
            numVoo= "TAM3434";
            pos= 0;
        }
        if(destination==2){
            nameDestination= "São Paulo";
            hour= "08:45";
            numVoo= "TAM2173";
            pos= 1;
        }
        if(destination==3){
            nameDestination= "Recife";
            hour= "19:30";
            numVoo= "TAM6060";
            pos= 2;
        }
        String command;
        //lendo o arquivo do voo escolhido
        destiny[pos].read(numVoo);
        //menu
        do {
            System.out.println("MENU:");
            System.out.println("1. show Aircraft");
            System.out.println("2. sell (seat)");
            System.out.println("3. show Customer");
            //escreve no arquivo do voo os assentos comprados 
            destiny[pos].write(numVoo);
            //inserir comando e chamar os métodos da classe Aircraft
            command= sc.nextLine();
            if (command.startsWith("show Aircraft"))
                destiny[pos].print(nameDestination, hour,numVoo);
            else if (command.startsWith("sell"))                
                destiny[pos].sell(command, numVoo);
            else if (command.startsWith("show Customer"))
                destiny[pos].whobuy(numVoo);
            else if (!command.startsWith("show") && !command.startsWith("sell") &&!command.startsWith("write") && !command.startsWith("read"))
                System.out.println("Invalid command!");
            } while (!command.startsWith("quit"));
    }
}
