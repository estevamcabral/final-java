/**
 * Seats representa um assento em uma aeronave.
 * Armazena informações sobre se o assento está livre ou ocupado, se está bloqueado e o valor da compra do assento.
 * Permite verificar o estado do assento, ocupá-lo, calcular o valor da compra e bloqueá-lo.
 * @author estevamcabral1308@gmail.com - 23108553
 * @author fefe.franceschini@gmail.com - 23102302
 */

public class Seats{
    private boolean seatIsFree = true;
    private boolean blocked = false;
    private double value;

    /**
     * Verifica se o assento está livre.
     * @return true se o assento está livre, false caso contrário.
     */
    public boolean getLivre(){
        return seatIsFree;
    }

    /**
     * Ocupa o assento, marcando-o como não livre.
     */
    public void takeSeat(){
        seatIsFree = false;
    }

    /**
     * Bloqueia o assento, marcando-o como bloqueado e não livre.
     */
    public void Blocked(){
        blocked = true;
        seatIsFree = false;
    }

    /**
     * Verifica se o assento está bloqueado.
     * @return true se o assento está bloqueado, false caso contrário.
     */
    public boolean getBlocked(){
        return blocked;
    }

    /**
     * Calcula o valor da compra do assento com base na classe e na disponibilidade de assentos bloqueados.
     * @param linha a linha do assento.
     * @param coluna a coluna do assento.
     * @param seats a matriz de assentos da aeronave.
     * @return o valor da compra do assento.
     */
    public double checkValue(int linha, int coluna, Seats[][] seats){
        int nextColumn = 0;
        if(coluna == 0 || coluna == 2){
            nextColumn = coluna + 1;
        }
        else{
            nextColumn = coluna - 1;
        }
        if(seats[linha][nextColumn].getBlocked() == false){
            if(linha <= 1){
                // primeira classe
                value = 50000.00;
            }
            else if(linha >= 2 && linha <= 7){
                // classe executiva
                value = 20000.00;
            }
            else{
                // classe economica;
                value = 3000.00;
            }
        }
        else{
            if(linha <= 1){
                // primeira classe
                value = 51200.00;
            }
            else if(linha >= 2 && linha <= 7){
                // classe executiva
                value = 20800.00;
            }
            else{
                // classe economica;
                value = 3060.00;
            }
        }
        return value;
    }
}