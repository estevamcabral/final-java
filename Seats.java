public class Seats{
    private boolean estaLivre= true;
    private int value;
    private Passangers passageiro; 
    String comprador= "0";
    public Seats(){
        passageiro = new Passangers();
    }
    public boolean getLivre(){
        return estaLivre;
    }
    public void tomarAssento(){
        estaLivre= false;
    }
    public int checkValue(Seats[][]seats){
        for(int i= 0;i<seats[i].length;i++){
            if(i<=1){
                //primeira classe
                value= 50000;
            }
            else if(i>=2 &&i<=7){
                //classe executiva
                value= 20000;
            }
            else{
                //classe economica;
                value= 3000;
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
    
}