public class Seats{
    private boolean estaLivre= true;
    private int value;
    public Seats(){
        
    }
    public boolean getLivre(){
        return estaLivre;
    }
    public boolean tomarAssento(){
        estaLivre= false;
        return estaLivre;
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
}