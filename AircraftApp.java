import java.util.Scanner;
import java.time.LocalDate;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
public class AircraftApp
{
    private AircraftApp() {
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
       LocalDate today = LocalDate.now();
        Aircraft[] destiny = new Aircraft[3];
        destiny[0]= new Aircraft();
        destiny[1]= new Aircraft();
        destiny[2]= new Aircraft();
        
        System.out.println("Qual seu destino?");
        System.out.println("dia:"+ today.toString());
        System.out.printf("[1]Porto Alegre--> Rio de Janeiro\n");
        System.out.printf("[2]Porto Alegre--> São Paulo\n");
        System.out.printf("[3]Porto Alegre--> Recife\n");
        int destination= sc.nextInt();
         String nameDestination="";
         String hour="";
         String numVoo="";
        if(destination==1){
            nameDestination= "Rio de Janeiro";
            hour= "06:30";
            numVoo= "TAM3434";
        }
        if(destination==2){
            nameDestination= "São Paulo";
            hour= "08:45";
            numVoo= "TAM2173";
        }
        if(destination==3){
            nameDestination= "Recife";
            hour= "19:30";
            numVoo= "TAM6060";
        }
        System.out.println("Venda de passagens");
        String command;
        do {
            command= sc.nextLine();
            if (command.startsWith("show"))
                destiny[0].print(nameDestination, hour,numVoo);
            else if (command.startsWith("sell"))                
                destiny[0].sell(command);
            else if (command.startsWith("write"))                
                destiny[0].write(numVoo);
            else if (command.startsWith("read"))                
                destiny[0].read();
            else
                System.out.println("Comando invalido!");
            } while (!command.startsWith("quit"));
    }
}
