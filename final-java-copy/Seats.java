public class Seats{
    private boolean estaLivre= true;
    private boolean ocupado= false;
    private double value;
    private Passangers passageiro; 
    String comprador= "";
    public Seats(){
        passageiro = new Passangers();
    }
    public boolean getLivre(){
        return estaLivre;
    }
    public void tomarAssento(){
        estaLivre= false;
    }
    public double checkValue(int linha,int coluna,Seats[][]seats){
        int nextColuna= 0;
        if(coluna==0|| coluna== 2){
           nextColuna= coluna+ 1; 
        }
        else{
            nextColuna= coluna- 1;
        }
        if(seats[linha][nextColuna].getOcupado()==false){
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
    public void whoBuy(){
        comprador= passageiro.customer();
    }
    public String getCustomer(){
        return comprador;
    }
    public void getBlocked(){
        ocupado= true;
    }
    public boolean getOcupado(){
        return ocupado;
    }
}