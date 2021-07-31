
package gatojuego;


public class Gato {
    
    //X==0
    //0==1
    private int [][] tablero;
    private boolean turno; //TRUE=X/FALSE=O

    public Gato() {
        tablero=new int[3][3];
        turno=true;
        InicializarTablero();
    }
    
    public void InicializarTablero(){
        turno=true;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                tablero[i][j]=-1;
            }
        }
    }
    
    public boolean Jugada(int x,int y){
        if (tablero[x][y]!=-1){
            return false;
        }
        else{
            if (turno){
                tablero[x][y]=0;
                turno=false;
            }
            else{
                tablero[x][y]=1;
                turno=true;
            }
            return true;
        }
    }
    
    public boolean JuegoGanado(){
        byte auxX=0;
        byte auxY=0;
        //CHECAR HORIZONTALES
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (tablero[j][i]==0){
                    auxX++;
                }
                else if (tablero[j][i]==1) {
                    auxY++;
                }
                if (auxY==3||auxX==3){
                    return true;
                }
            }
            auxX=0;
            auxY=0;
        }
        //CHECAR VERTICALES
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (tablero[i][j]==0){
                    auxX++;
                }
                else if (tablero[i][j]==1) {
                    auxY++;
                }
                if (auxY==3||auxX==3){
                    return true;
                }
            }
            auxX=0;
            auxY=0;
        }
        //CHECAR DIAGONALS
        if (tablero[0][0]==1&&tablero[1][1]==1&&tablero[2][2]==1||tablero[2][0]==1&&tablero[1][1]==1&&tablero[0][2]==1){
            return true;
        }
        if (tablero[0][0]==0&&tablero[1][1]==0&&tablero[2][2]==0||tablero[2][0]==0&&tablero[1][1]==0&&tablero[0][2]==0){
            return true;
        }
        return false;
    }
    
    public int[][] GetTablero(){
        return tablero;
    }
    
    public boolean GetJugador(){
        return turno;
    }
}
