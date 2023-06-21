import java.util.Scanner;
public class Passangers{
    Scanner sc= new Scanner(System.in);
    String nome= "";
    String cpf= "";
    public String customer(){
        System.out.println("Digite o nome:");
        nome= sc.next();
        System.out.println("Digite o CPF:");
        cpf= sc.next();
        String nomeCPF= nome+ " "+ cpf;
        return nomeCPF;
    }
}