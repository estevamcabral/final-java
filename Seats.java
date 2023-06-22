/**
 * AircraftApp
 * @author estevamcabral1308@gmail.com
 * @author fefe.franceschini@gmail.com
 */
public class Seats{
    private boolean seatIsFree= true;
    private boolean blocked= false;
    private double value;
    //retorna se esta livre ou ocupado o assento
    public boolean getLivre(){
        return seatIsFree;
    }
    //assento ocupado
    public void takeSeat(){
        seatIsFree=false;
    }
    //calcular valor da compra
    public double checkValue(int linha,int coluna,Seats[][]seats){
        int nextColumn= 0;
        if(coluna==0|| coluna== 2){
           nextColumn= coluna+ 1; 
        }
        else{
            nextColumn= coluna- 1;
        }
        if(seats[linha][nextColumn].getBlocked()==false){
                if(linha<=1){
                    //primeira classe
                    value= 50000.00;
                }
                else if(linha>=2 && linha<=7){
                    //classe executiva
                    value= 20000.00;
                }
                else{
                    //classe economica;
                    value= 3000.00;
                }
            }
            else{
                if(linha<=1){
                    //primeira classe
                    value= 51200.00;
                }
                else if(linha>=2 && linha<=7){
                    //classe executiva
                    value= 20800.00;
                }
                else{
                    //classe economica;
                    value= 3060.00;
                }
            }
        return value;
    }
    //assento bloqueado
    public void Blocked(){
        blocked= true;
        seatIsFree= false;
    }
    //retornar se o assento esta bloqueado ou não
    public boolean getBlocked(){
        return blocked;
    }
}