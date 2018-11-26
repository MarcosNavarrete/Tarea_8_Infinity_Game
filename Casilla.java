
package infinitygame;

import java.util.*;
public class Casilla {

    private Random azar = new Random();   
    private int posicion;
      
public void casillaDesafio(int tablero[], int posicionJugadores[],int saludJugadores[]){
        int camino= azar.nextInt(2);
        if(0==camino){
            camino = azar.nextInt(6)-5;
            posicionJugadores[posicion] = posicionJugadores[posicion] + camino;
            System.out.println("Usted ha caigo en desafio avanza o retrocede" + camino + " pasos");
        }else{
            camino = azar.nextInt(5)-4;
            posicionJugadores[posicion] = posicionJugadores[posicion] + camino;
            if(posicionJugadores[0]<0){
                System.out.println("Game Over");
                saludJugadores[0]= 0;
            }else if(posicionJugadores[0]>tablero.length){
                System.out.println("Game Over");
                saludJugadores[0]= 0;
            }
            System.out.println("Usted ha caigo en desafio gana o pierde" + camino + " puntos de vida");
        }
    }
   public void casillaSalud(int saludJugadores[]){
        int salud = azar.nextInt(3)+1;
        if(saludJugadores[posicion]== 15){
            System.out.println("Salud actual del jugador es 15 ");
        }else{
                saludJugadores[posicion]= saludJugadores[posicion]+ salud;
                if(saludJugadores[0]>= 15){
                     System.out.println("La salud actual es 15");
                     saludJugadores[posicion]= 15;
                }else{
                     System.out.println("La salud actual es "+ saludJugadores[0]);
                }
           
        }
   }
   public void casillaPortal(int tablero[],int posicionJugadores[] ){
       int valor;
       do{
          valor = azar.nextInt(tablero.length);
          if(posicionJugadores[posicion]==tablero[valor]){
              
          } else if(tablero[valor] == 3){
              posicionJugadores[posicion] = tablero[valor];
          }  
        }while(tablero[valor]!= 3);
       System.out.println("posicion actual "+ posicionJugadores[0]);
   }
}
