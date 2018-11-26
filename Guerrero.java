/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

/**
 *
 * @author WINDOWS 10
 */
public class Guerrero extends Clase {
    
    public Guerrero(){
        this.energia = 5;
        this.vida = 20;
    }
@Override    
protected final int habilidadEspecial(int saludJugador){
    if(this.energia>0){
    saludJugador = saludJugador -1;
    this.energia = energia -1;
    System.out.println("Le has infligido 1 de daño al jugador" + saludJugador);
    }else {
        System.out.println("No tienes suficiente mana");
    }
    return saludJugador; 
}
}   

