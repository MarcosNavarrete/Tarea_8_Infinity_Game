/*
 Se incluye un objeto mágico al juego: reliquia. 
Al momento de que un jugador lanza los dados, existe 1% de probabilidad de 
activar la reliquia para restaurar la vida original del jugador; 
en el caso de que al lanzar los dados el resultado sea 12 (doble seis),
la probabilidad sube a un 50%. Por otro lado, si un jugador cae en la casilla
de salud, éste tendrá un 5% de probabilidad de activar la reliquia pero en este
caso para conseguir una meditación extra a su colección.
 */
package infinitygame;

import java.util.*;

public class ObjetoMagico {
  private Random azar = new Random();

  public void reliquia(int saludJugadores[], int meditacionJugador[],int dado,int turno){
    int valor=0;  
      if (dado == 12){
          valor = azar.nextInt(2);
          if(valor==1 ){
              saludJugadores[turno]= 15;
              System.out.println("Vida reestablecida");
          }
      }else{
          valor = azar.nextInt(20);
          if(valor == 0){
              meditacionJugador[turno]+= 1;
              System.out.println("Se ha ganado una meditacion ");
          }
      }
    valor = azar.nextInt(100);
    if(valor == 0){
        saludJugadores[turno]= 15;
        System.out.println("Vida reestablecida");
    }
       
  }  
  
 
}

