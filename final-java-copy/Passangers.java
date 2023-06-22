import java.util.Scanner;
public class Passangers{
    Scanner sc= new Scanner(System.in);
    String nome= "";
    String cpf= "";
    public String customer(){
        System.out.println("Digite o nome:");
        nome= sc.nextLine();
        System.out.println("Digite o CPF:");
        cpf= sc.nextLine();
        String nomeCPF= nome+ " "+ cpf;
        return nomeCPF;
    }
}