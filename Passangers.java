import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Scanner;
/**
 * AircraftApp
 * @author estevamcabral1308@gmail.com
 * @author fefe.franceschini@gmail.com
 */
public class Passangers{

    public String name;
    public String cpf;

    Scanner sc = new Scanner(System.in);
    public Passangers (String numVoo, String seat) throws Exception{
        System.out.println("Enter name of the passenger:");
        this.name = sc.nextLine();
        System.out.println("Enter CPF of the passenger:");
        this.cpf = sc.nextLine();
        write(numVoo, seat, name, cpf);
    }
    public void write(String numVoo, String seat, String name, String cpf) throws Exception{
        PrintStream file = new PrintStream(new FileOutputStream("Passangers.txt", true));
        file.print(numVoo + " " + seat + " " + name + " " + cpf);
        file.println();
        file.close();
    }
    public static void read(String numVoo, String whichSeat) throws Exception
    {
        FileInputStream file2 = new FileInputStream("Passangers.txt");
        Scanner in = new Scanner(file2);
        String line="";
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
