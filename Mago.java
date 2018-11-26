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
public class Mago extends Clase {

    public Mago( ){
        this.vida = 15;
        this.energia = 4;
}
    
@Override    
protected final int habilidadEspecial(int guardian){
    if(this.energia>0){
    guardian = guardian -2;
    this.energia = energia -1;
    System.out.println("Le has infligido 2 de daño al guardian");
    }else {
        System.out.println("No tienes suficiente mana");
    } 
    return guardian;
}
}
