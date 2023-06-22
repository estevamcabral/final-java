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

    public String nome;
    public String cpf;

    public Passangers (){

    }
    public static String getAssento(char letter, int number) {
        return String.valueOf(letter) + number;
    }

    public static void write(String numVoo, char letter, int number, String nome, String cpf) throws Exception{
        PrintStream file = new PrintStream(new FileOutputStream("Passangers.txt", true));
        file.print(numVoo + " " + getAssento(letter,number) + " " + nome + " " + cpf);
        file.println();
        file.close();
    }
    public static void read(String numVoo, String assento) throws Exception
    {
        FileInputStream file2 = new FileInputStream("Passangers.txt");
        Scanner in = new Scanner(file2);
        String line="";
        while(in.hasNextLine()){
            line = in.nextLine();
            if(line.startsWith(numVoo) && line.toLowerCase().contains(assento.toLowerCase())){
                String[] parts = line.split(" ");
                String nome = parts[2];
                String cpf = parts[3];
                System.out.println("Nome: " + nome);
                System.out.println("CPF: " + cpf);
                break;
            }
            if(!in.hasNextLine()){
                System.out.println("assento livre");
                break;
            }
        }
        in.close();
        file2.close();
    }
}
