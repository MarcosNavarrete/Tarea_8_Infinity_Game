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
public  abstract class Clase {
   
    protected int energia;
    protected int vida;

protected int habilidadEspecial(int daño){
    // este metodo lo heredaremos para las razas de personajes
    return daño;
}    
}
