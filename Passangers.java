import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.Scanner;
public class Passangers{

    Scanner scan = new Scanner(System.in);
    public String nome;
    public String cpf;


    public static String getAssento(char letter, int number) {
        return String.valueOf(letter) + number;
    }

    public static void write(String numVoo, char letter, int number, String nome, String cpf) throws Exception{
        PrintStream file = new PrintStream(new FileOutputStream("Passangers2.txt", true));
        file.print(numVoo + " " + getAssento(letter,number) + " " + nome + " " + cpf);
        file.println();
        file.close();
    }
    public static void read(String numVoo, char letter, int number) throws Exception
    {
        FileInputStream file2 = new FileInputStream("Passangers2.txt");
        Scanner in = new Scanner(file2);
        String line="";
        while(in.hasNextLine()){
            line = in.nextLine();
            if(line.length()<=0){
                break;
            }
            else{
                if(line.startsWith(numVoo) && line.contains(getAssento(letter, number))) {
                    String[] parts = line.split(" ");
                    String nome = parts[2];
                    String cpf = parts[3];
                    System.out.println("Nome: " + nome);
                    System.out.println("CPF: " + cpf);
                }
            }
        }
        in.close();
        file2.close();
    }

}