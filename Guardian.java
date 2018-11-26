/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

import java.util.Random;


public class Guardian {
    
     private int guardian;
     private Random azar = new Random();
        
     public void guardianArena(int dado){
    if (dado == 12){
        guardian = guardian - 3;
        System.out.println("Se le han quitado 3 puntos de vida al guardian");
        }else{
        guardian = guardian -1;
    }
  }
  public void furiaGuardian(int saludJugadores[]){
      int valor;
      valor = azar.nextInt(50);
      if(valor == 0){
          System.out.println("El guardian ha lanzado su furia, se restara 1 punto de salud a cada jugador");
          for (int i = 0 ; i < saludJugadores.length; i++) {
                saludJugadores[i]= saludJugadores[i]-1;
          }
      }
  }
  
  public void crearGuardian(int saludJugadores[]){
      for (int i = 0 ; i < saludJugadores.length; i++) {
          guardian = saludJugadores[i]+guardian;
      }
    }
}
