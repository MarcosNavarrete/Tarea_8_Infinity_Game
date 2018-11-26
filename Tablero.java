/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

import java.util.*;
public class Tablero {
   private int tablero[];
   private int saludJugadores[];
   private int posicionJugadores[];
   private int listaJugadores[];
   private int meditacionJugador[];
   private int turno =0;
   Mago mago ;
   Guerrero guerrero;
   Validaciones val = new Validaciones();
   private Random azar = new Random();
   Dado dado = new Dado();
   ObjetoMagico objeto = new ObjetoMagico();
   Casilla casilla = new Casilla();
   Guardian guardian = new Guardian();
   
   public Tablero(){
       
   }
   public void seleccionMenu(){
        int opcion = 0;
        while(opcion!=3){
            menu();
            System.out.println("Ingrese una opcion");
            opcion = val.validacion();
            switch(opcion){
                
                case 1 : 
                        jugadorIndividual();
                        guardian.crearGuardian(saludJugadores);
                        generarTablero();
                        do{ 
                            
                            do{
                                    System.out.println("Ingrese la opcion : 1.- Lanzar dados 2.- Meditar 3.- Habilidad Especial");
                                    opcion = val.validacion();
                                }while(opcion <=0 || opcion >3);
                            switch(opcion){
                                case 1:
                                    int lanzada =  dado.lanzarDados(opcion);
                                    guardian.guardianArena(lanzada);
                                    posicionJugadores[0]= posicionJugadores[0]+ lanzada;
                                    guardian.furiaGuardian(saludJugadores);
                                    objeto.reliquia(saludJugadores, meditacionJugador, lanzada, turno);
                                    perderJuego();
                                        switch(tablero[posicionJugadores[0]]){
                                            case 1:
                                                System.out.println("La posicion actual es "+ posicionJugadores[0]);
                                            case 2:
                                                System.out.println("Cayo en desafio");
                                                casilla.casillaDesafio(tablero, posicionJugadores, saludJugadores);
                                            break;
                                            case 3:
                                                System.out.println("Cayo en portal");
                                                casilla.casillaPortal(tablero, posicionJugadores);
                                            break;
                                            case 4:
                                                System.out.println("Cayo en casilla salud");
                                                casilla.casillaSalud(saludJugadores);
                                            break;
                                        }
                                    break;
                                case 2 :
                                    meditacion();
                                    perderJuego();
                                    break;
                                case 3:
                                    System.out.println("Lanzar habilidad");
                                    break;
                            }
                        }while(saludJugadores[0]>0 || posicionJugadores[0] <= tablero.length);
                        System.out.println("Fin del juego");
                        break;
                case 2 :
                        multijugadores(opcion);
                        generarTablero();
                        listaJugadores = new int[opcion];
                        guardian.crearGuardian(saludJugadores);
                        turno = 0;
                        do{ 
  
                            for(int i =0 ; i<listaJugadores.length;i++){
                            turno = i;
                            
                            do{
                                    System.out.println("turno del jugador " + (i+1));
                                    System.out.println("Ingrese la opcion : 1.- Lanzar dados 2.- Meditar 3.- Lanzar Habilidad");
                                    opcion = val.validacion();
                                }while(opcion <=0 || opcion >3);
                            switch(opcion){
                                case 1:
                                    int lanzada = dado.lanzarDados(opcion);
                                    objeto.reliquia(saludJugadores, meditacionJugador, lanzada, turno);
                                    guardian.furiaGuardian(saludJugadores);
                                    guardian.guardianArena(lanzada);
                                    posicionJugadores[i]= posicionJugadores[i]+ lanzada;
                                    perderJuego();
                                        switch(tablero[posicionJugadores[i]]){
                                            case 1:
                                                System.out.println("La posicion actual es "+ posicionJugadores[i]);
                                            case 2:
                                                System.out.println("Cayo en desafio");
                                                casilla.casillaDesafio(tablero, posicionJugadores, saludJugadores);
                                            break;
                                            case 3:
                                                System.out.println("Cayo en portal");
                                                casilla.casillaPortal(tablero, posicionJugadores);
                                            break;
                                            case 4:
                                                System.out.println("Cayo en casilla salud");
                                                casilla.casillaSalud(saludJugadores);
                                            break;
                                        }
                                    break;
                                case 2 :
                                    meditacion();
                                    perderJuego();
                                    break;
                                case 3:
                                    System.out.println("Lanzar habilidad");
                                    break;    
                            }
                        }
                        }while(saludJugadores[turno]>0 || posicionJugadores[turno] <= tablero.length);
                        System.out.println("Fin del juego");
                        
                        break;
                case 3 :
                        System.out.println("¡Hasta luego!");
                        System.exit(0);
                        break;
       
                    default:
                        System.out.println("Opcion no valida");
                        break;
                
            }
        }
    }
   public static void menu(){
        System.out.println("Bienvenido a Infinity Game");
        System.out.println("");
        System.out.println("Modo de juego");
        System.out.println("1: Modo Individual");
        System.out.println("2: Multijugador");
        System.out.println("3: Salir del juego");
    } 
  
 private void generarTablero(){// 0 inicio,1 blanco, 2 desafio , 3 portal , 4 salud , 5 final.
        int largo= 0;
        do{
            System.out.println("Ingrese el largo del tablero(mayor a 20)");
            largo= val.validacion();
        }while(largo<20);
        tablero = new int[largo];
        for(int i =0 ; i<tablero.length ;i++){
            tablero[i]= azar.nextInt(4)+1;
        }
        tablero[0]= 0;
        tablero[(largo-1)]= 5;
   }
 
   private int multijugadores(int largo){
       do{
          System.out.println("Ingrese la cantidad de jugadores. (mayor a 1)");
          largo = val.validacion();
        }while(largo<=1);
       listaJugadores = new int[largo];
       saludJugadores = new int[largo];
       posicionJugadores = new int[largo];
       meditacionJugador= new int[largo];
       for(int i = 0; i<largo;i++){
            saludJugadores[i] = 15 ;
            posicionJugadores[i]= 0;
            meditacionJugador[i] = 5;
       }
       return largo;
   }
   private void jugadorIndividual(){
       listaJugadores = new int[1];
       saludJugadores = new int[1];
       posicionJugadores = new int[1];
       meditacionJugador = new int[1];
       meditacionJugador[0]= 5;
       saludJugadores[0] = 15 ;
       posicionJugadores[0]= 0;
   }
   private void meditacion(){
       if(meditacionJugador[turno]> 0){
           meditacionJugador[turno]= meditacionJugador[turno] -1;
           System.out.println("La salud del jugador actual es "+ saludJugadores[0]);
           System.out.println("Quedan estas meditaciones "+ meditacionJugador[0]);
       }else{
          saludJugadores[turno]= saludJugadores[turno] - 1;
          System.out.println("La salud es "+ saludJugadores[turno]);
          System.out.println("Ya no quedan meditaciones, empezo a restar 1 de vida");
       }
   }
   private void perderJuego(){
           if(tablero.length<=posicionJugadores[turno]|| posicionJugadores[turno]<0 ){
            System.out.println("Game over, cayo fuera del tablero");
            seleccionMenu();
        }   
            if(saludJugadores[turno] == 0){
            System.out.println("Game over, su salud es 0");
            seleccionMenu();
        }    
            if(tablero.length == posicionJugadores[turno]){
                System.out.println("Ha ganado el juego el jugador " + (posicionJugadores[turno]+1) );
            }
   }
}
